package intermedioClase4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class mailchimpFindBy {


    String URL = "https://login.mailchimp.com/signup/";

    public WebDriver driver;

    String notice1 = "One lowercase character";
    String notice2 = "One uppercase character";
    String notice3 = "One number";
    String notice4 = "One special character";
    String notice5 = "8 characters minimum";

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "onetrust-accept-btn-handler")
    private WebElement cookies;

    @FindBy(tagName = "h1")
    public List<WebElement> listaH1;


    @FindBy (id="create-account")
    private WebElement signUp;

    @FindBy (tagName = "p")
    private List<WebElement> already;

    @FindBy (linkText = "Log in")
    private WebElement login;

    @FindBy (tagName = "li")
    private List<WebElement> require;


    /* campos */
    @FindBy (id="email")
    private WebElement email;

    @FindBy (id="new_username")
    private WebElement username;

    @FindBy (id="new_password")
    private WebElement password;


    @Test
    public void mailchimpFindBy() throws InterruptedException {
        cookies.click();
        boolean containsText = false;

        boolean requirements = false;


        Thread.sleep(2000);
        for (WebElement parrafo: listaH1){
            Assert.assertEquals(parrafo.getText(),"Welcome to Mailchimp");
        }
        Assert.assertEquals(signUp.getText(),"Sign Up");

        //Assert.assertTrue(already.contains("Already have an account?"));
        for (WebElement a: already){
            System.out.println(a.getText());
            String v = a.getText();
            if(v.contains("Already have an account?"))
                containsText = true;
        }

        Assert.assertTrue(containsText,"No se cumple la condicion"); //
        Assert.assertNotNull(login,"No se encontró la etiqueta Log in");
        email.sendKeys("random@mail.com");
        username.sendKeys("usuarioNuevo");
        password.sendKeys("123");


        for (WebElement a: require){
            if(a.getText().isEmpty()==false) {
                System.out.println(a.getText());
            }
            String v = a.getText();
            if(v.contains(notice1))
                requirements = true;
            if(v.contains(notice2))
                requirements = true;
            if(v.contains(notice3))
                requirements = true;
            if(v.contains(notice4))
                requirements = true;
            if(v.contains(notice5))
                requirements = true;
            Assert.assertTrue(requirements,"No se encuentra ningun aviso");
        }
    }
}
