package com.nttdata.steps;

import com.nttdata.page.LoginPage;
import com.nttdata.page.ProductPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductSteps {
    private WebDriver driver;
    private WebDriverWait wait;

    public ProductSteps(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
    }

    public void typeQuantity(int quantity) {
        WebElement quantityInput = wait.until(ExpectedConditions.visibilityOfElementLocated(ProductPage.quantityInput));
        quantityInput.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
        quantityInput.sendKeys(String.valueOf(quantity));
    }

    public void addToCart() {
        WebElement addToCartBtn = wait.until(ExpectedConditions.elementToBeClickable(ProductPage.addToCartButton));
        addToCartBtn.click();
    }

    public String getProductAddedToCartMessage() {
        WebDriverWait shortWait = new WebDriverWait(driver, java.time.Duration.ofSeconds(2));

        WebElement modalLabel = shortWait.until(
                ExpectedConditions.visibilityOfElementLocated(ProductPage.labelSuccess)
        );

        return modalLabel.getText();
    }
}
