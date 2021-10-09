package xPruebaOctubre;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SpotifyRegistrationPage extends BasePage{

    public SpotifyRegistrationPage(WebDriver remotedriver){
        this.driver = remotedriver;
    }

    public void insertEmail(String email){
        WebElement mail = driver.findElement(By.name("email"));
        mail.sendKeys(email);
        mail.sendKeys(Keys.TAB);
    }
}
