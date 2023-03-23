package week6day2assignmentstaticanno;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;



public class BaseClass {
	public RemoteWebDriver driver;
	public ChromeOptions options;
	@Parameters({"browser","url","username","password"})
	@BeforeMethod
	public void preCondition(String browser,String url,String username,String password) throws InterruptedException
	{
	
 options = new ChromeOptions();
	options.addArguments("--remote-allow-origins=*");
	 driver = new ChromeDriver(options);
	 if(browser.equalsIgnoreCase("Chrome"))
	 {
		driver = new ChromeDriver(options);
	 }else if(browser.equalsIgnoreCase("Edge"))
	 {
		 driver=new EdgeDriver();
	 }
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
}

@AfterMethod
public void postCondition()
{
	driver.close();
	
}
}