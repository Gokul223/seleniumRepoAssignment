package week6.day1Assign;


import org.openqa.selenium.By;
import org.testng.annotations.Test;


public class CreateLead extends ProjectSpecificMethod{

	@Test
	public void testCreateLead() {
//		driver.findElement(By.xpath("//a[text()='Leads']")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Testleaf");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Jeya Gokul");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Sekar");
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("Jeya Gokul");
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("Testing");
		driver.findElement(By.id("createLeadForm_description")).sendKeys("Testing Engineer");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("gokuldesparks@gmail.com");
		driver.findElement(By.name("submitButton")).click();
		String title = driver.getTitle();
		System.out.println(title); 
}
}






