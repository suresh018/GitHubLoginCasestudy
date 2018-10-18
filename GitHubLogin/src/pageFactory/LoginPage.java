package pageFactory;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import customException.MyException;
public class LoginPage {
	
	public WebDriver driver;
	public LoginPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how=How.ID, using="user[login]")
	private WebElement txtUserName;
	
	@FindBy(how=How.ID, using="user[email]")
	private WebElement txtEmail;
	
	@FindBy(how=How.ID, using="user[password]")
	private WebElement txtPassword;
	
	@FindBy(how=How.CSS, using=".btn-primary-mktg")
	private WebElement btnSignUp;
	
	@FindBy(how=How.CSS, using=".flash.flash-error.my-3")
	private WebElement flashError;
	
	@FindBy(how=How.CSS, using=".error")
	private WebElement lblErrorMessage;
	
	@FindBy(how=How.CSS, using=".f2-light.mb-3")
	private WebElement lblVerifyAccount;
	
	public void Login(String username,String email, String password){
		try{
			txtUserName.clear();
			txtUserName.sendKeys(username);
			
			//String xx=errorMessage.getText();
			Thread.sleep(2000);
			txtEmail.clear();
			txtEmail.sendKeys(email);
			Thread.sleep(2000);
			txtPassword.clear();
			txtPassword.sendKeys(password);
			Thread.sleep(2000);
			btnSignUp.click();
			Thread.sleep(2000);
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		verifySignUp();
		
	}
	public void verifySignUp(){

		try{
			//If error occured
			if(flashError.getText().contains("There were problems creating your account.")){
				
				//if multiple fields have invalid data, it will show only the first error
				String errMsg=lblErrorMessage.getText();
				throw new MyException("There were problems creating your account."+ errMsg);
			}
		}
		catch(NoSuchElementException e){
			//Verify account to create
			if(!lblVerifyAccount.getText().contains("Verify account")){
				throw new MyException("Error while verifying account.");
			}
		}
		

		
	}
}