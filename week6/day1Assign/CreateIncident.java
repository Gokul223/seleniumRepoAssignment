package week6.day1Assign;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class CreateIncident extends ServiceNow {
		@Test
		public void createIncident() {
			
		driver.findElement(By.xpath("//button[@id='sysverb_new']")).click();
		String incidentNo = driver.findElement(By.id("incident.number")).getAttribute("value");
		System.out.println("Incident number "+incidentNo);
		driver.findElement(By.id("incident.short_description")).sendKeys("Created vai automation");
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys(incidentNo,Keys.ENTER);
		String text = shadow.findElementByXPath("//a[@class='linked formlink']").getText();
		System.out.println(text);
		if(text.contentEquals(text)) {
			System.out.println("Incident Created");
		}else {
			System.out.println("Incident not Created");
		}
		
	}

}
