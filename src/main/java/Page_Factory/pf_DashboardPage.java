package Page_Factory;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
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

public class pf_DashboardPage extends pf_genericmethods {

	Basefunctions b=new Basefunctions();
	final static Logger log = Logger.getLogger(pf_DashboardPage.class);

	@FindBy(how = How.XPATH, using = "//div[@class='quick-area']/div[1]/ul/li/a/span") public WebElement homeBtn;
	@FindBy(how = How.XPATH, using = "//div[@class='clearfix row dashboardBox']/div[1]/div/a/span/b") public WebElement pendingCount;
	@FindBy(how = How.XPATH, using = "//div[@class='clearfix row dashboardBox']/div[2]/div/a/span/b") public WebElement rejectedCount;
	@FindBy(how = How.XPATH, using = "//div[@class='clearfix row dashboardBox']/div[3]/div/a/span/b") public WebElement approvedCount;
	@FindBy(how = How.XPATH, using = "//div[@class='clearfix row dashboardBox']/div[4]/div/a/span/b") public WebElement cancelCount;

	//pending 
	@FindBy(how = How.XPATH, using = "//div[@class='clearfix row dashboardBox']/div[1]/div/a") public WebElement pending;
	@FindBy(how = How.ID, using = "cancelpopupmsg") public WebElement cancelpopupmsg;
	@FindBy(how = How.XPATH, using = "//a[text()='Yes']") public WebElement yesBtn;
	@FindBy(how = How.ID, using = "cancelpopupmsg") public WebElement succesMsg;	
	@FindBy(how = How.ID, using = "closeWindowAlert") public WebElement closeWindowAlert;
	
	String pendngView="//table[@id='myCount']/tbody/tr[@class='jqgfirstrow']/following-sibling::tr[#DELIM#]/td[6]/ul/li[2]/a/i";
	String pendngView1="//table[@id='myCount']/tbody/tr[@class='jqgfirstrow']/following-sibling::tr[#DELIM#]/td[6]/ul/li/a/i";
	String pendingEdit="//table[@id='myCount']/tbody/tr[@class='jqgfirstrow']/following-sibling::tr[#DELIM#]/td[6]/ul/li[1]/a/i";
	@FindBy(how = How.XPATH, using = "//div[@class='clearfix row dashboardBox']/div[2]/div/a") public WebElement rejected;
	String pendingReqType="//table[@id='myCount']/tbody/tr[@class='jqgfirstrow']/following-sibling::tr[#DELIM#]/td[2]";
	@FindAll({@FindBy(how = How.XPATH, using = "//table[@id='myCount']/tbody/tr[not(@class='jqgfirstrow')]")}) public List<WebElement> ViewCount;
	String view="//table[@id='myCount']/tbody/tr[@class='jqgfirstrow']/following-sibling::tr[#DELIM#]/td[6]/ul/li";
	String requesttype="//table[@id='myCount']/tbody/tr[@class='jqgfirstrow']/following-sibling::tr[#DELIM#]/td[2]";
	//close button

	@FindBy(how = How.CSS, using = "#cancelUpdateProfilePopupId > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > button:nth-child(1)") WebElement prfleUpdteCloseBtn;
	@FindBy(how = How.CSS, using = "#cancelResourceAccessPopupId > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > button:nth-child(1)") WebElement accessReqCloseBtn;
	@FindBy(how = How.CSS, using = "#cancelGroupEntryPopupId > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > button:nth-child(1)") WebElement groupCloseBtn;
	@FindBy(how = How.CSS, using = "#cancelEmailPopupId > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > button:nth-child(1)") WebElement updteEmailCloseBtn;
	@FindBy(how = How.CSS, using = "#cancelMobilePopupId > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > button:nth-child(1)") WebElement updteMobleNoCloseBtn;
	@FindBy(how = How.CSS, using = "#cancelKBAPopupId > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > button:nth-child(1)") WebElement KBACloseBtn;
	@FindBy(how = How.CSS, using = "#cancelFaceRecogPopupId > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > button:nth-child(1)") WebElement FaceRecCloseBtn;
	@FindBy(how = How.CSS, using = "#cancelDSCPopupId > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > button:nth-child(1)") WebElement DSCCloseBtn;

