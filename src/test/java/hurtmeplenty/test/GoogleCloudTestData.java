package hurtmeplenty.test;

import hurtmeplenty.page.AbstractGooglePage;

import hurtmeplenty.page.GoogleCloudHomePage;
import org.openqa.selenium.WebDriver;

public class GoogleCloudTestData extends AbstractGooglePage {
    public void fillTestData() {

        new GoogleCloudHomePage(driver)
                .openPage()
                .searchPage()
                .openCalculator()
                .switchToFrameAndSelectCompute()
                .fillFormWithData(
                        "4",
                        "",
                        "Free: Debian, CentOS, CoreOS, Ubuntu or BYOL (Bring Your Own License)",
                        "Regular",
                        "N1",
                        "n1-standard-8 (vCPUs: 8, RAM: 30GB)",
                        "1 Year",
                        "Frankfurt (europe-west3)",
                        "NVIDIA Tesla P100",
                        "1",
                        "2x375");

    }

    @Override
    public AbstractGooglePage openPage() {
        throw new RuntimeException();
    }

    public GoogleCloudTestData(WebDriver driver) {
        super(driver);
    }
}
