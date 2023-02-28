package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SBLoginPage {
    public SBLoginPage() {
    PageFactory.initElements(Driver.getDriver(), this);}

    @FindBy(id = "ctl00_MainContent_username")
    public WebElement userNameInput;

    @FindBy(css = "input[id='ctl00_MainContent_password']")
    public WebElement passwordInput;

    @FindBy(id = "ctl00_MainContent_login_button")
    public WebElement loginButton;

    @FindBy(id = "ctl00_MainContent_status")
    public WebElement error;

}
