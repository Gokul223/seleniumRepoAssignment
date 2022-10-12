package week2.day2Assign;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGround2 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/button.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//h5[text()='Click and Confirm title.']/following-sibling::button[@aria-disabled='false']")).click();
		if(driver.getTitle().contains("Dashboard")) {
			System.out.println("The title of the page is Confirm --> "+driver.getTitle());
		}else {
			System.out.println("The title of the page is not confirm");
		}
		driver.findElement(By.xpath("//span[text()='Element']/ancestor::a")).click();
		driver.findElement(By.xpath("//span[text()='Element']/following::a[@href='/button.xhtml']")).click();
		System.out.println("The button is Enabled --> "+driver.findElement(By.xpath("//h5[text()='Confirm if the button is disabled.']/following-sibling::button")).isEnabled());
		System.out.println("The postion of the submit button --> "+driver.findElement(By.xpath("//h5[text()='Find the position of the Submit button']/following-sibling::button")).getLocation());
		System.out.println("Color of the save button --> "+driver.findElement(By.xpath("//h5[text()='Find the Save button color']/following-sibling::button")).getCssValue("background-color"));
		System.out.println("The height and width of the button --> "+driver.findElement(By.xpath("//h5[text()='Find the height and width of this button']/following-sibling::button")).getSize());
		WebElement bgClr = driver.findElement(By.xpath("//h5[text()='Mouse over and confirm the color changed']//following::span[1]"));
		Actions act = new Actions(driver);
		act.moveToElement(bgClr).clickAndHold().pause(10).perform();
		String clrChange = bgClr.getCssValue("background-color");
		System.out.println("After mouseOver "+clrChange);
		driver.findElement(By.xpath("//h5[text()='Click Image Button and Click on any hidden button']//following::button[contains(@id,'imageBtn')]")).click();
		System.out.println(driver.findElement(By.xpath("//h5[text()='Click Image Button and Click on any hidden button']//following::img")).getTagName());
		List<WebElement> button = driver.findElements(By.xpath("//h5[text()='How many rounded buttons are there?']/following-sibling::button"));
		int size = button.size();
		System.out.println(size);
		driver.close();
	}

}
