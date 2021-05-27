package FifthTask;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import java.util.concurrent.TimeUnit;
import static org.testng.AssertJUnit.assertEquals;

public class BookStore {

    private String baseUrl = "https://demoqa.com";
    private String driverPath = "E:\\Software\\Selenium\\ChromeDriver86\\chromedriver.exe";
    private WebDriver driver;

    @BeforeSuite
    public void beforeTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);

        String URL = driver.getCurrentUrl();
        System.out.print("The Current Web URL is " + URL);

        String title = driver.getTitle();
        System.out.print("\n");
        System.out.println("The Page Title is " + title);
        String expectedTitle = "ToolsQA";
        assertEquals(title, expectedTitle);
        System.out.println("The Page Title Assertion Success");

        Thread.sleep(10000);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("scroll(0, 500)");
        System.out.println("Scroll Down to the Bottom");


        driver.findElement(By.xpath("//h5[contains(text(),'Book Store Application')]")).click();
        System.out.println("Book Store Click Successful");
        Thread.sleep(10000);

        driver.findElement(By.id("login")).click();
        System.out.println("USer Login Button Click Successful");
        Thread.sleep(5000);

    }

    @Test(priority=1)
    @Parameters({"UserName","Password"})
    public void LoginUser(String UserName,String Password) throws InterruptedException {

        driver.findElement(By.id("userName")).sendKeys(UserName);
        System.out.println("User Name Entered Click Successful");

        driver.findElement(By.id("password")).sendKeys(Password);
        System.out.println("Password Entered Successful");
        Thread.sleep(2000);

        driver.findElement(By.id("login")).click();
        System.out.println("Login Successful");
        Thread.sleep(5000);

    }

    @AfterClass
    @Parameters({"BookName"})
    public void LoginUser(String BookName) throws InterruptedException {

        driver.findElement(By.id("searchBox")).sendKeys(BookName);
        System.out.println("Book Name Entered Successful");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//a[contains(text(),'Speaking JavaScript')]")).click();
        System.out.println("Book Selected Successful");

        Thread.sleep(4000);
        JavascriptExecutor jsenew = (JavascriptExecutor) driver;
        jsenew.executeScript("scroll(0, 500)");
        System.out.println("Scroll Down to the bottom");

    }

    @AfterTest
    public void CollectionAdd() throws InterruptedException {

        driver.findElement(By.xpath("//button[contains(text(),'Add To Your Collection')]")).click();
        Thread.sleep(5000);
        System.out.println("Add New Record Successful");


        Alert alert = driver.switchTo().alert();
        Thread.sleep(5000);
        alert.accept();
        Thread.sleep(2000);
        System.out.println("Alert Removed Successful");

        driver.findElement(By.xpath("//button[@id='submit']")).click();
        System.out.println("Log Out Successful");
        Thread.sleep(5000);


    }

    @AfterSuite
    public void afterSuite() {
        driver.quit();
        System.out.println("Closing the Driver");
    }
}