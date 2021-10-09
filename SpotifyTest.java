package xPruebaOctubre;


import intermedioCucumber3.pages.LandingPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SpotifyTest {

    WebDriver driver;

    public SpotifyLandingPage landingPage;
    public SpotifyPremiumPage premiumPage;
    public SpotifyRegistrationPage registrationPage;
    public SpotifyLegalPage legalPage;

    // Escenario 1

    @Given("ingreso spotify")
    public void ingreso_spotify() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.spotify.com");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        landingPage = new SpotifyLandingPage(driver);
    }

    @When("voy a la seccion premium")
    public void voy_a_la_seccion_premium() {
        landingPage.spotifyPremium();
    }

    @Then("encuentro nombre {string}")
    public void encuentro_nombre(String plan) {
        boolean nombre = premiumPage.existePlan(plan);
        Assert.assertTrue(nombre,"No se han encontrado coincidencias");
    }

    // Escenario 2

    @Given("voy a registro")
    public void voy_a_registro() {
        landingPage.spotifyRegister();
    }

    @When("ingreso email {string}")
    public void ingreso_email(String email) {
        registrationPage = landingPage.spotifyRegister();
        registrationPage.insertEmail(email);
    }

    @Then("obtengo el error {string}")
    public void obtengo_el_error(String mensaje) throws InterruptedException {
        WebElement errorElement = driver.findElement(By.xpath("//*[@aria-label='Indicador de error']"));
        Assert.assertEquals(errorElement.getText(), mensaje, "Error: se esperaba otro mensaje!!");
        Thread.sleep(2000);
        driver.close();
    }


    // Escenario 3

    @When("voy a legal")
    public void voy_a_legal() {
       legalPage = landingPage.spotifyLegal();
    }

    @Then("existen mensajes")
    public void existen_mensajes(String puntos) {
        legalPage.getLinks();
        Assert.assertEquals(legalPage.getLinks().contains(puntos));
    }

}
