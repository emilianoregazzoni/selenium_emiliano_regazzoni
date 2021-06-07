package practico15;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class OrangeHrmLoginPage {

    public WebDriver driver;

    public OrangeHrmLoginPage(WebDriver remoteDriver){
        driver = remoteDriver;
    }

    public void loginOrange() throws InterruptedException {
        Thread.sleep(1500);
        WebElement user = driver.findElement(By.id("txtUsername"));
        user.sendKeys("Admin ");
        WebElement password = driver.findElement(By.id("txtPassword"));
        password.sendKeys("admin123");
        WebElement btnLogin = driver.findElement(By.id("btnLogin"));
        btnLogin.click();
    }


    public String checkOptionsMenu(){
        WebElement div = driver.findElement(By.id("dashboard-quick-launch-panel-container"));
        return div.getText(); //div.getLocation();
    }

    public int quantityOptionsMenuAvailable(){
        int q=0;
        WebElement div = driver.findElement(By.id("dashboard-quick-launch-panel-container"));
        List<WebElement> rows = driver.findElements(By.className("quickLaunge"));
        q = rows.size();
        return q;
      //  Assert.assertEquals(6,q); // 6 cantidad requerida q cantidad obtenida, valido
    }

}