	@FindBy(how = How.ID, using = "alertTitleUserSelfRegistration") public WebElement alrtTitle;
	//search button
	@FindBy(how = How.XPATH, using = "//td[@id='myCountpager_left']/table/tbody/tr/td[1]") public WebElement searchBtn;
	//search with request Type 
	@FindBy(how = How.ID, using = "gs_requestType") public WebElement searchReqType;
	@FindBy(how = How.XPATH, using = "//td[@id='myCountpager_left']/table/tbody/tr/td[2]") public WebElement clrSearchBtn;

	@FindBy(how = How.XPATH, using = "//div[@class='clearfix row dashboardBox']/div[3]/div/a") public WebElement approved;

	@FindBy(how = How.XPATH, using = "//div[@class='clearfix row dashboardBox']/div[4]/div/a") public WebElement cancel;

	@FindBy(how = How.XPATH, using = "//a[@href='selfservice-dashboard.htm']") public WebElement homeLink;
	
	public pf_DashboardPage(WebDriver driver){

		PageFactory.initElements(driver, this);
	}

	public void dashboardDetails() {
		System.out.println("--Dashboard Details--");
		log.info("--Dashboard Details--");
		System.out.println("Pending Count: "+pendingCount.getText());
		System.out.println("Rejected Count: "+rejectedCount.getText());
		System.out.println("Approved Count: "+approvedCount.getText());
		System.out.println("Cancel Count: "+cancelCount.getText());
		log.info("Pending/Rejected/Approved/Cancel count: "+pendingCount.getText() +"/"+ rejectedCount.getText() +"/" + approvedCount.getText()+"/" +cancelCount.getText());
	}

	public void deletependingStatus(String shtname,String scrptname) throws Exception {
		cl_click(pending);
		log.info("Pending status page is displayed");
		et.log(LogStatus.PASS,"Pending tab is clicked- passed");
		int size=ViewCount.size();
		if(size!=0) {
			Random rand = new Random();
			int n = rand.nextInt(size);
			if (n==0){

				n= n+1;
			}
			WebElement a = w.findElement(By.xpath(pendingReqType.replace("#DELIM#",String.valueOf(n))));
			String pReqType=a.getText();
			if(pReqType.equalsIgnoreCase("Access Request") || pReqType.equalsIgnoreCase("Group Request")) {
			cl_click(w.findElement(By.xpath(pendngView.replace("#DELIM#",String.valueOf(n)))));
			Thread.sleep(3000);
			}
			else {
				cl_click(w.findElement(By.xpath(pendngView1.replace("#DELIM#",String.valueOf(n)))));
				Thread.sleep(3000);
			}
			String msg=cancelpopupmsg.getText();
			cl_click(yesBtn);
			et.log(LogStatus.PASS,"Pending record is deleted- passed");
			Utility.comparelogic(msg, shtname, scrptname);
			log.info("Yes button is clicked");
			Thread.sleep(3000);
			String msg1=succesMsg.getText();
			//System.out.println("Pending Request delete msg: "+msg1);
			cl_click(closeWindowAlert);
			et.log(LogStatus.PASS,"Close button of delete msg is clicked- passed");
			log.info("Alert window is closed");
			Thread.sleep(3000);
		}
		else {
			b.getScreenshot();
			log.info("Screenshot Taken");
		}

	}

	public void editpendingStatus(String shtname,String scrptname) throws Exception {
		int size=ViewCount.size();
		if(size!=0) {
			Random rand = new Random();
			int n = rand.nextInt(size);
			if (n==0){

				n= n+1;
			}
			WebElement a = w.findElement(By.xpath(requesttype.replace("#DELIM#",String.valueOf(n))));
			String reqstType=a.getText();
			cl_click(w.findElement(By.xpath(pendingEdit.replace("#DELIM#",String.valueOf(n)))));
			Thread.sleep(3000);
		}
	}
	
