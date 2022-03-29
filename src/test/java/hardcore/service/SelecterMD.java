package hardcore.service;

import hardcore.helper.JSExecutor;
import hardcore.helper.Waiter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SelecterMD {

    private static final String ELEMENT_XPATH =
            "//div[@class = 'md-select-menu-container md-active md-clickable']//div[contains(text(),'%s')]";

    private final WebElement select;
    private WebElement option;
    private WebElement optionDiv;

    public SelecterMD(WebElement select) {
        this.select = select;
    }

    private void expandSelect() {
        JSExecutor.clickElement(select);
        Waiter.waitUntilAttributeAriaExpandedToBe(select, true);
    }

    private void findSelectOption(String optionText) {
        String elementXpath = String.format(ELEMENT_XPATH, optionText);
        By elementLocator = By.xpath(elementXpath);
        Waiter.waitUntilElementAppears(elementLocator);
        optionDiv = select.findElement(elementLocator);
        option = select.findElement(By.xpath(elementXpath + "/ancestor::md-option"));
    }

    private void selectOption() {
        JSExecutor.clickElement(option);
        JSExecutor.clickElement(optionDiv);
        Waiter.waitUntilElementToBeVisible(select);
    }

    public void selectByValue(String optionText) {
        expandSelect();
        findSelectOption(optionText);
        selectOption();
    }

    public void selectRegion(String region) {
        JSExecutor.clickElement(select);
        Waiter.waitUntilElementToBeVisible(select);
        String elementXpath = "//div[@class='md-select-menu-container cpc-region-select md-active md-clickable']" +
                "//md-option//div[contains(text(),'" + region + "')]";
        By elementLocator = By.xpath(elementXpath);
        optionDiv = select.findElement(elementLocator);
        option = select.findElement(By.xpath(elementXpath + "/ancestor::md-option"));
        selectOption();
    }
}








