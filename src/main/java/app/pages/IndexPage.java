package app.pages;

import app.Utils;
import app.Version;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class IndexPage {
    private static final By VERSION_SELECT_LOCATOR = By.id("switch-version-select");
    private static final By ADD_CUSTOMER_BUTTON_LOCATOR = By.xpath("/html/body/div[2]/div[2]/div[1]/div[2]/form/div[1]/div[1]/a");
    private static final By SEARCH_NAME_INPUT_LOCATOR = By.xpath("/html/body/div[2]/div[2]/div[1]/div[2]/form/div[2]/table/thead/tr[2]/td[3]/input");
    private static final By SEARCH_NAME_FIRST_RESULT_LOCATOR = By.xpath("/html/body/div[2]/div[2]/div[1]/div[2]/form/div[2]/table/tbody/tr[1]/td[3]");
    private static final By ACTION_MORE_BUTTON_LOCATOR = By.xpath("/html/body/div[2]/div[2]/div[1]/div[2]/form/div[2]/table/tbody/tr[1]/td[2]/div[1]/div/button");
    private static final By ACTION_DELETE_BUTTON_LOCATOR = By.xpath("/html/body/div[2]/div[2]/div[1]/div[2]/form/div[2]/table/tbody/tr[1]/td[2]/div[1]/div/div/a[3]");
    private static final By SUCCESS_MESSAGE_ELEMENT_LOCATOR = By.xpath("/html/body/div[3]/span[3]/p");

    private final WebDriver driver;

    public IndexPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setVersion(Version version) {
        WebElement selectElement = this.driver.findElement(VERSION_SELECT_LOCATOR);
        Select selectObject = new Select(selectElement);

        selectObject.selectByVisibleText(version.getVisibleText());
    }

    public void clickAddCustomer() {
        WebElement button = this.driver.findElement(ADD_CUSTOMER_BUTTON_LOCATOR);
        button.click();
    }

    public DeletePopUp deleteByCustomerName(String name) {
        WebElement input = this.driver.findElement(SEARCH_NAME_INPUT_LOCATOR);
        input.sendKeys(name);

        Utils.waitFor(this.driver, (driver) -> {
            WebElement e = driver.findElement(SEARCH_NAME_FIRST_RESULT_LOCATOR);
            if (e.getText().equalsIgnoreCase(name)) {
                return e;
            }

            return null;
        });

        WebElement moreButton = Utils.waitVisibilityAndGetElement(this.driver, ACTION_MORE_BUTTON_LOCATOR);
        moreButton.click();

        WebElement deleteButton = Utils.waitVisibilityAndGetElement(this.driver, ACTION_DELETE_BUTTON_LOCATOR);
        deleteButton.click();

        return new DeletePopUp(this.driver);
    }

    public String getSuccessDeletionMessage() {
        WebElement message = Utils.waitVisibilityAndGetElement(this.driver, SUCCESS_MESSAGE_ELEMENT_LOCATOR);
        return message.getText();
    }

}
