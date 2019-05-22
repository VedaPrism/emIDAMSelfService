package Page_Factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class pf_LoginPage extends pf_genericmethods {
	//WebDriverWait wait;
	
	@FindBy(how = How.ID, using = "username") WebElement Usernamebox;
	
	@FindBy(how = How.XPATH, using = "//form[@class='formAfterLogin']/div[2]/input") public WebElement nextBtn;
	
	@FindBy(how = How.ID, using = "password") WebElement passwordbox;
	
	@FindBy(how = How.ID, using = "loginButtonId") WebElement authenticBtn;
	
	//@FindBy(how = How.XPATH, using = "//span[text()='Home']") WebElement homeBtn;
	
	public pf_LoginPage(WebDriver driver){

		PageFactory.initElements(driver, this);
		

	}

	public void logincredentials(String uid, String pas) throws Exception {

		cl_entertext(Usernamebox, uid);
		Thread.sleep(2000);
		cl_click(nextBtn);
		cl_entertext(passwordbox, pas);
		cl_click(authenticBtn);
		Thread.sleep(4000);
		
	}

}
