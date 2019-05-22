package Page_Factory;

import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.LogStatus;

import Generic_Library.Utility;
import Scripts.ReviewAccess_Script;

public class pf_profilePage extends pf_genericmethods {
	final static Logger log = Logger.getLogger(pf_profilePage.class);
	
	@FindBy(how = How.XPATH, using = "//div[@class='pull-right']/ul/li/a/i") WebElement profileclick;	
	@FindBy(how = How.XPATH, using = "//div[@class='pull-right']/ul/li/ul/li[1]/a") WebElement profileBtn;
	@FindBy(how = How.XPATH, using = "//div[@class='pull-right']/ul/li/ul/li[2]/a") WebElement autoDelegationBtn;
	@FindBy(how = How.ID, using = "firstname") WebElement firstname;
	@FindBy(how = How.ID, using = "middlename") WebElement middlename;
	@FindBy(how = How.ID, using = "lastname") WebElement lastname;
	@FindBy(how = How.ID, using = "gender") WebElement gender;
	@FindBy(how = How.ID, using = "dateValues") WebElement dateValues;
	@FindBy(how = How.ID, using = "mobile") WebElement mobile;
	@FindBy(how = How.ID, using = "email") WebElement email; 
	@FindBy(how = How.ID, using = "username") WebElement username;
	//organization details	
	@FindBy(how = How.ID, using = "organization") WebElement organization; 
	@FindBy(how = How.ID, using = "userdept") WebElement userdept; 
	@FindBy(how = How.ID, using = "empId") WebElement empId;
	@FindBy(how = How.ID, using = "role") WebElement role;
	@FindBy(how = How.ID, using = "repMgr") WebElement repMgr;
	//address details
	@FindBy(how = How.ID, using = "addressline1") WebElement addressline1;
	@FindBy(how = How.ID, using = "addressline2") WebElement addressline2;
	@FindBy(how = How.ID, using = "country") WebElement country;
	@FindBy(how = How.ID, using = "state") WebElement state;
	@FindBy(how = How.ID, using = "city") WebElement city;
	@FindBy(how = How.ID, using = "zipcode") WebElement zipcode;
	//update button
	@FindBy(how = How.ID, using = "updateBtn") WebElement updateBtn;	
	//@FindBy(how = How.XPATH, using = "//span[@id='ProfileUpdationPopupmsg']/p/span") WebElement updateBtnMsg;
	
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Profile updated')]") WebElement updateBtnMsg;
	@FindBy(how = How.XPATH, using = "//a[text()='Cancel']") WebElement CancelBtn;
	
