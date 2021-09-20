package intermedioClase6.pages;
import intermedioClase5.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import intermedioClase5.BasePage;
import org.openqa.selenium.support.ui.Select;

public class MyAccountPage extends BasePage {
    public WebDriver driver;

    public MyAccountPage(WebDriver remoteDriver){
        this.driver = remoteDriver;
        PageFactory.initElements(driver, this);
    }

    public String getPageTitle(){
        return driver.getTitle();
    }

    public String getPageURL(){
        return driver.getCurrentUrl();
    }

    public AuthenticationPage clickOnLogoutBtn(){
        WebElement logoutElement = driver.findElement(By.className("logout"));
        AuthenticationPage nextPage = new AuthenticationPage(driver);
        return nextPage;
    }

    public String getLogoutBtnText(){
        WebElement logoutElement = driver.findElement(By.className("logout"));
        return logoutElement.getText();
    }

    public String getAccountName(){
        WebElement nameElement = driver.findElement(By.xpath("(//*[@href='http://automationpractice.com/index.php?controller=my-account']/span)[1]"));
        return nameElement.getText();
    }

    public AuthenticationPage clickOnLogutBtn(){
        WebElement logoutElement = driver.findElement(By.className("logout"));
        AuthenticationPage nextPage = new AuthenticationPage(driver);
        return nextPage;
    }

        public MyAccountPage clickOnRegisterAccountbutton(){
            WebElement registerButton = driver.findElement(By.id("submitAccount"));
            registerButton.click();
            MyAccountPage nextPage = new MyAccountPage(driver);
            return nextPage;
        }

}