	public void rejectedStatus() throws Exception {
		cl_click(homeBtn);
		et.log(LogStatus.PASS,"Home button is clicked- passed");
		cl_click(rejected);
		et.log(LogStatus.PASS,"Reject button is clicked- passed");
		log.info("Rejected status page is displayed");
		int size=ViewCount.size();
		if(size!=0) {
			Random rand = new Random();
			int n = rand.nextInt(size);
			if (n==0){

				n= n+1;
			}	
			WebElement a = w.findElement(By.xpath(requesttype.replace("#DELIM#",String.valueOf(n))));
			String reqstType=a.getText();
			cl_click(w.findElement(By.xpath(view.replace("#DELIM#",String.valueOf(n)))));
			et.log(LogStatus.PASS,"View button is clicked- passed");
			b.getScreenshot();
			Thread.sleep(3000);
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

			if(reqstType.equalsIgnoreCase(ProfleUpdate)) {
				Thread.sleep(2000);
				cl_click(prfleUpdteCloseBtn);
				et.log(LogStatus.PASS,"Profile update close button is clicked- passed");

			}
			else if(reqstType.equalsIgnoreCase(accessReq)) {
				Thread.sleep(2000);
				cl_click(accessReqCloseBtn);
				et.log(LogStatus.PASS,"Access request close button is clicked- passed");
			}
			else if(reqstType.equalsIgnoreCase(grpReq)){
				Thread.sleep(2000);
				cl_click(groupCloseBtn);
				et.log(LogStatus.PASS,"Group request close button is clicked- passed");
			}
			else if(reqstType.equalsIgnoreCase(updteEmail)){
				Thread.sleep(2000);
				cl_click(updteEmailCloseBtn);
				et.log(LogStatus.PASS,"Update email close button is clicked- passed");
			}
			else if(reqstType.equalsIgnoreCase(KBA)){
				Thread.sleep(2000);
				cl_click(KBACloseBtn);
				et.log(LogStatus.PASS,"KBA close button is clicked- passed");
			}
			else if(reqstType.equalsIgnoreCase(updteMobleNo)){
				Thread.sleep(2000);
				cl_click(updteMobleNoCloseBtn);
				et.log(LogStatus.PASS,"Update mobile Number close button is clicked- passed");
			}
			else if(reqstType.equalsIgnoreCase(faceRec)){
				Thread.sleep(2000);
				cl_click(FaceRecCloseBtn);
				et.log(LogStatus.PASS,"Face rec close button is clicked- passed");
			}
			else if(reqstType.equalsIgnoreCase(DSC)){
				Thread.sleep(2000);
				cl_click(DSCCloseBtn);
				et.log(LogStatus.PASS,"DSC close button is clicked- passed");
			}
			
			Thread.sleep(2000);
			cl_click(searchBtn);
			et.log(LogStatus.PASS,"Search button is clicked- passed");
			log.info("Search Button is clicked");
			cl_entertext(searchReqType, reqstType);
			Robot r=new Robot();
			r.keyPress(KeyEvent.VK_ENTER);
			Thread.sleep(2000);
			r.keyPress(KeyEvent.VK_ENTER);
			Thread.sleep(6000);
			int c1=ViewCount.size();
			for(int i=1;i<=c1;i++) {
				WebElement name = w.findElement(By.xpath(requesttype.replace("#DELIM#",String.valueOf(i))));
				String searchR=name.getText();
				if(searchR.equalsIgnoreCase(reqstType)) {
					System.out.println("Searched result displayed correctly");
					et.log(LogStatus.PASS,"Searched result displayed correctly- passed");
				}else {
					System.out.println("Searched result did not display correctly");
					et.log(LogStatus.FAIL,"Searched result did not display correctly- failed");
				}
			}
			Thread.sleep(3000);
			cl_click(clrSearchBtn);
			log.info("Clear Button is clicked");
			Thread.sleep(2000);
			et.log(LogStatus.PASS,"Clear button is clicked- passed");
			cl_click(homeLink);
			Thread.sleep(2000);
			et.log(LogStatus.PASS,"Home Link is clicked- passed");
		}
		else {
			b.getScreenshot();
			log.info("Screenshot Taken");
			et.log(LogStatus.PASS,"Reject status record is not present- passed");
		}

	}

