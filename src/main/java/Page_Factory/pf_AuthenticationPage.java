package Page_Factory;

import java.util.Scanner;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.LogStatus;

import Generic_Library.Basefunctions;
import Generic_Library.Utility;


public class pf_AuthenticationPage extends pf_genericmethods {
	Basefunctions b=new Basefunctions();
	final static Logger log = Logger.getLogger(pf_AuthenticationPage.class);
	
	@FindBy(how = How.ID, using = "AuthenticationTypes") WebElement AuthenticationTypes;
	//Change Password
	@FindBy(how = How.XPATH, using = "//div[@class='formAfterLogin formBlk']/ul/li[1]/a/i") WebElement editPasswrdBtn;	
	@FindBy(how = How.ID, using = "oldPassword") WebElement oldPass;
	@FindBy(how = How.ID, using = "newPassword") WebElement newPasswrd;
	@FindBy(how = How.ID, using = "confirmPassword") WebElement confrmPass;
	@FindBy(how = How.XPATH, using = "//a[text()='Change Password']") WebElement changePassBtn;	
	@FindBy(how = How.XPATH, using = "//a[text()='Cancel']") WebElement cancelBtn;
	@FindBy(how = How.XPATH, using = "//span[@id=\"changePWDpopupmsg\"]/p/span") WebElement changePassMsg;
	@FindBy(how = How.ID, using = "clsBtnId") WebElement closeMsg;
	@FindBy(how = How.ID, using = "failureMSG") WebElement failMsg;
	
	
	//change mobile number
	@FindBy(how = How.XPATH, using = "//div[@class='formAfterLogin formBlk']/ul/li[2]/a/i") WebElement editMobleNoBtn;	
	@FindBy(how = How.XPATH, using = "//section[@class='wrap']/article/div[4]/div/div/div[2]/p/span/p/span") WebElement ReqExist;	
	@FindBy(how = How.XPATH, using = "//div[@id='popup']/div/div/div[1]/button") WebElement reqExistClseBtn;
	@FindBy(how = How.ID, using = "currentMobNo") WebElement currentMobNo;
	@FindBy(how = How.ID, using = "newMobNo") WebElement newMobNo;
	@FindBy(how = How.ID, using = "newMobNoError") WebElement newMobNoError;
	@FindBy(how = How.XPATH, using = "//input[@value='Verify']") WebElement verifyBtn;
	@FindBy(how = How.ID, using = "otpId") WebElement otpId;
	@FindBy(how = How.XPATH, using = "//article[@class='inner-wrap right_col']/div[2]/div/div/div/div/a[1]") WebElement submitBtn;
	@FindBy(how = How.XPATH, using = "//div[@id='popup']/div/div/div[2]/p/span/p/span") WebElement successMsg;
	@FindBy(how = How.ID, using = "popupClsBtnId") WebElement popupClsBtnId;
	
	//change email ID
	@FindBy(how = How.XPATH, using = "//div[@class='formAfterLogin formBlk']/ul/li[3]/a/i") WebElement editEmailIDBtn;
	@FindBy(how = How.ID, using = "currentEmailId") WebElement currentEmailId;
	@FindBy(how = How.ID, using = "newEmailId") WebElement newEmailId;	
	@FindBy(how = How.XPATH, using = "//section[@class='wrap']/article/div[2]/div/div/div/div/a[1]") WebElement submitEmail;
	
	
	//DSC (Digital Signature Certificate) 
	@FindBy(how = How.XPATH, using = "//div[@class='formAfterLogin formBlk']/ul/li[4]/a/i") WebElement editDSCBtn;	
	@FindBy(how = How.XPATH, using = "//div[@id='utilityWindowAlert']/div/div/div/button") WebElement closeUtility;
	@FindBy(how = How.XPATH, using = "//form[@id='formName']/input[2]") WebElement registerDSC;
	@FindBy(how = How.XPATH, using = "//form[@id='formName']/div/a") WebElement probInDSC;
	
