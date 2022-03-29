package ibringiton.pageobject_model.page;

import icanwin.pageobject_model.page.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class PastebinResultPage extends BasePage {

    @FindBy(xpath = "//div[@class='post-view']//h1")
    private WebElement newPasteName;

    @FindBy(className = "bash")
    private WebElement codeText;

    @FindBy(className = "kw2")
    private List<WebElement> bashStyle;

    public PastebinResultPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected BasePage openPage() {
        throw new RuntimeException("Cannot open this page without creating a new paste");
    }

    public List<FontOfCssStyles> getBashCommandsCssStyles() {
        List<FontOfCssStyles> fontOfCssStyles = new ArrayList<>();

        for (WebElement style : bashStyle) {
            fontOfCssStyles.add(new FontOfCssStyles(style.getCssValue(FontOfCssStyles.COLOR_ATTRIBUTE),
                    style.getCssValue(FontOfCssStyles.FONT_WEIGHT_ATTRIBUTE)));
        }
        return fontOfCssStyles;
    }

    public String getPasteNameOfResultPage() {
        return newPasteName.getText();
    }

    public String getInputtedCodeInResultPage() {
        return codeText.getText();
    }

    public static class FontOfCssStyles {
        private static final String COLOR_ATTRIBUTE= "color";
        private static final String FONT_WEIGHT_ATTRIBUTE = "font-weight";

        private final String color;
        private final String weight;

        public FontOfCssStyles(String color, String weight) {
            this.color = color;
            this.weight = weight;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            FontOfCssStyles that = (FontOfCssStyles) o;

            if (!color.equals(that.color)) return false;
            return weight.equals(that.weight);
        }

        @Override
        public int hashCode() {
            int result = color.hashCode();
            result = 31 * result + weight.hashCode();
            return result;
        }
    }

}
