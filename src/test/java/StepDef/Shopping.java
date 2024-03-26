package StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.chrono.ThaiBuddhistChronology;

public class Shopping {
    WebDriver driver;
    String product;

    @Then("Product successfully found")
    public void productSuccessfullyFound() throws InterruptedException {
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[1]/div[2]/div[1]/div[1]/div[1]/h1/span[2]")).getText(),this.product);
        Thread.sleep(1000);
        driver.close();
    }

    @When("Input {string} product on searchbar")
    public void inputProductOnSearchbar(String p) throws InterruptedException {
        product = p;
        driver.findElement(By.xpath("//*[@id=\"gh-ac\"]")).sendKeys(p, Keys.ENTER);
        Thread.sleep(2000);
    }

    @And("Click category on the navbar")
    public void clickCategoryOnTheNavbar() {
        driver.findElement(By.xpath("//*[@id=\"gh-shop-a\"]")).click();
    }

    @When("Click {string} product on category modal")
    public void clickProductOnCategoryModal(String product) {
        this.product = product;
        driver.findElement(By.partialLinkText(product)).click();

    }

    @And("Scroll down to today deals")
    public void scrollDownToTodayDeals() throws InterruptedException {
        WebElement section = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[4]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", section);
        Thread.sleep(1000);
    }

    @And("Click product")
    public void clickProduct() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"s0-1-0-48-1-3-5-10-0[2]-2-@match-media-0-@ebay-carousel-list\"]/li[2]/div/a/div/div[2]/h3")).click();
        Thread.sleep(1000);
        driver.getWindowHandles().forEach(tab->driver.switchTo().window(tab));
    }

    @And("Input quantity product")
    public void inputQuantityProduct() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"qtyTextBox\"]")).sendKeys("3");
        Thread.sleep(1000);
        driver.close();
    }

    @When("Input quantity product with string")
    public void inputQuantityProductWithString() {
        driver.findElement(By.xpath("//*[@id=\"qtyTextBox\"]")).sendKeys("one");
        
    }

    @Then("Appers alert quantity")
    public void appersAlertQuantity() throws InterruptedException {
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"qtyErrMsg\"]/span")).getText(), "Please enter a quantity of 1 or more");
        Thread.sleep(1000);
        driver.close();
    }

    @And("Hover category product")
    public void hoverCategoryProduct() throws InterruptedException {
        WebElement product = driver.findElement(By.xpath("//*[@id=\"vl-flyout-nav\"]/ul/li[3]/a"));
        Actions action = new Actions(driver);
        action.moveToElement(product).perform();
        Thread.sleep(1000);
    }

    @When("Click {string} product on category popup")
    public void clickProductOnCategoryPopup(String product) {
        driver.findElement(By.linkText("Apple")).click();

    }

    @Then("Product successfully found from category")
    public void productSuccessfullyFoundFromCategory() throws InterruptedException {
        Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[3]/div[2]/h1/span")).getText(),this.product);
        Thread.sleep(1000);
        driver.close();
    }

    @And("Open ebay home page")
    public void openEbayHomePage() throws InterruptedException {
        driver.navigate().to("https://www.ebay.com/");
        driver.manage().window().maximize();
        Thread.sleep(500);
    }

    @Given("Open browser for shopping")
    public void openBrowserForShopping() {
        final String dir = System.getProperty("user.dir");
        System.out.println("current dir = " + dir);
        System.setProperty("webdriver.chrome.driver", dir+"/driver/chromedriver.exe");
        driver = new ChromeDriver();
//        System.setProperty("webdriver.edge.driver", dir+"/driver/msedgedriver.exe");
//        driver = new EdgeDriver();
    }


}
