package week4.day2Assign;

import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Chittorgarh {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--disable notification");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.chittorgarh.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//a[text()='STOCK MARKET ']")).click();
		driver.findElement(By.xpath("//a[text()='NSE Bulk Deals']")).click();
		List<WebElement> length = driver.findElements(By.xpath("//h2[text()='NSE Bulk Deals From Last Trading Session']/following::tr"));
		List<String> sName = new ArrayList<String>();
		for(int i =2; i<length.size();i++) {
			String securityName = driver.findElement(By.xpath("//h2[text()='NSE Bulk Deals From Last Trading Session']/following::tr["+i+"]/td[3]")).getText();
			sName.add(securityName);
		}
		System.out.println(sName);
		System.out.println(sName.size());
		Set<String> secName = new LinkedHashSet<String>(sName);
		System.out.println(secName);
		System.out.println(secName.size());
		if(sName.size()==secName.size()) {
			System.out.println("No duplicates are in security name");
		}else {
			System.out.println((sName.size()-secName.size()+" duplicates are found"));
		}
	}
}
