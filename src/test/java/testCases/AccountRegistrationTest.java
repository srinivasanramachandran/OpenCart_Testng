package testCases;


import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegistrationPage;
import testBase.BaseClass;

public class AccountRegistrationTest extends BaseClass {
	@Test(groups= {"Regression","Master"}) //Step8 groups added
	public void verify_account_registration() throws InterruptedException {
		
		logger.info("*** starting TC001_AccountRegistrationTest***");
		try
		{
    	HomePage hp = new HomePage(driver);
		
		Thread.sleep(5);
		logger.info("Clicked on MyAccount Link.. ");
	    hp.clickMyAccount();
	    logger.info("Clicked on Register Link.. ");
	    hp.setRegister();
	    
	    RegistrationPage rp = new RegistrationPage(driver);
	    
	    rp.setFirstName(randomeString().toUpperCase());
	    rp.setLastName(randomeString().toUpperCase());
	    rp.setEmail(randomeString()+"@gmail.com");
	    rp.setTelephone(randomeNumber());
	    String pwd = randomAlphaNumeric();
	    rp.setPassword(pwd);
	    rp.setConfirmPassword(pwd);
	    rp.setPrivacyPolicy();
	    rp.clickContinue();

		logger.info("Validating expected message..");
	    
	    String confmsg = rp.getConfirmationMsg();
		Assert.assertEquals(confmsg, "Your Account Has Been Created!", "Confirmation message mismatch");
	    logger.info("Testpassed");
		}
		catch (Exception e)
		{
			logger.error("Test failed: " + e.getMessage());
			Assert.fail("Test failed: " + e.getMessage());
		} 
		finally 
		{
		logger.info("***** Finished TC001_AccountRegistrationTest *****");
		}
	
		
	}
	
   
	
	
	
}
