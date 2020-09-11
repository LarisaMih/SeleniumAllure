package com.Re;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class RedesingTest extends SeleniumSteps {

    @Owner("Михайлова Лариса")
    @Description("Запуск браузера")
    @Feature("Тесты по олимпу")
    @Story("Проверка заголовка")
    @BeforeClass(groups = {"householdapi", "householdapi2", "prod"})
            // @BeforeClass(groups ={"householdapi2"})
   /* public void OpenMainPage() throws Exception {
        String name = "Main";
        SeleniumSteps.StartBrouser(EndPoints.redesing, name);
    }*/



    public void OpenMainPage() throws Exception {
       // DataBase.delete(); удаление папки
        String url = null;
        String env = System.getenv("env");
        if (env.equals("Prod")) {
            url = EndPoints.prod;
        } else if (env.equals("dev")) {
            url = EndPoints.dev;
        }
        String name = "Main";
        SeleniumSteps.StartBrouser(url, name);
    }


    @Owner("Михайлова Лариса")
    @Description("Закрываем  браузер")
    @Feature("Тесты по олимпу")
    @Story("Проверка заголовка")
    @AfterClass(groups = {"householdapi", "householdapi2", "prod"})
    // @AfterClass(groups ={"householdapi2"})
    public void finish() throws Exception {
        SeleniumSteps.Allure();
        SeleniumSteps.ShutDown();
        SeleniumSteps.Allure();

    }

    @Owner("Михайлова Лариса")
    @Description("Проверяем Title")
    @Feature("Тесты по олимпу")
    @Story("Проверка заголовка")
    // @Test(priority = 1, description = "Проверка Титла на главной странице")

    @Test(priority = 1)
    public void AssertTitle() throws Exception {

        String titl = driver.getTitle();
        String expTitl = "Ставки на спорт - Букмекерская контора «Олимп»";
        String name = "Title";
        driver.findElement(EndPoints.e).click();
        driver.findElement(By.name("phone")).sendKeys("916482-55-92");
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("1234Qw");
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='visibility'])[1]/following::button[1]")).click();
//driver.findElement(By.linkText("Войти"));
        sleep(8);
        SeleniumSteps.AssertTitle(titl, expTitl);
        DataBase.Screenshot(name);

    }

    @Owner("Михайлова Лариса")
    @Description("Проверяем Title")
    @Feature("Тесты по олимпу")
    @Story("Проверка заголовка")
    @Test(priority = 2)

    public void AssertTitle2() throws Exception {

        DataBase.LinkAllure("qw");
    }

    @Owner("Михайлова Лариса")
    @Description("Проверяем при переходе на линию  title и URL")
    @Feature("Тесты по олимпу")
    @Story("Линия")
    @Test(priority = 3, groups = {"householdapi2", "prod"})
    public void AssertLineTitle() throws Exception {
        SeleniumSteps.ClikLine();
        String titleLine = driver.getTitle();
        Assert.assertEquals(titleLine, "Ставки на спорт - Букмекерская контора «Олимп»");
        System.out.println("line");
      /*  String url = driver.getCurrentUrl();
        Assert.assertTrue(url.equals("https://redesing.olimp.dev/line"), "ссылка иная");*/
    }

    @Owner("Михайлова Лариса")
    @Description("Вводим в поиске мак и находим элементы")
    @Feature("Тесты по олимпу")
    @Story("Поиск")

    //@Test
    @Test(priority = 4, groups = {"householdapi", "prod"})
    public void search() throws Exception {
        driver.findElement(EndPoints.search).click();
        driver.findElement(By.xpath("//input[@value='']")).sendKeys("мак");
        sleep(1000);
        DataBase.Screenshot("search");
        DataBase.LinkScreenAllure("C:/Users/User/IdeaProjects/Redesing/src/screenshot/search.PNG");
        DataBase.LinkScreenAllure("C:/Users/User/IdeaProjects/Redesing/src/screenshot/log.txt");
        DataBase.LinkAllure("Тестовый текст");

    }

    @Feature("Математика")
    @Test(priority = 5, groups = {"householdapi", "prod"})
    public void Check() throws Exception {

        Mat(44.44f, 44.22f, 88.66f);

    }


}
