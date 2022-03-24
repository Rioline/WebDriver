package ibringiton.pageobject_model.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {

    protected WebDriver driver;
    protected WebDriverWait waiter;
    public static final int WAIT_TIME_OUT = 10;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waiter = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_OUT));
    }

    public void waitUntilElementBeVisible(WebElement element) {
        waiter.until(ExpectedConditions.visibilityOf(element));
    }

    protected abstract BasePage openPage();

}
