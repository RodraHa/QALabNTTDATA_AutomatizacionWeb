package com.nttdata.stepsdefinitions;

import com.nttdata.page.StorePage;
import com.nttdata.steps.LoginSteps;
import com.nttdata.steps.StoreSteps;
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
    private LoginSteps loginSteps;

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
        loginSteps = new LoginSteps(driver);
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
    }

    @Y("agrego {int} unidades del primer producto al carrito")
    public void agregoUnidadesDelPrimerProductoAlCarrito(int arg0) {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Entonces("valido en el popup la confirmación del producto agregado")
    public void validoEnElPopupLaConfirmaciónDelProductoAgregado() {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Y("valido en el popup que el monto total sea calculado correctamente")
    public void validoEnElPopupQueElMontoTotalSeaCalculadoCorrectamente() {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Cuando("finalizo la compra")
    public void finalizoLaCompra() {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Entonces("valido el titulo de la pagina del carrito")
    public void validoElTituloDeLaPaginaDelCarrito() {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Y("vuelvo a validar el calculo de precios en el carrito")
    public void vuelvoAValidarElCalculoDePreciosEnElCarrito() {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
