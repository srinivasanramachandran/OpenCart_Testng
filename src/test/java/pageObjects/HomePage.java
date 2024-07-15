package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage extends BasePage{
    
	public HomePage(WebDriver driver) {
		
    	super(driver);
	}
	
	@FindBy(xpath="//span[text()='My Account']") 
	WebElement btn_myaccount;
	
	@FindBy(xpath="//a[text()='Register']") 
	WebElement btn_register;
	
	@FindBy(linkText ="Login")
	WebElement linkLogin;
	
	
	   
	public void clickMyAccount() {
		
	 btn_myaccount.click();

	}
	
	public void setRegister() {
		
       btn_register.click();
	}
	
	
	public void clickLogin() {
		
		linkLogin.click();
	}
	
}
