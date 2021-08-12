import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.files.DownloadActions.click;

import com.codeborne.selenide.*;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import org.openqa.selenium.By;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;
import org.openqa.selenium.WebElement;
import sun.jvm.hotspot.utilities.Assert;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AddressTest {

    @BeforeEach
    public void setUp() {
//        Configuration.headless = true;
        Configuration.startMaximized = true;

    }

    @AfterEach
    public void tearDown() {
        closeWebDriver();
    }


    @Test
    @Order(1)
    public void loginTest() throws IOException {
        LoginPage loginPage = new LoginPage();
        loginPage.openLoginPage();
        loginPage.login();
        loginPage.textOfProducts.shouldBe(visible);
        Assertions.assertEquals("PRODUCTS", loginPage.textOfProducts.getText());

    }


    @Test
    @Order(2)
    public void boughtTest() throws IOException {
        LoginPage loginPage = new LoginPage();
        ProductsPage productsPage = new ProductsPage();
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
        CheckoutInfoPage checkoutInfoPage = new CheckoutInfoPage();
        CheckOutOverviewPage checkOutOverviewPage = new CheckOutOverviewPage();
        loginPage.openLoginPage();
        loginPage.login();
        productsPage.addCart();
        shoppingCartPage.checkoutCart();
        checkoutInfoPage.checkout();
        checkOutOverviewPage.finishBought();
        Assertions.assertEquals("THANK YOU FOR YOUR ORDER", ThxForOrderPage.thxOrder.getText());

    }

    @Test
    @Order(3)
    public void boughtCancelTest() throws IOException {
        LoginPage loginPage = new LoginPage();
        ProductsPage productsPage = new ProductsPage();
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
        CheckoutInfoPage checkoutInfoPage = new CheckoutInfoPage();
        CheckOutOverviewPage checkOutOverviewPage = new CheckOutOverviewPage();
        loginPage.openLoginPage();
        loginPage.login();
        productsPage.addCart();
        shoppingCartPage.checkoutCart();
        checkoutInfoPage.checkout();
        checkOutOverviewPage.cancelBought();
        Assertions.assertEquals("Sauce Labs Backpack", ProductsPage.backPackProductText.getText());

    }

    @Test
    @Order(4)
    public void removeProductsFromCartTest() throws IOException {
        LoginPage loginPage = new LoginPage();
        ProductsPage productsPage = new ProductsPage();
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
        loginPage.openLoginPage();
        loginPage.login();
        productsPage.addCart();
        shoppingCartPage.cartElements.shouldBe(visible);
        ElementsCollection productCollection = shoppingCartPage.cartElements.$$(".cart_item");
        System.out.println(productCollection.size());
        for (int i = 0; i < 6; i++) {

            productCollection.first().$(By.xpath(".//button[text()='Remove']")).click();
        }
        productCollection.size();
        Assertions.assertTrue(productCollection.size()==0);
    }


    @Test
    @Order(5)
    public void calculatingCostOfProds() throws IOException {
        LoginPage loginPage = new LoginPage();
        ProductsPage productsPage = new ProductsPage();
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
        CheckoutInfoPage checkoutInfoPage = new CheckoutInfoPage();
        CheckOutOverviewPage checkOutOverviewPage = new CheckOutOverviewPage();
        loginPage.openLoginPage();
        loginPage.login();
        productsPage.addCart();
        shoppingCartPage.checkoutCart();
        checkoutInfoPage.checkout();
        shoppingCartPage.cartList.shouldBe(visible);
        ElementsCollection costProds = shoppingCartPage.cartList.$$(By.className("inventory_item_price"));
        String str = costProds.texts().toString();
        String newStr = str.replaceAll("[[$,]]","");
        String rdyStr = newStr.substring(1,newStr.length()-1);
        System.out.println(rdyStr);
        float sum = 0;
        String[] parts = rdyStr.split(" ");
        float[] n1 = new float[parts.length];
        for(int n = 0; n < parts.length; n++) {
            n1[n] = Float.parseFloat(parts[n]);
            sum += n1[n];
        }
        String s=String.valueOf(sum);
        checkOutOverviewPage.finalCost.getText();
        String finStr = checkOutOverviewPage.finalCost.getText().substring(13);

        Assertions.assertEquals(finStr,s);




    }
}
