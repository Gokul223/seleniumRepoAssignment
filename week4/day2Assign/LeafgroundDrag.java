package week4.day2Assign;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafgroundDrag {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/drag.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement sourceCol = driver.findElement(By.xpath("//h5[text()='Draggable Columns']/following::span[text()='Name']"));
		Actions act = new Actions(driver);
		System.out.println(sourceCol.getLocation());
		WebElement tarCol = driver.findElement(By.xpath("//h5[text()='Draggable Columns']/following::span[text()='Quantity']"));
		System.out.println(tarCol.getLocation());
		act.clickAndHold(sourceCol).dragAndDrop(sourceCol, tarCol).perform();
		act.clickAndHold(tarCol).dragAndDrop(tarCol, sourceCol).perform();
		Thread.sleep(1000);
		String text = driver.findElement(By.xpath("//span[text()='Columns reordered']")).getText();
		System.out.println(text);
		WebElement dragRow = driver.findElement(By.xpath("//h5[text()='Draggable Rows']/following::tr[@data-ri='3']"));
		WebElement tarRow = driver.findElement(By.xpath("//h5[text()='Draggable Rows']/following::tr[@data-ri='5']"));
		System.out.println(dragRow.getLocation());
		System.out.println(tarRow.getLocation());
		Thread.sleep(1000);
		act.clickAndHold(dragRow).dragAndDrop(dragRow, tarRow).perform();
		WebElement resize = driver.findElement(By.xpath("//img[@id='form:logo']/following-sibling::div[1]"));
		act.clickAndHold(resize).dragAndDropBy(resize, 220, 0).perform();
		WebElement img = driver.findElement(By.xpath("//span[text()='Image resized']/following-sibling::p"));
		System.out.println(img.getText());
		WebElement sourceRange = driver.findElement(By.xpath("//span[@tabindex='0']"));
		act.clickAndHold(sourceRange).dragAndDropBy(sourceRange, -80, 0).perform();
	}
}

