package Page_Factory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.LogStatus;

import Generic_Library.Basefunctions;
import Generic_Library.Utility;
import Scripts.MakeARequest_Script;

public class pf_ReviewAccessPage extends pf_genericmethods {
	Basefunctions b=new Basefunctions();
	final static Logger log = Logger.getLogger(pf_ReviewAccessPage.class);

	@FindBy(how = How.XPATH, using = "//span[text()='Review Access']") WebElement reviewAccess;
	@FindBy(how = How.XPATH, using = "//div[@class='panel-heading']/ul/li[1]/a") WebElement pending;
	@FindBy(how = How.XPATH, using = "//div[@class='panel-heading']/ul/li[2]/a") WebElement rejected;
	@FindBy(how = How.XPATH, using = "//div[@class='panel-heading']/ul/li[3]/a") WebElement approved;
	@FindBy(how = How.XPATH, using = "//div[@class='panel-heading']/ul/li[4]/a") WebElement expired;
	@FindBy(how = How.XPATH, using = "//div[@class='panel-heading']/ul/li[5]/a") WebElement delegate;

	//pending review access actions		
	@FindAll({@FindBy(how = How.XPATH, using = "//table[@id='reviewAccessUserActivityTable']/tbody/tr[not(@class='jqgfirstrow')]")}) public List<WebElement> apprveCount;
	String apprveBtn="//table[@id='reviewAccessUserActivityTable']/tbody/tr[@class='jqgfirstrow']/following-sibling::tr[#DELIM#]/td[9]/ul/li[1]/a/i";
	String reviewName="//table[@id='reviewAccessUserActivityTable']/tbody/tr[@class='jqgfirstrow']/following-sibling::tr[#DELIM#]/td[3]";
	String Username="//table[@id='reviewAccessUserActivityTable']/tbody/tr[@class='jqgfirstrow']/following-sibling::tr[#DELIM#]/td[4]";
	String reviewType="//table[@id='reviewAccessUserActivityTable']/tbody/tr[@class='jqgfirstrow']/following-sibling::tr[#DELIM#]/td[5]";
	String pcheckbox="//table[@id='reviewAccessUserActivityTable']/tbody/tr[@class='jqgfirstrow']/following-sibling::tr[#DELIM#]/td[1]";
	@FindBy(how = How.XPATH, using = "//div[@id='approvalConfirmation']/div/div/div[3]/button[1]") WebElement yesBtn;
	//success msg	
	@FindBy(how = How.XPATH, using = "//div[@id='successMessage']/div/div/div[2]") WebElement successMsg;
	//success msg close button
	@FindBy(how = How.XPATH, using = "//div[@id='successMessage']/div/div/div[1]/button") WebElement successMsgClseBtn;

	@FindBy(how = How.XPATH, using = "//div[@id='gbox_reviewAccessUserActivityTable']/following-sibling::div[1]/input[1]") WebElement delegateBtn;
	@FindBy(how = How.XPATH, using = "//div[@id='gbox_reviewAccessUserActivityTable']/following-sibling::div[1]/input[2]") WebElement approveBtn;
	@FindBy(how = How.XPATH, using = "//div[@id='gbox_reviewAccessUserActivityTable']/following-sibling::div[1]/input[3]") WebElement rejectBtn;
	@FindBy(how = How.XPATH, using = "//div[@id='bulkApprovalConfirmation']/div/div[1]/div[3]/button[1]") WebElement yesButton;

	//approved review access actions		
	@FindAll({@FindBy(how = How.XPATH, using = "//table[@id='approvedTable']/tbody/tr[not(@class='jqgfirstrow')]")}) public List<WebElement> apprveActnCount;
	String apprveActn="//table[@id='approvedTable']/tbody/tr[@class='jqgfirstrow']/following-sibling::tr[#DELIM#]/td[7]/ul/li/a/i";	
	@FindBy(how = How.XPATH, using = "//div[@id='approvalOrderId']/div/div/div[3]/button") WebElement apActncloseBtn;
	String AprvRName="//table[@id='approvedTable']/tbody/tr[@class='jqgfirstrow']/following-sibling::tr[#DELIM#]/td[1]";
	String AprvUName="//table[@id='approvedTable']/tbody/tr[@class='jqgfirstrow']/following-sibling::tr[#DELIM#]/td[2]";
	String AprvRType="//table[@id='approvedTable']/tbody/tr[@class='jqgfirstrow']/following-sibling::tr[#DELIM#]/td[3]";

