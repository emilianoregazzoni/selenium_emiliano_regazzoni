package SimulacroIntermedio.Pages;

import intermedioCucumber3.pages.PrivacyPage;
import intermedioCucumber3.pages.RegistrationPage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.Keys.ENTER;

public class LandingPage extends BasePage {

    WebDriver driver;

    //LandingPage landingPage = new LandingPage(driver);

    public LandingPage(WebDriver remotedriver){
        this.driver = remotedriver;
    }

    public void buscar(){
        WebElement buscar = driver.findElement(By.className("_1mzhry13"));  // Click en buscar
        buscar.click();
    }

    public void clickExperiencias(){
        driver.findElement(By.id("search-block-tab-false-EXPERIENCES")).click();
        WebElement e = driver.findElement(By.xpath("//*[text()='Experiencias']"));
        e.click();
    }

    public boolean tituloVive(){
        WebElement e = driver.findElement(By.xpath("//*[text()='Vive en cualquier lugar del mundo']"));
        if(e.getText().isEmpty()){
            return false;
        }
        return true;
    }


    public boolean existeAvisoCovid(){
        WebElement e = driver.findElement(By.xpath("//*[text()='Antes de reservar, revisa las restricciones de viaje relacionadas con el coronavirus.']"));
        if(e.getText().isEmpty()){
            return false;
        }
        return true;

    }


    public void cargaHuespedes() throws InterruptedException {
        WebElement dates1 = driver.findElement(By.xpath("//*[text()='¿Cuántos?']"));
        dates1.click();
        Thread.sleep(3000);
        WebElement increaseButton =  driver.findElement(By.xpath("//*[@id='stepper-adults']/button[2]/span"));
        increaseButton.click();
        increaseButton.click();
    }


    public void cargaCiudad(String ciudad) throws InterruptedException {
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

    public boolean cantidadHuespedes(){
        WebElement cantidad = driver.findElement(By.xpath("//*[text()='2 huéspedes']"));
        if(cantidad.getText().isEmpty()){
            return false;
        }
        return true;
    }

// Escenario 2


    public void ingresoFecha(){
        WebElement dates2 = driver.findElement(By.xpath("//*[text()='Fechas flexibles']"));
        dates2.click();
        WebElement dates3 = driver.findElement(By.xpath("//*[text()='Semana']"));
        dates3.click();
    }

    public String getH1Text(){
        WebElement h1Element = driver.findElement(By.tagName("h1"));
        return h1Element.getText();
    }









// Escenario 3
    public void findNearPlaces()  {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        js.executeScript("window.scrollBy(0,350)", "");
    }

}
