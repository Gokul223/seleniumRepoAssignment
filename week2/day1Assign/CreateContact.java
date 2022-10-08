package week2.day1Assign;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContact {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.findElement(By.id("username")).sendKeys("demosalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.linkText("Create Contact")).click();
		driver.findElement(By.id("firstNameField")).sendKeys("Jeya Gokul");
		driver.findElement(By.id("lastNameField")).sendKeys("Sekar");
		driver.findElement(By.name("submitButton")).click();
		String name = driver.findElement(By.id("viewContact_firstName_sp")).getText();
		System.out.println(name);
		String title = driver.getTitle();
		System.out.println(title);
		driver.close();
	}

}
