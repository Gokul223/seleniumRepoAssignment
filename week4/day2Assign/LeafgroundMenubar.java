package week4.day2Assign;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafgroundMenubar {

	public static void main(String[] args) throws InterruptedException  {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/menu.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement shipments = driver.findElement(By.xpath("//span[text()='Shipments']"));
		Actions act = new Actions(driver);
		act.click(shipments).perform();
		WebElement tracker = driver.findElement(By.xpath("(//span[text()='Tracker'])[1]"));
		act.contextClick(tracker).perform();
		WebElement order = driver.findElement(By.xpath("(//span[text()='Orders'])[2]"));
		act.click(order).perform();
		Thread.sleep(1000);
		WebElement back = driver.findElement(By.xpath("(//div[contains(@class,'slidemenu')])[4]"));
		act.click(back).perform();
	}

}
