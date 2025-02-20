package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.*;

public class Steps {
    WebDriver driver;

    @Given("the user is on the SauceDemo login page")
    public void user_is_on_login_page() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Akash\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        Thread.sleep(1000);
    }

    @When("the user enters valid credentials")
    public void user_enters_valid_credentials() throws InterruptedException {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        Thread.sleep(1000);
    }
    
    @When("the user enters invalid credentials")
    public void user_enters_invalid_credentials() throws InterruptedException {
        driver.findElement(By.id("user-name")).sendKeys("standard_use");
        driver.findElement(By.id("password")).sendKeys("secret_sauc");
        Thread.sleep(1000);
    }

    @And("clicks the login button")
    public void user_clicks_login_button() throws InterruptedException {
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(1000);
    }

    @Then("the user should be redirected to the products page")
    public void user_redirected_to_products_page() throws InterruptedException {
        boolean isDisplayed = driver.findElement(By.className("title")).isDisplayed();
        assert isDisplayed;
        Thread.sleep(1000);
        driver.quit();
    }
    
    @And("the user must be directed to the products page")
    public void user_directed_to_products_page() throws InterruptedException {
        boolean isDisplayed = driver.findElement(By.className("title")).isDisplayed();
        assert isDisplayed;
        Thread.sleep(1000);

    }
    
    @And("the user adds item to cart")
    public void user_adds_item_to_cart() throws InterruptedException {
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        Thread.sleep(1000);

    }
    
    @And("the user adds multiple items to cart")
    public void user_adds_multiple_item_to_cart() throws InterruptedException {
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        Thread.sleep(1000);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(1000);
        driver.findElement(By.id("add-to-cart-sauce-labs-onesie")).click();
        Thread.sleep(1000);
        actions.sendKeys(Keys.PAGE_UP).perform();
        Thread.sleep(1000);

    }
    
    @And("the user clicks on cart button")
    public void user_clicks_on_cart_button() throws InterruptedException {
        driver.findElement(By.className("shopping_cart_link")).click();
        Thread.sleep(1000);
    }
    
    @And("the user clicks on checkout button")
    public void user_clicks_on_checkout_button() throws InterruptedException {
        driver.findElement(By.id("checkout")).click();
        Thread.sleep(1000);
    }
    
    @And("the user fills additional info and continue to checkout")
    public void user_fills_additonal_info_and_clicks_on_Continue() throws InterruptedException {
        driver.findElement(By.id("first-name")).sendKeys("Bucky");
        Thread.sleep(1000);
        driver.findElement(By.id("last-name")).sendKeys("Barnes");
        Thread.sleep(1000);
        driver.findElement(By.id("postal-code")).sendKeys("N2JL4M");
        Thread.sleep(1000);
        driver.findElement(By.id("continue")).click();
        Thread.sleep(1000);
    }
    
    @And("the user clicks on finish button")
    public void user_clicks_on_finish_button() throws InterruptedException {
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(1000);
        driver.findElement(By.id("finish")).click();
        Thread.sleep(1000);
    }
    
    @And("the user clicks on the hamburger menu and logout")
    public void user_clicks_on_hamburgermenu_logout() throws InterruptedException {
        driver.findElement(By.id("react-burger-menu-btn")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("logout_sidebar_link")).click();
        Thread.sleep(1000);
    }
    
    @Then("the user should be displayed with a warning message")
    public void user_displayed_error_message() throws InterruptedException {
        boolean isDisplayed = driver.findElement(By.className("error-button")).isDisplayed();
        assert isDisplayed;
        Thread.sleep(1000);
        driver.quit();
    }
    
    @Then("the user must be displayed with the thank you message")
    public void user_displayed_with_thank_you_message() throws InterruptedException {
        WebElement thankYouMessage = driver.findElement(By.xpath("//h2[@class='complete-header' and text()='Thank you for your order!']"));

        Assert.assertTrue("Unable to Place Order", thankYouMessage.isDisplayed());
        System.out.println("Thank you for your order!' message is displayed.");
        Thread.sleep(1000);
        WebElement btpButton = driver.findElement(By.id("back-to-products"));
        btpButton.click();
        Thread.sleep(1000);
        driver.quit();
    }
    
    @Then("the user is redirected to login page")
    public void user_redirected_to_login_page() throws InterruptedException {
        String expectedLoginURL = "https://www.saucedemo.com/";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals("Logout failed! Not redirected to the login page.", expectedLoginURL, actualURL);
        System.out.println("Successfully redirected to the login page.");
        driver.quit();
    }
    
}
