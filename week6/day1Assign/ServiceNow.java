package week6.day1Assign;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class ServiceNow {

	public ChromeDriver driver;
	public Shadow shadow;
	@BeforeMethod
	public void preCondition() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://dev82739.service-now.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("ktIFzFt63-J=");
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
		shadow = new Shadow(driver);
		shadow.setImplicitWait(25);
		shadow.findElementByXPath("//div[text()='All']").click();
		shadow.findElementByXPath("//a[@aria-label='Incidents']").click();
		WebElement frame1 = shadow.findElementByXPath("//iframe[@title='Main Content']");
		driver.switchTo().frame(frame1);
	}
	
	@AfterMethod
	public void postCondition() {
		driver.close();
	}
}
