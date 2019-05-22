package Page_Factory;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.LogStatus;

import Generic_Library.Basefunctions;
import Generic_Library.Utility;

public class pf_ApprovalsPage extends pf_genericmethods {
	final static Logger log = Logger.getLogger(pf_ApprovalsPage.class);
	Basefunctions b=new Basefunctions();
	@FindBy(how = How.ID, using = "Approvals") public WebElement approvals;	
	@FindBy(how = How.XPATH, using = "//div[@class='exbtnBlk']/button") public WebElement exportToExcel;
	@FindBy(how = How.XPATH, using = "//div[@class='panel-heading']/ul/li[2]/a") public WebElement approvedStatus;
	@FindBy(how = How.XPATH, using = "//div[@class='panel-heading']/ul/li[3]/a") public WebElement rejectedStatus;
	@FindBy(how = How.XPATH, using = "//div[@class='panel-heading']/ul/li[4]/a") public WebElement delegatedStatus;	
	//search button  
	@FindBy(how = How.XPATH, using = "//div[text()='Search ']") public WebElement searchBtn; 
	//clear button
	@FindBy(how = How.XPATH, using = "//div[text()='Clear ']") public WebElement clearBtn;

	//pending status count
	@FindAll({@FindBy(how = How.XPATH, using = "//table[@id='all_pending_approval_list']/tbody/tr[not(@class='jqgfirstrow')]")}) public List<WebElement> pndngStatusCount;
	String pcount="//table[@id='all_pending_approval_list']/tbody/tr[@class='jqgfirstrow']/following-sibling::tr[#DELIM#]/td[7]/ul/li";
	String preqID="//table[@id='all_pending_approval_list']/tbody/tr[@class='jqgfirstrow']/following-sibling::tr[#DELIM#]/td[2]";
	String requesttype="//table[@id='all_pending_approval_list']/tbody/tr[@class='jqgfirstrow']/following-sibling::tr[#DELIM#]/td[3]";
	String checkbox="//table[@id='all_pending_approval_list']/tbody/tr[@class='jqgfirstrow']/following-sibling::tr[#DELIM#]/td[1]/input";
	//search for req type

	@FindBy(how = How.ID, using = "gs_request_type") public WebElement reqType;

	@FindBy(how = How.XPATH, using = "//div[@id='all_pending_approval_pager']/div/table/tbody/tr/td[1]/table/tbody/tr/td[1]") public WebElement pndngSearchBtn;
	//buttons inside view button of pending page
	@FindBy(how = How.XPATH, using = "//div[@id='alertWindowGroupApproval']/div/div/div[2]/div/div/div/div/div/ul/li[2]/button[1]") public WebElement groupViewApprveBtn;
	@FindBy(how = How.XPATH, using = "//div[@id='alertWindowGroupApproval']/div/div/div[2]/div/div/div/div/div/ul/li[2]/button[2]") public WebElement groupViewDelegateBtn;
	@FindBy(how = How.XPATH, using = "//div[@id='alertWindowGroupApproval']/div/div/div[2]/div/div/div/div/div/ul/li[2]/button[3]") public WebElement groupViewRejctBtn;

	//buttons inside view button of pending page
	@FindBy(how = How.XPATH, using = "//div[@id='alertWindowChangeKBA']/div/div/div[2]/div/div/div/div/div/ul/li[2]/button[1]") public WebElement KBAviewApprveBtn;
	@FindBy(how = How.XPATH, using = "//div[@id='alertWindowChangeKBA']/div/div/div[2]/div/div/div/div/div/ul/li[2]/button[2]") public WebElement KBAviewDelegateBtn;
	@FindBy(how = How.XPATH, using = "//div[@id='alertWindowChangeKBA']/div/div/div[2]/div/div/div/div/div/ul/li[2]/button[3]") public WebElement KBAviewRejctBtn;

	//buttons inside view button of pending page
	@FindBy(how = How.XPATH, using = "//div[@id='alertWindowChangeEmailId']/div/div/div[3]/div[1]/button[1]") public WebElement updteEmailviewApprveBtn;
	@FindBy(how = How.XPATH, using = "//div[@id='alertWindowChangeEmailId']/div/div/div[3]/div[1]/button[2]") public WebElement updteEmailviewDelegateBtn;
	@FindBy(how = How.XPATH, using = "//div[@id='alertWindowChangeEmailId']/div/div/div[3]/div[1]/button[3]") public WebElement updteEmailviewRejctBtn;

	//buttons inside view button of pending page
	@FindBy(how = How.XPATH, using = "//div[@id='alertWindowChangeFido']/div/div/div[2]/div/div/div/div/div/ul/li[2]/button[1]") public WebElement FIDOviewApprveBtn;
	@FindBy(how = How.XPATH, using = "//div[@id='alertWindowChangeFido']/div/div/div[2]/div/div/div/div/div/ul/li[2]/button[2]") public WebElement FIDOviewDelegateBtn;
	@FindBy(how = How.XPATH, using = "//div[@id='alertWindowChangeFido']/div/div/div[2]/div/div/div/div/div/ul/li[2]/button[3]") public WebElement FIDOviewRejctBtn;

	//buttons inside view button of pending page
	@FindBy(how = How.XPATH, using = "//div[@id='alertWindowChangeDSc']/div/div/div[2]/div/div/div/div/div/ul/li[2]/button[1]") public WebElement DSCviewApprveBtn;
	@FindBy(how = How.XPATH, using = "//div[@id='alertWindowChangeDSc']/div/div/div[2]/div/div/div/div/div/ul/li[2]/button[2]") public WebElement DSCviewDelegateBtn;
	@FindBy(how = How.XPATH, using = "//div[@id='alertWindowChangeDSc']/div/div/div[2]/div/div/div/div/div/ul/li[2]/button[3]") public WebElement DSCviewRejctBtn;

	//buttons inside view button of pending page
	@FindBy(how = How.XPATH, using = "//div[@id='alertWindowChangeFaceRecognition']/div/div/div[2]/div/div/div/div/div/ul/li[2]/button[1]") public WebElement FaceRecviewApprveBtn;
	@FindBy(how = How.XPATH, using = "//div[@id='alertWindowChangeFaceRecognition']/div/div/div[2]/div/div/div/div/div/ul/li[2]/button[2]") public WebElement FaceRecviewDelegateBtn;
	@FindBy(how = How.XPATH, using = "//div[@id='alertWindowChangeFaceRecognition']/div/div/div[2]/div/div/div/div/div/ul/li[2]/button[3]") public WebElement FaceRecviewRejctBtn;

	//buttons inside view button of pending page
	@FindBy(how = How.XPATH, using = "//div[@id='alertWindowUserSelfRegistration']/div/div/div[3]/div/button[1]") public WebElement profleUpdateviewApprveBtn;
	@FindBy(how = How.XPATH, using = "//div[@id='alertWindowUserSelfRegistration']/div/div/div[3]/div/button[2]") public WebElement profleUpdateviewDelegateBtn;
	@FindBy(how = How.XPATH, using = "//div[@id='alertWindowUserSelfRegistration']/div/div/div[3]/div/button[3]") public WebElement profleUpdateviewRejctBtn;

