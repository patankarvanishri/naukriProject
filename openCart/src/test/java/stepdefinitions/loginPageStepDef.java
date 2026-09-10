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
import openCart.UpdateProfilePage;

public class loginPageStepDef {
	
	private WebDriver driver;
	private LoginPage loginPage;
	private UpdateProfilePage updateProfilePage;
	
	@Before
	public void setUp() 
	{
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		
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
	@Given("I click on update profile button")
	public void i_click_on_update_profile_button() throws InterruptedException {
		//updateProfilePage = new UpdateProfilePage();
		loginPage.clickViewProfileButton();
	}

	@Then("I am on the profile page")
	public void i_am_on_the_profile_page() throws InterruptedException {
		updateProfilePage = new UpdateProfilePage(driver);
		driver.navigate().to("https://www.naukri.com/mnjuser/profile");
		Assert.assertEquals(driver.getTitle(), "Profile | Mynaukri");
		Thread.sleep(1000);
	}

	@Then("I click on edit resume headline")
	public void i_click_on_edit_resume_headline() {
		updateProfilePage.clickOnEditResumeHeaddLine();
	}

	@Then("I have entered text {string}")
	public void i_have_entered_text(String string) throws InterruptedException {
		updateProfilePage.updateResumeHeadline(string);
	}

	@Then("I save the headline")
	public void i_save_the_headline() {
		updateProfilePage.saveResumeHeaddLine();
	}

	@After
	public void tearDown() 
	{
		if(driver!=null) {driver.quit();}
	}

	
	}
