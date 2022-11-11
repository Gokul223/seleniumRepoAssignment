package week4.day2Assign;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--disable notification");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("oneplus 9 pro");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@aria-label='oneplus 9 pro']")).click();
		String firstMob = driver.findElement(By.xpath("//span[@class='a-price']")).getText();
		System.out.println("Price of the first mobile "+firstMob);
		String firstRating = driver.findElement(By.xpath("//span[contains(@aria-label,'out of 5 stars')]/following-sibling::span")).getText();
		System.out.println("Rating of the first product "+firstRating);
		WebElement rating = driver.findElement(By.xpath("//span[@class='a-declarative']"));
		rating.click();
		Actions act = new Actions(driver);
		act.clickAndHold(rating).perform();
		WebElement fiStar = driver.findElement(By.xpath("//a[contains(text(),'5 star')]/following::a"));
		act.moveToElement(fiStar).perform();
		String star = fiStar.getText();
		System.out.println("Percentage of the 5star rating "+star);
		File image = driver.findElement(By.xpath("//span[@data-component-id='2']")).getScreenshotAs(OutputType.FILE);
		File des = new File("./snap/img1.jpg");
		FileUtils.copyFile(image, des);
		driver.findElement(By.xpath("//span[contains(text(),'OnePlus 9 Pro')]")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> window = new ArrayList<String>(windowHandles);
		System.out.println(window.size());
		driver.switchTo().window(window.get(1));
		WebElement starRate = driver.findElement(By.xpath("(//span[@id='acrPopover'])[1]//i"));
		act.moveToElement(starRate).perform();
		driver.findElement(By.id("add-to-cart-button")).click();
		String subTotal = driver.findElement(By.xpath("(//span[@id='attach-accessory-cart-subtotal']/parent::span)[1]")).getText();
		System.out.println("Cart sub total "+subTotal);
		if(subTotal.contains(firstMob)) {
			System.out.println("Its correct");
		}
	}

}
