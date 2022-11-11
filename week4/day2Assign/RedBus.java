package week4.day2Assign;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RedBus {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.redbus.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//input[@id='src']")).sendKeys("Madiwala Bangalore");
		driver.findElement(By.xpath("//input[@id='dest']")).sendKeys("Koyambedu Chennai");
		driver.findElement(By.xpath("//input[@id='onward_cal']")).click();
		driver.findElement(By.xpath("//td[text()='Oct 2022']")).click();
		driver.findElement(By.xpath("//td[text()='31']")).click();
		System.out.println(driver.getTitle());
	}

}
