package practico15;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OrangeHrmLiveTest {

    WebDriver driver;

    @BeforeMethod
    private void setup() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/");
    }

    @Test
    public void OrangeHrmCicle() throws InterruptedException {
        OrangeHrmLoginPage orangeHrmLoginPage = new OrangeHrmLoginPage(driver);
        OrangeHrmTimeSheet orangeHrmTimeSheet = new OrangeHrmTimeSheet(driver);
        orangeHrmLoginPage.loginOrange();
        System.out.println("Las opciones son: " + orangeHrmLoginPage.checkOptionsMenu());
        System.out.println("*************");
        System.out.println("*************");
        Assert.assertEquals(6,orangeHrmLoginPage.quantityOptionsMenuAvailable()); // 6 cantidad requerida q cantidad obtenida, valido
        orangeHrmTimeSheet.timeSheets();
        Assert.assertEquals(orangeHrmTimeSheet.checkPageTitle(),"OrangeHRM");
        Assert.assertEquals(orangeHrmTimeSheet.checkPageUrl(),"https://opensource-demo.orangehrmlive.com/index.php/time/viewEmployeeTimesheet");
        System.out.println("Los elementos son: " + orangeHrmTimeSheet.showElements());
    }

}