	@FindBy(how = How.XPATH, using = "//div[@id='actionBtns']/a") WebElement closeBtn;
	
	
	//Auto Delegation
	@FindBy(how = How.ID, using = "approval_delgation_username") WebElement autoDUsername;	
	@FindBy(how = How.XPATH, using = "//form[@id='approval_delegation_form']/ul/li/a") WebElement autoDUsernameSearchBtn;
	//checkbox
	@FindBy(how = How.XPATH, using = "//table[@id='searchedusers']/tbody/tr[2]/td/input") WebElement autoDUsernameChkbx;	
	@FindBy(how = How.ID, using = "showSelectedUser") WebElement submitBtn;
	@FindBy(how = How.ID, using = "approval_delgation_email") WebElement autoDEmailID;
	@FindBy(how = How.ID, using = "approval_delgation_name") WebElement autoDAprvName;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"approval_delgation_from_date\"]") WebElement aFromDate;
	
	
	//@FindAll({@FindBy(how = How.XPATH, using = "//table[@class=' table-condensed']/tbody/tr/td[(@class='old disabled day') and (@class='disabled day')]")}) public List<WebElement> fromoldDate;
	@FindAll({@FindBy(how = How.XPATH, using = "//table[@class=' table-condensed']/tbody/tr/td[not(@class='old disabled day') and not(@class='disabled day') and not(@class='new day')]")}) public List<WebElement> fromDate;
	String fdate="//table[@class=' table-condensed']/tbody/tr/td[not(@class='old disabled day') and not(@class='disabled day') and not(@class='new day')]/following-sibling::td[#DELIM#]";
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"approval_delgation_to_date\"]") WebElement aToDate;
	@FindBy(how = How.XPATH, using = "//table[@class=' table-condensed']/thead/tr[1]/th[3]") WebElement nxtBtnCalnder;
	@FindBy(how = How.ID, using = "approval_delgation_from_date") WebElement autoDFromDate;
	@FindBy(how = How.ID, using = "approval_delgation_to_date") WebElement autoDToDate;
	@FindBy(how = How.ID, using = "approval_delgation_reason") WebElement autoDReasn;
	//delegate button
	@FindBy(how = How.XPATH, using = "//a[text()='Delegate']") WebElement delegateBtn;
	//sucess msg
	
	@FindBy(how = How.ID, using = "succesMsg") WebElement successMsg;
	@FindBy(how = How.ID, using = "closeWindowAlert") WebElement closeWindowAlert;
	
	public pf_profilePage(WebDriver driver){

		PageFactory.initElements(driver, this);
	}
	
	public void profileDetails(String shtname,String scriptname) throws Exception {
		cl_click(profileclick);
		cl_click(profileBtn);
		et.log(LogStatus.PASS,"Profile button is clicked- passed");
		log.info("--Profile page is displayed");
		System.out.println("First Name is: "+firstname.getAttribute("value"));
		System.out.println("Middle Name is: "+middlename.getAttribute("value"));
		System.out.println("Last Name is: "+lastname.getAttribute("value"));
		System.out.println("Gender is: "+gender.getAttribute("value"));
		System.out.println("Date of Birth is: "+dateValues.getAttribute("value"));
		System.out.println("Mobile number is: "+mobile.getAttribute("value"));
		System.out.println("Email Id is: "+email.getAttribute("value"));
		System.out.println("User Name is: "+username.getAttribute("value"));
		System.out.println("organization is: "+organization.getAttribute("value"));
		System.out.println("User department is: "+userdept.getAttribute("value"));
		System.out.println("Employee ID is: "+empId.getAttribute("value"));
		System.out.println("Role is: "+role.getAttribute("value"));
		System.out.println("Reporting manager is: "+repMgr.getAttribute("value"));
		System.out.println("Addressline1 is: "+addressline1.getAttribute("value"));
		System.out.println("Addressline2 is: "+addressline2.getAttribute("value"));
		System.out.println("Country is: "+country.getAttribute("value"));
		System.out.println("State is: "+state.getAttribute("value"));
		System.out.println("City is: "+city.getAttribute("value"));
		System.out.println("Zipcode is: "+zipcode.getAttribute("value"));
		cl_click(updateBtn);
		Thread.sleep(3000);
		et.log(LogStatus.PASS,"Update button is clicked- passed");
		String msg=updateBtnMsg.getText();
		System.out.println("MSG:"+ msg);
		cl_click(closeBtn);	
		Utility.comparelogic(msg, shtname, scriptname);
		et.log(LogStatus.PASS,"Close button of popup is clicked- passed");
		log.info("--Profile page Cancel button check");
		cl_click(profileclick);
		cl_click(profileBtn);
		et =  es.startTest("Profile cancel Button");
		et.log(LogStatus.PASS,"Profile button is clicked- passed");
		cl_click(CancelBtn);
		Thread.sleep(2000);
		log.info("Cancel button is clicked");
		et.log(LogStatus.PASS,"Cancel button is clicked- passed");
		
	}
	
	public void autoDelegation() throws Exception {
		cl_click(profileclick);
		cl_click(autoDelegationBtn);
		log.info("--Auto delegation page is displayed");
		String name=Utility.getpropertydetails("AutoDelegationUserName");
		autoDUsername.clear();
		cl_entertext(autoDUsername, name);
		cl_click(autoDUsernameSearchBtn);
		Thread.sleep(1000);
		cl_click(autoDUsernameChkbx);
		cl_click(submitBtn);
		System.out.println("--Delegate to someone else--");
		System.out.println("Email ID is: "+autoDEmailID.getAttribute("value"));
		System.out.println("Approver's name is: "+autoDAprvName.getAttribute("value"));
		Thread.sleep(3000);
		//cl_click(aFromDate);
		String fromDate=Utility.getpropertydetails("AutoDelegationFromDate");	
		((JavascriptExecutor)w).executeScript("document.getElementById('approval_delgation_from_date').setAttribute('value','"+fromDate+"')");
		/*int fromDateSize=fromDate.size();
		System.out.println("fromDateSize: "+fromDateSize);
		Random r=new Random();
		int f=r.nextInt(fromDateSize);
		cl_click(w.findElement(By.xpath(fdate.replace("#DELIM#",String.valueOf(f)))));*/
		
		Thread.sleep(2000);
		//cl_click(aToDate);
		String toDate=Utility.getpropertydetails("AutoDelegationToDate");
		((JavascriptExecutor)w).executeScript("document.getElementById('approval_delgation_to_date').setAttribute('value','"+toDate+"')");
		Thread.sleep(1000);
		//cl_click(nxtBtnCalnder);
		String reason=Utility.getpropertydetails("AutoDelegationReason");
		cl_entertext(autoDReasn, reason);
		cl_click(delegateBtn);
		Thread.sleep(4000);
		String msg=successMsg.getText();
		System.out.println("Delegation success messsage: "+msg);
		cl_click(closeWindowAlert);
	}
}
