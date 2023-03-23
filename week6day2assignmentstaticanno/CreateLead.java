package week6day2assignmentstaticanno;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class CreateLead extends BaseClass {
//	String[][] data  ;

@Test(dataProvider="createLead")
	public  void runCreate(String cname,String fname,String lname,String ph) {

		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(cname);
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fname);
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lname);
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys(ph);
		driver.findElement(By.name("submitButton")).click();
}


@DataProvider(name="createLead")
public String[][] sendData()
{
	String[][]data=new String[2][4];
	data[0][0]="CTS";
	data[0][1]="Hari";
	data[0][2]="R";
	data[0][3]="98";
	
	data[1][0]="TCS";
	data[1][1]="Sabari";
	data[1][2]="S";
	data[1][3]="97";
	return data;


}
}