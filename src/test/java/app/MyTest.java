package app;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import app.pages.CustomerFormPage;
import app.pages.DeletePopUp;
import app.pages.IndexPage;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class MyTest {
    private static final String URL = "https://www.grocerycrud.com/v1.x/demo/my_boss_is_in_a_hurry/bootstrap";
    private static final String SUCCESS_MESSAGE = "Your data has been successfully stored into the database. Edit Record or Go back to list";
    private static final String DELETE_CONFIRMATION_MESSAGE = "Are you sure that you want to delete this record?";
    private static final String DELETE_SUCCESS_MESSAGE = "Your data has been successfully deleted from the database.";

    private WebDriver driver;

    @BeforeAll
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupTest() {
        driver = new ChromeDriver();
    }

   @AfterEach
    void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    void test() {
        this.driver.get(URL);
        IndexPage indexPage = new IndexPage(this.driver);

        indexPage.setVersion(Version.BOOTSTRAP_V4_THEME);
        indexPage.clickAddCustomer();

        CustomerFormPage formPage = new CustomerFormPage(this.driver);
        formPage.fillForm(TestData.CUSTOMER_FORM_DATA.getFormData());
        formPage.saveForm();
        String successPopupMessage = formPage.getResultPopupText();

        assertEquals(SUCCESS_MESSAGE, successPopupMessage);
    }

    @Test
    void secondTest() {
        test();

        CustomerFormPage formPage = new CustomerFormPage(this.driver);
        formPage.goBack();

        IndexPage indexPage = new IndexPage(this.driver);
        DeletePopUp confirmation =indexPage.deleteByCustomerName(TestData.CUSTOMER_FORM_DATA.getFormData().getName());

        assertEquals(DELETE_CONFIRMATION_MESSAGE, confirmation.getMessage());

        confirmation.confirm();

        assertEquals(DELETE_SUCCESS_MESSAGE, indexPage.getSuccessDeletionMessage());
    }
}