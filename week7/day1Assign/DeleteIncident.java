package week7.day1Assign;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DeleteIncident extends ServiceNow {

	@Test(dataProvider = "fetchData")
	public void deleteIncident(String Inc) {
		driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys(Inc,Keys.ENTER);
		shadow.findElementByXPath("//a[@class='linked formlink']").click();
		driver.findElement(By.id("sysverb_delete")).click();
		driver.findElement(By.id("ok_button")).click();
		System.out.println("Incident deleted");
	}
	
	@DataProvider(name="fetchData")
	public String[][] sendData() {
		String[][] data = new String[1][1];
		data[0][0] = incidentNum;
		return data;
	}

}
