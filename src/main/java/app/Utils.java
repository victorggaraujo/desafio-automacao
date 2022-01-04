package app;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utils {
    public static WebElement waitVisibilityAndGetElement(WebDriver driver, By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement waitFor(WebDriver driver, Function<? super WebDriver, WebElement> isTrue) {
        return new WebDriverWait(driver, Duration.ofSeconds(10)).until(isTrue);
    }
}
