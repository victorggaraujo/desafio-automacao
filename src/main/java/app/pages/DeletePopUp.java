package app.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import app.Utils;

public class DeletePopUp {
    private static final By DELETE_CONFIRMATION_MESSAGE_LOCATOR = By.xpath("/html/body/div[2]/div[2]/div[2]/div/div/div[2]/p");
    private static final By DELETE_CONFIRMATION_BUTTON = By.xpath("/html/body/div[2]/div[2]/div[2]/div/div/div[3]/button[2]");

    private final WebDriver driver;

    DeletePopUp(WebDriver driver) {
        this.driver = driver;
    }

    public String getMessage() {
        WebElement message = Utils.waitVisibilityAndGetElement(this.driver, DELETE_CONFIRMATION_MESSAGE_LOCATOR);
        return message.getText();
    }

    public void confirm() {
        WebElement button = Utils.waitVisibilityAndGetElement(this.driver, DELETE_CONFIRMATION_BUTTON);
        button.click();
    }
}