package hurtmeplenty.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GoogleCloudCalculatorPage extends AbstractGooglePage {
    private static final String FRAME_NAME = "myFrame";
    private static final int FRAME_NUMBER = 0;

    @FindBy(css = ".md-ink-ripple[aria-controls='tab-content-1']")
    public WebElement computeEngine;

    @Override
    public AbstractGooglePage openPage() {
        throw new RuntimeException("Cannot open search page without searching.");
    }

    public GoogleCloudCalculatorPage(WebDriver driver) {
        super(driver);
    }

    public void switchToFrame() {
        driver.switchTo()
                .defaultContent();
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_OUT))
                .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(FRAME_NUMBER));
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_OUT))
                .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(FRAME_NAME));
    }

    public void selectComputeEngine() {
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_OUT))
                .until(ExpectedConditions.visibilityOf(computeEngine));
        computeEngine.click();
    }

    public GoogleCloudFillComputeEngine switchToFrameAndSelectCompute() {
        switchToFrame();
        selectComputeEngine();
        return new GoogleCloudFillComputeEngine(driver);
    }
}