	//buttons inside view button of pending page
	@FindBy(how = How.XPATH, using = "//div[@id='alertWindowChangeFingerprint']/div/div/div[2]/div/div/div/div/div/ul/li[2]/button[1]") public WebElement FngrPrntviewApprveBtn;
	@FindBy(how = How.XPATH, using = "//div[@id='alertWindowChangeFingerprint']/div/div/div[2]/div/div/div/div/div/ul/li[2]/button[2]") public WebElement FngrPrntviewDelegateBtn;
	@FindBy(how = How.XPATH, using = "//div[@id='alertWindowChangeFingerprint']/div/div/div[2]/div/div/div/div/div/ul/li[2]/button[3]") public WebElement FngrPrntviewRejctBtn;

	//buttons inside view button of pending page
	@FindBy(how = How.XPATH, using = "//div[@id='alertWindowUserAccessResource']/div/div/div[2]/div/div/div/div/div/ul/li[2]/button[1]") public WebElement accessReqviewApprveBtn;
	@FindBy(how = How.XPATH, using = "//div[@id='alertWindowUserAccessResource']/div/div/div[2]/div/div/div/div/div/ul/li[2]/button[3]") public WebElement accessReqviewDelegateBtn;
	@FindBy(how = How.XPATH, using = "//div[@id='alertWindowUserAccessResource']/div/div/div[2]/div/div/div/div/div/ul/li[2]/button[2]") public WebElement accessReqviewRejctBtn;

	//buttons inside view button of pending page
	@FindBy(how = How.XPATH, using = "//div[@id='alertWindowChangeMobileNumber']/div/div/div[2]/div/div/div/div/div/ul/li[2]/button[1]") public WebElement updteMobleviewApprveBtn;
	@FindBy(how = How.XPATH, using = "//div[@id='alertWindowChangeMobileNumber']/div/div/div[2]/div/div/div/div/div/ul/li[2]/button[2]") public WebElement updteMobleviewDelegateBtn;
	@FindBy(how = How.XPATH, using = "//div[@id='alertWindowChangeMobileNumber']/div/div/div[2]/div/div/div/div/div/ul/li[2]/button[3]") public WebElement updteMobleviewRejctBtn;


	@FindBy(how = How.ID, using = "popupmsg") public WebElement ApprvMsg;	
	@FindBy(how = How.XPATH, using = "//div[@id='actionBtns']/button[1]") public WebElement apprveYesBtn;
	//approve success msg	
	@FindBy(how = How.XPATH, using = "//span[@id='successMsg']") public WebElement apprveSuccessMsg;
	//close btn
	@FindBy(how = How.XPATH, using = "//button[@id=\"closeWindow\"]") public WebElement apprveMsgCloseBtn;

	//approve status page search btn	
	@FindBy(how = How.XPATH, using = "//td[@id='all_approved_approval_pager_left']/table/tbody/tr/td/div[text()='Search ']") public WebElement apprveSearchBtn;
	@FindBy(how = How.XPATH, using = "//*[@id=\"all_approved_approval_pager_left\"]/table/tbody/tr/td[2]/div") public WebElement clearSearchBtn;
	//search with Request ID
	@FindBy(how = How.XPATH, using = "//th[@id='gsh_all_approved_approval_list_request_id']/div/table/tbody/tr/td[2]/input[@id='gs_request_id']") public WebElement apprveSearchReqID;
	@FindBy(how = How.XPATH, using = "//th[@id='gsh_all_approved_approval_list_request_type']/div/table/tbody/tr/td[2]/input[@id='gs_request_type']") public WebElement apprveSearchReqType;
	//view the searched request	
	@FindBy(how = How.XPATH, using = "//*[@id=\"1\"]/td[6]/ul/li/a/i") public WebElement apprveSearchViewBtn;
	@FindBy(how = How.XPATH, using = "//*[@id=\"closeIcon\"]") public WebElement apprveSearchViewCloseBtn;


	@FindBy(how = How.XPATH, using = "//*[@id=\"apprvRejButtons_access_request\"]/button[2]") public WebElement rejctBtn;

	//Delegate Button
	@FindBy(how = How.ID, using = "approval_delgation_modal_present_username") public WebElement delegateUserName;	
	@FindBy(how = How.XPATH, using = "//form[@id='delegate_form']/ul/li[1]/div/a") public WebElement delegateUserNameSearchBtn;

	@FindBy(how = How.XPATH, using = "//table[@id='searchedusers']/tbody/tr[2]/td/input") public WebElement selectdelegateUserName;

	@FindBy(how = How.ID, using = "showSelectedUser") public WebElement submtDUser;
	//delegate button inside popup	
	@FindBy(how = How.XPATH, using = "//div[@id='delegate_buttons']/button[1]") public WebElement delegateBtnPopup;
	@FindBy(how = How.ID, using = "approval_delgation_modal_reason") public WebElement delegateReason;
	//delegate search button
	@FindBy(how = How.XPATH, using = "//td[@id='all_delegated_approval_pager_left']/table/tbody/tr/td[1]/div") public WebElement delgteSearchBtn;
	@FindAll({@FindBy(how = How.XPATH, using = "//table[@id='searchedusers']/tbody/tr[@class='jqgfirstrow']/following-sibling::tr")}) public List<WebElement> chckbxCount;
	String delegateUName= "//table[@id='searchedusers']/tbody/tr/td[text()='#DELIM#']";
	//search with Request ID
	@FindBy(how = How.XPATH, using = "//th[@id='gsh_all_delegated_approval_list_request_id']/div/table/tbody/tr/td[2]/input[@id='gs_request_id']") public WebElement dlgteSearchReqID;
	@FindBy(how = How.XPATH, using = "//th[@id='gsh_all_delegated_approval_list_request_type']/div/table/tbody/tr/td[2]/input[@id='gs_request_type']") public WebElement dlgteSearchReqType;
	//Reject Button
	@FindBy(how = How.ID, using = "remarks") public WebElement remarks;
	//yes button
	@FindBy(how = How.XPATH, using = "//div[@id='popupApproval']/div/div/div[3]/div/button[1]") public WebElement rejctOkBtn;
	//Reject close
	@FindBy(how = How.ID, using = "closeWindow") public WebElement rejectClose;
	//reject search button
	@FindBy(how = How.XPATH, using = "//td[@id='all_rejected_approval_pager_left']/table/tbody/tr/td[1]/div") public WebElement rjctSearchBtn;
	//search with Request ID
	@FindBy(how = How.XPATH, using = "//th[@id='gsh_all_rejected_approval_list_request_id']/div/table/tbody/tr/td[2]/input[@id='gs_request_id']") public WebElement rjctSearchReqID;
	@FindBy(how = How.XPATH, using = "//th[@id='gsh_all_rejected_approval_list_request_type']/div/table/tbody/tr/td[2]/input[@id='gs_request_type']") public WebElement rjctSearchReqType;

