package utilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import java.util.List;
import java.util.Random;

public class PaymentHandler {

    public static void selectRandomRadioButton(List<WebElement> radioButtons) {
        int size = radioButtons.size();
        if (size > 0) {
            Random random = new Random();
            int randomIndex = random.nextInt(size);
            WebElement radioButton = radioButtons.get(randomIndex);
            JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
            js.executeScript("arguments[0].click();", radioButton);
        }
    }
}
