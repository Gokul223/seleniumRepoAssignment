package week2.day2Assign;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGround1 {

	public static void main(String[] args) throws InterruptedException  {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/input.xhtml;jsessionid=node0tmb2389go0xlxjvuy66xu9p668024.node0");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		WebElement name = driver.findElement(By.xpath("//h5[text()='Type your name']/following::input[1]"));
		name.clear();
		name.sendKeys("Jeya Gokul S");
		WebElement city = driver.findElement(By.xpath("//h5[text()='Append Country to this City.']/following::input[1]"));
		city.clear();
		city.sendKeys("Chennai");
		System.out.println(driver.findElement(By.xpath("//h5[text()='Verify if text box is disabled']/following::input[1]")).isEnabled());
		driver.findElement(By.xpath("//h5[text()='Clear the typed text.']/following::input[1]")).clear();
		System.out.println(driver.findElement(By.xpath("//h5[text()='Retrieve the typed text.']/following::input[1]")).getText());
		driver.findElement(By.xpath("//h5[text()='Type email and Tab. Confirm control moved to next element.']/following::input[1]")).sendKeys("gokuldesparks@gmail.com",Keys.TAB);
		driver.findElement(By.xpath("//h5[text()='Type about yourself']/following::textarea")).sendKeys("Im Jeya Gokul S.");
		driver.findElement(By.xpath("//span[@aria-controls='ql-picker-options-0']")).click();
		driver.findElement(By.xpath("(//span[contains(@id,'picker')]//span[@data-value='monospace'])[1]")).click();
		driver.findElement(By.xpath("//span[@aria-controls='ql-picker-options-1']")).click();
		driver.findElement(By.xpath("(//span[contains(@id,'ql-picker-options')]//span[@data-value='large'])[1]")).click();
		driver.findElement(By.xpath("(//span[@class='ql-formats']/button[@class='ql-bold'])[1]")).click();
		driver.findElement(By.xpath("(//span[@class='ql-formats']/button[@class='ql-italic'])[1]")).click();
		driver.findElement(By.xpath("(//span[@class='ql-formats']/button[@class='ql-underline'])[1]")).click();
		driver.findElement(By.xpath("(//span[@class='ql-formats']/button[@class='ql-strike'])[1]")).click();
		driver.findElement(By.xpath("//span[@aria-controls='ql-picker-options-2']")).click();
		driver.findElement(By.xpath("//span[@aria-controls='ql-picker-options-2']//following::span[@tabindex='0'][1]")).click();
		driver.findElement(By.xpath("//span[@aria-controls='ql-picker-options-2']")).click();
		driver.findElement(By.xpath("//span[@aria-controls='ql-picker-options-2']//following::span[@data-value='#ffc266'][1]")).click();
		driver.findElement(By.xpath("//span[@aria-controls='ql-picker-options-4']")).click();
		driver.findElement(By.xpath("//span[@data-value='justify']")).click();
		driver.findElement(By.xpath("(//div[@style='height: 300px;']//p)[1]")).sendKeys("Welcome");
		driver.findElement(By.xpath("//h5[text()='Just Press Enter and confirm error message*']//following::input[contains(@id,'thisform')]")).sendKeys(Keys.ENTER);
		System.out.println(driver.findElement(By.xpath("//div[@aria-live='polite']//span[text()='Age is mandatory']")).getText());
		WebElement label = driver.findElement(By.xpath("//label[text()='Username']"));
		driver.findElement(By.xpath("//label[text()='Username']/preceding-sibling::input")).click();
		WebElement Label = driver.findElement(By.xpath("//label[text()='Username']"));
		if(label != Label) {
			System.out.println("Label position changes");
		}else {
			System.out.println("Label position not changes");
		}
		driver.findElement(By.xpath("//h5[text()='Type your name and choose the third option']/following::input[@aria-autocomplete='list']")).sendKeys("Jeya Gokul");
		driver.findElement(By.xpath("//li[contains(@data-item-label,'2')]")).click();
		driver.findElement(By.xpath("//h5[text()='Type your DOB (mm/dd/yyyy) and confirm date chosen ']/following::input[contains(@id,'input')][1]")).sendKeys("09/02/1999");
		driver.findElement(By.xpath("//a[text()='2']")).click();
		driver.findElement(By.xpath("//h5[text()='Type number and spin to confirm value changed']/following::input[contains(@id,'input')][1]")).sendKeys("7");
		driver.findElement(By.xpath("//h5[text()='Type number and spin to confirm value changed']/following::a[contains(@class,'spinner')][1]")).click();
		driver.findElement(By.xpath("//h5[text()='Type random number (1-100) and confirm slider moves correctly']/following::input[contains(@id,'slider')]")).sendKeys("7");
		WebElement slider = driver.findElement(By.xpath("//h5[text()='Type random number (1-100) and confirm slider moves correctly']/following::input[contains(@id,'slider')]"));
		Thread.sleep(1000);
		System.out.println(driver.findElement(By.xpath("//h5[text()='Type random number (1-100) and confirm slider moves correctly']/following::input[contains(@id,'slider')]/following::span[contains(@style,'left:')][1]")).getAttribute("style"));
		String slideValue =driver.findElement(By.xpath("//h5[text()='Type random number (1-100) and confirm slider moves correctly']/following::input[contains(@id,'slider')]/following::span[contains(@style,'left:')][1]")).getAttribute("style");
		if(slideValue.contains(slider.getText())) {
			System.out.println("This is equal");
		}else {
			System.out.println("This is not equal");
		}
		driver.findElement(By.xpath("//h5[text()='Click and Confirm Keyboard appears']/following::input[1]")).click();
		String keyboard = driver.findElement(By.xpath("//div[@id='textarea_simulator']/following-sibling::div[1]")).getCssValue("display");
		System.out.println(keyboard);
		if(keyboard.contains("block")) {
			System.out.println("The keyboard is visible");
		}
		driver.findElement(By.xpath("//h5[text()='Custom Toolbar']/following::button[contains(@class,'bold')]")).click();
		driver.findElement(By.xpath("//h5[text()='Custom Toolbar']/following::button[contains(@class,'italic')]")).click();
		driver.findElement(By.xpath("//h5[text()='Custom Toolbar']/following::button[contains(@class,'underline')]")).click();
		driver.findElement(By.xpath("//h5[text()='Custom Toolbar']/following::button[contains(@class,'strike')]")).click();
		driver.findElement(By.xpath("//h5[text()='Custom Toolbar']/following::span[contains(@aria-controls,'picker')][1]")).click();
		driver.findElement(By.xpath("//h5[text()='Custom Toolbar']/following::span[@data-value='monospace']")).click();
		driver.findElement(By.xpath("//h5[text()='Custom Toolbar']/following::span[contains(@aria-controls,'picker')][2]")).click();
		driver.findElement(By.xpath("//h5[text()='Custom Toolbar']/following::span[@data-value='large']")).click();
		driver.findElement(By.xpath("//h5[text()='Custom Toolbar']/following::div[@data-placeholder='Enter your content']")).sendKeys("Toolbar");
		Thread.sleep(1000);
		driver.close();
		}

}