	//Approve button
	@FindBy(how = How.XPATH, using = "//div[@id='approval_buttons']/button[1]") public WebElement aprveBtn;
	@FindBy(how = How.XPATH, using = "//div[@id='approval_buttons']/button[2]") public WebElement delegateBtn;
	@FindBy(how = How.XPATH, using = "//div[@id='approval_buttons']/button[3]") public WebElement rejectBtn;
	//without selecting record click on approve/delegate/reject
	@FindBy(how = How.ID, using = "errorMsg") public WebElement errorMsg;
	@FindBy(how = How.ID, using = "closeWindowAlert") public WebElement closeWindowAlert;

	public pf_ApprovalsPage(WebDriver driver){

		PageFactory.initElements(driver, this);
	}

	public void pendingStatus(String remrk,String delgteUN,String delgteResn,String shtname,String scriptname) throws Exception {

		cl_click(approvals);
		Thread.sleep(1000);
		log.info("Approvals page is displayed");		
		b.getScreenshot();
		cl_click(exportToExcel);
		log.info("Pending status request is exported to excel");				
		int count=pndngStatusCount.size();
		if(count>0) {
			Random rand = new Random();
			int n = rand.nextInt(count);
			if (n==0){

				n= n+1;
			}
			WebElement a = w.findElement(By.xpath(preqID.replace("#DELIM#",String.valueOf(n))));
			String requestID=a.getText();
			log.info("Selected request ID is:" +requestID);
			WebElement aa = w.findElement(By.xpath(requesttype.replace("#DELIM#",String.valueOf(n))));
			String reqstType=aa.getText();
			log.info("Selected request Type is:" +reqstType);
			cl_click(w.findElement(By.xpath(pcount.replace("#DELIM#",String.valueOf(n)))));
			b.getScreenshot();
			Thread.sleep(4000);

			String grpReq=Utility.getpropertydetails("AuthenticGroupReq");
			String KBA=Utility.getpropertydetails("AuthenticKBA");
			String updteEmail=Utility.getpropertydetails("AuthenticUpdteEmail");
			String FIDO=Utility.getpropertydetails("AuthenticFIDO");
			String DSC=Utility.getpropertydetails("AuthenticDSC");
			String faceRec=Utility.getpropertydetails("AuthenticFaceRec");
			String ProfleUpdate=Utility.getpropertydetails("AuthenticProfleUpdate");
			String AccntReg=Utility.getpropertydetails("AuthenticAccReg");
			String FingerPrint=Utility.getpropertydetails("AuthenticFingerPrint");
			String accessReq=Utility.getpropertydetails("AuthenticAccessReq");
			String updteMobleNo=Utility.getpropertydetails("AuthenticUpdteMobleNo");

			JavascriptExecutor js = (JavascriptExecutor)w;

			if(reqstType.equalsIgnoreCase(grpReq)) {
				log.info("Request type is"+reqstType);
				Scanner sc=new Scanner(System.in);
				System.out.println("Enter the Action to be done? Approve/Reject/Delegate: ");
				String action=sc.next();
				if(action.equalsIgnoreCase("Approve")) {
					log.info("Action is to Approve");
					cl_click(groupViewApprveBtn);
					log.info("Approve button present inside view button is clicked");
					Thread.sleep(2000);
					String msg=ApprvMsg.getText();
					System.out.println("Approve msg"+msg);
					cl_click(apprveYesBtn);
					log.info("Yes button is clicked");
					Thread.sleep(4000);
					String msg1=apprveSuccessMsg.getText();
					System.out.println("Pending Request approval msg: "+msg1);
					cl_click(apprveMsgCloseBtn);
					Thread.sleep(2000);
				}
				if(action.equalsIgnoreCase("Delegate")) {
					log.info("Action is to Delegate");
					cl_click(groupViewDelegateBtn);
					Thread.sleep(4000);

					cl_entertext(delegateUserName, delgteUN);
					Thread.sleep(2000);
					cl_click(delegateUserNameSearchBtn);
					Thread.sleep(2000);
					cl_click(selectdelegateUserName);
					Thread.sleep(2000);
					cl_click(submtDUser);
					Thread.sleep(2000);
					cl_entertext(delegateReason, delgteResn);
					cl_click(delegateBtnPopup);
					Thread.sleep(2000);
					String msg=apprveSuccessMsg.getText();
					System.out.println("Pending request delegated successfully: "+msg);
					cl_click(rejectClose);
					Thread.sleep(2000);
				}
				if(action.equalsIgnoreCase("Reject")) {
					log.info("Action is to Reject");
					cl_click(groupViewRejctBtn);
					Thread.sleep(4000);
					cl_entertext(remarks, remrk);
					cl_click(rejctOkBtn);
					Thread.sleep(2000);
					String rejctMsg=apprveSuccessMsg.getText();
					System.out.println("Pending Request reject msg: "+rejctMsg);
					cl_click(rejectClose);
					Thread.sleep(2000);
				}
			}

			else if(reqstType.equalsIgnoreCase(KBA)) {
				log.info("Request type is"+reqstType);
				Scanner sc=new Scanner(System.in);
				System.out.println("Enter the Action to be done? Approve/Reject/Delegate: ");
				String action=sc.next();
				if(action.equalsIgnoreCase("Approve")) {
					log.info("Action is to Approve");
					cl_click(KBAviewApprveBtn);
					log.info("Approve button present inside view button is clicked");
					Thread.sleep(2000);
					String msg=ApprvMsg.getText();
					System.out.println("Approve msg"+msg);
					cl_click(apprveYesBtn);
					log.info("Yes button is clicked");
					Thread.sleep(4000);
					String msg1=apprveSuccessMsg.getText();
					System.out.println("Pending Request approval msg: "+msg1);
					cl_click(apprveMsgCloseBtn);
					Thread.sleep(2000);
				}
				if(action.equalsIgnoreCase("Delegate")) {
					cl_click(KBAviewDelegateBtn);
					Thread.sleep(4000);
					log.info("Delegate button present inside view button is clicked");
					cl_entertext(delegateUserName, delgteUN);
					Thread.sleep(2000);
					cl_click(delegateUserNameSearchBtn);
					Thread.sleep(2000);
					cl_click(selectdelegateUserName);
					Thread.sleep(2000);
					cl_click(submtDUser);
					Thread.sleep(2000);
					cl_entertext(delegateReason, delgteResn);
					cl_click(delegateBtnPopup);
					Thread.sleep(2000);
					String msg=apprveSuccessMsg.getText();
					System.out.println("Pending request delegated successfully: "+msg);
					cl_click(rejectClose);
					Thread.sleep(2000);
				}
				if(action.equalsIgnoreCase("Reject")) {
					log.info("Action is to Reject");
					cl_click(KBAviewRejctBtn);
					Thread.sleep(4000);
					cl_entertext(remarks, remrk);
					cl_click(rejctOkBtn);
					Thread.sleep(2000);
					String rejctMsg=apprveSuccessMsg.getText();
					System.out.println("Pending Request reject msg: "+rejctMsg);
					cl_click(rejectClose);
					Thread.sleep(2000);
				}
			}

			else if(reqstType.equalsIgnoreCase(updteEmail)) {
				log.info("Request type is"+reqstType);
				Scanner sc=new Scanner(System.in);
				System.out.println("Enter the Action to be done? Approve/Reject/Delegate: ");
				String action=sc.next();
				if(action.equalsIgnoreCase("Approve")) {
					cl_click(updteEmailviewApprveBtn);
					log.info("Approve button present inside view button is clicked");
					Thread.sleep(2000);
					String msg=ApprvMsg.getText();
					System.out.println("Approve msg"+msg);
					cl_click(apprveYesBtn);
					log.info("Yes button is clicked");
					Thread.sleep(4000);
					String msg1=apprveSuccessMsg.getText();
					System.out.println("Pending Request approval msg: "+msg1);
					cl_click(apprveMsgCloseBtn);
					Thread.sleep(2000);
				}
				if(action.equalsIgnoreCase("Delegate")) {
					cl_click(updteEmailviewDelegateBtn);
					Thread.sleep(4000);
					log.info("Delegate button present inside view button is clicked");
					cl_entertext(delegateUserName, delgteUN);
					Thread.sleep(2000);
					cl_click(delegateUserNameSearchBtn);
					Thread.sleep(2000);
					cl_click(selectdelegateUserName);
					Thread.sleep(2000);
					cl_click(submtDUser);
					Thread.sleep(2000);
					cl_entertext(delegateReason, delgteResn);
					cl_click(delegateBtnPopup);
					Thread.sleep(2000);
					String msg=apprveSuccessMsg.getText();
					System.out.println("Pending request delegated successfully: "+msg);
					cl_click(rejectClose);
					Thread.sleep(2000);
				}
				if(action.equalsIgnoreCase("Reject")) {
					log.info("Action is to Reject");
					cl_click(updteEmailviewRejctBtn);
					Thread.sleep(4000);
					cl_entertext(remarks, remrk);
					cl_click(rejctOkBtn);
					Thread.sleep(3000);
					String rejctMsg=apprveSuccessMsg.getText();
					System.out.println("Pending Request reject msg: "+rejctMsg);
					cl_click(rejectClose);
					Thread.sleep(2000);
				}
			}

			else if(reqstType.equalsIgnoreCase(FIDO)) {
				log.info("Request type is"+reqstType);
				Scanner sc=new Scanner(System.in);
				System.out.println("Enter the Action to be done? Approve/Reject/Delegate: ");
				String action=sc.next();
				if(action.equalsIgnoreCase("Approve")) {
					cl_click(FIDOviewApprveBtn);
					log.info("Approve button present inside view button is clicked");
					Thread.sleep(2000);
					String msg=ApprvMsg.getText();
					System.out.println("Approve msg"+msg);
					cl_click(apprveYesBtn);
					log.info("Yes button is clicked");
					Thread.sleep(4000);
					String msg1=apprveSuccessMsg.getText();
					System.out.println("Pending Request approval msg: "+msg1);
					cl_click(apprveMsgCloseBtn);
					Thread.sleep(2000);
				}
				if(action.equalsIgnoreCase("Delegate")) {
					cl_click(FIDOviewDelegateBtn);
					Thread.sleep(4000);
					log.info("Delegate button present inside view button is clicked");
					cl_entertext(delegateUserName, delgteUN);
					Thread.sleep(2000);
					cl_click(delegateUserNameSearchBtn);
					Thread.sleep(2000);
					cl_click(selectdelegateUserName);
					Thread.sleep(2000);
					cl_click(submtDUser);
					Thread.sleep(2000);
					cl_entertext(delegateReason, delgteResn);
					cl_click(delegateBtnPopup);
					Thread.sleep(2000);
					String msg=apprveSuccessMsg.getText();
					System.out.println("Pending request delegated successfully: "+msg);
					cl_click(rejectClose);
					Thread.sleep(2000);
				}
				if(action.equalsIgnoreCase("Reject")) {
					log.info("Action is to Reject");
					cl_click(FIDOviewRejctBtn);
					Thread.sleep(4000);
					cl_entertext(remarks, remrk);
					cl_click(rejctOkBtn);
					Thread.sleep(2000);
					String rejctMsg=apprveSuccessMsg.getText();				
					System.out.println("Pending Request reject msg: "+rejctMsg);
					cl_click(rejectClose);
					Thread.sleep(2000);
				}
			}

			else if(reqstType.equalsIgnoreCase(DSC)) {
				log.info("Request type is"+reqstType);
				Scanner sc=new Scanner(System.in);
				System.out.println("Enter the Action to be done? Approve/Reject/Delegate: ");
				String action=sc.next();
				if(action.equalsIgnoreCase("Approve")) {
					cl_click(DSCviewApprveBtn);
					log.info("Approve button present inside view button is clicked");
					Thread.sleep(2000);
					String msg=ApprvMsg.getText();
					System.out.println("Approve msg"+msg);
					cl_click(apprveYesBtn);
					log.info("Yes button is clicked");
					Thread.sleep(4000);
					String msg1=apprveSuccessMsg.getText();
					System.out.println("Pending Request approval msg: "+msg1);
					cl_click(apprveMsgCloseBtn);
					Thread.sleep(2000);
				}
				if(action.equalsIgnoreCase("Delegate")) {
					cl_click(DSCviewDelegateBtn);
					Thread.sleep(4000);
					log.info("Delegate button present inside view button is clicked");
					cl_entertext(delegateUserName, delgteUN);
					Thread.sleep(2000);
					cl_click(delegateUserNameSearchBtn);
					Thread.sleep(2000);
					cl_click(selectdelegateUserName);
					Thread.sleep(2000);
					cl_click(submtDUser);
					Thread.sleep(2000);
					cl_entertext(delegateReason, delgteResn);
					cl_click(delegateBtnPopup);
					Thread.sleep(2000);
					String msg=apprveSuccessMsg.getText();
					System.out.println("Pending request delegated successfully: "+msg);
					cl_click(rejectClose);
					Thread.sleep(2000);
				}
				if(action.equalsIgnoreCase("Reject")) {
					log.info("Action is to Reject");
					cl_click(DSCviewRejctBtn);
					Thread.sleep(4000);
					cl_entertext(remarks, remrk);
					cl_click(rejctOkBtn);
					Thread.sleep(2000);
					String rejctMsg=apprveSuccessMsg.getText();
					System.out.println("Pending Request reject msg: "+rejctMsg);
					cl_click(rejectClose);
					Thread.sleep(2000);
				}
			}

			else if(reqstType.equalsIgnoreCase(faceRec)) {
				log.info("Request type is"+reqstType);
				Scanner sc=new Scanner(System.in);
				System.out.println("Enter the Action to be done? Approve/Reject/Delegate: ");
				String action=sc.next();
				if(action.equalsIgnoreCase("Approve")) {
					cl_click(FaceRecviewApprveBtn);
					log.info("Approve button present inside view button is clicked");
					Thread.sleep(2000);
					String msg=ApprvMsg.getText();
					System.out.println("Approve msg"+msg);
					cl_click(apprveYesBtn);
					log.info("Yes button is clicked");
					Thread.sleep(4000);
					String msg1=apprveSuccessMsg.getText();
					System.out.println("Pending Request approval msg: "+msg1);
					cl_click(apprveMsgCloseBtn);
					Thread.sleep(2000);
				}
				if(action.equalsIgnoreCase("Delegate")) {
					cl_click(FaceRecviewDelegateBtn);
					Thread.sleep(4000);
					log.info("Delegate button present inside view button is clicked");
					cl_entertext(delegateUserName, delgteUN);
					Thread.sleep(2000);
					cl_click(delegateUserNameSearchBtn);
					Thread.sleep(2000);
					cl_click(selectdelegateUserName);
					Thread.sleep(2000);
					cl_click(submtDUser);
					Thread.sleep(2000);
					cl_entertext(delegateReason, delgteResn);
					cl_click(delegateBtnPopup);
					Thread.sleep(2000);
					String msg=apprveSuccessMsg.getText();
					System.out.println("Pending request delegated successfully: "+msg);
					cl_click(rejectClose);
					Thread.sleep(2000);
				}
				if(action.equalsIgnoreCase("Reject")) {
					log.info("Action is to Reject");
					cl_click(FaceRecviewRejctBtn);
					Thread.sleep(4000);
					cl_entertext(remarks, remrk);
					cl_click(rejctOkBtn);
					Thread.sleep(2000);
					String rejctMsg=apprveSuccessMsg.getText();
					System.out.println("Pending Request reject msg: "+rejctMsg);
					cl_click(rejectClose);
					Thread.sleep(2000);
				}
			}

			else if(reqstType.equalsIgnoreCase(ProfleUpdate) || reqstType.equalsIgnoreCase(AccntReg)) {
				log.info("Request type is"+reqstType);
				Scanner sc=new Scanner(System.in);
				System.out.println("Enter the Action to be done? Approve/Reject/Delegate: ");
				String action=sc.next();
				if(action.equalsIgnoreCase("Approve")) {
					js.executeScript("arguments[0].scrollIntoView();",profleUpdateviewApprveBtn);
					cl_click(profleUpdateviewApprveBtn);
					log.info("Approve button present inside view button is clicked");
					Thread.sleep(2000);
					String msg=ApprvMsg.getText();
					System.out.println("Approve msg"+msg);
					cl_click(apprveYesBtn);
					log.info("Yes button is clicked");
					Thread.sleep(4000);
					String msg1=apprveSuccessMsg.getText();
					System.out.println("Pending Request approval msg: "+msg1);
					cl_click(apprveMsgCloseBtn);
					Thread.sleep(2000);
				}
				if(action.equalsIgnoreCase("Delegate")) {
					js.executeScript("arguments[0].scrollIntoView();",profleUpdateviewApprveBtn);
					cl_click(profleUpdateviewDelegateBtn);
					Thread.sleep(4000);
					log.info("Delegate button present inside view button is clicked");
					cl_entertext(delegateUserName, delgteUN);
					Thread.sleep(2000);
					cl_click(delegateUserNameSearchBtn);
					Thread.sleep(2000);
					cl_click(selectdelegateUserName);
					Thread.sleep(2000);
					cl_click(submtDUser);
					Thread.sleep(2000);
					cl_entertext(delegateReason, delgteResn);
					cl_click(delegateBtnPopup);
					Thread.sleep(2000);
					String msg=apprveSuccessMsg.getText();
					System.out.println("Pending request delegated successfully: "+msg);
					cl_click(rejectClose);
					Thread.sleep(2000);
				}
				if(action.equalsIgnoreCase("Reject")) {
					log.info("Action is to Reject");
					js.executeScript("arguments[0].scrollIntoView();",profleUpdateviewRejctBtn);
					cl_click(profleUpdateviewRejctBtn);
					Thread.sleep(4000);
					cl_entertext(remarks, remrk);
					cl_click(rejctOkBtn);
					Thread.sleep(2000);
					String rejctMsg=apprveSuccessMsg.getText();
					System.out.println("Pending Request reject msg: "+rejctMsg);
					cl_click(rejectClose);
					Thread.sleep(2000);
				}
			}

			else if(reqstType.equalsIgnoreCase(FingerPrint)) {
				log.info("Request Type is: "+reqstType);
				Scanner sc=new Scanner(System.in);
				System.out.println("Enter the Action to be done? Approve/Reject/Delegate: ");
				String action=sc.next();
				if(action.equalsIgnoreCase("Approve")) {
					cl_click(FngrPrntviewApprveBtn);
					log.info("Approve button present inside view button is clicked");
					Thread.sleep(2000);
					String msg=ApprvMsg.getText();
					System.out.println("Approve msg"+msg);
					cl_click(apprveYesBtn);
					log.info("Yes button is clicked");
					Thread.sleep(4000);
					String msg1=apprveSuccessMsg.getText();
					System.out.println("Pending Request approval msg: "+msg1);
					cl_click(apprveMsgCloseBtn);
					Thread.sleep(2000);
				}
				if(action.equalsIgnoreCase("Delegate")) {
					cl_click(FngrPrntviewDelegateBtn);
					Thread.sleep(4000);
					log.info("Delegate button present inside view button is clicked");
					cl_entertext(delegateUserName, delgteUN);
					Thread.sleep(2000);
					cl_click(delegateUserNameSearchBtn);
					Thread.sleep(2000);
					cl_click(selectdelegateUserName);
					Thread.sleep(2000);
					cl_click(submtDUser);
					Thread.sleep(2000);
					cl_entertext(delegateReason, delgteResn);
					cl_click(delegateBtnPopup);
					Thread.sleep(2000);
					String msg=apprveSuccessMsg.getText();
					System.out.println("Pending request delegated successfully: "+msg);
					cl_click(rejectClose);
					Thread.sleep(2000);
				}
				if(action.equalsIgnoreCase("Reject")) {
					log.info("Action is to Reject");
					cl_click(FngrPrntviewRejctBtn);
					Thread.sleep(4000);
					cl_entertext(remarks, remrk);
					cl_click(rejctOkBtn);
					Thread.sleep(2000);
					String rejctMsg=apprveSuccessMsg.getText();
					System.out.println("Pending Request reject msg: "+rejctMsg);
					cl_click(rejectClose);
					Thread.sleep(2000);
				}
			}

			else if(reqstType.equalsIgnoreCase(accessReq)) {
				log.info("Request type is: "+reqstType);
				Scanner sc=new Scanner(System.in);
				System.out.println("Enter the Action to be done? Approve/Reject/Delegate: ");
				String action=sc.next();
				if(action.equalsIgnoreCase("Approve")) {
					cl_click(accessReqviewApprveBtn);
					log.info("Approve button present inside view button is clicked");
					Thread.sleep(2000);
					String msg=ApprvMsg.getText();
					System.out.println("Approve msg"+msg);
					cl_click(apprveYesBtn);
					log.info("Yes button is clicked");
					Thread.sleep(4000);
					String msg1=apprveSuccessMsg.getText();
					System.out.println("Pending Request approval msg: "+msg1);
					cl_click(apprveMsgCloseBtn);
					Thread.sleep(2000);
				}
				if(action.equalsIgnoreCase("Delegate")) {
					cl_click(accessReqviewDelegateBtn);
					Thread.sleep(4000);
					log.info("Delegate button present inside view button is clicked");
					cl_entertext(delegateUserName, delgteUN);
					Thread.sleep(2000);
					cl_click(delegateUserNameSearchBtn);
					Thread.sleep(2000);
					cl_click(selectdelegateUserName);
					Thread.sleep(2000);
					cl_click(submtDUser);
					Thread.sleep(2000);
					cl_entertext(delegateReason, delgteResn);
					cl_click(delegateBtnPopup);
					Thread.sleep(2000);
					String msg=apprveSuccessMsg.getText();
					System.out.println("Pending request delegated successfully: "+msg);
					cl_click(rejectClose);
					Thread.sleep(2000);
				}
				if(action.equalsIgnoreCase("Reject")) {
					log.info("Action is to Reject");
					cl_click(accessReqviewRejctBtn);
					Thread.sleep(4000);
					cl_entertext(remarks, remrk);
					cl_click(rejctOkBtn);
					Thread.sleep(2000);
					String rejctMsg=apprveSuccessMsg.getText();
					System.out.println("Pending Request reject msg: "+rejctMsg);
					cl_click(rejectClose);
					Thread.sleep(2000);
				}
			}

			else if(reqstType.equalsIgnoreCase(updteMobleNo)) {
				log.info("Request type is: "+reqstType);
				Scanner sc=new Scanner(System.in);
				System.out.println("Enter the Action to be done? Approve/Reject/Delegate: ");
				String action=sc.next();
				if(action.equalsIgnoreCase("Approve")) {
					cl_click(updteMobleviewApprveBtn);
					log.info("Approve button present inside view button is clicked");
					Thread.sleep(2000);
					String msg=ApprvMsg.getText();
					System.out.println("Approve msg"+msg);
					cl_click(apprveYesBtn);
					log.info("Yes button is clicked");
					Thread.sleep(4000);
					String msg1=apprveSuccessMsg.getText();
					System.out.println("Pending Request approval msg: "+msg1);
					cl_click(apprveMsgCloseBtn);
					Thread.sleep(2000);
				}
				if(action.equalsIgnoreCase("Delegate")) {
					cl_click(updteMobleviewDelegateBtn);
					Thread.sleep(4000);
					log.info("Delegate button present inside view button is clicked");
					cl_entertext(delegateUserName, delgteUN);
					Thread.sleep(2000);
					cl_click(delegateUserNameSearchBtn);
					Thread.sleep(2000);
					cl_click(selectdelegateUserName);
					Thread.sleep(2000);
					cl_click(submtDUser);
					Thread.sleep(2000);
					cl_entertext(delegateReason, delgteResn);
					cl_click(delegateBtnPopup);
					Thread.sleep(2000);
					String msg=apprveSuccessMsg.getText();
					System.out.println("Pending request delegated successfully: "+msg);
					cl_click(rejectClose);
					Thread.sleep(2000);
				}
				if(action.equalsIgnoreCase("Reject")) {
					log.info("Action is to Reject");
					cl_click(updteMobleviewRejctBtn);
					Thread.sleep(4000);
					cl_entertext(remarks, remrk);
					cl_click(rejctOkBtn);
					Thread.sleep(2000);
					String rejctMsg=apprveSuccessMsg.getText();
					System.out.println("Pending Request reject msg: "+rejctMsg);
					cl_click(rejectClose);
					Thread.sleep(2000);
				}
			}
			cl_click(approvedStatus);
			Thread.sleep(1000);
			log.info("Approve status page");
			cl_click(apprveSearchBtn);
			log.info("Search button in Approve tab is clicked");
			Thread.sleep(3000);
			try {	
				cl_entertext(apprveSearchReqType,reqstType);
				Thread.sleep(3000);
				Robot r=new Robot();
				r.keyPress(KeyEvent.VK_ENTER);
				Thread.sleep(3000);
				/*cl_click(apprveSearchViewBtn);
		Thread.sleep(1000);
		b.getScreenshot();
		cl_click(apprveSearchViewCloseBtn);*/
				Thread.sleep(2000);
				cl_click(clearSearchBtn);
			}catch(Exception e) {
				//e.printStackTrace();
				log.info(reqstType+"Request type not present");
			}

			cl_click(delegatedStatus);
			Thread.sleep(1000);
			b.getScreenshot();
			cl_click(exportToExcel);
			Thread.sleep(1000);
			log.info("Delegate status request is exported to excel");
			cl_click(delgteSearchBtn);
			Thread.sleep(3000);
			log.info("Search button in Delegate tab is clicked");
			try {
				cl_entertext(dlgteSearchReqType,reqstType);
				Robot r=new Robot();
				r.keyPress(KeyEvent.VK_ENTER);
				Thread.sleep(3000);
				cl_click(delgteSearchBtn);
				Thread.sleep(1000);
			}catch(Exception e) {
				log.info("Delegate- request type is not present");
			}

			cl_click(rejectedStatus);
			Thread.sleep(1000);
			b.getScreenshot();
			cl_click(exportToExcel);
			log.info("Reject status request is exported to excel");
			Thread.sleep(1000);
			cl_click(rjctSearchBtn);
			Thread.sleep(3000);
			log.info("Search button in Reject tab is clicked");
			try {
				cl_entertext(rjctSearchReqType,reqstType);
				Robot r=new Robot();
				r.keyPress(KeyEvent.VK_ENTER);
				Thread.sleep(3000);
				cl_click(rjctSearchBtn);
				Thread.sleep(1000);
				b.getScreenshot();
			}catch(Exception e) {
				log.info("Rejected- request type is not present");
			}
		}
		else {
			b.getScreenshot();
			System.out.println("Pending approvals not present, Screenshot taken");
		}

	}

