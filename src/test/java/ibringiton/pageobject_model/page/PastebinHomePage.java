package ibringiton.pageobject_model.page;

/*
       Bring It On
   При выполнении задания необходимо использовать возможности Selenium WebDriver,
   юнит-тест фреймворка и концепцию Page Object.
   Автоматизировать следующий сценарий:
   1. Открыть https://pastebin.com  или аналогичный сервис в любом браузере
   2. Создать New Paste со следующими деталями:
   Код:
   git config --global user.name  "New Sheriff in Town"
   git reset $(git commit-tree HEAD^{tree} -m "Legacy code")
   git push origin master --force
   Syntax Highlighting: "Bash"
   Paste Expiration: "10 Minutes"
   Paste Name / Title: "how to gain dominance among developers"
   3. Сохранить paste и проверить следующее:
   Заголовок страницы браузера соответствует Paste Name / Title
   Синтаксис подcвечен для bash
   Проверить что код соответствует введенному в пункте 2
 */

import icanwin.pageobject_model.page.PastebinSelect;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PastebinHomePage extends BasePage {

    private static final String HOMEPAGE_URL = "https://pastebin.com/"; //0 open page()

    @FindBy(xpath = "//*[@class='sc-ifAKCX ljEJIv']")   //1 remove Agree popUp
    private WebElement agreePopUp;

    @FindBy(id = "postform-format")     //2 Paste Bash Syntax Select
    private WebElement syntaxHighLightingSelect;

    @FindBy(id = "postform-text")   //3 Paste code
    private WebElement codeInput;

    @FindBy(id = "postform-expiration")    //4 Paste Expiration Select
    private WebElement pasteExpirationSelect;

    @FindBy(id = "postform-name")   //5 Paste name
    private WebElement pasteNameInput;

    @FindBy(xpath = "//button[@type='submit']")  //6 Create new paste
    private WebElement createButton;

    public PastebinHomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public PastebinHomePage openPage() {
        driver.get(HOMEPAGE_URL);
        return this;
    }

    public void popUp() {
        waitUntilElementBeVisible(agreePopUp);
        agreePopUp.click();
    }

    public void fillPasteSyntaxHighLight(String syntaxHighLighting) {
        new PastebinSelect(driver, syntaxHighLightingSelect).selectOption(syntaxHighLighting);
    }

    public String fillCodeText(String codeText) {
        codeInput.sendKeys(codeText);
        return codeText;
    }

    public void fillPasteExpiration(String pasteExpiration) {
        new PastebinSelect(driver, pasteExpirationSelect).selectOption(pasteExpiration);
    }

    public String fillPasteName(String pasteName) {
        pasteNameInput.sendKeys(pasteName);
        return pasteName;
    }

    public void submitCreatingPaste() {
        createButton.click();
    }

    public PastebinResultPage createNewPastebin(String codeText, String syntaxHighLight,
                                                String pasteExpiration, String pasteName) {
        openPage();
        popUp();
        fillCodeText(codeText);
        fillPasteSyntaxHighLight(syntaxHighLight);
        fillPasteExpiration(pasteExpiration);
        fillPasteName(pasteName);
        submitCreatingPaste();
        popUp();
        return new PastebinResultPage(driver);
    }

}
