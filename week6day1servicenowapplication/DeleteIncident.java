package week6day1servicenowapplication;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.sukgu.Shadow;

public class DeleteIncident {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*","--disable-notifications");
		ChromeDriver driver=new ChromeDriver(options);
		driver.get("https://dev126818.service-now.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("Testleaf@123");
		driver.findElement(By.id("sysverb_login")).click();
		Shadow dom=new Shadow(driver);
		dom.setImplicitWait(20);
		dom.findElementByXPath("//div[text()='All']").click();
		dom.findElementByXPath("//input[@id='filter']").sendKeys("Incident");
		dom.findElementByXPath("//mark[text()='Incident']").click();
		WebElement frame = dom.findElementByXPath("//iframe[@name='gsft_main']");
		driver.switchTo().frame(frame);	
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()='New']")).click();
		String value = driver.findElement(By.xpath("//input[@name='incident.number']")).getAttribute("value");
		System.out.println("num:" +value);
		WebElement description = driver.findElement(By.xpath("//input[@name='incident.short_description']"));
		description.sendKeys("Issue with email");	
		 driver.findElement(By.xpath("(//button[text()='Submit'])[2]")).click();
		 driver.findElement(By.xpath("//th[@glide_field='incident.number']")).click();
		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
		  String result =
		  driver.findElement(By.xpath("//input[@id='incident.number']")).getAttribute(
		  "value"); System.out.println(result);
		  driver.findElement(By.xpath("//button[text()='Delete']")).click(); 
		  driver.findElement(By.xpath("//button[@class='btn btn-destructive']")).click();
		  if(result.equals(value)) {
		  System.out.println("incident deleted"); } else {
		  System.out.println("incident not delete"); }

	}

}
