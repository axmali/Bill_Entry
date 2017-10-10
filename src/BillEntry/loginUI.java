package BillEntry;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginUI {
	static WebDriver driver;
	
	public loginUI(WebDriver driver)
	{
		loginUI.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="txt_login_username")
	private WebElement userName;
	
	@FindBy(id="txt_login_password")
	private WebElement password;
	
	@FindBy(id="btn_login_submit")
	private WebElement loginButton;
	
	@FindBy(id="btn_user_portal")
	private WebElement userPortal;
	
	
	public void inputUserName(String name){
		userName.sendKeys(name);
	}
	
	public void inputPassword(String pwd){
		password.sendKeys(pwd);
	}
	
	public void ClickOnLoginButton(){
		loginButton.click();
	}
	
	public void ClickOnUserPortal(){
		userPortal.click();
	}
	
}
