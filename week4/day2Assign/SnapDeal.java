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

public class SnapDeal {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--disable notification");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Actions act = new Actions(driver);
		WebElement menFash = driver.findElement(By.xpath("//li[@navindex='1']"));
		menFash.click();
		driver.findElement(By.xpath("(//span[text()='Sports Shoes'])[1]")).click();
		String shoeCount = driver.findElement(By.xpath("//div[text()='Sports Shoes for Men']/following-sibling::div")).getText();
		System.out.println("Number of sports shoes for men is "+shoeCount);
		driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();
		driver.findElement(By.xpath("//span[text()='Sort by:']")).click();
		driver.findElement(By.xpath("(//span[@class='arrow hidden']/parent::li)[1]")).click();
		String sortBy = driver.findElement(By.xpath("//span[text()='Sort by:']/following-sibling::div")).getText();
		if(sortBy.contains("Price Low To High")) {
			System.out.println("sortBy is correct");
		}else {
			System.out.println("sortBy is wrong");
		}
		WebElement fromval = driver.findElement(By.xpath("//input[@name='fromVal']"));
		fromval.clear();
		fromval.sendKeys("900");
		WebElement toval = driver.findElement(By.xpath("//input[@name='toVal']"));
		toval.clear();
		toval.sendKeys("1200");
		driver.findElement(By.xpath("//div[contains(text(),'GO')]")).click();
		System.out.println(driver.findElement(By.xpath("//input[@id='Color_s-Navy']/parent::div")).isSelected());
		WebElement firstShoe = driver.findElement(By.xpath("//picture[@class='picture-elem']"));
		act.moveToElement(firstShoe).perform();
		WebElement trdShoe = driver.findElement(By.xpath("(//picture[@class='picture-elem'])[3]"));
		act.moveToElement(trdShoe).perform();
		driver.findElement(By.xpath("(//div[contains(text(),'Quick View')])[3]")).click();
		String price = driver.findElement(By.xpath("//div[contains(text(),'Price')]/following::span[@class='payBlkBig']")).getText();
		System.out.println("Price of the shoe "+price);
		String discount = driver.findElement(By.xpath("//div[contains(text(),'Price')]/following::span[@class='percent-desc ']")).getText();
		System.out.println("Discount of the shoe "+discount);
		WebElement image = driver.findElement(By.xpath("(//img[@class='cloudzoom'])[1]"));
		File parimage = image.getScreenshotAs(OutputType.FILE);
		File imagepath = new File("./snap/pic2.jpg");
		FileUtils.copyFile(parimage, imagepath);
		File screenshotAs = driver.getScreenshotAs(OutputType.FILE);
		File des = new File("./snap/pic3.jpg");
		FileUtils.copyFile(screenshotAs, des);
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> window = new ArrayList<String>(windowHandles);
		driver.switchTo().window(window.get(0));
		driver.close();
	}

}