	public void approveWithoutRcrd(String shtname, String scriptname) throws Exception {
		cl_click(approvals);
		Thread.sleep(1000);
		log.info("Approvals page is displayed");
		et.log(LogStatus.PASS,"Approvals present in left menu is clicked- passed");
		int count=pndngStatusCount.size();
		if(count>0) {	
			cl_click(aprveBtn);
			Thread.sleep(1000);
			et.log(LogStatus.PASS,"Approve button is clicked- passed");
			String msg=errorMsg.getText();
			Thread.sleep(2000);
			et.log(LogStatus.PASS,"Error msg saying no record selected is displayed- passed");	
			cl_click(closeWindowAlert);
			Thread.sleep(1000);
			et.log(LogStatus.PASS,"Close button in popup is clicked- passed");
			Utility.comparelogic(msg, shtname, scriptname);
		}else {
			boolean ab = aprveBtn.isEnabled();
			System.out.println("Approve button in pending tab without record: "+ab);
			et.log(LogStatus.PASS,"No Record,Approve button is disabled- passed");
			boolean db = delegateBtn.isEnabled();
			System.out.println("Delegate button in pending tab without record: "+db);
			et.log(LogStatus.PASS,"No Record,Delegate button is disabled- passed");
			boolean rb = rejectBtn.isEnabled();
			System.out.println("Reject button in pending tab without record: "+rb);
			et.log(LogStatus.PASS,"No Record,Reject button is disabled- passed");
		}


	}

