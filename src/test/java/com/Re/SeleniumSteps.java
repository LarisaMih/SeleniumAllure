package com.Re;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.*;
import static org.testng.Assert.fail;

public class SeleniumSteps extends DataBase {



    @Step("Метод запускает работу Браузера получая в парметрах URL")
    public static void StartBrouser(String URL , String name) throws IOException, InterruptedException {

        System.setProperty("webdriver.gecko.driver", "C:\\tools\\geckodriver.exe");
       // String name = "Стартовая страницы";
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(URL);
        sleep(5000);
        DataBase.Screenshot(name);
    }
    @Step("Проверка заголовка ожидаемого с фактическим")
    public static void AssertTitle(String titl, String expTitl) throws IOException, InterruptedException {

        Assert.assertEquals(titl,expTitl);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }
    @Step ("Метод кликает по линии")
    public  static void ClikLine() throws IOException
    {
        //driver.get("https://redesing.olimp.dev/live/1");
        //driver.get(baseUrl+"/line");
        driver.findElement(EndPoints.line).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }


    @Step("Вход на главную страницу, проверка заголовка")
    public static void title(String URL) throws IOException, InterruptedException {


       // DataBase.Screenshot(name);


        /*File srcFile = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
         FileHandler.copy(srcFile, new File("resources/screenshots/" + result.getName() + "-" + currentTime + ".jpg"));
        String screenshotBase64 = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BASE64);*/
    }



    @Step("Закрываем браузер")
    public static void ShutDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }
}
