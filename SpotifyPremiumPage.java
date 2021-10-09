package xPruebaOctubre;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SpotifyPremiumPage extends BasePage {

    public SpotifyPremiumPage(WebDriver remotedriver){
        this.driver = remotedriver;
    }

    public boolean existePlan(String plan){
        boolean b = false;
        List<WebElement> listaPlanes = driver.findElements(By.tagName("h3"));

        for (WebElement e : listaPlanes) {
            System.out.println(e.getText());
            if(e.getText().equalsIgnoreCase(plan))
                b = true;
            //System.out.println("cambia a true");
        }
        return b;
    }
}