	public void delegateWithoutRcrd(String shtname, String scriptname) throws Exception {		
		cl_click(approvals);
		Thread.sleep(1000);
		log.info("Approvals page is displayed");
		et.log(LogStatus.PASS,"Approvals present in left menu is clicked- passed");
		int count=pndngStatusCount.size();
		if(count>0) {	
			cl_click(delegateBtn);
			Thread.sleep(1000);
			et.log(LogStatus.PASS,"Delegate button is clicked- passed");
			String msg=errorMsg.getText();
			Thread.sleep(2000);
			et.log(LogStatus.PASS,"Error msg saying no record selected is displayed- passed");
			cl_click(closeWindowAlert);
			Thread.sleep(1000);
			et.log(LogStatus.PASS,"Close button in popup is clicked- passed");
			Utility.comparelogic(msg, shtname, scriptname);
		}

	}

	public void RejectWithoutRcrd(String shtname, String scriptname) throws Exception {
		cl_click(approvals);
		Thread.sleep(1000);
		log.info("Approvals page is displayed");
		et.log(LogStatus.PASS,"Approvals present in left menu is clicked- passed");
		int count=pndngStatusCount.size();
		if(count>0) {	
			cl_click(rejectBtn);
			Thread.sleep(1000);
			et.log(LogStatus.PASS,"Reject button is clicked- passed");
			String msg=errorMsg.getText();
			Thread.sleep(2000);
			et.log(LogStatus.PASS,"Error msg saying no record selected is displayed- passed");
			cl_click(closeWindowAlert);
			Thread.sleep(1000);
			et.log(LogStatus.PASS,"Close button in popup is clicked- passed");
			Utility.comparelogic(msg, shtname, scriptname);
		}

	}

