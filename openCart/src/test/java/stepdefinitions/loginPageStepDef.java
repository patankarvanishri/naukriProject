package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import openCart.LoginPage;

public class loginPageStepDef {
	
	private WebDriver driver;
	private LoginPage loginPage;
	
	@Before
	public void setUp() 
	{
		driver= new ChromeDriver();
		
	}
	
	@After
	public void tearDown() 
	{
		if(driver!=null) {driver.quit();}
	}
	
	@Given("I am on the openCart Login Page")
	public void i_am_on_the_open_cart_login_page() throws InterruptedException {
		loginPage = new LoginPage(driver);
	    driver.get("https://www.naukri.com/nlogin/login");
	    Thread.sleep(3000);
	    
	}

	@Given("I have entered valid username and password")
	public void i_have_entered_valid_username_and_password() {
	    loginPage.enterEmail("patankarvanishri@gmail.com");
	    loginPage.enterPassword("Parvati@1996");
	}

	@When("I click on login button")
	public void i_click_on_login_button() throws InterruptedException {
	    loginPage.clickLoginButton();
	    Thread.sleep(2000);
	}

	@Then("I should be logged successfully")
	public void i_should_be_logged_successfully() {
	   
	    Assert.assertEquals(driver.getTitle(), "Home | Mynaukri");
	}

	
	}
