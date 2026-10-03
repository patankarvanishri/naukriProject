package openCart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UpdateProfilePage extends BasePage {
	
//private WebDriver driver;
	
	//By locator
	
	
	private By editResumeHeadLineButtonLocator= By.xpath("//div[@class='resumeHeadline']//span[2]");
	private By  resumeHeadLineTextLocator= By.xpath("//textarea[@id='resumeHeadlineTxt']");
	private By  saveResumeHeadLineLocator= By.xpath("(//div[@class='action s12']//button)");
	
	
	//Constructor
	public UpdateProfilePage(WebDriver driver)
	{	
	super(driver);
	}
	
	

	//Methods/Actions
	
	public void clickOnEditResumeHeaddLine() 
	{
		try {
		WebElement editResumeHeadLineButton=driver.findElement(editResumeHeadLineButtonLocator);
		editResumeHeadLineButton.click();
		}
		catch(Exception e)
		{
			System.out.print(e.getMessage());
		}
	}
	
	public void updateResumeHeadline(String newHeadLine) throws InterruptedException 
	{
		WebElement resumeHeadLineText=driver.findElement(resumeHeadLineTextLocator);
		Thread.sleep(1000);
		String text = resumeHeadLineText.getAttribute("value");
		//System.out.print(text);
		if(newHeadLine.equals(text))
		{
			resumeHeadLineText.clear();
			resumeHeadLineText.sendKeys(newHeadLine +"|");
			System.out.println("If statement executed");		
			
		}
		
		else {
			resumeHeadLineText.clear();
			resumeHeadLineText.sendKeys(text  +" | ");
			System.out.println("else statement executed");
		}
		
	}
	
	public void saveResumeHeaddLine() 
	{
		WebElement saveResumeHeadLineButton=driver.findElement(saveResumeHeadLineLocator);
		saveResumeHeadLineButton.click();
	}
	

}
