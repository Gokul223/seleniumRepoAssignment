package week4.day2Assign;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TagTable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--disable notification");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://html.com/tags/table/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		List<WebElement> lib1 = driver.findElements(By.xpath("//td[text()='Market Share']/following-sibling::td"));
		List<String> ms = new ArrayList<String>();
		for(int i=1;i<=lib1.size();i++) {
			String MSText = driver.findElement(By.xpath("//td[text()='Market Share']/following-sibling::td["+i+"]")).getText();
			ms.add(MSText);
		}
		System.out.println(driver.findElement(By.xpath("//td[text()='Market Share']")).getText()+" "+ms);
		List<WebElement> lib2 = driver.findElements(By.xpath("//td[text()='Absolute Usage']/following-sibling::td"));
		List<String> au = new ArrayList<String>();
		for(int i=1;i<=lib2.size();i++) {
			String AUText = driver.findElement(By.xpath("//td[text()='Absolute Usage']/following-sibling::td["+i+"]")).getText();
			au.add(AUText);
		} 
		System.out.println(driver.findElement(By.xpath("//td[text()='Absolute Usage']")).getText()+" "+au);
	}

}
