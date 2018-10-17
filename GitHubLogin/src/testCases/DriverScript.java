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
	public static  String URL="https://www.facebook.com/";
	public static  String pathChromeDriver="D:\\Automation\\AutomationFramework\\PageObjcetWithPageFactory\\drivers\\chromedriver_win32\\chromedriver.exe";
	public static WebDriver driver;
	LoginPage loginpage;
	
	
  @Test
  public void Login() {

	  loginpage=new LoginPage(driver);
	  loginpage.Login("suresh", "das@123");
	  
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
