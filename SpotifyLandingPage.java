package practico15;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SpotifyLandingPage {

    public WebDriver driver;

    public SpotifyLandingPage(WebDriver remoteDriver){
        driver = remoteDriver;
    }

    public String getSpotifyTitle(){
        return driver.getTitle();
    }

    public String getSpotifyCurrentUrl(){
        return driver.getCurrentUrl();
    }

    public void spotifyRegistrar(){
        WebElement regist = driver.findElement(By.partialLinkText("Regi"));
        regist.click();
    }

    public void sendEmailSpotify() throws InterruptedException {
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("@@@.com");
        Thread.sleep(2500);
        email.sendKeys(Keys.TAB); // tab para que se genere el error
    }

    public String getError(){

       // btn = driver.findElement(By.xpath(""));
        WebElement btnelement = driver.findElement(By.xpath("//div[@aria-label='Indicador de error']")); // aria-label="Indicador de error"
        return btnelement.getText();
    }
}
