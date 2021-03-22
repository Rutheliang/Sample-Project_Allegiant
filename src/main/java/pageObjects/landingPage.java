package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class landingPage {

	public WebDriver driver;

	By signin = By.xpath("//div[contains(@class,'dLFASS')]/ul/li/span/div/div");
	By layover = By.cssSelector("button[data-hook='overlay-merchandise_ice-pop_close']");
	By origin = By.cssSelector("div[data-hook='flight-search-origin']");
	By destination = By.cssSelector("div[data-hook='flight-search-destination']");
	By departureDate = By.cssSelector("input[id='departure_date']");
	By datePickerCalender_0 = By.xpath("//div[@data-hook='flight-search-date-picker_calendar-0']/div/h2");
	By datePickerNavigate_0 = By.xpath("//button[@data-hook='flight-search-date-picker_navigate-next-month']");
	By datePickerCalender_1 = By.xpath("//div[@data-hook='flight-search-date-picker_calendar-1']/div/h2");
	By datePickerNavigate_1 = By.xpath("//button[@data-hook='flight-search-date-picker_navigate-next-month']");
	By traveler = By.cssSelector("div[class*='TravelersField__ArrowIconContainer']");
	By addTraveler = By.cssSelector("button[data-hook='flight-search-adults_increment']");
	By searchButton = By.cssSelector("div[class*='FlightSearchForm'] span[class*='Button__ButtonText']");
	
	
	
	
	public landingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public WebElement GetSignin() {
		return driver.findElement(signin);
	}

	public WebElement GetLayOver() {
		return driver.findElement(layover);
	}

	public void GetOrigin() {
		Actions b = new Actions(driver);
		String clickonLink = Keys.chord(Keys.ENTER);

		b.moveToElement(driver.findElement(origin)).click().sendKeys("las vegas").sendKeys(clickonLink).build()
				.perform();
	}

	public void GetDestination() {
		Actions b = new Actions(driver);
		String clickonLink = Keys.chord(Keys.ENTER);

		b.moveToElement(driver.findElement(destination)).click().sendKeys("fresno").sendKeys(clickonLink).build()
				.perform();
	}

	
	
	public void GetDepartureDate() {

		Actions b = new Actions(driver);
		b.moveToElement(driver.findElement(departureDate)).click().build().perform();

		JavascriptExecutor ab = (JavascriptExecutor)driver;
		
		ab.executeScript("window.scrollBy(0,300)");
		
		while (!driver.findElement(datePickerCalender_0).getText().contains("May"))
		{
			driver.findElement(datePickerNavigate_0).click();
		}
		
		List<WebElement> dates = driver.findElements(By.cssSelector("button[class*='Day-a047d8-0 bMaVmA']"));
		
		for (WebElement date : dates)
		{
			if(date.getText().equalsIgnoreCase("8"))
			{
				date.click();
				break;
			}
		}
	}
	
	
	
	public void GetArrivalDate() {

		
		while (!driver.findElement(datePickerCalender_1).getText().contains("June"))
		{
			driver.findElement(datePickerNavigate_1).click();
		}
		
		List<WebElement> returndates = driver.findElements(By.xpath("//div[@data-hook='flight-search-date-picker_calendar-1']//div[@class='Box-s8oj9r-0 iGqewV']"));
		
		for (WebElement returndate : returndates)
		{
			if(returndate.getText().equalsIgnoreCase("10"))
			{
				returndate.click();
				break;
			}
		}
	}

	
	public WebElement GetTraveler() {
		
		return driver.findElement(traveler);
	}
	
	
	public WebElement GetAddTraveler() {
		return driver.findElement(addTraveler);
	}
	
	public WebElement GetSearch() {
		return driver.findElement(searchButton);
	}
	
	
}
