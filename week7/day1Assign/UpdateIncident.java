package week7.day1Assign;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class UpdateIncident extends ServiceNow {

	@Test(dataProvider ="fetchData") 
	public void updateIncident(String Inc) {
		driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys(Inc,Keys.ENTER);
		shadow.findElementByXPath("//a[@class='linked formlink']").click();
		driver.findElement(By.id("incident.urgency")).click(); 
		driver.findElement(By.xpath("//option[text()='1 - High']")).click();
		driver.findElement(By.id("incident.state")).click();
		driver.findElement(By.xpath("//option[text()='In Progress']")).click();
		driver.findElement(By.id("sysverb_update")).click();
		shadow.findElementByXPath("//a[@class='linked formlink']").click();
		String incidentState = driver.findElement(By.xpath("(//span[text()='Incident state'])[1]//following-sibling::span")).getText();
		String priority = driver.findElement(By.xpath("(//span[text()='Priority'])[1]//following-sibling::span")).getText();
		if(incidentState.contains("In Progress")) {
			System.out.println("State verified--> "+incidentState);
		}else {
			System.out.println("State not verified");
		}
		if(priority.contains("3 - Moderate")) {
			System.out.println("Priority verified--> "+priority);
		}else {
			System.out.println("Priority not verified");
		}
	}
	
	@DataProvider(name="fetchData")
	public String[][] sendData() {
		String[][] data = new String[1][1];
		data[0][0] = incidentNum;
		return data;
	}
}