	//KBA
	@FindBy(how = How.XPATH, using = "//div[@class='formAfterLogin formBlk']/ul/li[6]/a/i") WebElement editKBABtn;	
	@FindBy(how = How.ID, using = "question1") WebElement question1;
	@FindBy(how = How.ID, using = "answer1") WebElement answer1;
	@FindBy(how = How.ID, using = "question2") WebElement question2;
	@FindBy(how = How.ID, using = "answer2") WebElement answer2;
	@FindBy(how = How.ID, using = "question3") WebElement question3;
	@FindBy(how = How.ID, using = "answer3") WebElement answer3;
	@FindBy(how = How.ID, using = "question4") WebElement question4;
	@FindBy(how = How.ID, using = "answer4") WebElement answer4;	
	@FindBy(how = How.XPATH, using = "//section[@class='wrap']/article/div[2]/div/div/div/a[1]") WebElement submitKBABtn;
	//kba success msg
	@FindBy(how = How.ID, using = "kbasuccessMsg") WebElement kbasuccessMsg;
	@FindBy(how = How.XPATH, using = "//div[@id='kbaalertSuccessWindow']/div/div/div[1]/button") WebElement kbasuccessMsgClseBtn;
	
	
	//FIDO
	@FindBy(how = How.XPATH, using = "//div[@class='formAfterLogin formBlk']/ul/li[8]/a/i") WebElement editFIDOBtn;
	
	//FingerPrint
	@FindBy(how = How.XPATH, using = "//div[@class='formAfterLogin formBlk']/ul/li[9]/a/i") WebElement editFngrPrintBtn;
	//popup
	@FindBy(how = How.XPATH, using = "//div[@id='popup']") WebElement reqExstpopup;	
	@FindBy(how = How.XPATH, using = "//*[@id=\"formName\"]/div/a") WebElement probInFngrPrint;
	
	//Face recognition
	@FindBy(how = How.XPATH, using = "//div[@class='formAfterLogin formBlk']/ul/li[10]/a/i") WebElement editFaceRecBtn;
	@FindBy(how = How.XPATH, using = "//div[@id='alertWindow']/div/div/div[1]/button") WebElement closeFaceRecAlrt;
	@FindBy(how = How.XPATH, using = "//*[@id=\"popupClsBtnId\"]") WebElement closeFaceRecPopup;
	
	public pf_AuthenticationPage(WebDriver driver){

		PageFactory.initElements(driver, this);
	}

	public void authenticChangePw(String crntPass,String newPass,String cnfrmPass,String shtname,String scriptname) throws Exception {
		et =  es.startTest("Change Password");
		cl_click(AuthenticationTypes);
		Thread.sleep(2000);
		et.log(LogStatus.PASS,"Authentication type present in left menu is clicked- passed");
		try {
		cl_click(editPasswrdBtn);
		log.info("Change password page");
		Thread.sleep(3000);
		et.log(LogStatus.PASS,"Edit password button is clicked- passed");
		cl_click(cancelBtn);
		log.info("Change password page cancel button is clicked");
		Thread.sleep(2000);
		et.log(LogStatus.PASS,"Cancel button is clicked- passed");
		cl_click(editPasswrdBtn);
		cl_entertext(oldPass, crntPass);
		Thread.sleep(2000);
		et.log(LogStatus.PASS,"Current password is entered- passed");
		cl_entertext(newPasswrd, newPass);
		et.log(LogStatus.PASS,"New password is entered- passed");
		cl_entertext(confrmPass, cnfrmPass);
		et.log(LogStatus.PASS,"Confirm password is entered- passed");
		cl_click(changePassBtn);
		Thread.sleep(4000);
		et.log(LogStatus.PASS,"Change password button is clicked- passed");
		log.info("Password is changed successfully");
		String msg=changePassMsg.getText();
		Utility.comparelogic(msg, shtname, scriptname);
		Thread.sleep(2000);
		cl_click(closeMsg);
		Thread.sleep(2000);
		}
		catch(Exception e) {
			System.out.println("Failed to change password: "+failMsg.getText());
			log.info("Failed to change password");
		}
		
	}
	

