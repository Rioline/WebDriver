package ibringiton.pageobject_model.test;

import ibringiton.pageobject_model.page.PastebinHomePage;
import ibringiton.pageobject_model.page.PastebinResultPage;
import ibringiton.pageobject_model.page.PastebinResultPage.FontOfCssStyles;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

public class WebDriverPastebinTest {

    private WebDriver driver;

    @BeforeSuite(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        new PastebinHomePage(driver).createNewPastebin(
                        """
                                git config --global user.name  "New Sheriff in Town"
                                git reset $(git commit-tree HEAD^{tree} -m "Legacy code")
                                git push origin master --force""",
                        "8",
                        "10M",
                        "how to gain dominance among developers");
    }

    @Test(description = "Entered paste name match new paste name.")
    public void checkTitleTest() {
        String actual = new PastebinResultPage(driver).getPasteNameOfResultPage();
        String expected = "how to gain dominance among developers";
        Assert.assertEquals(actual, expected, "Wrong result of checkTitleTest()");
    }

    @Test(description = "Entered code text match code text in result page.")
    public void checkCodeTest() {
        String actual = new PastebinResultPage(driver).getInputtedCodeInResultPage();
        String expected = """
                git config --global user.name  "New Sheriff in Town"
                git reset $(git commit-tree HEAD^{tree} -m "Legacy code")
                git push origin master --force""";
        Assert.assertEquals(actual, expected, "Wrong result of checkCodeTest()!");
    }

    @Test(description = "Check syntax highlighting.")
    public void checkSyntaxHighlightingTest() {
        List<FontOfCssStyles> actual = new PastebinResultPage(driver).getBashCommandsCssStyles();
        final FontOfCssStyles expected = new FontOfCssStyles("rgba(194, 12, 185, 1)", "700");
        Assert.assertTrue(actual.stream().allMatch(style ->style.equals(expected)));
    }

    @AfterSuite(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }

}
