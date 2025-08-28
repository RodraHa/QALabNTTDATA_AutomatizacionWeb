package com.nttdata.stepsdefinitions;

import com.nttdata.page.StorePage;
import com.nttdata.steps.*;
import io.cucumber.java.PendingException;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import static com.nttdata.core.DriverManager.getDriver;
import static com.nttdata.core.DriverManager.screenShot;

public class ProductStepsDef {
    private WebDriver driver;
    private StoreSteps storeSteps;
    private ProductSteps productSteps;
    private CartSteps cartSteps;

    @Dado("estoy en la página de la tienda")
    public void estoyEnLaPáginaDeLaTienda() {
        driver = getDriver();
        driver.get("https://qalab.bensg.com/store");
        screenShot();
    }

    @Y("me logueo con mi usuario {string} y clave {string}")
    public void meLogueoConMiUsuarioYClave(String email, String password) {
        storeSteps = new StoreSteps(driver);
        storeSteps.openLoginPage();
        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps.typeEmail(email);
        loginSteps.typePassword(password);
        loginSteps.login();
        screenShot();
        // Validar la autentificacion
        Assertions.assertTrue(storeSteps.isLoggedIn());
    }

    @Cuando("navego a la categoria {string} y subcategoria {string}")
    public void navegoALaCategoriaYSubcategoria(String category, String subcategory) {
        storeSteps = new StoreSteps(driver);
        storeSteps.goToSubCategory(category, subcategory);
        screenShot();
    }

    @Y("agrego {int} unidades del primer producto al carrito")
    public void agregoUnidadesDelPrimerProductoAlCarrito(int quantity) {
        SubCategorySteps subCategorySteps = new SubCategorySteps(driver);
        subCategorySteps.clickFirstItem();
        screenShot();
        productSteps = new ProductSteps(driver);
        productSteps.typeQuantity(quantity);
        productSteps.addToCart();
        screenShot();
    }

    @Entonces("valido en el popup la confirmación del producto agregado")
    public void validoEnElPopupLaConfirmaciónDelProductoAgregado() {
        productSteps = new ProductSteps(driver);
        String text = productSteps.getProductAddedToCartMessage();
        Assertions.assertFalse(text.isEmpty());
        screenShot();
    }

    @Y("valido en el popup que el monto total sea calculado correctamente")
    public void validoEnElPopupQueElMontoTotalSeaCalculadoCorrectamente() {
        double price = productSteps.getProductPrice();
        int quantity = productSteps.getProductQuantity();
        double expectedTotal = price * quantity;
        double actualSubtotal = productSteps.getSubtotal();
        Assertions.assertEquals(expectedTotal, actualSubtotal, 0.01);
    }

    @Cuando("finalizo la compra")
    public void finalizoLaCompra() {
        productSteps.finishPurchase();
        screenShot();
    }

    @Entonces("valido el titulo de la pagina del carrito")
    public void validoElTituloDeLaPaginaDelCarrito() {
        cartSteps = new CartSteps(driver);
        String title = cartSteps.getCartTitle();
        Assertions.assertEquals("CARRITO", title);
        screenShot();
    }

    @Y("vuelvo a validar el calculo de precios en el carrito")
    public void vuelvoAValidarElCalculoDePreciosEnElCarrito() {
        double price = cartSteps.getProductPrice();
        int quantity = cartSteps.getProductQuantity();
        double expectedTotal = price * quantity;
        double actualTotal = cartSteps.getTotalProduct();
        double cartTotal = cartSteps.getTotalCart();
        Assertions.assertEquals(expectedTotal, actualTotal, 0.01);
        Assertions.assertEquals(expectedTotal, cartTotal, 0.01);
    }
}
