package SimulacroIntermedio.Escenario1;

import SimulacroIntermedio.Pages.LandingPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.Keys.ENTER;

public class AirBnbSteps {

    WebDriver driver;

   // public LandingPage landingPage;

    @Given("estoy en la pagina de inicio")
    public void estoy_en_la_pagina_de_inicio() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://es.airbnb.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      //  landingPage = new LandingPage(driver);

    }

    @When("ingreso una ciudad {string}")
    public void ingreso_una_ciudad_ciudad(String ciudad) throws InterruptedException {
        try {
            WebElement lugar = driver.findElement(By.xpath("//input[@placeholder='¿A dónde viajas?']"));
            Thread.sleep(2000);
            lugar.click();
            lugar.sendKeys(ciudad);
            lugar.sendKeys(ENTER);
        }
        catch (StaleElementReferenceException | InterruptedException ex){
            WebElement lugar = driver.findElement(By.xpath("//input[@placeholder='¿A dónde viajas?']"));
            Thread.sleep(2000);
            lugar.click();
            lugar.sendKeys(ciudad);
            lugar.sendKeys(ENTER);
        }
    }

    @When("ingreso una llegada {string}")
    public void ingreso_una_llegada_llegada(String llegada) throws InterruptedException {
        WebElement cuando = driver.findElement(By.xpath("//input[@placeholder='Agrega cuándo quieres ir']"));
        Thread.sleep(2000);
        cuando.click();
        cuando.sendKeys(llegada);
    }

    @When("ingreso una salida <salida>")
    public void ingreso_una_salida_salida() {

    }

    @When("ingreso huespedes <huespedes>")
    public void ingreso_huespedes_huespedes() {

    }

    @Then("se muestran opciones de alojamiento")
    public void se_muestran_opciones_de_alojamiento() {

    }

    // Scenario 2

    @Given("estoy en experiencias")
    public void estoy_en_experiencias() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://es.airbnb.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       //driver.findElement(By.id("search-block-tab-false-EXPERIENCES")).click();
        WebElement exp = driver.findElement(By.id("search-block-tab-false-EXPERIENCES"));
        System.out.println("llego?");
        exp.click();
    }

    @Then("se muestran experiencias")
    public void se_muestran_experiencias() {

    }
}
