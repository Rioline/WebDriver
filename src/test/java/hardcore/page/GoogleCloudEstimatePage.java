package hardcore.page;

import hardcore.helper.JSExecutor;
import hardcore.helper.Switcher;
import hardcore.service.CostFormatter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleCloudEstimatePage extends AbstractPage {
    @FindBy(xpath = "//md-card-content[@id = 'resultBlock']//b[contains(text(),'Total Estimated Cost')]")
    protected WebElement totalEstimateCost;

    @FindBy(xpath = "//input[@type='email']")
    protected WebElement email;

    @FindBy(xpath = "//button[@aria-label='Send Email']")
    private WebElement sendEmailButton;

    @Override
    public GoogleCloudEstimatePage openPage() {
        Switcher.switchToOtherTab();
        Switcher.switchToFrame();
        return this;
    }

    public GoogleCloudEstimatePage(WebDriver driver) {
        super(driver);
    }

    public String getTotalEstimatedCost() {
        return CostFormatter.receiveCostFromString(totalEstimateCost.getText());
    }

    public GoogleCloudEstimatePage sendEmail(String emailValue) {
        email.sendKeys(emailValue);
        JSExecutor.clickElement(sendEmailButton);
        return new GoogleCloudEstimatePage(driver);
    }


}
