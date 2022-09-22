package Assignment6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Exercise2 {
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
	   WebDriverWait wait = new WebDriverWait(driver,30);
	   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[text()='Hello World!']")));
	   driver.findElement(By.xpath("//h4[text()='Hello World!']"));
	 
	  
	   
   }
}
