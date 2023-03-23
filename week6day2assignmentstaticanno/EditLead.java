package week6day2assignmentstaticanno;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class EditLead   extends BaseClass {
//		String [][]data;
@Test(dataProvider="editLead")
	public  void runEdit(String ph,String cname)throws InterruptedException {
	
		
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(ph);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		driver.findElement(By.linkText("Edit")).click();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys(cname);
		driver.findElement(By.name("submitButton")).click();
		
}



@DataProvider(name="editLead")
public String[][] sendData()
{
	String[][] data=new String[2][2];
	data[0][0]="98";
	data[0][1]="TCS";
	
	data[1][0]="99";
	data[1][1]="Wipro";
	return data;
	}
}


