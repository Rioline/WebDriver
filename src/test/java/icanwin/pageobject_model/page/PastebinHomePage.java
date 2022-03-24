package icanwin.pageobject_model.page;

/*
        I Can Win
    При выполнении задания необходимо использовать возможности Selenium WebDriver,
    юнит-тест фреймворка и концепцию Page Object. Автоматизировать следующий сценарий:
    1.Открыть https://pastebin.com или аналогичный сервис в любом браузере
    2.Создать New Paste со следующими деталями:
    Код: "Hello from WebDriver"
    Paste Expiration: "10 Minutes"
    Paste Name / Title: "helloweb"
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PastebinHomePage extends BasePage {

    private static final String HOMEPAGE_URL = "https://pastebin.com/";

    @FindBy(xpath = "//*[@class='sc-ifAKCX ljEJIv']")   //remove Agree popUp
    private WebElement agreePopUp;

    @FindBy(id = "postform-text")   //Paste code
    private WebElement codeInput;

    @FindBy(id = "postform-expiration")    //Paste Expiration
    private WebElement pasteExpirationSelect;

    @FindBy(id = "postform-name")   //Paste name
    private WebElement pasteNameInput;

    @FindBy(xpath = "//button[@type='submit']")  //Create new paste
    private WebElement createButton;

    public PastebinHomePage(WebDriver driver) {
        super(driver);
    }

    public PastebinHomePage openPage() {
        driver.get(HOMEPAGE_URL);
        return this;
    }

    public void popUp() {
        waitUntilElementBeVisible(agreePopUp);
        agreePopUp.click();
    }

    public void fillCodeText(String codeText) {
        codeInput.sendKeys(codeText);
    }

    public void fillPasteExpiration(String pasteExpiration) {
        new PastebinSelect(driver, pasteExpirationSelect).selectOption(pasteExpiration);
    }

    public void fillPasteName(String pasteName) {
        pasteNameInput.sendKeys(pasteName);
    }

    public void submitCreatingPaste() {
        createButton.click();
    }

}