	public void approveWithSingleRcrd(String shtname, String scriptname) throws Exception {		
		cl_click(approvals);
		Thread.sleep(1000);
		log.info("Approvals page is displayed");
		et.log(LogStatus.PASS,"Approvals present in left menu is clicked- passed");
		int count=pndngStatusCount.size();
		if(count>0) {
			Random rand = new Random();
			int n = rand.nextInt(count);
			if (n==0){

				n= n+1;
			}
			WebElement a = w.findElement(By.xpath(preqID.replace("#DELIM#",String.valueOf(n))));
			String requestID=a.getText();
			log.info("Selected request ID is:" +requestID);
			WebElement aa = w.findElement(By.xpath(requesttype.replace("#DELIM#",String.valueOf(n))));
			String reqstType=aa.getText();
			log.info("Selected request Type is:" +reqstType);
			cl_click(w.findElement(By.xpath(checkbox.replace("#DELIM#",String.valueOf(n)))));			
			Thread.sleep(3000);
			et.log(LogStatus.PASS,"Checkbox of record is clicked- passed");
			cl_click(aprveBtn);
			Thread.sleep(2000);
			et.log(LogStatus.PASS,"Approve button is clicked- passed");
			cl_click(apprveYesBtn);
			log.info("Yes button is clicked");
			Thread.sleep(4000);
			et.log(LogStatus.PASS,"Approve Yes button is clicked- passed");
			String msg1=apprveSuccessMsg.getText();
			System.out.println("Pending Request approval msg: "+msg1);
			cl_click(apprveMsgCloseBtn);
			Thread.sleep(2000);
			et.log(LogStatus.PASS,"Approve success close button is clicked- passed");
			Utility.comparelogic(msg1, shtname, scriptname);
		}
		else {
			System.out.println("Record is not present to Approve");
			et.log(LogStatus.PASS,"Record is not present to Approve- passed");
		}
	}

