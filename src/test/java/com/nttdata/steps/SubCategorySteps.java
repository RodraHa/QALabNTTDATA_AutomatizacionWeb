package com.nttdata.steps;

import com.nttdata.page.LoginPage;
import com.nttdata.page.SubCategoryPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SubCategorySteps {
    private WebDriver driver;
    private WebDriverWait wait;

    public SubCategorySteps(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
    }

    public void clickFirstItem() {
        WebElement firstProduct = wait.until(ExpectedConditions.elementToBeClickable(SubCategoryPage.firstProduct));
        firstProduct.click();
    }
}
