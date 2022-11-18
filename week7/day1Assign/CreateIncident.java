package week7.day1Assign;

import java.io.IOException;

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
		incidentNum = (String) incidentNo;
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
		public String[][] sendData() throws IOException{
			fileName ="ServiceNow";
			sheetIndex = 0;
			return ReadExcel.ReadData(fileName, sheetIndex);
			
		}

		
		

}
