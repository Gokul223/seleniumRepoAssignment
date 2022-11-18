package week6.day2Assign;


import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class CreateLead extends projectSpecificMethod{

	@Test(dataProvider="fetchData")
	public void testCreateLead(String cName, String fName, String lName) {
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(cName);
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fName);
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lName);
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys("99");
		driver.findElement(By.name("submitButton")).click();
		String title = driver.getTitle();
		System.out.println(title); 
}
	
	@DataProvider(name="fetchData")
	public String[][] sendData(){
		String[][] data = new String[2][3];
		data[0][0]="Testleaf";
		data[0][1]="Jeya Gokul";
		data[0][2]="Sekar";
		
		data[1][0]="Qeagle";
		data[1][1]="Gokul";
		data[1][2]="Sekar";
		return data;
	}
	
}






