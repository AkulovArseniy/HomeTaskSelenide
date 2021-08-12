import com.codeborne.selenide.SelenideElement;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static com.codeborne.selenide.Selenide.$;

public class CheckoutInfoPage {
    SelenideElement firstName = $("#first-name");
    SelenideElement lastName = $("#last-name");
    SelenideElement postalCode = $("#postal-code");
    SelenideElement continueButton = $("#continue");

    void checkout() throws IOException {
        Properties props = new Properties();
        props.load(new FileInputStream("src/main/resources/user.properties"));
        firstName.sendKeys(props.getProperty("user.firstname"));
        lastName.sendKeys(props.getProperty("user.lastname"));
        postalCode.sendKeys(props.getProperty("user.postalcode"));
        continueButton.click();
    }
}
