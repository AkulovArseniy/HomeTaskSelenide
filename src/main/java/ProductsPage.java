import com.codeborne.selenide.SelenideElement;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.$;

public class ProductsPage {
    SelenideElement textOfProducts = $("#header_container > div.header_secondary_container > span");
    SelenideElement backpackProduct = $("#add-to-cart-sauce-labs-backpack");
    SelenideElement bikeLightProduct = $("#add-to-cart-sauce-labs-bike-light");
    SelenideElement tShirtProduct = $("#add-to-cart-sauce-labs-bolt-t-shirt");
    SelenideElement fleeseJacketProduct = $("#add-to-cart-sauce-labs-fleece-jacket");
    SelenideElement onesieProduct = $("#add-to-cart-sauce-labs-onesie");
    SelenideElement tShirtRedProduct = $("#add-to-cart-test\\.allthethings\\(\\)-t-shirt-\\(red\\)");
    SelenideElement shoppingCart = $("#shopping_cart_container > a");
    static SelenideElement backPackProductText = $("#item_4_title_link > div");
    void addCart() throws IOException{
        backpackProduct.click();
        bikeLightProduct.click();
        tShirtProduct.click();
        fleeseJacketProduct.click();
        onesieProduct.click();
        tShirtRedProduct.click();
        shoppingCart.click();
    }
}
