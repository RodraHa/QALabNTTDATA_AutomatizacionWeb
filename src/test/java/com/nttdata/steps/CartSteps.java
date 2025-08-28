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

    public double getProductPrice() {
        WebElement priceElement = wait.until(ExpectedConditions.visibilityOfElementLocated(CartPage.unitPrice));
        String priceText = priceElement.getText();

        priceText = priceText.replaceAll("[^0-9,]", "").replace(",", ".");

        return Double.parseDouble(priceText);
    }

    public int getProductQuantity() {
        WebElement quantityInput = wait.until(ExpectedConditions.visibilityOfElementLocated(CartPage.quantityInput));
        String quantityText = quantityInput.getAttribute("value");

        quantityText = quantityText.replaceAll("[^0-9,]", "").replace(",", ".");

        return Integer.parseInt(quantityText);
    }

    public double getTotalProduct() {
        WebElement totalElement = wait.until(ExpectedConditions.visibilityOfElementLocated(CartPage.productTotal));
        String totalText = totalElement.getText();

        totalText = totalText.replaceAll("[^0-9,]", "").replace(",", ".");

        return Double.parseDouble(totalText);
    }

    public double getTotalCart() {
        WebElement totalElement = wait.until(ExpectedConditions.visibilityOfElementLocated(CartPage.cartTotal));
        String totalText = totalElement.getText();

        totalText = totalText.replaceAll("[^0-9,]", "").replace(",", ".");

        return Double.parseDouble(totalText);
    }
}
