package com.Re;

import io.qameta.allure.*;
import org.apache.commons.io.FileUtils;
import org.aspectj.lang.annotation.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.print.attribute.standard.PrinterInfo;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class RedesingTest extends SeleniumSteps {

    @Owner("Михайлова Лариса")
    @Description("Запуск браузера")
    @Feature("Сайт Редизигн")
    @Story("Проверка заголовка")
    @BeforeClass

    public void OpenMainPage() throws Exception {
        String name = "Main";
         SeleniumSteps.StartBrouser(EndPoints.redesing, name);
    }

    @Owner("Михайлова Лариса")
    @Description("Закрываем  браузер")
    @Feature("Сайт Редизигн")
    @Story("Проверка заголовка")
    @AfterClass
    public void finish() throws Exception {
        SeleniumSteps.ShutDown();
    }

    @Owner("Михайлова Лариса")
    @Description("Проверяем Title")
    @Feature("Сайт Редизигн")
    @Story("Проверка заголовка")
   // @Test(priority = 1, description = "Проверка Титла на главной странице")
@Test(priority = 1)
    public void AssertTitle() throws Exception {

        String titl = driver.getTitle();
        String expTitl= "Ставки на спорт - Букмекерская контора «Олимп»";
        String name = "Title";

        driver.findElement(EndPoints.e).click();
        driver.findElement(By.name("phone")).sendKeys("916482-55-92");
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("1234Qw");
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='visibility'])[1]/following::button[1]")).click();
//driver.findElement(By.linkText("Войти"));
        sleep(8);
        SeleniumSteps.AssertTitle(titl,expTitl);
        DataBase.Screenshot(name);

    }

    @Owner("Михайлова Лариса")
    @Description("Проверяем Title")
    @Feature("Сайт Редизигн")
    @Story("Проверка заголовка")
    @Test(priority = 4)

    public void AssertTitle2() throws Exception {

    }

    @Owner("Михайлова Лариса")
    @Description("Проверяем при переходе на линию  title и URL")
    @Feature("Сайт Редизигн")
    @Story("Линия")
    @Test(priority = 2)
    public void AssertLineTitle() throws Exception {
        SeleniumSteps.ClikLine();
        String titleLine= driver.getTitle();
        Assert.assertEquals(titleLine, "Линия ставок на спорт - Букмекерская контора «Олимп»");
        System.out.println("line");
        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.equals("https://redesing.olimp.dev/line"), "ссылка иная");


    }


    @Owner("Михайлова Лариса")
    @Description("Вводим в поиске мак и находим элементы")
    @Feature("Сайт Редизигн")
    @Story("Поиск")
    @Test(priority = 3)
    public void search() throws Exception {
        driver.findElement(EndPoints.search).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Линия'])[2]/following::input[1]")).sendKeys("мак");
        sleep(1000);
        DataBase.Screenshot("search");

        driver.findElement(EndPoints.event);
        //String ass = "Search";

    }
}
