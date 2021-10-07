package SimulacroIntermedio.Escenario1;

import SimulacroIntermedio.Pages.LandingPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.Keys.ENTER;

public class AirBnbSteps {

    WebDriver driver;

    public LandingPage landingPage;


    @Given("estoy en la pagina de inicio")
    public void estoy_en_la_pagina_de_inicio() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://es.airbnb.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        landingPage = new LandingPage(driver);
    }

    @When("ingreso una ciudad {string}")
    public void ingreso_una_ciudad_ciudad(String ciudad) throws InterruptedException {
        landingPage.cargaCiudad(ciudad);
    }

    @When("ingreso una fecha {string}")
    public void ingreso_una_fecha_fecha(String fecha) {
        landingPage.ingresoFecha();
    }

    @When("presiono en buscar")
    public void presiono_en_buscar() {
        landingPage.buscar();
    }

    @When("ingreso huespedes")
    public void ingreso_huespedes() throws InterruptedException {
        landingPage.cargaHuespedes();
    }

    @Then("se muestran opciones de alojamiento")
    public void se_muestran_opciones_de_alojamiento() {
        System.out.println(landingPage.getH1Text());
        Assert.assertTrue(landingPage.getH1Text().contains("Estancias"));
        Assert.assertTrue(landingPage.existeAvisoCovid(),"No se encuentra texto asociado a la pagina");
        Assert.assertTrue(landingPage.cantidadHuespedes(),"No se ha validado la cantidad de huéspedes");
       
    }

    // Scenario 2

    @Given("estoy en experiencias")
    public void estoy_en_experiencias() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://es.airbnb.com/");
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        landingPage = new LandingPage(driver);
        landingPage.clickExperiencias();
    }


    @Then("se muestran experiencias")
    public void se_muestran_experiencias() {
        Assert.assertTrue(landingPage.getH1Text().contains("experiencias"));
        //System.out.println("llego a experiencias"); OK
    }

    @Then("se muestra titulo experiencias")
    public void se_muestra_titulo_experiencias() {
        Assert.assertTrue(landingPage.getH1Text().contains("experiencias"));
        //System.out.println("llego a experiencias"); OK
    }

    @Then("veo lugares cercanos")
    public void veo_lugares_cercanos() {
        landingPage.findNearPlaces();
    }

}
