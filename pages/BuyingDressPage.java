package intermedioClase6.pages;

import com.github.javafaker.Faker;
import intermedioClase5.BasePage;
import intermedioClase5.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.List;
import java.util.concurrent.TimeUnit;

public class BuyingDressPage extends BasePage {

    public WebDriver driver;

    public BuyingDressPage(WebDriver remoteDriver){
        this.driver = remoteDriver;
        PageFactory.initElements(driver, this);
    }

    public BuyingDressPage loginBtnClick(){
        loginBtnMenu.click();
        BuyingDressPage nextPage = new BuyingDressPage(driver);
        return nextPage;
    }

    public String getEmailValue(){
        return emailUserField.getAttribute("value");
    }

    public void registerAnUser(String myEmail, String fakeFirstName, String fakeLastName) {
        emailUserField.sendKeys("prueba");
        firstNameField.sendKeys(fakeFirstName);
        lastNameField.sendKeys(fakeLastName);
        passwdField.sendKeys(Constants.PASSWORD);
        WebElement address1 = driver.findElement(By.id("address1"));
        WebElement address2 = driver.findElement(By.id("address2"));
        WebElement city = driver.findElement(By.id("city"));
        WebElement stateSelector = driver.findElement(By.id("id_state"));
        WebElement postcode = driver.findElement(By.id("postcode"));
        WebElement countrySelector = driver.findElement(By.id("id_country"));
        WebElement mobile = driver.findElement(By.id("phone_mobile"));
        WebElement addressAlias = driver.findElement(By.id("alias"));
        //WebElement registerButton = driver.findElement(By.id("submitAccount"));
        //
        address1.sendKeys("My address Nr1");
        address2.sendKeys("My address Nr2");
        city.sendKeys(Constants.CITY);
        Select selectState = new Select(stateSelector);
        selectState.selectByValue("2");
        postcode.sendKeys("10000");
        Select selectCountry = new Select(countrySelector);
        selectCountry.selectByValue("21");
        mobile.sendKeys("123456789");
        addressAlias.clear();
        addressAlias.sendKeys("MyAlias");
       // WebElement registerButton = driver.findElement(By.id("submitAccount"));
    }

    public BuyingDressPage clickOnRegisterAccountbtn(){
        WebElement registerButton = driver.findElement(By.id("submitAccount"));
        registerButton.click();
        BuyingDressPage nextPage = new BuyingDressPage(driver);
        return nextPage;
    }

    public void clickOnSignInBtn(){
        WebElement sigin = driver.findElement(By.xpath("(//*[@href='http://automationpractice.com/index.php?controller=my-account']/span)[1]"));
        sigin.click();
    }


/*
    //logging in to the site



    //search product via the search bar

    WebElement searchBar = driver.findElement(By.id(“search_query_top”));

    WebElement searchButton = driver.findElement(By.cssSelector(“button[name=’submit_search’]”));



        searchBar.sendKeys(“printed dress”);

        searchButton.click();



    //waiting for the Search page

        wait.until(ExpectedConditions.titleContains(“Search”));



    //this return a list of all the products that has been found

    List<WebElement> allTheProducts = driver.findElements(By.cssSelector(“li.ajax_block_product”));



    //accesing and storing the link of the desired result, in this case the 0 corresponding to the Printed Summer Dress

    String productLink = allTheProducts.get(0).findElement(By.cssSelector(“div.product-container a.product_img_link”)).getAttribute(“href”);



    //going to the product page

        driver.get(productLink);



    //waiting for the add to cart button to be clickable

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(“button[name=’Submit’]”)));

        driver.findElement(By.cssSelector(“button[name=’Submit’]”)).click();



    //waiting for the modal to open and then clicking on Proceed to checkout

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(“layer_cart”)));

        driver.findElement(By.cssSelector(“a[title=’Proceed to checkout’]”)).click();



    //waiting to land the checkout page and checking if the cart has products because the div#order-detail-content only appears when products are in the cart

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(“order-detail-content”)));

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(“p a[title=’Proceed to checkout’]”)));



    //going to the address section

        driver.findElement(By.cssSelector(“p a[title=’Proceed to checkout’]”)).click();



    //waiting for the address box to be displayed

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(“address_delivery”)));

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(“button[name=’processAddress’]”)));



    //going to the shipping section and agreeing to the terms

        driver.findElement(By.cssSelector(“button[name=’processAddress’]”)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(“order_carrier_content”)));

        driver.findElement(By.id(“cgv”)).click();



    //going to the payment section

        driver.findElement(By.cssSelector(“button[name=’processCarrier’]”)).click();

    //checking if the payment methods are present, this is easy, just check if the div container is being displayed

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(“HOOK_PAYMENT”)));

    //selecting the bankwire option

        wait.until(ExpectedConditions.elementToBeClickable(By.className(“bankwire”)));

        driver.findElement(By.className(“bankwire”)).click();



    //checking if we selected the payment method correctly

        System.out.println(driver.findElement(By.className(“page-subheading”)).getText());

        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.className(“page-subheading”), “BANK-WIRE PAYMENT.”));



    //confirming order by clicking on the Confirm Order button

        driver.findElement(By.cssSelector(“#cart_navigation button”)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(“cheque-indent”)));

    WebElement buyDetailsBox = driver.findElement(By.className(“box”));
*/
}

