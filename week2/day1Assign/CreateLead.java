package week2.day1Assign;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLead {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.findElement(By.id("username")).sendKeys("demosalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Testleaf");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Jeya Gokul");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Sekar");
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("Jeya Gokul");
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("Testing");
		driver.findElement(By.id("createLeadForm_description")).sendKeys("Testing Engineer");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("gokuldesparks@gmail.com");
		driver.findElement(By.name("submitButton")).click();
		String title = driver.getTitle();
		System.out.println(title);
	}

}
