package com.nttdata.steps;

import com.nttdata.page.StorePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class StoreSteps {
    private WebDriver driver;
    private WebDriverWait wait;

    private Map<String, By> categoriesMap = new HashMap<>();
    private Map<String, Map<String, By>> subCategoriesMap = new HashMap<>();


    public StoreSteps(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        categoriesMap.put("Accesorios", StorePage.accesoriosCategory);
        categoriesMap.put("Clothes", StorePage.clothesCategory);
        categoriesMap.put("Art", StorePage.artCategory);

        Map<String, By> clothesSubs = new HashMap<>();
        clothesSubs.put("Men", StorePage.menSub);
        clothesSubs.put("Women", StorePage.womenSub);
        Map<String, By> accesoriosSubs = new HashMap<>();
        clothesSubs.put("Stationery", StorePage.stationerySub);
        clothesSubs.put("Home Accessories", StorePage.homeSub);

        subCategoriesMap.put("Clothes", clothesSubs);
        subCategoriesMap.put("Accesorios", accesoriosSubs);
        subCategoriesMap.put("Art", new HashMap<>());
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

    public void goToSubCategory(String category, String subCategory) {
        if (!categoriesMap.containsKey(category)) {
            throw new IllegalArgumentException("Categoría desconocida: " + category);
        }

        if (!subCategoriesMap.get(category).containsKey(subCategory)) {
            throw new IllegalArgumentException(
                    "Subcategoría desconocida: " + subCategory + " para la categoría " + category
            );
        }

        WebElement categoryElement = wait.until(ExpectedConditions.visibilityOfElementLocated(categoriesMap.get(category)));

        Actions actions = new Actions(driver);
        actions.moveToElement(categoryElement).perform();

        WebElement subCategoryElement = wait.until(
                ExpectedConditions.elementToBeClickable(subCategoriesMap.get(category).get(subCategory))
        );
        subCategoryElement.click();
    }
}
