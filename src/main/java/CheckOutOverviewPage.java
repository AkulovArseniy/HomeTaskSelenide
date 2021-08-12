import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CheckOutOverviewPage {
    SelenideElement finishButton = $("#finish");
    SelenideElement cancelButton = $("#cancel");
    SelenideElement finalCost = $("#checkout_summary_container > div > div.summary_info > div.summary_subtotal_label");
    void cancelBought(){
        cancelButton.click();
    }
    void finishBought(){
        finishButton.click();
    }
}
