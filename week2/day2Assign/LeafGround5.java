package week2.day2Assign;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGround5 {

	public static void main(String[] args) throws MalformedURLException, IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/link.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//h5[text()='Take me to dashboard']/following::a[text()='Go to Dashboard'][1]")).click();
		driver.findElement(By.xpath("//span[text()='Element']/ancestor::a")).click();
		driver.findElement(By.xpath("//span[text()='Hyper Link']")).click();
		System.out.println("URl --> "+driver.findElement(By.xpath("//h5[text()='Find my destination']/following::a[text()='Find the URL without clicking me.']")).getAttribute("href"));
		WebElement brokenLink = driver.findElement(By.xpath("//h5[text()='Am I broken link?']/following::a[text()='Broken?']"));
		HttpURLConnection connection = (HttpURLConnection)new  URL(brokenLink.getAttribute("href")).openConnection();
		System.out.println("The link is "+connection.getResponseMessage());
		//System.out.println(url.isBlank());
		List<WebElement> dashboard = driver.findElements(By.xpath("//h5[text()='Take me to dashboard']/following::a[text()='Go to Dashboard']"));
        int dashLink = dashboard.size();
        if(dashLink <=1) {
        	System.out.println("The dashboard link is not duplicate");
        }else {
        	System.out.println("The dashboard link is duplicate");
        }
        System.out.println("Links in the page is "+driver.findElements(By.xpath("//a[@href]")).size());
        System.out.println("Links in the layout is "+driver.findElements(By.xpath("//h5[text()='Take me to dashboard']/following::a")).size());
        driver.close();
		}
	   
}
