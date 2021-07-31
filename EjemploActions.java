package intermedioClase8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class EjemploActions {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://www.gmail.com");
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    @Test
    public void moveToElementTest(){
        WebElement emailElement = driver.findElement(By.id("identifierId"));
        Actions action = new Actions(driver);
        action.moveToElement(emailElement).build().perform();
    }

    @Test
    public void doubleClickTest(){
        driver.get("http://api.jquery.com/dblclick");
        driver.switchTo().frame(0);
        WebElement clickableElement = driver.findElement(By.cssSelector("html>body>div"));
        Actions action = new Actions(driver);
        action.doubleClick(clickableElement).build().perform();
    }

    @Test
    public void contextClickTest(){
        WebElement siguienteElement = driver.findElement(By.id("identifierNext"));
        Actions action = new Actions(driver);
        action.contextClick(siguienteElement).build().perform();
    }

    @Test
    public void dragAndDropTest(){
        driver.get("https://crossbrowsertesting.github.io/drag-and-drop");
        WebElement elementoOrigen = driver.findElement(By.id("draggable"));
        WebElement elementoDestino = driver.findElement(By.id("droppable"));

        Actions action = new Actions(driver);
        action.dragAndDrop(elementoOrigen, elementoDestino).build().perform();

    }
}