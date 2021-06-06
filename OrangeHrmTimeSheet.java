package practico15;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class OrangeHrmTimeSheet {

    public WebDriver driver;

    public OrangeHrmTimeSheet(WebDriver remoteDriver){
        driver = remoteDriver;
    }

    public void timeSheets(){
        WebElement timesheet = driver.findElement(By.xpath("//*[@id=\"dashboard-quick-launch-panel-menu_holder\"]/table/tbody/tr/td[3]/div/a/img"));
        timesheet.click();
    }

    public void checkPageTitle(){
        String title = driver.getTitle();
        Assert.assertEquals(title,"OrangeHRM");
    }

    public void checkPageUrl(){
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url,"https://opensource-demo.orangehrmlive.com/index.php/time/viewEmployeeTimesheet");
    }

    public String showElements(){
        WebElement elements = driver.findElement(By.id("viewTimesheetForm"));

        return elements.getText().substring(30);
    }

}
