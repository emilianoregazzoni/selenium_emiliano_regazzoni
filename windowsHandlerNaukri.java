package intermedioClase9;

import intermedioClase6.pages.LandingPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class windowsHandlerNaukri {

    public WebDriver driver;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.naukri.com/");
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    // Cerrar todas las ventanas, menos la ventana principal
    @Test
    public void sitio(){
        String mainWindow = driver.getWindowHandle();
        System.out.println("pagina principal:" + mainWindow);

        Set<String> allTabs = driver.getWindowHandles();

        for(String tab : allTabs){
            //System.out.println("->" + tab);
            if(tab.equals(mainWindow)==false){
              driver.switchTo().window(tab);
              driver.close();
            }
        }
    }

    // Crear un método llamado cerrarVentanas que reciba el identificador de una ventana,
    // y cierre todas las demás exceptuando la recibida por parámetro.
    @Test
    public void cerrarVentanas(String identificador){
        Set<String> allTabs = driver.getWindowHandles();
        for(String tab : allTabs){
            //System.out.println("->" + tab);
            if(tab.equals(identificador)==false){
                driver.switchTo().window(tab);
                driver.close();
            }
        }
    }
}
