package intermedioCucumber3.tests;

import intermedioCucumber3.pages.LandingPage;
import intermedioCucumber3.pages.PrivacyPage;
import intermedioCucumber3.pages.RegistrationPage;
import intermedioCucumber3.utilities.Constants;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class SalesforceSteps {

    WebDriver driver;

    public LandingPage landingPage;
    public RegistrationPage registrationPage;
    public PrivacyPage privacyPage;


    @Given("estoy inicio")
    public void estoy_inicio() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.salesforce.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        landingPage = new LandingPage(driver);
    }

    @When("ingreso a la seccion registrarse")
    public void ingreso_a_la_seccion_registrarse() throws InterruptedException {

        Assert.assertTrue(landingPage.getPageTitlte().contains("Marketing"), "Error , el titulo no contiene la palabra marketing");
        Assert.assertTrue(landingPage.getPageURL().contains("www.salesforce.com"), "Error URL incorrecta");
        Thread.sleep(5000);
        registrationPage = landingPage.goToRegistrationPage();
       // Thread.sleep(5000);
       // Assert.assertTrue(registrationPage.getPageTitlte().contains("Prueba gratuita"));
       // Assert.assertTrue(registrationPage.getPageURL().contains("signup"), "Error, invalid URL");
    }

    @Then("puedo completar campos registro")
    public void puedo_completar_campos_registro() {
        registrationPage.completeRegistration();
        Assert.assertTrue(registrationPage.getPageTitlte().contains("Prueba Gratuita"),Constants.TITLE_ERROR_MESSAGE);
        Assert.assertTrue(registrationPage.getPageURL().contains("signup"), "Error, se esperaba otra URL");
    }
    @Then("encuentro {string}")
    public void encuentro(String string) {
     String h1text = landingPage.getH1Text();
     Assert.assertTrue(h1text.contains("Una mirada hacia el futuro."));
    }

    @When("realizo click en el link privacidad")
    public void realizo_click_en_el_link_privacidad() {
        privacyPage = landingPage.goToPrivacyPage();
        Assert.assertEquals(privacyPage.getPageTitlte(), Constants.PRIVACY_PAGE,Constants.TITLE_ERROR_MESSAGE);
    }

    @Then("el titulo debe ser Privacidad")
    public void el_titulo_debe_ser_privacidad() {
        Assert.assertTrue(privacyPage.getH1Text().contains("Privacidad"));
    }
}
