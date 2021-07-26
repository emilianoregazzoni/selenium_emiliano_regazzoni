package intermedioClase6.test;

import intermedioClase5.BaseTest;
import intermedioClase5.Constants;
import intermedioClase6.test.EcommerceHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTest extends BaseTest {

    //@Test (invocationCount = 5, successPercentage = 60)
    @Test
    public void registrationTest() throws InterruptedException {
        String emailAddress = "seleniumintermedio" + Math.random() + "test@gmail.com";

        EcommerceHelper helper = new EcommerceHelper(driver);
        helper.completeRegistration(emailAddress);

        WebElement myPersonaInformationBtn = driver.findElement(By.xpath("//*[@href='http://automationpractice.com/index.php?controller=identity']"));
        myPersonaInformationBtn.click();

        WebElement myPersonalInformationElement = driver.findElement(By.tagName("h1"));
        Assert.assertEquals(myPersonalInformationElement.getText(), "YOUR PERSONAL INFORMATION", "Se esperaba obtener otro h1!!");

        WebElement nameElement = driver.findElement(By.id("firstname"));
        String actualName = nameElement.getAttribute("value");

        WebElement lastNameElement = driver.findElement(By.id("lastname"));
        String actualLastName = lastNameElement.getAttribute("value");

        Assert.assertEquals(actualName, Constants.FAKER_FIRST_NAME, "Los nombres no coinciden!!" );
        Assert.assertEquals(actualLastName, Constants.FAKER_LAST_NAME, "Los apellidos no coinciden!!" );
        //driver.close();
    }

}