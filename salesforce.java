package clase4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class salesforce {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://login.salesforce.com/?locale=eu");
    }

    @Test (priority = 1)
    public void validateSalesforceLogo(){
        WebElement logo = driver.findElement(By.id("logo"));
        System.out.println(logo.getTagName());
        System.out.println(logo.getAttribute("alt"));
    }

    @Test ( priority = 3, groups = {"login"} )
    public void LoginFailureTest(){

        driver.get("https://login.salesforce.com/?locale=eu");
        WebElement userName = driver.findElement(By.id("username"));

        //Validar logo, creo un webelement y busco el logo, si no es nulo lo pasa, quiere decir, que tiene un logo cargado

        userName.sendKeys("test@test.com");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("123466");

        driver.findElement(By.id("Login")).click();

        WebElement elementError = driver.findElement(By.id("error"));
        System.out.println(elementError.getText());

        String expectedError = "Your access to salesforce.com has been disabled by your system administrator. Please contact your Administrator for more information.";
        Assert.assertEquals(expectedError,elementError.getText());
    }






}
