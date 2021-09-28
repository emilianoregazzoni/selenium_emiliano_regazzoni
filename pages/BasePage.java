package intermedioCucumber3.pages;

import org.openqa.selenium.WebDriver;

public class BasePage {

    WebDriver driver;

    public String getPageTitlte(){
        return driver.getTitle();
    }

    public String getPageURL(){
        return driver.getCurrentUrl();
    }
}
