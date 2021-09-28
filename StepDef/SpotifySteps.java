package intermedioCucumber2.StepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.ss.formula.functions.Na;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class SpotifySteps {

    WebDriver driver;

    @Given("ingreso a spotify")
    public void ingreso_a_spotify() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.spotify.com");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Given("voy a la pagina de registro")
    public void voy_a_la_pagina_de_registro() {
        driver.navigate().to("https://www.spotify.com/uy/signup");
    }

    @When("ingreso la confirmacion {string}")
    public void ingreso_la_confirmacion(String confirmationEmail) {
        driver.findElement(By.id("confirm")).sendKeys(confirmationEmail);
        driver.findElement(By.id("password")).sendKeys("holamundo");

    }

    @When("ingreso un email {string}")
    public void ingreso_un_email(String email) {
       driver.findElement(By.name("email")).sendKeys(email);
       //driver.findElement(By.id("password")).sendKeys("holamundo");
    }

    @Then("obtengo el error {string}")
    public void obtengo_el_error(String mensaje) throws InterruptedException {
        WebElement errorElement = driver.findElement(By.xpath("//*[@aria-label='Indicador de error']"));
        Assert.assertEquals(errorElement.getText(), mensaje, "Error: se esperaba otro mensaje!!");
        Thread.sleep(2000);
        driver.close();
    }


}


