package week2.day2Assign;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Facebook {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://en-gb.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//  CreateNewAccount 
		driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
		driver.findElement(By.name("firstname")).sendKeys("Jeya Gokul");
		driver.findElement(By.name("lastname")).sendKeys("Sekar");
		driver.findElement(By.name("reg_email__")).sendKeys("8680870510");
		driver.findElement(By.name("reg_passwd__")).sendKeys("ThisIsMyPassword#");
		WebElement Day = driver.findElement(By.id("day"));
		Select day = new Select(Day);
		day.selectByValue("2");
		WebElement Month = driver.findElement(By.id("month"));
		Select month = new Select(Month);
		month.selectByIndex(8);
		WebElement Year = driver.findElement(By.id("year"));
		Select year = new Select(Year);
		year.selectByVisibleText("1999");
		driver.findElement(By.xpath("//label[text()='Male']/following-sibling::input")).click();
		driver.quit();
	}

}
