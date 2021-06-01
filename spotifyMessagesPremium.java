package practico15;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class spotifyMessagesPremium {

    WebDriver driver;

    @BeforeMethod
    private void setup() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.spotify.com/");
    }

    @Test
    public void spotifyMessagesPremium() throws InterruptedException {

        SpotifyPremiumPage spotifyPremiumPage = new SpotifyPremiumPage(driver);
        Thread.sleep(2500);
        spotifyPremiumPage.spotifyPremium();
        Thread.sleep(1500);
        Assert.assertTrue(spotifyPremiumPage.existePasateAPremium(),"Existe h1: Pasaste...");
        Assert.assertTrue(spotifyPremiumPage.existeBeneficiosPremium(),"Existe h1: Beneficios...");

    }
}