	//rejected review access actions		
	@FindAll({@FindBy(how = How.XPATH, using = "//table[@id='rejectedApprovalTable']/tbody/tr[not(@class='jqgfirstrow')]")}) public List<WebElement> rjctActnCount;
	String rejectActn="//table[@id='rejectedApprovalTable']/tbody/tr[@class='jqgfirstrow']/following-sibling::tr[#DELIM#]/td[7]/ul/li[2]/a[1]/i";	

	//Expired review access actions		
	@FindAll({@FindBy(how = How.XPATH, using = "//table[@id='expiredApprovalTable']/tbody/tr[not(@class='jqgfirstrow')]")}) public List<WebElement> expActnCount;
	String expActn="//table[@id='expiredApprovalTable']/tbody/tr[@class='jqgfirstrow']/following-sibling::tr[#DELIM#]/td[7]/ul/li/a/i";	

	//Delegate review access actions		
	@FindAll({@FindBy(how = How.XPATH, using = "//table[@id='delegatedTable']/tbody/tr[not(@class='jqgfirstrow')]")}) public List<WebElement> delegateActnCount;
	String delegateActn="//table[@id='delegatedTable']/tbody/tr[@class='jqgfirstrow']/following-sibling::tr[#DELIM#]/td[7]/ul/li/a/i";
	@FindBy(how = How.ID, using = "closeIcon") WebElement dcloseBtn;
	@FindBy(how = How.ID, using = "approval_delgation_modal_present_username") public WebElement delegateUserName;	
	@FindBy(how = How.XPATH, using = "//form[@id='delegate_form']/ul/li[1]/div/a") public WebElement delegateUserNameSearchBtn;
	
	@FindAll({@FindBy(how = How.XPATH, using = "//table[@id='searchedusers']/tbody/tr[@class='jqgfirstrow']/following-sibling::tr")}) public List<WebElement> chckbxCount;
	@FindBy(how = How.XPATH, using = "//div[@id='myModalLabelMessage']") public WebElement delegateSuccessMsg;
	@FindBy(how = How.XPATH, using = "//div[@id='reviewAccessDeligationModel']/div/div/div/button/span") public WebElement delegateClose;
	String delegateUName= "//table[@id='searchedusers']/tbody/tr/td[text()='#DELIM#']";
	@FindBy(how = How.XPATH, using = "//table[@id='searchedusers']/tbody/tr[2]/td/input") public WebElement selectdelegateUserName;
	//delegate button inside popup	
	@FindBy(how = How.XPATH, using = "//div[@id='delegate_buttons']/button[1]") public WebElement delegateBtnPopup;
	@FindBy(how = How.ID, using = "approval_delgation_modal_reason") public WebElement delegateReason;
	@FindBy(how = How.ID, using = "showSelectedUser") public WebElement submtDUser;
	public pf_ReviewAccessPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void pendingStatus() throws Exception {
		cl_click(reviewAccess);
		log.info("Review Access page is Displayed");
		Thread.sleep(2000);
		et.log(LogStatus.PASS,"Review Access present in menu is clicked- passed");
		if(delegateBtn.isDisplayed()) {
			System.out.println("Delegate button is present");
			et.log(LogStatus.PASS,"Delegate button is present- passed");
		}else {
			System.out.println("Delegate button is not present");
			et.log(LogStatus.FAIL,"Delegate button is not present- passed");
		}
		if(approveBtn.isDisplayed()) {
			System.out.println("Approve button is present");
			et.log(LogStatus.PASS,"Approve button is present- passed");
		}else {
			System.out.println("Approve button is not present");
			et.log(LogStatus.FAIL,"Approve button is not present- passed");
		}
		if(rejectBtn.isDisplayed()) {
			System.out.println("Reject button is present");
			et.log(LogStatus.PASS,"Reject button is present- passed");
		}else {
			System.out.println("Reject button is not present");
			et.log(LogStatus.FAIL,"Reject button is not present- passed");
		}
	}