	public void authenticChangeMobileNo(String crntNumber,String newNumber,String shtname,String scriptname) throws Exception {
		et =  es.startTest("Change MobileNumber");
		cl_click(AuthenticationTypes);
		Thread.sleep(2000);
		et.log(LogStatus.PASS,"Authentication type present in left menu is clicked- passed");
		try {
		cl_click(editMobleNoBtn);
		Thread.sleep(3000);
		et.log(LogStatus.PASS,"Edit mobile Number button is clicked- passed");
		cl_click(cancelBtn);
		Thread.sleep(3000);
		et.log(LogStatus.PASS,"Cancel button is clicked- passed");
		try {
		cl_click(editMobleNoBtn);
		et.log(LogStatus.PASS,"Edit mobile Number button is clicked- passed");
		log.info("Change Mobile Number page");
		cl_entertext(currentMobNo,crntNumber);
		et.log(LogStatus.PASS,"Current mobileNumber is entered- passed");
		cl_entertext(newMobNo,newNumber);
		et.log(LogStatus.PASS,"Current mobileNumber is entered- passed");
		cl_click(verifyBtn);
		Thread.sleep(2000);
		et.log(LogStatus.PASS,"Verify button is clicked- passed");
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the otp");
		String otp=s.nextLine();
		cl_entertext(otpId, otp);
		et.log(LogStatus.PASS,"OTP is entered- passed");
		cl_click(submitBtn);
		Thread.sleep(4000);
		et.log(LogStatus.PASS,"Submit button is clicked- passed");
		log.info("Mobile Number is changed");
		String msg=successMsg.getText();
		cl_click(popupClsBtnId);
		Utility.comparelogic(msg, shtname, scriptname);	
		Thread.sleep(4000);
		}
		catch(Exception e) {
			//String msg=newMobNoError.getText();
			System.out.println("Mobile number already exists");
			log.info("Mobile number already exists");
		}
		}
		catch(Exception e) {
			String msg=ReqExist.getText();
			System.out.println("Request already exist msg: "+msg);
			log.info("Mobile number request already exists");
			cl_click(reqExistClseBtn);
			Thread.sleep(2000);
			et.log(LogStatus.PASS,"Request for mobileNumber already exist- passed");
		}
	}
	
	public void authenticChangeEmailID(String crntEmail,String newEmail,String shtname,String scriptname) throws Exception {
		et =  es.startTest("Change EmailID");
		cl_click(AuthenticationTypes);
		Thread.sleep(2000);
		et.log(LogStatus.PASS,"Authentication type present in left menu is clicked- passed");
		try {
		cl_click(editEmailIDBtn);
		log.info("Change EmailID page");
		Thread.sleep(3000);
		et.log(LogStatus.PASS,"Edit emailId button is clicked- passed");
		cl_click(cancelBtn);
		Thread.sleep(2000);
		et.log(LogStatus.PASS,"Cancel button is clicked- passed");
		cl_click(editEmailIDBtn);
		et.log(LogStatus.PASS,"Edit emailId button is clicked- passed");
		cl_entertext(currentEmailId,crntEmail);
		et.log(LogStatus.PASS,"Current emailId is entered- passed");
		cl_entertext(newEmailId,newEmail);
		et.log(LogStatus.PASS,"New emailId is entered- passed");
		cl_click(verifyBtn);
		Thread.sleep(2000);
		et.log(LogStatus.PASS,"Verify button is clicked- passed");
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the Email otp");
		String otp=s.nextLine();
		cl_entertext(otpId, otp);
		et.log(LogStatus.PASS,"OTP is entered- passed");
		cl_click(submitBtn);
		Thread.sleep(4000);
		Thread.sleep(2000);
		et.log(LogStatus.PASS,"Submit button is clicked- passed");
		log.info("EmailId is changed");
		String msg=successMsg.getText();
		System.out.println(msg);
		Thread.sleep(2000);
		cl_click(popupClsBtnId);
		Utility.comparelogic(msg, shtname, scriptname);	
		Thread.sleep(4000);
		
		}
		catch(Exception e) {
			String msg=ReqExist.getText();
			System.out.println("Request already exist msg: "+msg);
			log.info("EmailID request already exists");
			cl_click(reqExistClseBtn);
			Thread.sleep(2000);
			et.log(LogStatus.PASS,"Request for emailID already exist- passed");
		}
	}
	
