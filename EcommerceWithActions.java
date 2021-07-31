package intermedioClase8;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class EcommerceWithActions {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void registrationTest() throws InterruptedException {
        Actions actions = new Actions(driver);

        WebElement loginBtn = driver.findElement(By.xpath("//*[@href = 'http://automationpractice.com/index.php?controller=my-account']"));
        actions.moveToElement(loginBtn).click().build().perform();

        String emailAddress = "seleniumintermedio" + Math.random() + "test@gmail.com";

        WebElement emailField = driver.findElement(By.name("email_create"));

        Action completeEmailFieldAction =
                actions.moveToElement(emailField)
                        .click()
                        .sendKeys(emailAddress)
                        .build();
        completeEmailFieldAction.perform();

        //driver.findElement(By.id("SubmitCreate")).click();
        WebElement submitBtn = driver.findElement(By.id("SubmitCreate"));
        actions.moveToElement(submitBtn).click().build().perform();

        Thread.sleep(3000);

        WebElement maleRadioButton = driver.findElement(By.id("id_gender1"));

        Action maleRadioButtonAction = actions.moveToElement(maleRadioButton).click().build();
        maleRadioButtonAction.perform();

        WebElement firstNameElement = driver.findElement(By.id("customer_firstname"));

        Action firstNameAction = actions
                .moveToElement(firstNameElement)
                .click()
                .sendKeys("Jona")
                .keyDown(Keys.SHIFT)
                .sendKeys("than")
                .keyUp(Keys.SHIFT)
                .build();

        WebElement lastNameElement = driver.findElement(By.id("customer_lastname"));
        WebElement password = driver.findElement(By.id("passwd"));

        Action lastNameAction = actions
                .moveToElement(lastNameElement)
                .click()
                .keyDown(Keys.SHIFT)
                .sendKeys("Jonathan")
                .keyUp(Keys.SHIFT)
                .build();

        Action passwordAction = actions
                .moveToElement(password)
                .click()
                .sendKeys("holamundo")
                .build();

        WebElement daySelector = driver.findElement(By.id("days"));
        WebElement monthSelector = driver.findElement(By.id("months"));
        WebElement yearSelector = driver.findElement(By.id("years"));

        Action daySelectorAction = actions
                .moveToElement(daySelector)
                .click()
                .sendKeys("9")
                .build();

        Action monthSelectorAction = actions
                .moveToElement(monthSelector)
                .click()
                .sendKeys("January")
                .build();

        Action yearSelectorAction = actions
                .moveToElement(yearSelector)
                .click()
                .sendKeys("1994")
                .build();

        WebElement address1 = driver.findElement(By.id("address1"));

        Action address1Action = actions
                .moveToElement(address1)
                .click()
                .sendKeys("General Flores")
                .build();

        WebElement city = driver.findElement(By.id("city"));
        Action cityAction = actions
                .moveToElement(city)
                .click()
                .sendKeys("Montevideo")
                .build();

        WebElement stateSelector = driver.findElement(By.id("id_state"));
        Action stateAction = actions
                .moveToElement(stateSelector)
                .click()
                .sendKeys("Alaska")
                .build();

        WebElement postcode = driver.findElement(By.id("postcode"));
        Action postalAction = actions
                .moveToElement(postcode)
                .click()
                .sendKeys("00000")
                .build();

        WebElement countrySelector = driver.findElement(By.id("id_country"));
        Action countryAction = actions
                .moveToElement(countrySelector)
                .click()
                .sendKeys("United States")
                .build();

        WebElement mobile = driver.findElement(By.id("phone_mobile"));
        Action mobileAction = actions
                .moveToElement(mobile)
                .click()
                .sendKeys("+598 111 222")
                .build();

        WebElement registerButton = driver.findElement(By.id("submitAccount"));
        Action registerAction = actions
                .moveToElement(registerButton)
                .click()
                .build();

        firstNameAction.perform();
        lastNameAction.perform();
        passwordAction.perform();
        daySelectorAction.perform();
        monthSelectorAction.perform();
        yearSelectorAction.perform();
        address1Action.perform();
        cityAction.perform();
        stateAction.perform();
        postalAction.perform();
        countryAction.perform();
        mobileAction.perform();
        registerAction.perform();


    }
}