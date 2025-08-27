package com.nttdata.steps;

import com.nttdata.page.StorePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class StoreSteps {
    private WebDriver driver;
    private WebDriverWait wait;

    public StoreSteps(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Espera de hasta 10 seg
    }

    public void openLoginPage() {
        WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(StorePage.loginButton));
        loginBtn.click();
    }

    public boolean isLoggedIn() {
        WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(2));
        try {
            WebElement logout = shortWait.until(
                    ExpectedConditions.visibilityOfElementLocated(StorePage.logoutButton)
            );
            return logout.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
