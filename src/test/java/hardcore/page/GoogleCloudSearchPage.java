package hardcore.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GoogleCloudSearchPage extends AbstractPage {
    private final String LINK_TEXT = "Google Cloud Pricing Calculator";

    @Override
    public AbstractPage openPage() {
        throw new RuntimeException("Cannot open search page without searching.");
    }

    public GoogleCloudSearchPage(WebDriver driver) {
        super(driver);
    }

    public void searchLink() {
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_OUT))
                .until(ExpectedConditions.presenceOfElementLocated(By.linkText(LINK_TEXT)));
        driver.findElement(By.linkText(LINK_TEXT))
                .click();
    }

    public GoogleCloudCalculatorPage openCalculator() {
        searchLink();
        return new GoogleCloudCalculatorPage(driver);
    }
}