	public void delegateWithSingleRcrd(String delgteUN,String delgteResn,String shtname, String scriptname) throws Exception {		
		cl_click(approvals);
		Thread.sleep(1000);
		log.info("Approvals page is displayed");
		et.log(LogStatus.PASS,"Approvals present in left menu is clicked- passed");
		int count=pndngStatusCount.size();
		if(count>0) {
			Random rand = new Random();
			int n = rand.nextInt(count);
			if (n==0){

				n= n+1;
			}
			WebElement a = w.findElement(By.xpath(preqID.replace("#DELIM#",String.valueOf(n))));
			String requestID=a.getText();
			log.info("Selected request ID is:" +requestID);
			WebElement aa = w.findElement(By.xpath(requesttype.replace("#DELIM#",String.valueOf(n))));
			String reqstType=aa.getText();
			log.info("Selected request Type is:" +reqstType);
			cl_click(w.findElement(By.xpath(checkbox.replace("#DELIM#",String.valueOf(n)))));			
			Thread.sleep(3000);
			et.log(LogStatus.PASS,"Checkbox of record is clicked- passed");
			cl_click(delegateBtn);
			Thread.sleep(1000);
			et.log(LogStatus.PASS,"Delegate button is clicked- passed");

			cl_entertext(delegateUserName, delgteUN);
			Thread.sleep(2000);
			cl_click(delegateUserNameSearchBtn);
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
			String msg=apprveSuccessMsg.getText();
			System.out.println("Pending request delegated successfully: "+msg);
			et.log(LogStatus.PASS,"Delegate Success message is displayed- passed");
			cl_click(rejectClose);
			Thread.sleep(2000);
			et.log(LogStatus.PASS,"Close button of succes popup is clicked- passed");
		}
		else {
			System.out.println("Record is not present to Delegate");
			et.log(LogStatus.PASS,"Record is not present to Delegate- passed");
		}
	}

