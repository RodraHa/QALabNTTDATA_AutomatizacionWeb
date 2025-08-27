package com.nttdata.page;

import org.openqa.selenium.By;

public class StorePage {

    public static By loginButton = By.className("user-info");
    public static By logoutButton = By.cssSelector("a.logout.hidden-sm-down");

    public static By accesoriosCategory = By.xpath("/html/body/main/header/div[2]/div/div[1]/div[2]/div[1]/ul/li[2]/a");
    public static By clothesCategory = By.xpath("/html/body/main/header/div[2]/div/div[1]/div[2]/div[1]/ul/li[1]/a");
    public static By artCategory = By.xpath("/html/body/main/header/div[2]/div/div[1]/div[2]/div[1]/ul/li[3]/a");

    public static By menSub = By.xpath("/html/body/main/header/div[2]/div/div[1]/div[2]/div[1]/ul/li[1]/div/ul/li[1]/a");
    public static By womenSub = By.xpath("/html/body/main/header/div[2]/div/div[1]/div[2]/div[1]/ul/li[1]/div/ul/li[2]/a");

    public static By stationerySub = By.xpath("/html/body/main/header/div[2]/div/div[1]/div[2]/div[1]/ul/li[2]/div/ul/li[1]/a");
    public static By homeSub = By.xpath("/html/body/main/header/div[2]/div/div[1]/div[2]/div[1]/ul/li[2]/div/ul/li[2]/a");
}
