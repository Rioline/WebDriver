package hardcore.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GoogleCloudHomePage extends AbstractPage {
    private static final String HOMEPAGE_URL = "https://cloud.google.com/";
    private static final String SEARCH_QUERY = "Google Cloud Pricing Calculator";

    @FindBy(name = "q")
    public WebElement searchInput;

    @Override
    public GoogleCloudHomePage openPage() {
        driver.get(HOMEPAGE_URL);
        return this;
    }

    public GoogleCloudHomePage(WebDriver driver) {
        super(driver);
    }

    public GoogleCloudSearchPage searchPage() {
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_OUT)).until(ExpectedConditions.visibilityOf(searchInput));
        searchInput.click();
        searchInput.sendKeys(SEARCH_QUERY);
        searchInput.submit();
        return new GoogleCloudSearchPage(driver);
    }
}