package week2.day2Assign;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGround3 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/select.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement DD1 = driver.findElement(By.xpath("//h5[text()='Which is your favorite UI Automation tool?']/following::select[contains(@style,'overflow-wrap')]"));
		Select dd1 = new Select(DD1);
		dd1.selectByVisibleText("Selenium");
		driver.findElement(By.xpath("//h5[text()='Choose your preferred country.']/following::label[text()='Select Country']")).click();
		driver.findElement(By.xpath("//h5[text()='Choose your preferred country.']/following::li[text()='India']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//h5[text()='Confirm Cities belongs to Country is loaded']/following::label[text()='Select City']")).click();
		driver.findElement(By.xpath("//h5[text()='Confirm Cities belongs to Country is loaded']/following::li[text()='Chennai']")).click();
		driver.findElement(By.xpath("//h5[text()='Choose the Course']/following::button[@aria-label='Show Options']")).click();
		driver.findElement(By.xpath("//h5[text()='Choose the Course']/following::li[text()='Selenium WebDriver']")).click();
		driver.findElement(By.xpath("//h5[text()='Choose language randomly']//following::label[text()='Select Language']")).click();
		driver.findElement(By.xpath("//h5[text()='Choose language randomly']//following::li[text()='English']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//h5[contains(text(),'irrespective of the language chosen')]/following::label[text()='Select Values']")).click();
		driver.findElement(By.xpath("//h5[contains(text(),'irrespective of the language chosen')]/following::li[text()='Two']")).click();
		driver.close();
	}

}
