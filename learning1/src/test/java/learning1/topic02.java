package learning1;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class topic02 {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	//BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", projectPath + "\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/v4/");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	@Test
	public void test_01_WebBrowerMethod() {
		driver.navigate().to("https://tiki.vn/");
		System.out.println("URL Page: " + driver.getCurrentUrl());
		System.out.println("Title Page: " + driver.getTitle());
		sleepInSecond(3);

	}
	//@Test
	public void test_02_WebBrowerMethod() {
//		driver.navigate().to("https://demo.nopcommerce.com/register?returnUrl=%2F");
//		WebElement  firstNameTextBox = driver.findElement(By.id("FirstName"));
//		firstNameTextBox.sendKeys("auto test class");
//		firstNameTextBox.clear();
//		firstNameTextBox.sendKeys("demo test");
//		WebElement registerButton = driver.findElement(By.id("register-button"));
//		registerButton.click();
//		sleepInSecond(3);
		driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");
		Select selecDate = new Select(driver.findElement(By.xpath("//select[@name ='DateOfBirthDay']")));
		List<WebElement> selecedDay = selecDate.getOptions();
		for(WebElement days : selecedDay) {
			System.out.println(days.getText());
		}
		sleepInSecond(3);
	}
	//@Test
	public void Test_03_Alert() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
		Alert  alert = driver.switchTo().alert();
		System.out.println("Text of Alert : "+alert.getText());
		sleepInSecond(3);
		alert.sendKeys("ass");
		sleepInSecond(3);
	}

	public void sleepInSecond(long timeout) {
		try {
			Thread.sleep(timeout * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
