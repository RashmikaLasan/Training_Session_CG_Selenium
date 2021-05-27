package SecondTask;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.testng.AssertJUnit.assertTrue;

public class DemoQA {
    private String baseUrl = "https://demoqa.com";
    String driverPath = "E:\\Software\\Selenium\\ChromeDriver86\\chromedriver.exe";
    public WebDriver driver ;

    @BeforeTest
    public void beforeTest() {
        System.out.println("before test");
    }

    @Test (priority=1)
    public void test() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", driverPath);

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);

        String URL = driver.getCurrentUrl();
        System.out.print("Current URL is" + URL);

        String title = driver.getTitle();
        System.out.print("\n");
        System.out.println("Page Title is " + title);


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
    public void openTextBox() throws InterruptedException {

        driver.findElement(By.xpath("//span[contains(text(),'Text Box')]")).click();

        Thread.sleep(5000);
        driver.findElement(By.id("userName")).click();
        driver.findElement(By.id("userName")).sendKeys("Lasan Rashmika");
        Thread.sleep(5000);

        driver.findElement(By.id("userEmail")).click();
        driver.findElement(By.id("userEmail")).sendKeys("Lasan@cgen.net");

        driver.findElement(By.id("currentAddress")).click();
        driver.findElement(By.id("currentAddress")).sendKeys("Nupe, Matara");

        driver.findElement(By.xpath("//textarea[@id='permanentAddress']")).click();
        driver.findElement(By.xpath("//textarea[@id='permanentAddress']")).sendKeys("DevataRoad, Matara");
        Thread.sleep(5000);

        driver.findElement(By.id("submit")).click();
        Thread.sleep(10000);

        System.out.println("Text Box Section Successful");


    }
    @Test(priority=5)
    public void ClickCheckBox() throws InterruptedException {

        driver.findElement(By.xpath("//span[contains(text(),'Check Box')]")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//span[contains(text(),'Home')]")).click();

        System.out.println("CheckBox Click Successful");
    }

    @Test(priority=6)
    public void ClickRadioButton() throws InterruptedException {

        Thread.sleep(5000);
        driver.findElement(By.xpath("//span[contains(text(),'Radio Button')]")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//label[contains(text(),'Impressive')]")).click();
        Thread.sleep(5000);
        System.out.println("ClickRadioButton Successful");
    }

    @Test(priority=7)
    public void FillTable() throws InterruptedException {


        driver.findElement(By.xpath("//span[contains(text(),'Web Tables')]")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[@id='addNewRecordButton']")).click();

        Thread.sleep(10000);


        String actualString = driver.findElement(By.id("registration-form-modal")).getText();
        assertTrue(actualString.contains("Registration Form"));
        System.out.println("Assertion Passed in Form Header");

        Thread.sleep(5000);

        driver.findElement(By.id("firstName")).sendKeys("Lasan");
        driver.findElement(By.id("lastName")).sendKeys("Rashmika");
        driver.findElement(By.id("userEmail")).sendKeys("lasan@gmail.com");
        driver.findElement(By.id("age")).sendKeys("15");
        driver.findElement(By.id("salary")).sendKeys("1500");
        driver.findElement(By.id("department")).sendKeys("QA");
        Thread.sleep(5000);
        driver.findElement(By.id("submit")).click();
        System.out.println("Submitted");
        System.out.println("Fill Table Successful");


    }

    @AfterTest
    public void afterTest() {
        driver.quit();
        System.out.println("Closing the Driver");
    }
}