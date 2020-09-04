package com.Re;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import sun.jvm.hotspot.StackTrace;

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

        driver.findElement(EndPoints.line).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }


    @Step("Проверка что {num1} + {num2} = {expectedSum}")
    public static void Mat(float num1, float num2, float expectedSum){

        System.out.println("I see this script");
        Assert.assertTrue(num1 + num2 == expectedSum,"Сумма слагаемых не соответствует ожидаемому значению"+expectedSum);
    }

    @Step
    public static void Allure() throws IOException, InterruptedException {
        Thread.sleep(10);

        //Запуск батника для аллюр, 2 способа
        Runtime.getRuntime().exec("cmd /k C:\\Users\\User\\IdeaProjects\\Redesing\\src\\test\\resources/startAllure.bat");

        /*ProcessBuilder processBuilder = new ProcessBuilder("cmd", "/C", "C:\\Users\\User\\IdeaProjects\\Redesing\\src\\test\\resources/startAllure.bat");
        Process process = processBuilder.start();*/

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
