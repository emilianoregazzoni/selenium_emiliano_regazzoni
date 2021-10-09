package xPruebaOctubre;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SpotifyLegalPage extends BasePage{

    public WebDriver driver;

    public SpotifyLegalPage(WebDriver remotedriver){
        this.driver = remotedriver;
    }

    public void getLinks(){
        List<WebElement> allLinks = driver.findElements(By.tagName("a"));
        for(WebElement link:allLinks){
            System.out.println(link.getText() + " - " + link.getAttribute("href"));
        }
    }

}
