package hurtmeplenty.helpers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JSExecutor extends Helper {
    private static JavascriptExecutor javascriptExecutor;

    JSExecutor(WebDriver driver) {
        super(driver);
        JSExecutor.javascriptExecutor = (JavascriptExecutor) JSExecutor.driver;
    }

    public static void clickElement(WebElement element) {
        javascriptExecutor.executeScript("arguments[0].click();", element);
    }

    public static void scrollToElement(WebElement element) {
        javascriptExecutor.executeScript("arguments[0].scrollIntoView();", element);
    }
}
