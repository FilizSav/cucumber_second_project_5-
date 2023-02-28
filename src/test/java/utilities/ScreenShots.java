package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenShots implements ITestListener {

    public static void takeSnapShot(WebDriver webdriver) throws IOException {
        File srcFile = ((TakesScreenshot)webdriver).getScreenshotAs(OutputType.FILE);
        File destFile = new File("ScreenShotFolder//"+timeStamp() +".png");
        FileUtils.copyFile(srcFile,destFile);
    }
    public static String timeStamp(){
        return new SimpleDateFormat("yyyy-MM-dd HH-mm").format(new Date());
    }
    public static void takeSnapShotFailure(String name) throws IOException {
        File srcFile = ((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.FILE);
        File destFile = new File("ScreenShotFolder//"+timeStamp() +".png");
        FileUtils.copyFile(srcFile,destFile);
    }
    public void onTestFailure(ITestResult result) {
        try{
            takeSnapShotFailure(result.getName());
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
