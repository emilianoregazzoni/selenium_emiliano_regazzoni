package practico15;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class spotify2 {

    WebDriver driver;

    @BeforeMethod
    private WebDriver setup() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.spotify.com/");
        return driver;
    }

    @Test
    public void spotify2() throws InterruptedException {

        SpotifyPremiumPage spotifyPremiumPage = new SpotifyPremiumPage(driver);
        Thread.sleep(2500);
        spotifyPremiumPage.spotifyPremium();
        Thread.sleep(1500);
        Assert.assertTrue(spotifyPremiumPage.existePasate(),"Existe h1: Pasaste...");
        Assert.assertTrue(spotifyPremiumPage.beneficiosPremium(),"Existe h1: Beneficios...");

    }
}
