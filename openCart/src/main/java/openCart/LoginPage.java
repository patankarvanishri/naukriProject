package openCart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	private WebDriver driver;
	
	//By locator
	
	private By emailInputLocator= By.xpath("//input[@id='usernameField']");
	private By passwordInputLocator= By.xpath("//input[@id='passwordField']");
	private By loginButtonLocator= By.xpath("//button[@type='submit']");
	
	
	//Constructor
	public LoginPage(WebDriver driver)
	{	
	this.driver=driver;
	}
	
	//Methods/Actions
	
	public void enterEmail(String Email) 
	{
		WebElement emailInput=driver.findElement(emailInputLocator);
		emailInput.sendKeys(Email);
	}
	public void enterPassword(String Paasword) 
	{
		WebElement passwordInput=driver.findElement(passwordInputLocator);
		passwordInput.sendKeys(Paasword);
	}
	public void clickLoginButton() 
	{
		WebElement loginButton=driver.findElement(loginButtonLocator);
		loginButton.click();
	}
	
	

}
