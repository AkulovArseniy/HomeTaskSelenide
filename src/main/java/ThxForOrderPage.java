import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class ThxForOrderPage {
    static SelenideElement thxOrder = $("#checkout_complete_container > h2");
}
