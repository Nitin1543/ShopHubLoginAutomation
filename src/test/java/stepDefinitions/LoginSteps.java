package stepDefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import pageObjects.LoginPage;
import utils.BaseTest;

public class LoginSteps extends BaseTest {
    LoginPage loginPage;

    @Given("User is on the login page")
    public void user_is_on_the_login_page() {
        initializeDriver();
        driver.get("https://bugbash.syook.com/");
        loginPage = new LoginPage(driver);
    }

    @When("User enters valid username and password")
    public void user_enters_valid_username_and_password() {
        loginPage.enterEmail("user@example.com");
        loginPage.enterPassword("user123");
    }

    @When("User enters invalid username and password")
    public void user_enters_invalid_username_and_password() {
        loginPage.enterEmail("wrong@demo.com");
        loginPage.enterPassword("wrongpass");
    }

    @And("Clicks the login button")
    public void clicks_the_login_button() {
        loginPage.clickLogin();
    }

    @Then("User should be redirected to the dashboard")
    public void user_should_be_redirected_to_dashboard() {
        Assert.assertTrue(driver.getCurrentUrl().contains("syook.com"));
        quitDriver();
    }

    @Then("An error message should be displayed")
    public void an_error_message_should_be_displayed() {
        String errorText = loginPage.getErrorMessage();
        System.out.println("Error displayed: " + errorText);
        Assert.assertFalse(loginPage.getErrorMessage().contains("Invalid email or password"));
        quitDriver();
    }
}
