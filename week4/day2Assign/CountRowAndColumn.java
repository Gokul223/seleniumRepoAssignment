package week4.day2Assign;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CountRowAndColumn {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--disable notification");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://html.com/tags/table/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		List<WebElement> rowNum = driver.findElements(By.tagName("tr"));
		int rowSize = rowNum.size();
		System.out.println("Total no of rows are "+rowSize);
		List<WebElement> colNum = driver.findElements(By.tagName("th"));
		int colSize = colNum.size();
		System.out.println("Total no of columns are "+colSize);
	}

}