	public void rejectedStatus() throws Exception {
		cl_click(rejected);
		log.info("Review Access- Reject status page");
		Thread.sleep(1000);
		et.log(LogStatus.PASS,"Reject tab is clicked- passed");
		int apActnCount=rjctActnCount.size();
		if(apActnCount>0) {
			Random r=new Random();
			int n=r.nextInt(apActnCount);
			if(n==0) {
				n=n+1;
			}/*if(n==1) {
			n=n+1;
		}*/
			cl_click(w.findElement(By.xpath(rejectActn.replace("#DELIM#",String.valueOf(n)))));
			Thread.sleep(2000);
			b.getScreenshot();
			cl_click(apActncloseBtn);
			Thread.sleep(2000);
			et.log(LogStatus.PASS,"Close button is clicked- passed");
		}
		else {
			System.out.println("Rejected records are not present");
			et.log(LogStatus.PASS,"Rejected records are not present- passed");
		}
	}

	public void approvedStatus() throws Exception {
		cl_click(approved);
		log.info("Review Access- Approve status page");
		Thread.sleep(1000);	
		et.log(LogStatus.PASS,"Approved tab is clicked- passed");
		int apActnCount=apprveActnCount.size();
		if(apActnCount>0) {
			Random r=new Random();
			int n=r.nextInt(apActnCount);
			if(n==0) {
				n=n+1;
			}
			cl_click(w.findElement(By.xpath(apprveActn.replace("#DELIM#",String.valueOf(n)))));
			Thread.sleep(2000);
			b.getScreenshot();
			cl_click(apActncloseBtn);
			Thread.sleep(2000);
			et.log(LogStatus.PASS,"Close button is clicked- passed");
		}
		else {
			System.out.println("Approved records are not present");
			et.log(LogStatus.PASS,"Approved records are not present- passed");
		}
	}

	public void expiredStatus() throws Exception {
		cl_click(expired);
		log.info("Review Access- Expired status page");
		Thread.sleep(1000);
		et.log(LogStatus.PASS,"Expired tab is clicked- passed");
		int apActnCount=expActnCount.size();
		if(apActnCount>0) {
			Random r=new Random();
			int n=r.nextInt(apActnCount);
			if(n==0) {
				n=n+1;
			}
			cl_click(w.findElement(By.xpath(expActn.replace("#DELIM#",String.valueOf(n)))));
			Thread.sleep(2000);
			et.log(LogStatus.PASS,"Signer diagram is clicked- passed");
			b.getScreenshot();
			et.log(LogStatus.PASS,"Signer diagram screenshot is taken- passed");
			cl_click(apActncloseBtn);
			Thread.sleep(2000);
			et.log(LogStatus.PASS,"Close button is clicked- passed");
		}else {
			System.out.println("Expired records are not present");
			et.log(LogStatus.PASS,"Expired records are not present- passed");
		}
	}

	public void delegateStatus() throws Exception {
		cl_click(delegate);
		log.info("Review Access- delegate status page");
		Thread.sleep(1000);
		et.log(LogStatus.PASS,"Delegate tab is clicked- passed");
		int apActnCount=delegateActnCount.size();
		if(apActnCount>0) {
			Random r=new Random();
			int n=r.nextInt(apActnCount);
			if(n==0) {
				n=n+1;
			}
			cl_click(w.findElement(By.xpath(delegateActn.replace("#DELIM#",String.valueOf(n)))));
			Thread.sleep(2000);
			et.log(LogStatus.PASS,"View delgated record is clicked- passed");
			b.getScreenshot();
			et.log(LogStatus.PASS,"View delgated record screenshot is taken- passed");
			cl_click(dcloseBtn);
			Thread.sleep(2000);
			et.log(LogStatus.PASS,"Close button is clicked- passed");
		}else {
			System.out.println("Delegate records are not present");
			et.log(LogStatus.PASS,"Delegated records are not present- passed");
		}
	}

