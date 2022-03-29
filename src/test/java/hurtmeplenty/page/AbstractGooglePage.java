package hurtmeplenty.page;

import hurtmeplenty.helpers.HelperInitializer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractGooglePage {
    public WebDriver driver;
    public static final int WAIT_TIME_OUT = 20;

    public abstract AbstractGooglePage openPage();

    public AbstractGooglePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        HelperInitializer.initHelpers(driver);
    }
}
