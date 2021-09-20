package pruebaJunio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pratico14.DataFactory;
import pruebaMarzo.dataProviderMailchimp;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertEquals;

public class PruebaNetflixTest {

    WebDriver driver;

    @BeforeMethod
    private void setup() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.netflix.com/");
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    @Test(priority = 0)
    public void iniciarSesionPageTest() {
        WebElement btn = driver.findElement(By.xpath("//a[@href='/login']"));
        btn.click();
        List<WebElement> listaTitulos = driver.findElements(By.tagName("h1"));
        for (WebElement list : listaTitulos) {
            System.out.println(list.getText());
            assertEquals(list.getText(),"Inicia sesión");
        }

        List<WebElement> facebookText = driver.findElements(By.xpath("//*[contains(text(),'" + "Iniciar sesión con Facebook" + "')]"));
        Assert.assertTrue(facebookText.size() > 0,"Encontro texto Iniciar Sesion con Facebook");
    }

    @Test(priority = 1)
    public void fakeEmailTest() throws InterruptedException {
        String email = DataFactory.getMail();
        //WebElement email = driver.findElement(By.name("email"));
        driver.findElement(By.name("email")).sendKeys(email);
        WebElement comienza =  driver.findElement(By.cssSelector("button[type=\"submit\"]"));
        comienza.click();
        Thread.sleep(2000);
        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.contains("signup"), "Contiene el texto signup");
    }

    @Test(priority = 2, dataProvider = "credenciales", dataProviderClass = dataProviderNetflix.class)
    public void dataProviderEmailTest(String mail){
        driver.findElement(By.name("email")).sendKeys(mail);
        WebElement comienza =  driver.findElement(By.cssSelector("button[type=\"submit\"]"));
        comienza.click();
    }

    @Test(priority = 3)
    public void printTagsTest(String tagname){
        List<WebElement> elementosTagname = driver.findElements(By.tagName(tagname));
        for (WebElement list : elementosTagname) {
            System.out.println(list.getText());
        }
    }
}
