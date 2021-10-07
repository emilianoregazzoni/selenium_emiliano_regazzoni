package SimulacroIntermedio.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {

    WebDriver driver;


    public String getPageTitlte(){
        return driver.getTitle();
    }

    public String getPageURL(){
        return driver.getCurrentUrl();
    }


}
