package ThirdTask;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.testng.AssertJUnit.assertEquals;

public class DemoForm {
    private String baseUrl = "https://demoqa.com";
    String driverPath = "E:\\Software\\Selenium\\ChromeDriver86\\chromedriver.exe";
    public WebDriver driver;

    @BeforeTest
    public void beforeTest() {
        System.out.println("before test");

    }

    @Test(priority = 1)
    public void test(){

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
    public void ClickForms() throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("scroll(0, 500)");
        System.out.println("Scroll Down to the bottom");
        driver.findElement(By.xpath("//text()[contains(.,'Forms')]/ancestor::div[1]")).click();
        System.out.println("Form Icon Click Successful");
        driver.findElement(By.xpath("//span[text()='Practice Form']")).click();
        System.out.println("Practice Form Icon Click Successful");
        Thread.sleep(5000);

    }
    @Test(priority=5)
    public void Names(){
        driver.findElement(By.id("firstName")).sendKeys("Lasan");
        System.out.println("First Name Entered Successful");

        driver.findElement(By.id("lastName")).sendKeys("Rashmika");
        System.out.println("Second Name Entered Successful");

        driver.findElement(By.id("userEmail")).sendKeys("lasan@gmail.com");
        System.out.println("Email Entered Successful");

    }
    @Test(priority=6)
    public void Gender() {
         driver.findElement(By.xpath("//label[contains(text(),'Male')]")).click();
         System.out.println("Male Selected Successful");

    }
    @Test(priority=7)
    public void MobileNumber() throws InterruptedException {
        driver.findElement(By.id("userNumber")).sendKeys("0711996777");
        System.out.println("Mobile Number Entered Successful");
        Thread.sleep(2000);

    }
    @Test(priority=8)
    public void SelectDate() throws InterruptedException {
        WebElement DatePick = driver.findElement(By.id("dateOfBirthInput"));
        DatePick.click();
        System.out.println("Date Picker Calendar Click Successful");
        Thread.sleep(1000);
        DatePick.clear();
        System.out.println("Clear the Existing Value");
        DatePick.sendKeys("19 May 1995");
        Thread.sleep(500);
        DatePick.sendKeys(Keys.HOME);

        for(int j=1;j<=11;j++){
            DatePick.sendKeys(Keys.DELETE);
        }
        System.out.println("Existing Date Erased");
        DatePick.sendKeys(Keys.ENTER);
        System.out.println("Date set as 19 May 1995");
        Thread.sleep(1000);

    }
    @Test(priority=9)
    public void Subject() throws InterruptedException {

        WebElement Sub = driver.findElement(By.id("subjectsInput"));
        Sub.sendKeys("P");
        System.out.println("P Letter Entered");
        Thread.sleep(3000);
        Sub.sendKeys(Keys.ENTER);
        System.out.println("Subject Entered Successfully");

    }
    @Test(priority=10)
    public void Hobby(){

            driver.findElement(By.xpath("//label[contains(text(),'Reading')]")).click();
            System.out.println("Hobby Selected Successful");

    }

    @Test(priority=11)
    public void FileUpload() throws InterruptedException {
        WebElement Upload = driver.findElement(By.id("uploadPicture"));
        Thread.sleep(8000);
        Upload.sendKeys("C:\\Users\\Lasan Rashmika\\Pictures\\New SS\\Screenshot_629.png");
        System.out.println("Uploaded");

    }

    @Test(priority=12)
    public void Address() throws InterruptedException {

        driver.findElement(By.xpath("//label[contains(text(),'Sports')]")).click();
        System.out.println("Sports Selected Successful");
        driver.findElement(By.id("currentAddress")).sendKeys("No 12, Devata Road, Nupe, Matara, Sri Lanka");
        System.out.println("Address Entered Successfully");
        Thread.sleep(5000);

    }
    @Test(priority=13)
    public void StateCity() throws InterruptedException {

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("scroll(0, 250)");
        System.out.println("Scroll Down to the bottom");
        WebElement dropdown1 = driver.findElement(By.xpath("//div[contains(text(),'Select State')]"));
        dropdown1.click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='Haryana']")).click();
        Thread.sleep(1000);
        System.out.println("State Selected Successfully");


        WebElement dropdown2 = driver.findElement(By.xpath("//div[contains(text(),'Select City')]"));
        dropdown2.click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='Karnal']")).click();
        Thread.sleep(1000);
        System.out.println("City Selected Successfully");

    }
    @Test(priority=14)
    public void SubmitButton() throws InterruptedException {
        driver.findElement(By.id("submit")).click();
        Thread.sleep(10000);
        System.out.println("submitted Successfully");
        driver.findElement(By.id("closeLargeModal")).click();
        System.out.println("Close the Modal Successfully");

    }
    @AfterTest
    public void afterTest() {
        driver.quit();
        System.out.println("Closing the Driver");
    }

}