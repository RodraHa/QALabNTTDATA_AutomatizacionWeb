package com.nttdata.steps;

import com.nttdata.page.CartPage;
import com.nttdata.page.ProductPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartSteps {
    private WebDriver driver;
    private WebDriverWait wait;

    public CartSteps(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
    }

    public String getCartTitle() {
        WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(CartPage.cartTitle));
        return title.getText();
    }
}