	public void approvedStatus() throws Exception {
		cl_click(homeBtn);
		et.log(LogStatus.PASS,"Home button is clicked- passed");
		cl_click(approved);
		log.info("Approved status page is displayed");
		Thread.sleep(2000);
		et.log(LogStatus.PASS,"Approved tab is clicked- passed");
		int size=ViewCount.size();
		if(size!=0) {
			Random rand = new Random();
			int n = rand.nextInt(size);
			if (n==0){

				n= n+1;
			}	
			WebElement a = w.findElement(By.xpath(requesttype.replace("#DELIM#",String.valueOf(n))));
			String reqstType=a.getText();
			cl_click(w.findElement(By.xpath(view.replace("#DELIM#",String.valueOf(n)))));			
			b.getScreenshot();
			Thread.sleep(3000);
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

			if(reqstType.equalsIgnoreCase(ProfleUpdate)) {
				Thread.sleep(2000);
				cl_click(prfleUpdteCloseBtn);
				et.log(LogStatus.PASS,"Profile update close button is clicked- passed");

			}else if(reqstType.equalsIgnoreCase(accessReq)) {
				Thread.sleep(2000);
				cl_click(accessReqCloseBtn);
				et.log(LogStatus.PASS,"Access request close button is clicked- passed");
			}else if(reqstType.equalsIgnoreCase(grpReq)) {
				Thread.sleep(2000);
				cl_click(groupCloseBtn);
				et.log(LogStatus.PASS,"Group request close button is clicked- passed");
			}else if(reqstType.equalsIgnoreCase(updteEmail)) {
				Thread.sleep(2000);
				cl_click(updteEmailCloseBtn);
				et.log(LogStatus.PASS,"Update email close button is clicked- passed");
			}
			else if(reqstType.equalsIgnoreCase(KBA)){
				Thread.sleep(2000);
				cl_click(KBACloseBtn);
				et.log(LogStatus.PASS,"KBA close button is clicked- passed");
			}
			else if(reqstType.equalsIgnoreCase(updteMobleNo)){
				Thread.sleep(2000);
				cl_click(updteMobleNoCloseBtn);
				et.log(LogStatus.PASS,"Update mobile Number close button is clicked- passed");
			}
			else if(reqstType.equalsIgnoreCase(faceRec)){
				Thread.sleep(2000);
				cl_click(FaceRecCloseBtn);
				et.log(LogStatus.PASS,"Face rec close button is clicked- passed");
			}
			else if(reqstType.equalsIgnoreCase(DSC)){
				Thread.sleep(2000);
				cl_click(DSCCloseBtn);
				et.log(LogStatus.PASS,"DSC close button is clicked- passed");
			}
			Thread.sleep(2000);
			cl_click(searchBtn);
			et.log(LogStatus.PASS,"Search button is clicked- passed");
			log.info("Search Button is clicked");
			cl_entertext(searchReqType, reqstType);
			Robot r=new Robot();
			r.keyPress(KeyEvent.VK_ENTER);
			Thread.sleep(2000);
			r.keyPress(KeyEvent.VK_ENTER);
			Thread.sleep(6000);
			int c1=ViewCount.size();
			for(int i=1;i<=c1;i++) {
				WebElement name = w.findElement(By.xpath(requesttype.replace("#DELIM#",String.valueOf(i))));
				String searchR=name.getText();
				if(searchR.equalsIgnoreCase(reqstType)) {
					System.out.println("Searched result displayed correctly");
					et.log(LogStatus.PASS,"Searched result displayed correctly- passed");
				}else {
					System.out.println("Searched result did not display correctly");
					et.log(LogStatus.FAIL,"Searched result did not display correctly- failed");
				}
			}
			Thread.sleep(3000);
			cl_click(clrSearchBtn);
			log.info("Clear Button is clicked");
			Thread.sleep(2000);
			et.log(LogStatus.PASS,"Clear button is clicked- passed");
			cl_click(homeLink);
			Thread.sleep(2000);
			et.log(LogStatus.PASS,"Home Link is clicked- passed");
		}

		else {
			b.getScreenshot();
			log.info("Screenshot Taken");
			et.log(LogStatus.PASS,"Approved status record is not present- passed");
		}
	}

