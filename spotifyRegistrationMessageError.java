package practico15;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pratico14.DataFactory;

import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertEquals;

public class spotifyRegistrationMessageError {

    WebDriver driver;

    @BeforeMethod
    private void setup() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.spotify.com/");
        //return driver;
    }

    @Test
    public void spotifyRegistrationMessageError() throws InterruptedException {

        SpotifyLandingPage spotifyLandingPage = new SpotifyLandingPage(driver);
        Thread.sleep(2500);
        spotifyLandingPage.spotifyRegistrar();
        Thread.sleep(1500);
        // OK titulo

        String titulo = spotifyLandingPage.getSpotifyTitle();
        assertEquals(titulo,"Registrarte - Spotify");

        // OK web
        String web = spotifyLandingPage.getSpotifyCurrentUrl();
        assertEquals(web,"https://www.spotify.com/uy/signup/");

        spotifyLandingPage.sendEmailSpotify();
        Thread.sleep(1500);

        String expectedError = "Este correo electrónico no es válido. Asegúrate de que tenga un formato como este: ejemplo@email.com";
        Assert.assertEquals(expectedError,spotifyLandingPage.getError());
    }
}


//driver.findElement(By.xpath("//*[@type='submit']")).click();