	public void pendingSingleRcrdApprove(String shtname, String scriptname) throws Exception {
		cl_click(reviewAccess);
		log.info("Review Access page is Displayed");
		Thread.sleep(2000);
		et.log(LogStatus.PASS,"Review Access present in menu is clicked- passed");
		int apCount=apprveCount.size();
		if(apCount>0) {
			Random r=new Random();
			int n=r.nextInt(apCount);
			if(n==0) {
				n=n+1;
			}
			WebElement rvname = w.findElement(By.xpath(reviewName.replace("#DELIM#",String.valueOf(n))));
			String RName=rvname.getText();
			WebElement usrname = w.findElement(By.xpath(Username.replace("#DELIM#",String.valueOf(n))));
			String PUName=usrname.getText();
			WebElement rvType = w.findElement(By.xpath(reviewType.replace("#DELIM#",String.valueOf(n))));
			String RType=rvType.getText();
			cl_click(w.findElement(By.xpath(apprveBtn.replace("#DELIM#",String.valueOf(n)))));
			Thread.sleep(2000);
			log.info("Approve button in Actions is clicked");
			et.log(LogStatus.PASS,"Approve button is clicked- passed");
			cl_click(yesBtn);
			Thread.sleep(2000);
			String msg=successMsg.getText();
			cl_click(successMsgClseBtn);
			Utility.comparelogic(msg, shtname, scriptname);	
			Thread.sleep(2000);
			et.log(LogStatus.PASS,"Success Message close button is clicked- passed");
			cl_click(approved);
			log.info("Review Access- Approve status page");
			Thread.sleep(1000);	
			et.log(LogStatus.PASS,"Approved tab is clicked- passed");
			int apActnCount=apprveActnCount.size();
			if(apActnCount>0) {
				for(int i=1;i<=apActnCount;i++) {
					WebElement aname = w.findElement(By.xpath(AprvRName.replace("#DELIM#",String.valueOf(i))));
					String ARName=aname.getText();
					WebElement uname = w.findElement(By.xpath(AprvUName.replace("#DELIM#",String.valueOf(i))));
					String UNAME=uname.getText();
					WebElement arvType = w.findElement(By.xpath(AprvRType.replace("#DELIM#",String.valueOf(i))));
					String artype=arvType.getText();
					if(RName.equalsIgnoreCase(ARName) && PUName.equalsIgnoreCase(UNAME) && RType.equalsIgnoreCase(artype)) {
						System.out.println("Approved record from pending tab came to Approved Tab");
						et.log(LogStatus.PASS,"Approved record from pending tab came to Approved Tab- passed");
					}/*else if(!RName.equalsIgnoreCase(ARName) && !PUName.equalsIgnoreCase(UNAME) && !RType.equalsIgnoreCase(artype)) {
						System.out.println("Approved record from pending tab didnot come to Approved Tab");
						et.log(LogStatus.FAIL,"Approved record from pending tab didnot come to Approved Tab");
					}*/			
				}
			}
		}else {
			System.out.println("Pending records are not present");
			et.log(LogStatus.PASS,"Pending records are not present- passed");
		}	
	}

	public void pendingMultiRcrdApprove(String shtname, String scriptname) throws Exception {
		et =  es.startTest("Review Access Pending Rcrd-Approve");
		cl_click(reviewAccess);
		log.info("Review Access page is Displayed");
		Thread.sleep(2000);
		et.log(LogStatus.PASS,"Review Access present in menu is clicked- passed");
		int apCount=apprveCount.size();
		if(apCount>=2) {
			for(int i=1;i<=2;i++) {
				cl_click(w.findElement(By.xpath(pcheckbox.replace("#DELIM#",String.valueOf(i)))));
				WebElement rvname = w.findElement(By.xpath(reviewName.replace("#DELIM#",String.valueOf(i))));
				String RName=rvname.getText();
				WebElement usrname = w.findElement(By.xpath(Username.replace("#DELIM#",String.valueOf(i))));
				String PUName=usrname.getText();
				WebElement rvType = w.findElement(By.xpath(reviewType.replace("#DELIM#",String.valueOf(i))));
				String RType=rvType.getText();
				ArrayList<String> rowData = new ArrayList<String>();
				rowData.add(RName);
				rowData.add(PUName);
				rowData.add(RType);
				System.out.println();
			}
			Thread.sleep(3000);
			cl_click(approveBtn);
			et.log(LogStatus.PASS,"Approve button is clicked- passed");
			Thread.sleep(2000);
			cl_click(yesButton);
			Thread.sleep(2000);
			String msg=successMsg.getText();
			cl_click(successMsgClseBtn);
			Utility.comparelogic(msg, shtname, scriptname);	
			Thread.sleep(2000);
			et.log(LogStatus.PASS,"Success Message close button is clicked- passed");
		}
	}