	public void cancelStatus() throws Exception {
		cl_click(homeBtn);
		et.log(LogStatus.PASS,"Home button is clicked- passed");
		cl_click(cancel);
		et.log(LogStatus.PASS,"Cancel tab is clicked- passed");
		log.info("Cancel status page is displayed");
		Thread.sleep(2000);
		int size=ViewCount.size();
		if(size!=0) {
			Random rand = new Random();
			int n = rand.nextInt(size);
			if (n==0){

				n= n+1;
			}	
			WebElement a = w.findElement(By.xpath(requesttype.replace("#DELIM#",String.valueOf(n))));
			String reqstType=a.getText();
			cl_click(w.findElement(By.xpath(view.replace("#DELIM#",String.valueOf(n)))));			
			b.getScreenshot();
			Thread.sleep(3000);
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
			if(reqstType.equalsIgnoreCase(ProfleUpdate)) {
				Thread.sleep(2000);
				cl_click(prfleUpdteCloseBtn);
				et.log(LogStatus.PASS,"Profile update close button is clicked- passed");

			}else if(reqstType.equalsIgnoreCase(accessReq)) {
				Thread.sleep(2000);
				cl_click(accessReqCloseBtn);
				et.log(LogStatus.PASS,"Access request close button is clicked- passed");
			}else if(reqstType.equalsIgnoreCase(grpReq)) {
				Thread.sleep(2000);
				cl_click(groupCloseBtn);
				et.log(LogStatus.PASS,"Group request close button is clicked- passed");
			}else if(reqstType.equalsIgnoreCase(updteEmail)) {
				Thread.sleep(2000);
				cl_click(updteEmailCloseBtn);
				et.log(LogStatus.PASS,"Update email close button is clicked- passed");
			}
			else if(reqstType.equalsIgnoreCase(KBA)){
				Thread.sleep(2000);
				cl_click(KBACloseBtn);
				et.log(LogStatus.PASS,"KBA close button is clicked- passed");
			}
			else if(reqstType.equalsIgnoreCase(updteMobleNo)){
				Thread.sleep(2000);
				cl_click(updteMobleNoCloseBtn);
				et.log(LogStatus.PASS,"Update mobile Number close button is clicked- passed");
			}
			else if(reqstType.equalsIgnoreCase(faceRec)){
				Thread.sleep(2000);
				cl_click(FaceRecCloseBtn);
				et.log(LogStatus.PASS,"Face rec close button is clicked- passed");
			}
			else if(reqstType.equalsIgnoreCase(DSC)){
				Thread.sleep(2000);
				cl_click(DSCCloseBtn);
				et.log(LogStatus.PASS,"DSC close button is clicked- passed");
			}
			Thread.sleep(2000);
			cl_click(searchBtn);
			log.info("Search Button is clicked");
			et.log(LogStatus.PASS,"Search button is clicked- passed");
			cl_entertext(searchReqType, reqstType);
			Robot r=new Robot();
			r.keyPress(KeyEvent.VK_ENTER);
			Thread.sleep(2000);
			r.keyPress(KeyEvent.VK_ENTER);
			Thread.sleep(6000);
			int c1=ViewCount.size();
			for(int i=1;i<=c1;i++) {
				WebElement name = w.findElement(By.xpath(requesttype.replace("#DELIM#",String.valueOf(i))));
				String searchR=name.getText();
				if(searchR.equalsIgnoreCase(reqstType)) {
					System.out.println("Searched result displayed correctly");
					et.log(LogStatus.PASS,"Searched result displayed correctly- passed");
				}else {
					System.out.println("Searched result did not display correctly");
					et.log(LogStatus.FAIL,"Searched result did not display correctly- failed");
				}
			}
			Thread.sleep(3000);
			cl_click(clrSearchBtn);
			log.info("Clear Button is clicked");
			Thread.sleep(2000);
			et.log(LogStatus.PASS,"Clear button is clicked- passed");
			cl_click(homeLink);
			Thread.sleep(2000);
			et.log(LogStatus.PASS,"Home Link is clicked- passed");
		}

		else {
			b.getScreenshot();
			log.info("Screenshot Taken");
			et.log(LogStatus.PASS,"Reject status record is not present- passed");

		}

	}
}

