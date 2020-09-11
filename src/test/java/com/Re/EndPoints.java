package com.Re;

import org.openqa.selenium.By;

public interface EndPoints {
    String dev = "https://desktop.olimp.dev/";
    String prod = "https://www.olimp.bet";
    public static final By line = By.linkText("Линия");
    public static final By search = By.cssSelector("#search_toggle");
    public static final By event = By.cssSelector("div[class=result-title]");
    //public static final By e = By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Акции'])[1]/following::span[3]");
   // public static final By e = By.xpath("(.//*[(text()) ='Идентификация'])[1]/following::span[3]");
    //public static final By e = By.xpath("(.//*[(text()) ='Вход'])[1]/following::span[3]");
    public static final By e = By.xpath(".//div[@id='header']/div/div/div[3]/ul/li/button");
}