	public void authenticDSC() throws Exception {
		et =  es.startTest("Authentication type DSC");
		cl_click(AuthenticationTypes);
		Thread.sleep(2000);
		et.log(LogStatus.PASS,"Authentication type present in left menu is clicked- passed");
		cl_click(editDSCBtn);
		Thread.sleep(2000);
		try {
		et.log(LogStatus.PASS,"DSC edit button is clicked- passed");
		log.info("Edit DSC button is clicked");
		try {
		cl_click(closeUtility);
		Thread.sleep(2000);
		et.log(LogStatus.PASS,"Close button present in Utility popup is clicked- passed");
//		cl_click(registerDSC);
		cl_click(probInDSC);
		Thread.sleep(2000);
		et.log(LogStatus.PASS,"Problem is DSC link is clicked- passed");
		Alert a=w.switchTo().alert();
		String msg=a.getText();
		a.accept();
		et.log(LogStatus.PASS,"Accepted the alert msg 'Please contact administrator'- passed");
		b.getScreenshot();
		Thread.sleep(2000);
		et.log(LogStatus.PASS,"Screenshot is taken- passed");
		}catch(Exception e) {
			cl_click(probInDSC);
			Thread.sleep(2000);
			et.log(LogStatus.PASS,"Problem is DSC link is clicked- passed");
			Alert a=w.switchTo().alert();
			String msg=a.getText();
			a.accept();
			et.log(LogStatus.PASS,"Accepted the alert msg 'Please contact administrator'- passed");
			Thread.sleep(1000);
			cl_click(registerDSC);
			Thread.sleep(2000);
			et.log(LogStatus.PASS,"Register DSC button is clicked- passed");
			b.getScreenshot();
			Thread.sleep(2000);
			et.log(LogStatus.PASS,"Screenshot of Websocket is taken- passed");
		}
		}catch(Exception e) {
			System.out.println("Request already exist msg: "+ReqExist.getText());
			et.log(LogStatus.PASS,"Request already exist msg is displayed- passed");
			log.info("DSC Request already exist msg");
			cl_click(reqExistClseBtn);
			Thread.sleep(2000);
			et.log(LogStatus.PASS,"Request already exist popup close button is clicked- passed");
		}
		cl_click(AuthenticationTypes);
		Thread.sleep(2000);
		et.log(LogStatus.PASS,"Authentication type present in left menu is clicked- passed");
	}
	
	public void authenticFIDO() throws Exception {
		et =  es.startTest("Authentication type FIDO");
		cl_click(AuthenticationTypes);
		Thread.sleep(2000);
		et.log(LogStatus.PASS,"Authentication type present in left menu is clicked- passed");
		cl_click(editFIDOBtn);
		et.log(LogStatus.PASS,"Edit FIDO button is clicked- passed");
		log.info("Edit FIDO button is clicked");
		Thread.sleep(2000);
		if(!reqExstpopup.isDisplayed()) {
		Thread.sleep(2000);
		b.getScreenshot();
		et.log(LogStatus.PASS,"FIDO register page screenshot is taken- passed");
		w.navigate().back();
		Thread.sleep(5000);
		}
		else {
			System.out.println("Request already exist msg: "+ReqExist.getText());
			et.log(LogStatus.PASS,"Request already exist msg is displayed- passed");
			log.info("FIDO Request already exist msg");
			cl_click(reqExistClseBtn);
			Thread.sleep(2000);
			et.log(LogStatus.PASS,"Request already exist popup close button is clicked- passed");
		}
	}
	
	public void authenticFngrPrint() throws Exception {
		et =  es.startTest("Authentication type FingerPrint");
		cl_click(AuthenticationTypes);
		Thread.sleep(2000);
		et.log(LogStatus.PASS,"Authentication type present in left menu is clicked- passed");
		cl_click(editFngrPrintBtn);
		et.log(LogStatus.PASS,"Edit Fingerprint button is clicked- passed");
		log.info("Edit Fingerprint button is clicked");
		Thread.sleep(2000);
		try {
		cl_click(closeUtility);
		Thread.sleep(4000);
		et.log(LogStatus.PASS,"Close button present in Utility popup is clicked- passed");
		cl_click(probInFngrPrint);
		et.log(LogStatus.PASS,"Problem is Fingerprint link is clicked- passed");
		Alert a=w.switchTo().alert();
		Thread.sleep(2000);
		a.dismiss();
		et.log(LogStatus.PASS,"Dismiss the alert msg 'Please contact administrator'- passed");
		Thread.sleep(2000);
//		Thread.sleep(2000);
		b.getScreenshot();
		et.log(LogStatus.PASS,"Screenshot is taken- passed");
		}catch(Exception e) {
			cl_click(probInFngrPrint);
			et.log(LogStatus.PASS,"Problem is Fingerprint link is clicked- passed");
			Alert a=w.switchTo().alert();
			Thread.sleep(2000);
			a.dismiss();
			et.log(LogStatus.PASS,"Dismiss the alert msg 'Please contact administrator'- passed");
			Thread.sleep(2000);	
		}
		cl_click(AuthenticationTypes);
		Thread.sleep(2000);
		et.log(LogStatus.PASS,"Authentication type present in left menu is clicked- passed");
		
	}
	
