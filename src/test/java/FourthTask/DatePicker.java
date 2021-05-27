package FourthTask;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import static org.testng.AssertJUnit.assertEquals;

public class DatePicker {
    private String baseUrl = "https://demoqa.com";
    String driverPath = "E:\\Software\\Selenium\\ChromeDriver86\\chromedriver.exe";
    public WebDriver driver;

    @BeforeTest
    public void beforeTest() {
        System.out.println("before test");
    }

    @Test(priority = 1)
    public void test() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);

        String URL = driver.getCurrentUrl();
        System.out.print("Current URL is " + URL);

        String title = driver.getTitle();
        System.out.print("\n");
        System.out.println("Page Title is " + title);
        String expectedTitle="ToolsQA";
        assertEquals(title, expectedTitle);
        System.out.println("Page Title Assertion Success");


    }

    @Test (priority=2)
    public void ScrollDown() throws InterruptedException {
        Thread.sleep(10000);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("scroll(0, 250)");
        System.out.println("Scroll Down to the bottom");
    }


    @Test(priority=3)
    public void ClickElements() throws InterruptedException {
        driver.findElement(By.xpath("//h5[text()='Elements']")).click();
        System.out.println("Elements Click Successful");
        Thread.sleep(10000);
    }

    @Test(priority=4)
    public void ClickWidget() throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("scroll(0, 600)");
        System.out.println("Scroll Down to the bottom");
        driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[4]/span[1]/div[1]/div[1]")).click();
        System.out.println("Widget Click Successful");
        Thread.sleep(1000);
    }

    @Test(priority=5)
    public void ClickDatePick() throws InterruptedException {
        driver.findElement(By.xpath("//span[contains(text(),'Date Picker')]")).click();
        System.out.println("Date Pick Click Successful");
        Thread.sleep(1000);
        String Name1 = driver.findElement(By.xpath("//div[contains(text(),'Date Picker')]")).getText();
        String expectedTitle="Date Picker";
        assertEquals(Name1, expectedTitle);
        System.out.println("Page Title Assertion Success");


    }
    @Test(priority=6)
    public void SelectDate() throws InterruptedException {
        WebElement DatePick = driver.findElement(By.id("datePickerMonthYearInput"));
        DatePick.click();
        System.out.println("Date Picker Calendar Click Successful");
        Thread.sleep(1000);
        DatePick.clear();
        System.out.println("Clear the Existing Value");
        DatePick.sendKeys("05/01/2021");
        Thread.sleep(500);

        for(int i=1;i<=10;i++){
            DatePick.sendKeys(Keys.ARROW_LEFT);
        }

        for(int j=1;j<=10;j++){
            DatePick.sendKeys(Keys.BACK_SPACE);
        }

        DatePick.sendKeys(Keys.ENTER);
        Thread.sleep(10000);
        System.out.println("Date set as 05/01/2021");
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
        System.out.println("Closing the Driver");
    }
}
