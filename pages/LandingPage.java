package intermedioCucumber3.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage extends BasePage {

    public LandingPage(WebDriver remotedriver){
        this.driver = remotedriver;
    }

    public String getH1Text(){
        WebElement h1Element = driver.findElement(By.tagName("h1"));
        return h1Element.getText();
    }


    public RegistrationPage goToRegistrationPage(){
        driver.navigate().to("https://www.salesforce.com/mx/form/signup/freetrial-sales-pe");
        RegistrationPage nextPage = new RegistrationPage(driver);
        return nextPage;
    }

    public PrivacyPage goToPrivacyPage(){
        driver.findElement(By.xpath("//*[@href='https://www.salesforce.com/mx/company/privacy/']")).click();
        PrivacyPage nextPage = new PrivacyPage(driver);
        return nextPage;
    }
}
