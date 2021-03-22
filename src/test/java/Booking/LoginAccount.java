package Booking;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.landingPage;
import pageObjects.loginPage;
//import pageObjects.loginPage;
//import pageObjects.passwordPage;
import resources.base;

public class LoginAccount extends base {
	
public WebDriver driver;
	
	@BeforeTest
	
	public void initialize () throws IOException {
		driver = intializeDriver();
		
	}
	
	@Test
	
	public void allegiantLoginAccess() throws IOException {
		
		driver.get(prop.getProperty("url"));
		
		//one is inheritance
		//creating object to that class and invoke methods of it
		
		landingPage land = new landingPage (driver);
		land.GetLayOver().click();
		land.GetSignin().click(); 
		
		loginPage lp = new loginPage (driver);
		lp.getEmail().sendKeys("ruthel_rodriguez@yahoo.com");
		lp.getPassword().sendKeys("Abcd@1234");
		lp.getLogin().click();
		
	
		
	}

	@AfterTest
	public void teardown() {
		
	driver.close();
	}

}