	public void pendingSingleRcrdDelegate(String delgteUN,String delgteResn,String shtname, String scriptname) throws Exception {
		et =  es.startTest("Review Access Pending Rcrd-Delegate");
		cl_click(reviewAccess);
		log.info("Review Access page is Displayed");
		Thread.sleep(2000);
		et.log(LogStatus.PASS,"Review Access present in menu is clicked- passed");
		int apCount=apprveCount.size();
		if(apCount>0) {
			Random r=new Random();
			int n=r.nextInt(apCount);
			if(n==0) {
				n=n+1;
			}
			cl_click(w.findElement(By.xpath(pcheckbox.replace("#DELIM#",String.valueOf(n)))));
			WebElement rvname = w.findElement(By.xpath(reviewName.replace("#DELIM#",String.valueOf(n))));
			String RName=rvname.getText();
			WebElement usrname = w.findElement(By.xpath(Username.replace("#DELIM#",String.valueOf(n))));
			String PUName=usrname.getText();
			WebElement rvType = w.findElement(By.xpath(reviewType.replace("#DELIM#",String.valueOf(n))));
			String RType=rvType.getText();

			Thread.sleep(3000);
			cl_click(delegateBtn);
			et.log(LogStatus.PASS,"Delegate button is clicked- passed");
			Thread.sleep(2000);
			cl_entertext(delegateUserName, delgteUN);
			Thread.sleep(2000);
			cl_click(delegateUserNameSearchBtn);
			Thread.sleep(2000);
			int si=chckbxCount.size();
			for(int i=1;i<=si;i++) {
				cl_click(w.findElement(By.xpath(delegateUName.replace("#DELIM#",String.valueOf(delgteUN)))));
			}
//			cl_click(selectdelegateUserName);
			Thread.sleep(2000);
			cl_click(submtDUser);
			Thread.sleep(2000);
			cl_entertext(delegateReason, delgteResn);
			cl_click(delegateBtnPopup);
			Thread.sleep(2000);
			String msg=delegateSuccessMsg.getText();
			System.out.println("Pending request delegated successfully: "+msg);
			cl_click(delegateClose);
			Thread.sleep(2000);
			Utility.comparelogic(msg, shtname, scriptname);	
		}
		else {
			System.out.println("Record is not present to delegate");
			et.log(LogStatus.PASS,"Record is not present to delegate- passed");
		}
	}
	public void pendingMutlipleRcrdDelegate(String delgteUN,String delgteResn,String shtname, String scriptname) throws Exception {
		et =  es.startTest("Review Access Pending Rcrd-Delegate");
		cl_click(reviewAccess);
		log.info("Review Access page is Displayed");
		Thread.sleep(2000);
		et.log(LogStatus.PASS,"Review Access present in menu is clicked- passed");
		int apCount=apprveCount.size();
		if(apCount>=2) {
			for(int i=1;i<=2;i++) {
				cl_click(w.findElement(By.xpath(pcheckbox.replace("#DELIM#",String.valueOf(i)))));
				WebElement rvname = w.findElement(By.xpath(reviewName.replace("#DELIM#",String.valueOf(i))));
				String RName=rvname.getText();
				WebElement usrname = w.findElement(By.xpath(Username.replace("#DELIM#",String.valueOf(i))));
				String PUName=usrname.getText();
				WebElement rvType = w.findElement(By.xpath(reviewType.replace("#DELIM#",String.valueOf(i))));
				String RType=rvType.getText();
				Thread.sleep(3000);
			}
			cl_click(delegateBtn);
			et.log(LogStatus.PASS,"Delegate button is clicked- passed");
			Thread.sleep(2000);
			cl_entertext(delegateUserName, delgteUN);
			Thread.sleep(2000);
			cl_click(delegateUserNameSearchBtn);
			Thread.sleep(2000);
			Thread.sleep(2000);
			int si=chckbxCount.size();
			for(int i=1;i<=si;i++) {
				cl_click(w.findElement(By.xpath(delegateUName.replace("#DELIM#",String.valueOf(delgteUN)))));
			}
			//cl_click(selectdelegateUserName);
			Thread.sleep(2000);
			cl_click(submtDUser);
			Thread.sleep(2000);
			cl_entertext(delegateReason, delgteResn);
			cl_click(delegateBtnPopup);
			Thread.sleep(2000);
			String msg=delegateSuccessMsg.getText();
			System.out.println("Pending request delegated successfully: "+msg);
			cl_click(delegateClose);
			Thread.sleep(2000);
			Utility.comparelogic(msg, shtname, scriptname);	
		}
		else {
			System.out.println("Multiple records are not present to delegate");
			et.log(LogStatus.PASS,"Multiple records are not present to delegate- passed");
		}
	}


}