	public void rejectWithSingleRcrd(String remrk,String shtname, String scriptname) throws Exception {		
		cl_click(approvals);
		Thread.sleep(1000);
		log.info("Approvals page is displayed");
		et.log(LogStatus.PASS,"Approvals present in left menu is clicked- passed");
		int count=pndngStatusCount.size();
		if(count>0) {
			Random rand = new Random();
			int n = rand.nextInt(count);
			if (n==0){

				n= n+1;
			}
			WebElement a = w.findElement(By.xpath(preqID.replace("#DELIM#",String.valueOf(n))));
			String requestID=a.getText();
			log.info("Selected request ID is:" +requestID);
			WebElement aa = w.findElement(By.xpath(requesttype.replace("#DELIM#",String.valueOf(n))));
			String reqstType=aa.getText();
			log.info("Selected request Type is:" +reqstType);
			cl_click(w.findElement(By.xpath(checkbox.replace("#DELIM#",String.valueOf(n)))));			
			Thread.sleep(3000);
			et.log(LogStatus.PASS,"Checkbox of record is clicked- passed");
			cl_click(rejectBtn);
			Thread.sleep(1000);
			et.log(LogStatus.PASS,"Reject button is clicked- passed");
			Thread.sleep(4000);
			cl_entertext(remarks, remrk);
			cl_click(rejctOkBtn);
			Thread.sleep(2000);
			et.log(LogStatus.PASS,"Reject Ok button is clicked- passed");
			String rejctMsg=apprveSuccessMsg.getText();
			System.out.println("Pending Request reject msg: "+rejctMsg);
			cl_click(rejectClose);
			Thread.sleep(2000);
			et.log(LogStatus.PASS,"Success popup close button is clicked- passed");
		}
		else {
			System.out.println("Record is not present to Reject");
			et.log(LogStatus.PASS,"Record is not present to Reject- passed");
		}
	}
	public void approveWithMultpleRcrd(String shtname, String scriptname) throws Exception {
		cl_click(approvals);
		Thread.sleep(1000);
		log.info("Approvals page is displayed");
		et.log(LogStatus.PASS,"Approvals present in left menu is clicked- passed");
		int count=pndngStatusCount.size();
		if(count>2) {
			for(int i=1;i<=count;i++) {
				WebElement a = w.findElement(By.xpath(preqID.replace("#DELIM#",String.valueOf(i))));
				String requestID=a.getText();
				log.info("Selected request ID is:" +requestID);
				WebElement aa = w.findElement(By.xpath(requesttype.replace("#DELIM#",String.valueOf(i))));
				String reqstType=aa.getText();
				log.info("Selected request Type is:" +reqstType);
				cl_click(w.findElement(By.xpath(checkbox.replace("#DELIM#",String.valueOf(i)))));			
				Thread.sleep(3000);
			}
			cl_click(aprveBtn);
			Thread.sleep(2000);
			et.log(LogStatus.PASS,"Approve button is clicked- passed");
			cl_click(apprveYesBtn);
			log.info("Yes button is clicked");
			Thread.sleep(4000);
			String msg1=apprveSuccessMsg.getText();
			System.out.println("Pending Request approval msg: "+msg1);
			cl_click(apprveMsgCloseBtn);
			Thread.sleep(2000);

		}
		else {
			System.out.println("Mutliple records are not present for approval");
			et.log(LogStatus.PASS,"Mutliple records are not present for approval- passed");
		}
	}

	public void delegateWithMultpleRcrd(String delgteUN,String delgteResn,String shtname, String scriptname) throws Exception {
		cl_click(approvals);
		Thread.sleep(1000);
		log.info("Approvals page is displayed");
		et.log(LogStatus.PASS,"Approvals present in left menu is clicked- passed");
		int count=pndngStatusCount.size();
		if(count>2) {
			for(int i=1;i<=count;i++) {
				WebElement a = w.findElement(By.xpath(preqID.replace("#DELIM#",String.valueOf(i))));
				String requestID=a.getText();
				log.info("Selected request ID is:" +requestID);
				WebElement aa = w.findElement(By.xpath(requesttype.replace("#DELIM#",String.valueOf(i))));
				String reqstType=aa.getText();
				log.info("Selected request Type is:" +reqstType);
				cl_click(w.findElement(By.xpath(checkbox.replace("#DELIM#",String.valueOf(i)))));			
				Thread.sleep(3000);
				et.log(LogStatus.PASS,"Checkbox of record is clicked- passed");
			}
			cl_click(delegateBtn);
			Thread.sleep(1000);
			et.log(LogStatus.PASS,"Delegate button is clicked- passed");

			cl_entertext(delegateUserName, delgteUN);
			Thread.sleep(2000);
			cl_click(delegateUserNameSearchBtn);
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
			String msg=apprveSuccessMsg.getText();
			System.out.println("Pending request delegated successfully: "+msg);
			et.log(LogStatus.PASS,"Delegate Success message is displayed- passed");
			cl_click(rejectClose);
			Thread.sleep(2000);
			et.log(LogStatus.PASS,"Close button of succes popup is clicked- passed");
		}
		else {
			System.out.println("Mutliple records are not present to Delegate");
			et.log(LogStatus.PASS,"Mutliple records are not present to Delegate- passed");
		}
	}

	public void rejectWithMultpleRcrd(String remrk, String shtname, String scriptname) throws Exception {
		cl_click(approvals);
		Thread.sleep(1000);
		log.info("Approvals page is displayed");
		et.log(LogStatus.PASS,"Approvals present in left menu is clicked- passed");
		int count=pndngStatusCount.size();
		if(count>2) {
			for(int i=1;i<=count;i++) {
				WebElement a = w.findElement(By.xpath(preqID.replace("#DELIM#",String.valueOf(i))));
				String requestID=a.getText();
				log.info("Selected request ID is:" +requestID);
				WebElement aa = w.findElement(By.xpath(requesttype.replace("#DELIM#",String.valueOf(i))));
				String reqstType=aa.getText();
				log.info("Selected request Type is:" +reqstType);
				cl_click(w.findElement(By.xpath(checkbox.replace("#DELIM#",String.valueOf(i)))));			
				Thread.sleep(3000);
				et.log(LogStatus.PASS,"Checkbox of record is clicked- passed");
			}
			cl_click(rejectBtn);
			Thread.sleep(1000);
			et.log(LogStatus.PASS,"Reject button is clicked- passed");
			Thread.sleep(4000);
			cl_entertext(remarks, remrk);
			cl_click(rejctOkBtn);
			Thread.sleep(2000);
			et.log(LogStatus.PASS,"Reject Ok button is clicked- passed");
			String rejctMsg=apprveSuccessMsg.getText();
			System.out.println("Pending Request reject msg: "+rejctMsg);
			cl_click(rejectClose);
			Thread.sleep(2000);
			et.log(LogStatus.PASS,"Success popup close button is clicked- passed");
		}
		else {
			System.out.println("Mutliple records are not present to Reject");
			et.log(LogStatus.PASS,"Mutliple records are not present to Reject- passed");
		}	

	}
}

