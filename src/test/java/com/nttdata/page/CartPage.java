package com.nttdata.page;

import org.openqa.selenium.By;

public class CartPage {
    public static By cartTitle = By.className("h1");
    public static By unitPrice = By.cssSelector("span.price");
    public static By quantityInput = By.cssSelector("input.js-cart-line-product-quantity");
    public static By productTotal = By.cssSelector("span.product-price strong");
    public static By cartTotal = By.xpath("/html/body/main/section/div/div/div/section/div/div[2]/div[1]/div[1]/div[1]/div/span[2]");
}
