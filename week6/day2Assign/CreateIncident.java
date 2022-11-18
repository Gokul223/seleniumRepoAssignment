package week6.day2Assign;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateIncident extends ServiceNow {
	
		@Test(dataProvider="fetchdata")
		public void createIncident(String shortDescription) {
			
		driver.findElement(By.xpath("//button[@id='sysverb_new']")).click();
		String incidentNo = driver.findElement(By.id("incident.number")).getAttribute("value");
		System.out.println("Incident number "+incidentNo);
		driver.findElement(By.id("incident.short_description")).sendKeys(shortDescription);
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys(incidentNo,Keys.ENTER);
		String text = shadow.findElementByXPath("//a[@class='linked formlink']").getText();
		System.out.println(text);
		if(text.contentEquals(incidentNo)) {
			System.out.println("Incident Created");
		}else {
			System.out.println("Incident not Created");
		}
		
	}
		
		@DataProvider(name="fetchdata")
		public String[][] sendData(){
			String [][] data = new String[1][1];
			data[0][0]="Created vai automation";
			return data;
			
		}
		

}
