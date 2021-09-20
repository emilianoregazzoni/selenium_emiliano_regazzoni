package intermedioClase6.pages;

import intermedioClase5.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class AuthenticationPage extends BasePage {

    public WebDriver driver;

    public AuthenticationPage(WebDriver remoteDriver){
        this.driver = remoteDriver;
        PageFactory.initElements(driver, this);
    }

    public String getPageTitle(){
        return driver.getTitle();
    }

    public String getPageURL(){
        return driver.getCurrentUrl();
    }

    public String getAutenticationH1Text(){
        return autenticationH1.getText();
    }


    public void fillEmailAddress(String anEmail){

        emailNewAccountField.sendKeys(anEmail);
    }

    public CreateAccountPage clickOnCreateAccountBtn(){
        createAccountBtn.click();
        CreateAccountPage nextPage = new CreateAccountPage(driver);
        return nextPage;
    }

    public void clickOnSignInBtn(){
        WebElement nameElement = driver.findElement(By.xpath("(//*[@href='http://automationpractice.com/index.php?controller=my-account']/span)[1]"));

    }
}