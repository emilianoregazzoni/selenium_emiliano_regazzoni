package pruebaJunio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class InterviewQuestionSiteTest {

    WebDriver driver;

    @BeforeMethod
    private void setup() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://allstq.com/most-popular-testng-interview-questions/");
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.manage().window().fullscreen();
    }

    @Test(priority = 0)
    public void landingPageTest() {
        String title = driver.getTitle();
        String url = driver.getCurrentUrl();
        List<WebElement> titulo = driver.findElements(By.tagName("h1"));

        for (WebElement list : titulo) {
            System.out.println(list.getText());
        }
        List<WebElement>listaTitulos = driver.findElements(By.xpath("//*[contains(text(),'" + "Ques." + "')]"));
        List<WebElement> listaPreguntas = driver.findElements(By.xpath("//*[contains(text(),'" + "Ans." + "')]"));
        int t = 0;
        int p = 0;
        for (WebElement listaT : listaTitulos) {
            System.out.println(listaT.getText());
            t++;
            if(t>=5) break;
         }
        for (WebElement listaP : listaPreguntas) {
            System.out.println(listaP.getText());
            p++;
            if(p>=5) break;
        }

        Assert.assertEquals(title, "Most popular TestNG interview questions - Software Testing Questions");
        Assert.assertEquals(driver.getCurrentUrl(), "https://allstq.com/most-popular-testng-interview-questions/", "Se esperaba otra url");

        List<WebElement> elements = driver.findElements(By.xpath("//ul[@class='menu-link']/li"));
        System.out.println("Los items son:");
        for( WebElement i: elements){
            System.out.println(i.getText()); }
    }
}
