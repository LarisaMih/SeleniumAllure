package com.Re;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DataBase {
    public  static WebDriver driver;
    public static StringBuffer verificationErrors = new StringBuffer();

    @Attachment(value = "Screenshot")//Прикручиваем скриншот к проекту Allure
    public static byte[] LinkScreenAllure(String path) throws IOException {
        return Files.readAllBytes(Paths.get(path));
    }
    @Step("Screen")//Создание скриншота
    public  static  void Screenshot(String name) throws IOException {
        TakesScreenshot scr = ((TakesScreenshot) driver);
        File file1 = scr.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file1, new File("C:/Users/User/IdeaProjects/Redesing/src/screenshot/"+name+".PNG"));
        DataBase.LinkScreenAllure("C:/Users/User/IdeaProjects/Redesing/src/screenshot/"+name+".PNG");

    }
}
