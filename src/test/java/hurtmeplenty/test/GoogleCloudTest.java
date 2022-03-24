package hurtmeplenty.test;

import hurtmeplenty.page.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.Locale;

public class GoogleCloudTest {
    private WebDriver driver;

    @BeforeSuite(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        new GoogleCloudTestData(driver).fillTestData();
    }

    @Test(description = "Check that the rental amount coincides with the manual calculation")
    public void testCompareOfCalculationsByProgramAndManually() {
        String actual = new GoogleCloudEstimatePage(driver).getTotalEstimatedCost();
        String expected = "USD 4,026.13 per 1 month";
        Assert.assertTrue(actual.toLowerCase(Locale.ROOT).contains(expected.toLowerCase(Locale.ROOT)));
    }

    @Test(description = "Check VmClass")
    public void testVerifyVMClassField() {
       String actual = new GoogleCloudEstimatePage(driver).getVMClassInResultPage();
       String expected = "Regular";
       Assert.assertTrue(actual.toLowerCase(Locale.ROOT).contains(expected.toLowerCase(Locale.ROOT)));
    }

    @Test(description = "Check Instance type")
    public void testVerifyInstanceType() {
        String actual = new GoogleCloudEstimatePage(driver).getInstanceType();
        String expected = "n1-standard-8";
        Assert.assertTrue(actual.toLowerCase(Locale.ROOT).contains(expected.toLowerCase(Locale.ROOT)));
    }

    @Test(description = "Check Region")
    public void testVerifyRegion(){
        String actual = new GoogleCloudEstimatePage(driver).getRegion();
        String expected = "Frankfurt";
        Assert.assertTrue(actual.toLowerCase(Locale.ROOT).contains(expected.toLowerCase(Locale.ROOT)));
    }

    @Test(description = "Check LocalSSD")
    public void testVerifyLocalSSD() {
        String actual = new GoogleCloudEstimatePage(driver).getLocalSSD();
        String expected = "2x375 GiB";
        Assert.assertTrue(actual.toLowerCase(Locale.ROOT).contains(expected.toLowerCase(Locale.ROOT)));
    }

    @Test(description = "Check Commitment Term")
    public void testVerifyCommitmentTerm() {
        String actual = new GoogleCloudEstimatePage(driver).getCommitmentTerm();
        String expected = "1 Year";
        Assert.assertTrue(actual.toLowerCase(Locale.ROOT).contains(expected.toLowerCase(Locale.ROOT)));
    }

    @AfterSuite(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }
}
