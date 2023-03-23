package week6day1servicenowapplication;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.sukgu.Shadow;

public class UpdateService {

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
		driver.findElement(By.xpath("//button[text()='New']")).click();
		WebElement description = driver.findElement(By.xpath("//input[@name='incident.short_description']"));
		description.sendKeys("Issue with email");
		Thread.sleep(1000);
		 String number = driver.findElement(By.xpath("//input[@id='incident.number']")).getAttribute("value");
		 System.out.println("Num:" +number);
		driver.findElement(By.xpath("(//button[text()='Submit'])[2]")).click();
		driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys(number, Keys.ENTER);	
		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();		
		WebElement urgent = driver.findElement(By.xpath("//select[@name='incident.urgency']"));		
				Select op=new Select(urgent);
				op.selectByVisibleText("1 - High");
				WebElement progress = driver.findElement(By.xpath("//select[@name='incident.state']"));
				Select op1=new Select(progress);
				op1.selectByVisibleText("In Progress");
				driver.findElement(By.xpath("(//button[text()='Update'])[1]")).click();
				driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
				String urgent1 = driver.findElement(By.xpath("//input[@name='sys_original.incident.urgency']")).getAttribute("value");
System.out.println(urgent1);
String progress1 = driver.findElement(By.xpath("//input[@name='sys_original.incident.state']")).getAttribute("value");
	System.out.println(progress1);
	}

}
