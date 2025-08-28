package com.nttdata.page;

import org.openqa.selenium.By;

public class ProductPage {
    public static By quantityInput = By.id("quantity_wanted");
    public static By addToCartButton = By.cssSelector(".btn.btn-primary.add-to-cart");
    public static By labelSuccess = By.id("myModalLabel");
}
