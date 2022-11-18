package week6.day2Assign;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class ServiceNow {

	public RemoteWebDriver driver;
	public Shadow shadow;
	@BeforeSuite
	public void callServer() {
		System.out.println("Cloud Connection");
	}
	
	@Parameters({"browser","url","userName","password"})
	@BeforeMethod
	public void preCondition(String browser, String url, String userName, String password) {
		System.out.println("Before method Thread Id :"+Thread.currentThread().getId());
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if(browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}else if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver(); 
		}
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.id("user_name")).sendKeys(userName);
		driver.findElement(By.id("user_password")).sendKeys(password);
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
