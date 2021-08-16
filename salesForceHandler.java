package intermedioClase9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class salesForceHandler {

    public WebDriver driver;
    // WebDriverWait wait = new WebDriverWait(driver, TimeUnit.SECONDS.toSeconds(5));

    /*@FindBy (name = "UserLastName")
    public WebElement userLastName;
     */
    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.salesforce.com/es/");
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    @Test
    public void parte1() {
        String mainTitle = "";
        String mainURL = "";
        String mainWindow = driver.getWindowHandle();
        mainTitle = driver.getTitle();
        mainURL = driver.getCurrentUrl();

        Assert.assertEquals("CRM On Demand, Soluciones CRM On Demand de Salesforce - Salesforce España", mainTitle);
        Assert.assertEquals("https://www.salesforce.com/es/", mainURL);
        driver.findElement(By.xpath("//span[contains(text(), 'PRUEBA GRATUITA')]")).click();
        Set<String> allTabs = driver.getWindowHandles();

        for (String tab : allTabs) {
            //System.out.println("->" + tab);
            if (tab.equals(mainWindow) == false) {
                driver.switchTo().window(tab);
                String title2 = driver.getTitle();
                Assert.assertEquals("Prueba gratuita de 30 días de Professional Edition: Salesforce Reino Unido - Salesforce España", title2);
                Assert.assertEquals("https://www.salesforce.com/es/form/signup/freetrial-sales-pe/?d=70130000000EqoP", driver.getCurrentUrl());


                WebElement userName = driver.findElement(By.name("UserFirstName"));
                WebDriverWait wait = new WebDriverWait(driver, TimeUnit.SECONDS.toSeconds(10));
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("UserFirstName")));

                userName.sendKeys("emi123");
                WebElement userLastName = driver.findElement(By.name("UserLastName"));
                userLastName.sendKeys("apellidoExample");

                WebElement userTitle = driver.findElement(By.name("UserTitle"));
                userTitle.sendKeys("Tech");

                WebElement userEmail = driver.findElement(By.name("UserEmail"));
                userEmail.sendKeys("mail@mail.com");

                WebElement userPhone = driver.findElement(By.name("UserPhone"));
                userPhone.sendKeys("1234567899999");

                WebElement userCompany = driver.findElement(By.name("CompanyName"));
                userCompany.sendKeys("My company");

                WebElement userEmployees = driver.findElement(By.name("CompanyEmployees"));
                userEmployees.sendKeys("3");

                WebElement userLanguage = driver.findElement(By.name("CompanyLanguage"));
                userLanguage.sendKeys("es");

                driver.findElement(By.className("checkbox-ui")).click();

                driver.findElement(By.name("Iniciar prueba gratuita")).click();
            }
        }
    }

    @Test
    public void parte2() throws InterruptedException {

        HashMap<Integer, String> map = new HashMap<>();

        String mainWindow = driver.getWindowHandle();
        String registerWindow = "";
        driver.findElement(By.xpath("//span[contains(text(), 'PRUEBA GRATUITA')]")).click();
        Set<String> allTabs = driver.getWindowHandles();
        for (String tab : allTabs) {
            //System.out.println("->" + tab);
            if (tab.equals(mainWindow) == false) {
                driver.switchTo().window(tab);
                registerWindow = tab;
                WebDriverWait wait = new WebDriverWait(driver, TimeUnit.SECONDS.toSeconds(10));
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("UserFirstName")));
            }
        }
        map.put(1,mainWindow); // almaceno en map
        map.put(2,registerWindow);

        driver.switchTo().window(mainWindow);
        Thread.sleep(3);
        driver.switchTo().window(registerWindow);
        Thread.sleep(3);
        driver.switchTo().window(mainWindow);


    }
}
