package intermedioCucumber3.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PrivacyPage extends BasePage{


    public PrivacyPage(WebDriver remotedriver){
        this.driver = remotedriver;
    }

    public String getH1Text(){
        WebElement h1Element = driver.findElement(By.tagName("h1"));
        return h1Element.getText();
    }

}
