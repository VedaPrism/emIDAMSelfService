package Page_Factory;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Generic_Library.Basefunctions;

public class pf_genericmethods extends Basefunctions {

	//	Entering text

	public void cl_entertext(WebElement el, String input){

		el.sendKeys(input);
	}

	//	Click on element

	public void cl_click(WebElement el){

		el.click();
	}

	// click OK on alert
	public void cl_popup() throws Exception {
		// Switch to Alert        
		Alert alert = w.switchTo().alert();		

		// Capture alert message.    
		String alertMessage= w.switchTo().alert().getText();		

		// Display alert message		
		System.out.println(alertMessage);	
		Thread.sleep(5000);

		// Accepting alert		
		alert.accept();
	}
	
	public void cl_waitUntil(WebElement e) {
		WebDriverWait wait = new WebDriverWait(w,500);
		wait.until(ExpectedConditions.visibilityOf(e));
	}
	

}
