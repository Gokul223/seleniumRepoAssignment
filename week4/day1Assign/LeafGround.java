package week4.day1Assign;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGround {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/window.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//h5[text()='Find the number of opened tabs']/following::span[text()='Open Multiple']")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println("List of windows are---> "+windowHandles.size());
		List<String> list = new ArrayList<String>(windowHandles);
		driver.switchTo().window(list.get(2));
		System.out.println("Tittle of the last window is--> "+driver.getTitle());
		driver.switchTo().window(list.get(0));
		driver.close();
		driver.switchTo().window(list.get(1));
		driver.close();
	}

}
