package hardcore.page;

import hardcore.helper.JSExecutor;
import hardcore.helper.Switcher;
import hardcore.helper.Waiter;
import hardcore.service.CostFormatter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TempMailInboxPage extends AbstractPage {
    private final String COST_TITLE = "Estimated Monthly Cost:";

    @FindBy(xpath = "//main")
    private WebElement messagesList;

    @FindBy(xpath = "//a[contains(text(), 'Google Cloud Price Estimate')]")
    private WebElement message;

    @FindBy(xpath = "//h2[contains(text(), 'Estimated Monthly Cost:')]")
    private WebElement estimateCost;

    @Override
    public TempMailInboxPage openPage() {
        Switcher.switchToOtherTab();
        return this;
    }

    public TempMailInboxPage(WebDriver driver) {
        super(driver);
    }

    public String receiveEstimateCostFromEmail() {
        Waiter.waitUntilElementToBeVisible(messagesList);
        JSExecutor.scrollToElement(messagesList);
        Waiter.waitUntilElementToBeVisible(message);
        JSExecutor.clickElement(message);
        Waiter.waitUntilTextToBe(estimateCost, COST_TITLE);
        System.out.println(estimateCost.getText());
        return CostFormatter.receiveCostFromString(estimateCost.getText());
    }


}
