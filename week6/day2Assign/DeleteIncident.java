package week6.day2Assign;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class DeleteIncident extends ServiceNow {

	@Test
	public void deleteIncident() {
		driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys("INC0010007",Keys.ENTER);
		shadow.findElementByXPath("//a[@class='linked formlink']").click();
		driver.findElement(By.id("sysverb_delete")).click();
		driver.findElement(By.id("ok_button")).click();
		System.out.println("Incident deleted");
	}
	
	

}
