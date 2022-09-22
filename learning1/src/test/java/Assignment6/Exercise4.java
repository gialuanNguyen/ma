package Assignment6;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Exercise4 {
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
		driver.get("http://live.techpanda.org/");
		driver.findElement(By.xpath("//a[@class='level0 ']")).click();
		driver.findElement(
				By.xpath("//a[@title='Sony Xperia']/parent::h2/following-sibling::div[@class='actions']/child::ul//a[@class='link-compare']"))
				.click();
		sleepInSecond(3);
		driver.findElement(By.xpath(
				"//a[@title='Samsung Galaxy']/parent::h2/following-sibling::div[@class='actions']/child::ul//a[@class='link-compare']"))
				.click();
		sleepInSecond(3);
		driver.findElement(By.xpath("//span[text()='Compare']")).click();
	}

	public void sleepInSecond(long timeout) {
		try {
			Thread.sleep(timeout * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void switchToWindowByID(String parentID) {
		Set<String> allWindows= driver.getWindowHandles();
	}
}
