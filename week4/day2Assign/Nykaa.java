package week4.day2Assign;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykaa {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--disable notification");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.nykaa.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement brands = driver.findElement(By.xpath("//a[text()='brands']"));
		Actions act = new Actions(driver);
		act.moveToElement(brands).perform();
		driver.findElement(By.id("brandSearchBox")).sendKeys("L'Oreal Paris");
		driver.findElement(By.xpath("//a[contains(text(),'Oreal Paris')]")).click();
		WebElement title = driver.findElement(By.xpath("//div[@id='title']"));
		if(title.getText().contains("L'Oreal Paris")) {
			System.out.println("The title is "+ title.getText());
		}
		driver.findElement(By.xpath("//span[@class='sort-name']")).click();
		driver.findElement(By.xpath("//span[text()='customer top rated']/following::div[@class='control-indicator radio ']")).click();
		driver.findElement(By.xpath("//span[text()='Category']")).click();
		driver.findElement(By.xpath("//span[text()='Hair']")).click();
		driver.findElement(By.xpath("(//span[text()='Hair Care'])[2]")).click();
		driver.findElement(By.xpath("//span[text()='Shampoo']")).click();
		driver.findElement(By.xpath("//span[text()='Concern']")).click();
		driver.findElement(By.xpath("//span[text()='Color Protection']")).click();
		WebElement filter = driver.findElement(By.xpath("//span[text()='Filters Applied']/parent::div/parent::div"));
		if(filter.getText().contains("Shampoo")) {
			System.out.println("Filter is applied with Shampoo");
		}else {
			System.out.println("Filter is not applied with Shampoo");
		}
		driver.findElement(By.xpath("//div[contains(text(),'Oreal Paris Colour Protect Shampoo')]")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> window = new ArrayList<String>(windowHandles);
		driver.switchTo().window(window.get(1));
		driver.findElement(By.xpath("//select[@title='SIZE']")).click();
		driver.findElement(By.xpath("//option[text()='175ml']")).click();
		String text = driver.findElement(By.xpath("//span[text()='MRP:']/following-sibling::span")).getText();
		System.out.println("MRP of the product is "+text);
		driver.findElement(By.xpath("//span[text()='Add to Bag']")).click();
		driver.findElement(By.xpath("//span[@class='cart-count']")).click();
		List<WebElement> friframe = driver.findElements(By.tagName("iframe"));
		System.out.println(friframe.size());
		driver.switchTo().frame(0);
		String grandTotal = driver.findElement(By.xpath("//span[contains(text(),'259')]")).getText();
		//act.moveToElement(grandTotal).perform();
		System.out.println("Grand total amount "+grandTotal);
		driver.findElement(By.xpath("//span[text()='Proceed']")).click();
		opt.addArguments("--disable notification");
		driver.findElement(By.xpath("//div[text()='Checkout as guest']/following::button")).click();
		String total = driver.findElement(By.xpath("//div[text()='Grand Total']/following::span")).getText();
		if(grandTotal.contains(total)) {
			System.out.println("Grand total has same price");
		}
		driver.close();
		driver.switchTo().window(window.get(0));
		driver.close();
	}

}
