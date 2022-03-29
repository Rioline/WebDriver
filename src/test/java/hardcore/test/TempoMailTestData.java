package hardcore.test;

import hardcore.page.AbstractPage;
import hardcore.page.GoogleCloudHomePage;
import org.openqa.selenium.WebDriver;

public class TempoMailTestData extends AbstractPage {
    @Override
    public AbstractPage openPage() {
        throw new RuntimeException("Wrong page.");
    }

    public TempoMailTestData(WebDriver driver) {
        super(driver);
    }

    public void fillTempoMailData() {
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
}
