package ejercicio1_3;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class CreacionDeUnaTarea {

    private AppiumDriver appiumDriver;

    @BeforeEach
    public void openApplication() throws MalformedURLException {
        DesiredCapabilities capabilities= new DesiredCapabilities();
        capabilities.setCapability("deviceName","Camilo");
        capabilities.setCapability("platformVersion","9 PKQ1. 180729.001");
        capabilities.setCapability("appPackage","com.vrproductiveapps.whendo");
        capabilities.setCapability("appActivity",".ui.HomeActivity");
        capabilities.setCapability("platformName","Android");

        appiumDriver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);

        // implicit
        appiumDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @AfterEach
    public void closeApplication(){
        appiumDriver.quit();
    }


    @Test
    public void verifyCalculator() throws InterruptedException {
        //Thread.sleep(5000);

        String name="Nuevo";
        appiumDriver.findElement(By.id("com.vrproductiveapps.whendo:id/fab")).click();
        appiumDriver.findElement(By.id("com.vrproductiveapps.whendo:id/noteTextTitle")).click();
        appiumDriver.findElement(By.id("com.vrproductiveapps.whendo:id/noteTextTitle")).sendKeys(name);
        appiumDriver.findElement(By.id("com.vrproductiveapps.whendo:id/saveItem")).click();
        String actualResult = appiumDriver.findElement(By.xpath("//android.widget.ListView[@resource-id='com.vrproductiveapps.whendo:id/notesList']/android.view.ViewGroup[last()]//android.widget.TextView")).getText();

        Assertions.assertEquals(name,actualResult, "Error, no encontre la tarea");
    }


}
