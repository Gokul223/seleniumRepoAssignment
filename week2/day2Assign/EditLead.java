package week2.day2Assign;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		driver.findElement(By.id("username")).sendKeys("demosalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.xpath("(//div[@id='label'])//following::a")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.xpath("//a[text()='Create Lead']//following::a[text()='Find Leads']")).click();
		driver.findElement(By.xpath("(//label[text()='First name:']/following::input[@name='firstName'])[3]")).sendKeys("Jeya Gokul");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[@class='linktext'])[4]")).click();
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("(//a[text()='Qualify Lead'])//following::a[text()='Edit']")).click();
		WebElement CompName = driver.findElement(By.id("updateLeadForm_companyName"));
		CompName.clear();
		CompName.sendKeys("TestLeaf");
		driver.findElement(By.xpath("//input[@value='Update']")).click();
		WebElement cName = driver.findElement((By.xpath(("//span[text()='Company Name']/following::span[@id='viewLead_companyName_sp']"))));
		System.out.println(cName.getText());
		driver.quit();
	}

}
