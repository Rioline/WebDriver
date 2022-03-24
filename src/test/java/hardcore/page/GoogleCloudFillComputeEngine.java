package hardcore.page;

import hardcore.helper.JSExecutor;
import hardcore.helper.Waiter;
import hardcore.service.SelecterMD;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleCloudFillComputeEngine extends AbstractPage {
    @FindBy(xpath = "//input[@name = 'quantity']")
    public WebElement numberOfInstances;

    @FindBy(xpath = "//label[text()='What are these instances for?']//following::input[1]")
    public WebElement purposeOfUses;

    @FindBy(xpath = "//label[text()='Operating System / Software']//following::md-select[1]")
    public WebElement operatingSystems;

    @FindBy(xpath = "//label[text()='Machine Class']//following::md-select[1]")
    public WebElement virtualMachinesClasses;

    @FindBy(xpath = "//label[text()='Series']//following::md-select[1]")
    public WebElement series;

    @FindBy(xpath = "//label[text()='Machine type']//following::md-select[1]")
    public WebElement machineTypes;

    @FindBy(xpath = "//div[11]//md-input-container/md-checkbox")
    public WebElement addGPUs;

    @FindBy(xpath = "//label[text()='GPU type']//following::md-select[1]")
    public WebElement addGPUTypes;

    @FindBy(xpath = "//label[text()='Number of GPUs']//following::md-select[1]")
    public WebElement numberOfGPUs;

    @FindBy(xpath = "//label[text()='Local SSD']//following::md-select[1]")
    public WebElement localSSDs;

    @FindBy(xpath = "//label[text()='Committed usage']//following::md-select[1]")
    private WebElement committedUsages;

    @FindBy(xpath = "//label[text()='Datacenter location']//following::md-select-value[1]")
    public WebElement datacenterLocations;

    @FindBy(xpath = "//button[@aria-label='Add to Estimate']")
    private WebElement addToEstimateButton;

    @FindBy(xpath = "//*[@id='email_quote']")
    public WebElement emailEstimate;

    @Override
    public AbstractPage openPage() {
        throw new RuntimeException("Cannot open search page without searching.");
    }

    public GoogleCloudFillComputeEngine(WebDriver driver) {
        super(driver);
    }

    public void fillNumberOfInstances(String numberOfInstance) {
        numberOfInstances.sendKeys(numberOfInstance);
    }

    public void fillInstancesFor(String purposeOfUse) {
        purposeOfUses.sendKeys(purposeOfUse);
    }

    public void fillOperatingSystem(String operatingSystem) {
        new SelecterMD(operatingSystems).selectByValue(operatingSystem);
    }

    public String fillMachineClass(String virtualMachinesClass) {
        new SelecterMD(virtualMachinesClasses).selectByValue(virtualMachinesClass);
        return virtualMachinesClasses.getText();
    }

    public void fillSeries(String serie) {
        new SelecterMD(series).selectByValue(serie);
    }

    public void fillMachineTypes(String machineType) {
        new SelecterMD(machineTypes).selectByValue(machineType);
    }

    public void fillCommittedUsage(String committedUsage) {
        new SelecterMD(committedUsages).selectByValue(committedUsage);
    }

    public void fillDatacenterLocation(String datacenterLocation) {
        new SelecterMD(datacenterLocations).selectRegion(datacenterLocation);
    }

    public void selectAddGPU() {
        JSExecutor.clickElement(addGPUs);
    }

    public void fillGPUType(String addGPUType) {
        Waiter.waitUntilElementToBeVisible(addGPUTypes);
        new SelecterMD(addGPUTypes).selectByValue(addGPUType);
    }

    public void fillNumberOfGPUs(String numberOfGpu) {
        new SelecterMD(numberOfGPUs).selectByValue(numberOfGpu);
    }

    public void fillLocalSSDs(String localSSD) {
        new SelecterMD(localSSDs).selectByValue(localSSD);
    }

    public void addTOEstimate(){
        JSExecutor.clickElement(addToEstimateButton);
    }

    public void pushEmailEstimate() {
        emailEstimate.click();
    }

    public GoogleCloudEstimatePage fillFormWithData(String numberOfInstance, String instanceFor, String operatingSoftware,
                                                    String virtualMachinesClass, String serie, String machineType,
                                                    String committedUsage, String datacenterLocation, String addGPUType,
                                                    String numberOfGpu, String localSSD) {
        fillNumberOfInstances(numberOfInstance);
        fillInstancesFor(instanceFor);
        fillOperatingSystem(operatingSoftware);
        fillMachineClass(virtualMachinesClass);
        fillSeries(serie);
        fillMachineTypes(machineType);
        fillCommittedUsage(committedUsage);
        fillDatacenterLocation(datacenterLocation);
        selectAddGPU();
        fillGPUType(addGPUType);
        fillNumberOfGPUs(numberOfGpu);
        fillLocalSSDs(localSSD);
        addTOEstimate();
        pushEmailEstimate();
        return new GoogleCloudEstimatePage(driver);
    }
}
