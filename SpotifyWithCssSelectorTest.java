package clase3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class SpotifyWithCssSelectorTest {

    private WebDriver getSpotifyDriver(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.spotify.com/");
        return driver;
    }

    @Test
    public void spotifyByPlaceHolderTest() throws InterruptedException{

        WebDriver driver = getSpotifyDriver();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("a[href='https://www.spotify.com/uy/signup/']")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("input[placeholder='Introduce tu correo electrónico.']")).sendKeys("test@test.com");
        driver.findElement(By.cssSelector("input[placeholder='Vuelve a introducir tu correo electrónico.']")).sendKeys("test@test.com");
        driver.findElement(By.cssSelector("input[placeholder='Crea una contraseña.']")).sendKeys("asd123");
        driver.findElement(By.cssSelector("input[placeholder='Introduce un nombre de perfil.']")).sendKeys("testUsuario");
        driver.findElement(By.cssSelector("input[placeholder='DD']")).sendKeys("09");

        // Mes, busco elemento y selecciono mes por texto visible (se puede por value9
        WebElement month_dropdown = driver.findElement(By.id("month"));
        Select month = new Select(month_dropdown);
        month.selectByVisibleText("Enero");
        //
        
        driver.findElement(By.cssSelector("input[placeholder='AAAA']")).sendKeys("1994");
        driver.findElement(By.cssSelector("label[for='marketing-opt-checkbox']")).click();
        driver.findElement(By.cssSelector("label[for='gender_option_male']")).click();

    }
}
