package Assignment6;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Exercise1 {
	WebDriver driver;
    String projectPath = System.getProperty("user.dir");



   @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", projectPath + "\\chromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        
        driver.manage().window().maximize();
    }
   @AfterClass
   public void afterClass() {
       driver.quit();
   }
   @Test
   public void Startbutton() {
	   driver.get("https://automationfc.github.io/dynamic-loading/");
	  
	   driver.findElement(By.xpath("//button[text()='Start']")).click();
	   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	   driver.findElement(By.xpath("//h4[text()='Hello World!']"));
   }
}
