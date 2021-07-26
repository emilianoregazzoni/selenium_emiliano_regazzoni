package intermedioClase6.pages;

import intermedioClase5.BasePage;
import intermedioClase6.pages.AuthenticationPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends BasePage {
    public WebDriver driver;

    public LandingPage(WebDriver remoteDriver){
        this.driver = remoteDriver;
        PageFactory.initElements(driver, this);
    }
    public AuthenticationPage loginBtnClick(){
        loginBtnMenu.click();
        AuthenticationPage nextPage = new AuthenticationPage(driver);
        return nextPage;
    }
}