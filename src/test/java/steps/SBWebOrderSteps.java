package steps;

import com.github.javafaker.Faker;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.SBLoginPage;
import pages.SBWebOrder;
import utilities.*;

import java.util.List;

public class SBWebOrderSteps {
    WebDriver driver;
    SBLoginPage sbLoginPage;
    SBWebOrder sbWebOrder;
    Faker fD;

    @Before
    public void setup(){
        driver = Driver.getDriver();
        sbLoginPage = new SBLoginPage();
        sbWebOrder = new SBWebOrder();
        fD = new Faker();
    }

    @Then("user should be routed to {string}")
    public void userShouldBeRoutedTo(String url) {
        Assert.assertEquals(url,driver.getCurrentUrl());
    }

    @And("validate below menu items are displayed")
    public void validateBelowMenuItemsAreDisplayed(DataTable dataTable) {
        int i = 0;
        List<String> expectedHeader = dataTable.asList();
        for(WebElement header : sbWebOrder.menuList){
        Assert.assertEquals(expectedHeader.get(i++),header.getText());
        }
    }

    @When("user clicks on {string} button")
    public void userClicksOnButton(String button) {
        switch (button){
            case "Check All":
                sbWebOrder.checkUncheckButtons.get(0).click();
                break;
            case "Uncheck All":
                sbWebOrder.checkUncheckButtons.get(1).click();
                break;
            case "Process":
                sbWebOrder.processButton.click();
                Waiter.pause(3);
                break;
            case "Delete Selected":
                sbWebOrder.deleteAllButton.click();
                break;
            default: throw new NotFoundException();
        }
    }

    @Then("all rows should be checked")
    public void allRowsShouldBeChecked() {
        for(WebElement checkbox : sbWebOrder.checkBoxList){
            Assert.assertTrue(checkbox.isSelected());
        }
    }

    @Then("all rows should be unchecked")
    public void allRowsShouldBeUnchecked() {
        for(WebElement checkbox : sbWebOrder.checkBoxList){
            Assert.assertFalse(checkbox.isSelected());
        }
    }

    @When("user clicks on {string} menu item")
    public void userClicksOnMenuItem(String item) {
        sbWebOrder.clickMenuItem(item);
    }

    @When("user selects {string} as product")
    public void user_selects_as_product(String product) {
        DropdownHandler.selectByVisibleText(sbWebOrder.productDropdown, product);
    }

    @And("user enters {int} as quantity")
    public void userEntersAsQuantity(int quantity) {
       sbWebOrder.quantity.sendKeys(Integer.toString(quantity));
    }

    @And("user enters all address information")
    public void userEntersAllAddressInformation() {
        String[] addressInfo = {"John Doe","222 West Palm st","Chicago","IL","60601"};
        for (int i = 0; i < sbWebOrder.addressInput.size(); i++) {
            sbWebOrder.addressInput.get(i).sendKeys(addressInfo[i]);
        }
        Waiter.pause(3);
    }

    @And("user enters all payment information")
    public void userEntersAllPaymentInformation() {
        sbWebOrder.cardOption.get(0).click();
        //Object[] paymentInfo = {fD.finance().creditCard().replaceAll("-","1"), "12/24"};
        Object[] paymentInfo = {"2345123455667123", "12/24"};
        for (int i = 0; i < sbWebOrder.cardInfo.size(); i++) {
            sbWebOrder.cardInfo.get(i).sendKeys(paymentInfo[i].toString());
        }
        Waiter.pause(3);
    }

    @Then("user should see their order displayed in the {string} table")
    public void userShouldSeeTheirOrderDisplayedInTheTable(String rows) {
        List<WebElement>tableRow = TableData.getTableRow(driver, 2);
        for (int i = 0; i < tableRow.size()-1; i++) {
            Assert.assertTrue(tableRow.get(i).isDisplayed());
        }
    }

    @And("validate all information entered displayed correct with the order")
    public void validateAllInformationEnteredDisplayedCorrectWithTheOrder(DataTable customerInfo) {
        List<WebElement>tableRow = TableData.getTableRow(driver, 2);
        for (int i = 0; i < tableRow.size()-1; i++) {
            Assert.assertEquals(customerInfo.asList().get(i), tableRow.get(i).getText());
        }
    }

    @Then("validate all orders are deleted from the {string}")
    public void validateAllOrdersAreDeletedFromThe(String arg0) {
        List<WebElement>tableRow = TableData.getTableRow(driver, 2);
        for (int i = 0; i < tableRow.size()-1; i++) {
            Assert.assertFalse(tableRow.get(i).isDisplayed());
        }
    }

    @And("validate user sees {string} message")
    public void validateUserSeesMessage(String message) {
        Assert.assertEquals(message, sbWebOrder.emptyMessage.getText());
    }
}
