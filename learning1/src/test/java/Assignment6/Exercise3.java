package Assignment6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Test
public class Exercise3 {
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

	public void Startbutton() {
		driver.get("https://kyna.vn/");
		driver.findElement(By.xpath("//div[@id='cs-live-chat']")).click();
		sleepInSecond(3);
		WebElement iframeFB = driver.findElement(By.xpath("//div[@id='cs-live-chat']//iframe"));
		driver.switchTo().frame(iframeFB);
		sleepInSecond(3);
		driver.findElement(By.xpath("//input[@ng-model='login.username']")).sendKeys("John Wick");

		driver.findElement(By.xpath("//input[@ng-model='login.phone']")).sendKeys("0909444555");

		driver.findElement(By.xpath("//select[@ng-model='login.selectedService']/option[text()='TƯ VẤN TUYỂN SINH']"))
				.click();

		driver.findElement(By.xpath("//textarea[@checked='undefined']")).sendKeys("Java Bootcamp");

		driver.findElement(By.xpath(
				"//input[@class='submit meshim_widget_widgets_ConnAwareSubmit ltr wide valid ng-scope desktop']"))
				.click();
		sleepInSecond(3);
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//input[@id='live-search-bar']")).sendKeys("excel");
		sleepInSecond(3);
		driver.findElement(By.xpath("//button[@aria-label='search']")).click();
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
