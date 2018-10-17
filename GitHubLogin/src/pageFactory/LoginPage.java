package pageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.How;
public class LoginPage {
	
	public WebDriver driver;
	public LoginPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how=How.ID, using="email")
	private WebElement txtEmailorPhone;
	
	@FindBy(how=How.ID, using="pass")
	private WebElement txtPassword;
	
	@FindBy(how=How.ID, using="u_0_2")
	private WebElement btnLogin;
	
	public void Login(String userid, String password){
		try{
			txtEmailorPhone.clear();
			txtEmailorPhone.sendKeys(userid);
			txtPassword.clear();
			txtPassword.sendKeys(password);
			btnLogin.click();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}
}
