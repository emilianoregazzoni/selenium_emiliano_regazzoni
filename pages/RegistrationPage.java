package intermedioCucumber3.pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage extends BasePage{

    public RegistrationPage(WebDriver remotedriver){
        this.driver = remotedriver;
    }

   public void completeRegistration(){
        Faker faker = new Faker();
        driver.findElement(By.name("UserFirstName")).sendKeys(faker.name().firstName());
        driver.findElement(By.name("UserLastName")).sendKeys(faker.name().lastName());
        driver.findElement(By.name("UserTitle")).sendKeys(faker.job().title());
        driver.findElement(By.name("UserEmail")).sendKeys(faker.internet().emailAddress());
        driver.findElement(By.name("UserPhone")).sendKeys("22004928");
        driver.findElement(By.name("CompanyName")).sendKeys(faker.company().name());

        WebElement industryElement = driver.findElement(By.name("Lead.Industry"));
        Select industrySelect = new Select(industryElement);
        industrySelect.selectByIndex(4);

        WebElement companyElement = driver.findElement(By.name("CompanyEmployees"));
        Select companySelect = new Select(companyElement);
        companySelect.selectByIndex(1);
    }
}
