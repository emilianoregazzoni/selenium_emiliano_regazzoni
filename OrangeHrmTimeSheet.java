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

    public String checkPageTitle(){
        String title = driver.getTitle();
        return title;
    }

    public String checkPageUrl(){
        String url = driver.getCurrentUrl();
        return url;
    }

    public String showElements(){
        WebElement elements = driver.findElement(By.id("viewTimesheetForm"));
        return elements.getText().substring(30);
    }

}
