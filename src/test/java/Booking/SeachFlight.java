package Booking;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.landingPage;
import pageObjects.loginPage;
//import pageObjects.passwordPage;
import resources.base;

public class SeachFlight extends base {
	
	public static Logger log =LogManager.getLogger(base.class.getName());
	
public WebDriver driver;
	
	@BeforeTest
	
	public void initialize () throws IOException {
		
		
		
		driver = intializeDriver();
		log.info("Driver is initialized");
		
	}
	
	@Test
	
	public void allegiantSearchFLight() throws IOException {
		driver.get(prop.getProperty("url"));
		log.info("Navigated to allegiant homepage");
		
	
		
		landingPage land = new landingPage (driver);
		land.GetLayOver().click();
		land.GetOrigin();
		land.GetDestination();
		land.GetDepartureDate();
		land.GetArrivalDate();
		land.GetTraveler().click();
		land.GetAddTraveler().click();
		land.GetSearch().click();
	
		
	
		
	}

	@AfterTest
	public void teardown() {
		
	driver.close();
	}

}
