package app.pages;

import app.CustomerFormData;
import app.Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CustomerFormPage {
    private static final By NAME_INPUT_LOCATOR = By.id("field-customerName");
    private static final By LAST_NAME_INPUT_LOCATOR = By.id("field-contactLastName");
    private static final By CONTACT_FIRST_NAME_INPUT_LOCATOR = By.id("field-contactFirstName");
    private static final By PHONE_NUMBER_INPUT_LOCATOR = By.id("field-phone");
    private static final By ADDRESS_LINE_1_INPUT_LOCATOR = By.id("field-addressLine1");
    private static final By ADDRESS_LINE_2_INPUT_LOCATOR = By.id("field-addressLine2");
    private static final By CITY_INPUT_LOCATOR = By.id("field-city");
    private static final By STATE_INPUT_LOCATOR = By.id("field-state");
    private static final By POSTAL_CODE_INPUT_LOCATOR = By.id("field-postalCode");
    private static final By COUNTRY_INPUT_LOCATOR = By.id("field-country");
    private static final By EMPLOYEE_INPUT_LOCATOR = By.id("field-salesRepEmployeeNumber");
    private static final By CREDIT_LIMIT_INPUT_LOCATOR = By.id("field-creditLimit");
    private static final By SAVE_BUTTON_LOCATOR = By.xpath(
            "/html/body/div[2]/div/div/div/div[2]/form/div[16]/div/button[1]"
    );
    private static final By CANCEL_BUTTON_LOCATOR = By.xpath(
            "/html/body/div[2]/div/div/div/div[2]/form/div[16]/div/button[3]"
    );
    private static final By SUCCESS_POPUP_LAST_CHILD_LOCATOR = By.xpath(
            "/html/body/div[2]/div/div/div/div[2]/form/div[15]/div[2]/p/a[2]"
    );

    private final WebDriver driver;

    public CustomerFormPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillForm(CustomerFormData data) {
        this.driver.findElement(NAME_INPUT_LOCATOR).sendKeys(data.getName());
        this.driver.findElement(LAST_NAME_INPUT_LOCATOR).sendKeys(data.getLastName());
        this.driver.findElement(CONTACT_FIRST_NAME_INPUT_LOCATOR).sendKeys(data.getContactFirstName());
        this.driver.findElement(PHONE_NUMBER_INPUT_LOCATOR).sendKeys(data.getPhoneNumber());
        this.driver.findElement(ADDRESS_LINE_1_INPUT_LOCATOR).sendKeys(data.getAddressLine1());
        this.driver.findElement(ADDRESS_LINE_2_INPUT_LOCATOR).sendKeys(data.getAddressLine2());
        this.driver.findElement(CITY_INPUT_LOCATOR).sendKeys(data.getCity());
        this.driver.findElement(STATE_INPUT_LOCATOR).sendKeys(data.getState());
        this.driver.findElement(POSTAL_CODE_INPUT_LOCATOR).sendKeys(data.getPostalCode());
        this.driver.findElement(COUNTRY_INPUT_LOCATOR).sendKeys(data.getCountry());
        this.driver.findElement(EMPLOYEE_INPUT_LOCATOR).sendKeys(data.getEmployeeNumber());
        this.driver.findElement(CREDIT_LIMIT_INPUT_LOCATOR).sendKeys(data.getCreditLimit());
    }

    public void saveForm() {
        this.driver.findElement(SAVE_BUTTON_LOCATOR).click();
    }

    public String getResultPopupText() {
        WebElement result = Utils.waitVisibilityAndGetElement(this.driver, SUCCESS_POPUP_LAST_CHILD_LOCATOR);

        return result.findElement(By.xpath("./..")).getText();
    }

    public void goBack() {
        this.driver.findElement(CANCEL_BUTTON_LOCATOR).click();
    }
}