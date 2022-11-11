package week4.day2Assign;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedList;
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

public class Myntra {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--disable notification");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.myntra.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement men = driver.findElement(By.xpath("//a[text()='Men']"));
		Actions act = new Actions(driver);
		act.moveToElement(men).perform();
		driver.findElement(By.xpath("(//a[text()='Jackets'])[1]")).click();
		String menJack = driver.findElement(By.xpath("//span[@class='title-count']")).getText();
		String catJac = driver.findElement(By.xpath("(//span[@class='categories-num'])[1]")).getText();
		String catRJac = driver.findElement(By.xpath("(//span[@class='categories-num'])[2]")).getText();
		menJack = menJack.replaceAll("\\D+","");
		int j1 = Integer.parseInt(menJack);
		catJac = catJac.replaceAll("\\D+","");
		int j2 = Integer.parseInt(catJac);
		catRJac = catRJac.replaceAll("\\D+","");
		int j3 = Integer.parseInt(catRJac);
		int j4 = j2+j3;
		System.out.println("Jacket for mens are "+j1);
		System.out.println("Sum of categories count matches are "+j4);
		System.out.println("Jacket count "+j2);
		driver.findElement(By.xpath("//input[@value='Jackets']/parent::label")).click();
		driver.findElement(By.xpath("//div[@class='brand-more']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Search brand']")).sendKeys("Duke");
		driver.findElement(By.xpath("//input[@value='Duke']/parent::label")).click();
		driver.findElement(By.xpath("//span[@class='myntraweb-sprite FilterDirectory-close sprites-remove']")).click();
		List<WebElement> dukeBrand = driver.findElements(By.xpath("//h3[text()='Duke']"));
		List<String> brand = new LinkedList<String>();
		brand.add("Duke");
		int s = dukeBrand.size();
		System.out.println(s);
		int count =0;
		for(int i=0;i<s;i++) {
			if(dukeBrand.get(i).getText().contains("Duke")) {
				count++;
			}
		}
		System.out.println(count);
		if(s==count) {
			System.out.println("All the coats are of brand Duke");
		}
		WebElement sort = driver.findElement(By.xpath("//div[@class='sort-sortBy']"));
		act.moveToElement(sort).perform();
		driver.findElement(By.xpath("//input[@value='discount']/parent::label")).click();
		WebElement disco = driver.findElement(By.xpath("(//span[@class='product-discountedPrice'])[1]"));
		String dsct = disco.getText();
		System.out.println("Price of the first discount item "+dsct);
		disco.click();
		Set<String> windowHandles = driver.getWindowHandles();
		ArrayList<String> window = new ArrayList<String>(windowHandles);
		driver.switchTo().window(window.get(1));
		File ss = driver.getScreenshotAs(OutputType.FILE);
		File des = new File("./snap/s1.jpg");
		FileUtils.copyFile(ss, des);
		driver.findElement(By.xpath("//span[text()='WISHLIST']/parent::div")).click();
		driver.close();
		driver.switchTo().window(window.get(0));
		driver.close();
	}

}
