package StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Login {
    WebDriver driver;
    @Given("Open browser")
    public void openBrowser() {
        final String dir = System.getProperty("user.dir");
        System.out.println("current dir = " + dir);
        System.setProperty("webdriver.chrome.driver", dir+"/driver/chromedriver.exe");
        driver = new ChromeDriver();
//        System.setProperty("webdriver.edge.driver", dir+"/driver/msedgedriver.exe");
//        driver = new EdgeDriver();
    }

    @And("Open ebay login page")
    public void openEbayLoginPage() throws InterruptedException {
        driver.navigate().to("https://www.ebay.com/");
        driver.manage().window().maximize();
        Thread.sleep(500);
    }

    @And("Click sign on navbar")
    public void clickSignOnNavbar() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"gh-ug\"]/a")).click();
        Thread.sleep(500);
    }

    @And("Input {string} email")
    public void inputEmail(String user) {
        driver.findElement(By.id("userid")).click();
        driver.findElement(By.id("userid")).sendKeys(user);
    }

    @And("Click button Continue")
    public void clickButtonContinue() throws InterruptedException {
        driver.findElement(By.id("signin-continue-btn")).click();
        Thread.sleep(1000);
    }

    @And("Input {string} password")
    public void inputPassword(String pass) throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"pass\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys(pass);
        driver.findElement(By.xpath("//*[@id=\"show-password-checkbox\"]")).click();
        Thread.sleep(1000);
    }

    @When("Click button Sign in")
    public void clickButtonSignIn() throws InterruptedException {
        driver.findElement(By.id("sgnBt")).click();
        Thread.sleep(1000);
    }

    @Then("Login successfully")
    public void loginSuccessfully() throws InterruptedException {
        Thread.sleep(1000);
        driver.close();

    }

    @Then("Login failed wrong email")
    public void loginFailedWrongEmail() throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"signin-error-msg\"]")).getText(),"We couldn't find this eBay account.");
        Thread.sleep(1000);
        driver.close();
    }

    @Then("Login failed wrong pass")
    public void loginFailedWrongPass() throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"errormsg\"]")).getText(),"Oops, that's not a match.");
        Thread.sleep(1000);
        driver.close();
    }
}
