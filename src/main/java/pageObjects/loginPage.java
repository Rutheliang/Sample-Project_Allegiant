package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class loginPage {
	
public WebDriver driver;
	
	By email = By.cssSelector("input[name='login-email']");
	By password = By.cssSelector("input[name='login-password']");
	By login = By.cssSelector("button[data-hook*='home-login_submit-button_continue']");
	
	
	

	
	public loginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public WebElement getEmail() {
		return driver.findElement(email);
	}
	

	public WebElement getPassword() {
		return driver.findElement(password);
	}
	
	
	
    public WebElement getLogin() {
			
    	JavascriptExecutor js = (JavascriptExecutor)driver;
    	js.executeScript("document.querySelector('.Box-s8oj9r-0.Modal__Overlay-sc-1522dmk-0.iwVcFq').scrollBy(0,200)");
			
		return driver.findElement(login);
		
		
	}
	

}
