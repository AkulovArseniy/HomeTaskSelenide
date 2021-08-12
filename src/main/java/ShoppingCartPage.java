import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ShoppingCartPage {
    static SelenideElement cartElements = $("#cart_contents_container > div > div.cart_list");
    static SelenideElement cartList = $(".cart_list");
    static SelenideElement cartItem = $(".cart_item");
    SelenideElement chekout = $("#checkout");
    void checkoutCart(){
        chekout.click();
    }


}
