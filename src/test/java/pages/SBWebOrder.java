package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SBWebOrder extends SBLoginPage {
    public SBWebOrder() {super();}

    @FindBy(xpath = "//li//a")
    public List<WebElement> menuList;

    @FindBy(xpath = "//p//a")
    public List<WebElement> checkUncheckButtons;

    @FindBy(xpath = "//td//input[@type='checkbox']")
    public List<WebElement> checkBoxList;

    @FindBy(css = "select[id*='MainContent']")
    public WebElement productButton;

    @FindBy(css = "select[id*='MainContent']>option")
    public List<WebElement> productList;

    @FindBy(id = "input[id*='Quantity']")
    public WebElement quantity;

    @FindBy(id = "input[id*='Name']")
    public WebElement name;

    @FindBy(xpath = "//ol[2]/li/input")
    public List<WebElement> addressInput;

    @FindBy(xpath = "//td/input")
    public List<WebElement> cardOption;

    @FindBy(xpath = "//ol[3]/li/input")
    public List<WebElement> cardInfo;

    @FindBy(css = "a[id*='InsertButton']")
    public WebElement processButton;

    @FindBy(css = "table[class='SampleTable'] tr")
    public List<WebElement> tableRows;

    @FindBy(css = "input[id*='btnDelete']")
    public WebElement deleteAllButton;

    @FindBy(css = "div[id*='Message']")
    public WebElement emptyMessage;


    public void clickMenuItem(String menuItem){
        for (WebElement item : menuList) {
            if(item.getText().equals(menuItem)){
                item.click();
                break;
            }
        }
    }
}
