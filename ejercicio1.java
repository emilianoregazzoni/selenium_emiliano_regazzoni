import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class ej14 {
    WebDriver driver;
    String netflix = "https://www.netflix.com/uy/";

    @Test
    public void seleccionar(){
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(netflix);
        //driver.get("https://www.facebook.com");

        List<WebElement> listaH1s = driver.findElements(By.tagName("h1"));
        List<WebElement> listaH2s = driver.findElements(By.tagName("h2"));

        System.out.println("---> Elementos H1: <---");
        for (WebElement elementoH1: listaH1s) {
            System.out.println(elementoH1.getText());
        }
        System.out.println("*****************");

        System.out.println("---> Elementos H2: <---");
        for (WebElement elementoH2: listaH2s) {
            System.out.println(elementoH2.getText());
        }
        System.out.println("*****************");

        driver.navigate().refresh();

        List<WebElement> btnElements = driver.findElements(By.tagName("button"));
        List<WebElement> divEelements = driver.findElements(By.tagName("div"));
        List<WebElement> linkElements = driver.findElements(By.tagName("link"));

        System.out.println("La pagina contiene: " + btnElements.size() + " botones");

        for (WebElement boton: btnElements){
            System.out.println("Boton -> " + boton.getText());
        }
        System.out.println("La pagina contiene: " + divEelements.size() + " elementos tipo div");
        System.out.print("El titulo de la pagina es: "+ driver.getTitle() + "\n");
        System.out.println("La pagina contiene: " + linkElements.size() + " elementos tipo link");
        driver.close();
    }
}
