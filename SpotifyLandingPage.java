package xPruebaOctubre;

import intermedioCucumber3.pages.RegistrationPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SpotifyLandingPage extends BasePage{


    public SpotifyLandingPage(WebDriver remotedriver){
        this.driver = remotedriver;
    }

    public String getH3Text(){
        WebElement h3Element = driver.findElement(By.tagName("h3"));
        return h3Element.getText();
    }

    public SpotifyPremiumPage spotifyPremium() {
        driver.findElement(By.linkText("Premium")).click();
        SpotifyPremiumPage nextPage = new SpotifyPremiumPage(driver);
        return nextPage;
    }

    public SpotifyRegistrationPage spotifyRegister(){
        driver.findElement(By.linkText("Registrarse")).click();
        SpotifyRegistrationPage nextPage = new SpotifyRegistrationPage(driver);
        return nextPage;
    }

    public SpotifyLegalPage spotifyLegal(){
        driver.navigate().to("https://www.spotify.com/uy/legal/end-user-agreement/");
        SpotifyLegalPage nextPage = new SpotifyLegalPage(driver);
        return nextPage;
    }


}
