package hurtmeplenty.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleCloudEstimatePage extends AbstractGooglePage {

    @FindBy(xpath = "//md-card-content[@id = 'resultBlock']//b[contains(text(),'Total Estimated Cost')]")
    public WebElement totalEstimateCost;

    @FindBy(xpath = "//md-card-content[@id = 'resultBlock']//div[contains(text(),'VM class')]")
    public WebElement vMClass;

    @FindBy(xpath = "//md-card-content[@id = 'resultBlock']//div[contains(text(),'Instance type')]")
    public WebElement instanceType;

    @FindBy(xpath = "//md-card-content[@id = 'resultBlock']//div[contains(text(),'Region')]")
    public WebElement region;

    @FindBy(xpath = "//*[@id='compute']/md-list/md-list-item[8]//div[@class='md-list-item-text ng-binding cpc-cart-multiline flex']")
    public WebElement localSSD;

    @FindBy(xpath = "//md-card-content[@id = 'resultBlock']//div[contains(text(),'Commitment term')]")
    private WebElement commitmentTerm;

    @Override
    public AbstractGooglePage openPage() {
        throw new RuntimeException("Cannot open search page without searching.");
    }

    public GoogleCloudEstimatePage(WebDriver driver) {
        super(driver);
    }

    public String getCommitmentTerm() {
        return commitmentTerm.getText();
    }

    public String getLocalSSD() {
        return localSSD.getText();
    }

    public String getRegion() {
        return region.getText();
    }

    public String getInstanceType () {
        return instanceType.getText();
    }

    public String getTotalEstimatedCost() {
        return totalEstimateCost.getText();
    }

    public String getVMClassInResultPage() {
        return vMClass.getText();
    }




}
