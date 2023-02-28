package steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.SBLoginPage;
import utilities.Driver;

public class SBSteps {
    WebDriver driver;
    SBLoginPage sbLoginPage;

    @Before
    public void setup(){
        driver = Driver.getDriver();
        sbLoginPage = new SBLoginPage();
    }

    @Given("user is on {string}")
    public void userIsOn(String url) {
        driver.get(url);
    }

    @When("user enters username as {string}")
    public void userEntersUsernameAs(String username) {
        sbLoginPage.userNameInput.sendKeys(username);
    }

    @And("user enters password as {string}")
    public void userEntersPasswordAs(String password) {
        sbLoginPage.passwordInput.sendKeys(password);
    }

    @And("user clicks on Login button")
    public void userClicksOnLoginButton() {
        sbLoginPage.loginButton.click();
    }

    @Then("user should see {string} message")
    public void userShouldSeeMessage(String error) {
        Assert.assertEquals(error,sbLoginPage.error.getText());
    }
}
