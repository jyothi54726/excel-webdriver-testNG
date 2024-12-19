package excelWebdriverTestNG;

import java.io.FileInputStream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;

public class ExcelWDTestNG {

	public WebDriver driver;
	
	@BeforeClass
	public void Startup() {
		driver=new FirefoxDriver();
	}
	
	@AfterClass
	public void teardown() {
		driver.quit();
	}
	
	@Test
	public void login() throws Exception {
	
		FileInputStream f1=new FileInputStream("E:\\Selenium\\LoginExcel.xls");
		Workbook w=Workbook.getWorkbook(f1);
		Sheet s=w.getSheet(0);
		String un=s.getCell(0,1).getContents();
		String pw=s.getCell(1,1).getContents();
		driver.navigate().to("http://183.82.125.5/nareshit/login.php");
		driver.findElement(By.name("txtUserName")).sendKeys(un);
		driver.findElement(By.name("txtPassword")).sendKeys(pw);
		driver.findElement(By.name("Submit")).click();
		Thread.sleep(3000);
		System.out.println("Login completed");
		Reporter.log("Login completed");
		driver.findElement(By.linkText("Logout")).click();
		Reporter.log("Logout completed");
	}
}