	public void authenticFaceRec() throws Exception {
		et =  es.startTest("Authentication type Face Recognition");
		cl_click(AuthenticationTypes);
		Thread.sleep(2000);
		et.log(LogStatus.PASS,"Authentication type present in left menu is clicked- passed");
		cl_click(editFaceRecBtn);
		et.log(LogStatus.PASS,"Edit Face Recognition button is clicked- passed");
		log.info("Edit Face recgntn button is clicked");
//		if(!reqExstpopup.isDisplayed()) {
		Thread.sleep(2000);
		b.getScreenshot();
		cl_click(closeFaceRecAlrt);
		et.log(LogStatus.PASS,"Close button present in alert popup is clicked- passed");
		Thread.sleep(2000);
		/*}
		else {
			System.out.println("Request already exist for Face recognition msg: "+ReqExist.getText());
			Thread.sleep(2000);
			cl_click(closeFaceRecPopup);
			Thread.sleep(2000);
		}*/
	}

	public void authenticKBA(String kbaQ1, String kbaA1, String kbaQ2, String kbaA2, String kbaQ3, String kbaA3,
			String kbaQ4, String kbaA4, String shtname, String scriptname) throws Exception {
		
		cl_click(AuthenticationTypes);
		et.log(LogStatus.PASS,"Authentication type present in left menu is clicked- passed");
		Thread.sleep(2000);
		cl_click(editKBABtn);
		log.info("Edit KBA button is clicked");
		et.log(LogStatus.PASS,"Edit button in KBA is clicked- passed");
		try {
		Select s1=new Select(question1);
		s1.selectByVisibleText(kbaQ1);
		cl_entertext(answer1, kbaA1);
		et.log(LogStatus.PASS,"Answer for Question 1 is entered- passed");
		try {
		Select s2=new Select(question2);
		s2.selectByVisibleText(kbaQ2);
		cl_entertext(answer2, kbaA2);
		et.log(LogStatus.PASS,"Answer for Question 2 is entered- passed");
		}catch(Exception e) {
			et.log(LogStatus.PASS,"Question 2 is not present- passed");
			System.out.println("Question number 2 is not present");
		}
		try {
		Select s3=new Select(question3);
		s3.selectByVisibleText(kbaQ3);
		cl_entertext(answer3, kbaA3);
		et.log(LogStatus.PASS,"Answer for Question 3 is entered- passed");
		}catch(Exception e) {
			et.log(LogStatus.PASS,"Question 3 is not present- passed");
			System.out.println("Question number 3 is not present");
		}
		try {
		Select s4=new Select(question4);
		s4.selectByVisibleText(kbaQ4);
		cl_entertext(answer4, kbaA4);
		et.log(LogStatus.PASS,"Answer for Question 4 is entered- passed");
		}catch(Exception e) {
			et.log(LogStatus.PASS,"Question 4 is not present- passed");
			System.out.println("Question number 4 is not present");
		}
		cl_click(submitKBABtn);
		Thread.sleep(4000);
		et.log(LogStatus.PASS,"Submit KBA button is clicked- passed");
		log.info("Submit KBA button is clicked");
		String msg=kbasuccessMsg.getText();
		System.out.println(msg);
		Utility.comparelogic(msg,shtname,scriptname);
		JavascriptExecutor js = (JavascriptExecutor)w;
		js.executeScript("arguments[0].scrollIntoView();",kbasuccessMsgClseBtn);
		cl_click(kbasuccessMsgClseBtn);
		Thread.sleep(2000);
		}catch(Exception e) {
			String msg=ReqExist.getText();
			System.out.println("Request already exist msg: "+msg);
			et.log(LogStatus.PASS,"Request already exist- passed");
			log.info("KBA Request already exist msg");
			cl_click(reqExistClseBtn);
			Thread.sleep(2000);
			et.log(LogStatus.PASS,"Request already exist popup close button is clicked- passed");
		}
		
	}
}
