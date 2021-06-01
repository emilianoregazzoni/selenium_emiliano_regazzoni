package practico15;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SpotifyPremiumPage {
    public WebDriver driver;

    public SpotifyPremiumPage(WebDriver remoteDriver){
        driver = remoteDriver;
    }

    public void spotifyPremium() {
        WebElement premium = driver.findElement(By.partialLinkText("Premiu"));
        premium.click();
    }

    public boolean existePasateAPremium(){
        boolean b = false;
        List<WebElement> listaPasate = driver.findElements(By.tagName("h1"));
        //System.out.println("La cantidad de h1 son: " + listaPasate.size());

        for(WebElement elementsh1 : listaPasate){
            System.out.println(elementsh1.getText());
            if(elementsh1.getText().equals("Disfruta 3 meses de Premium gratis")){ // cambio la pagina, cambio el h1 que contiene
               b = true;
            }
        }
      return b;
    }



    public boolean existeBeneficiosPremium(){
        boolean b = false;
        List<WebElement> listaPasate = driver.findElements(By.tagName("h1"));
        //System.out.println("La cantidad de h1 son: " + listaPasate.size());

        for(WebElement e : listaPasate){
            System.out.println(e.getText());
            if(e.getText().equals("Beneficios de Premium")){
                b = true;
            }
        }
        return b;
    }
}
