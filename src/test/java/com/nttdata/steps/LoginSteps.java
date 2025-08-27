package com.nttdata.steps;

import com.nttdata.page.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginSteps {
    private WebDriver driver;
    private WebDriverWait wait;

    public LoginSteps(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void typeEmail(String email) {
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPage.emailInput));
        emailField.sendKeys(email);
    }

    public void typePassword(String password) {
        WebElement passField = wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPage.passInput));
        passField.sendKeys(password);
    }

    public void login() {
        WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(LoginPage.loginButton));
        loginBtn.click();
    }
}
