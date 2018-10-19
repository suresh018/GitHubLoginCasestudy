package testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import pageFactory.LoginPage;

public class DriverScript {
	public static  String URL="https://github.com/";
	public static  String pathChromeDriver="D:\\Automation\\AutomationFramework\\PageObjcetWithPageFactory\\drivers\\chromedriver_win32\\chromedriver.exe";
	public static WebDriver driver;
	LoginPage loginpage;
	
	
  @Test
  //Successful signup
  public void Signup_Success() {
	  loginpage=new LoginPage(driver);
	  loginpage.Login("suresh234we","super.d@yahoo.com", "DasDer@123");
	  
  }
  @Test
  //Invalid/already existed username
  public void Signup_InvalidUser() {
	  loginpage=new LoginPage(driver);
	  loginpage.Login("suresh","super.d@yahoo.com", "DasDer@123");
	  
  }
  @Test
  //Invalid email
  public void Signup_InvalidEmail() {
	  loginpage=new LoginPage(driver);
	  loginpage.Login("suresh234we","super.yahoo.com", "DasDer@123");
	  
  }
  @Test
  //invalid password
  public void Signup_InvalidPassword() {
	  loginpage=new LoginPage(driver);
	  loginpage.Login("suresh234we","super.d@yahoo.com", "Das@123");
	  
  }
  @Test
  //invalid username, email and password
  public void Signup_InvalidInputs() {
	  loginpage=new LoginPage(driver);
	  loginpage.Login("suresh","super.yahoo.com", "Das@123");
	  
  }
  @Test
  //invalid username, email and password
  public void Signup_BlankInputs() {
	  loginpage=new LoginPage(driver);
	  loginpage.Login("","super.yahoo.com", "Das@123");
	  
  }    
  
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver",pathChromeDriver);
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.get(URL);  	
  }

  @AfterMethod
  public void afterMethod() {
	  driver.close();
  }
}
