package hardcore.page;

import hardcore.helper.JSExecutor;
import hardcore.helper.Switcher;
import hardcore.helper.Waiter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TempMailHomePage extends AbstractPage {
    public static final String TEMP_MAIL_URL = "https://temp-mail.org";

    @FindBy(xpath = "//input[@id = 'mail']")
    private WebElement emailAddress;

    @Override
    public TempMailHomePage openPage() {
        Switcher.openNewTab();
        Waiter.waitUntilNewWindowHandleAppear();
        Switcher.switchToNewTab(TEMP_MAIL_URL);
        return this;
    }

    public TempMailHomePage(WebDriver driver) {
        super(driver);
        Switcher.switchToFrame();
    }

    public String getEmailAddress() {
        Waiter.waitUntilElementToBeVisible(emailAddress);
        JSExecutor.scrollToElement(emailAddress);
        Waiter.waitUntilEmailInValueAppears(emailAddress);
        return emailAddress.getAttribute("value");
    }
}
