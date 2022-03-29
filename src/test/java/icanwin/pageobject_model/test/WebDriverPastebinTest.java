package icanwin.pageobject_model.test;

import icanwin.pageobject_model.page.PastebinHomePage;
import icanwin.pageobject_model.steps.OpenResultPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class WebDriverPastebinTest {

    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @DataProvider
    public Object[][] testData() {
        return new Object[][]{
                new Object[]{"Hello from WebDriver", "10M", "helloweb"},
        };
    }


    @Test(description = "Just to see of our PO work with testData!", dataProvider = "testData")
    public void testCreatingNewPasteFromData(String codeText, String pasteExpiration, String pasteName) {

        new OpenResultPage(new PastebinHomePage(driver))
                .createPastebin(codeText, pasteExpiration, pasteName);

    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }

}
