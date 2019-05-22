package Page_Factory;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Generic_Library.Basefunctions;
import Generic_Library.Utility;

public class pf_DocstorePage extends pf_genericmethods {
	Basefunctions b = new Basefunctions();
	@FindBy(how = How.XPATH, using = "//span[text()='Doc store']") WebElement docStore;
	//title
	@FindBy(how = How.XPATH, using = "//*[text()='Document Store']") WebElement docStoreTitle;
	//upload Document

	@FindBy(how = How.XPATH, using = "//a[text()='Upload Document']") WebElement uploadDocBtn; 

	@FindBy(how = How.ID, using = "treetag") WebElement BrowseCategory;
	@FindBy(how = How.XPATH, using = "//div[@class='modal-content']") WebElement BrowseCategoryPopup;

	@FindBy(how = How.ID, using = "searchid") WebElement popupSearch;
	//Select workflow
	@FindAll({@FindBy(how = How.XPATH, using = "//div[@id='jstree']/ul/li")}) public List<WebElement> WFSearchList;
	String Userwflist = "//div[@class='jstree-section']/div/ul/li[#DELIM#]/a";
	//upload document	
	//@FindBy(how = How.ID, using = "btnFileUpload") WebElement uploadDocument;

	@FindBy(how = How.XPATH, using = "//div[@class='upload-div']/span/span/input") WebElement uploadDocument;

	@FindBy(how = How.XPATH, using = "//*[text()='Uploaded Documents']") WebElement uploadedDoc;
	//action

	@FindBy(how = How.XPATH, using = "//*[@id=\"1\"]/td[10]/ul") WebElement action;
	//Status 
	
	@FindAll({@FindBy(how = How.XPATH, using = "//table[@id='WorkFlowGrid']/tbody/tr[not(@class='jqgfirstrow')]/td[9]")}) public List<WebElement> statusCount;
	String status="//table[@id='WorkFlowGrid']/tbody/tr[not(@class='jqgfirstrow')][#DELIM#]/td[9]";
	//@FindBy(how = How.XPATH, using = "//*[@id=\"1\"]/td[10]/ul") WebElement action;
	@FindBy(how = How.XPATH, using = "//ul[@class='dropdown-actions']/li/a") WebElement viewDoc;
	//Mark it as inactive
	@FindBy(how = How.XPATH, using = "//*[@id=\"lnkDelete\"]/i") WebElement markAsInactive;
	//Download the file	
	@FindBy(how = How.XPATH, using = "//ul[@id='actionSettings']/li[3]/a") WebElement downloadDoc;
	//Tag Category
	@FindBy(how = How.XPATH, using = "//*[@id=\"lnkMapCategory\"]/i") WebElement tagWF;
	//Share file button
	@FindBy(how = How.XPATH, using = "//a[@class='lnkshare']/i") WebElement shareFile; 
	//Email ID
	@FindBy(how = How.ID, using = "txtemail") WebElement emailID; 
	@FindBy(how = How.ID, using = "btnshared") WebElement emailSendBtn;
	//success msg	
	//@FindBy(how = How.XPATH, using = "//div[contains(text(),'You're done!')]") public WebElement sendBtnSuccessMsg;
	
	@FindBy(how = How.XPATH, using = "//div[@class='success']") public WebElement sendBtnSuccessMsg;
	//ok button
	@FindBy(how = How.ID, using = "btnmsgok") WebElement okBtn;
	
	//export to excel button	
	@FindBy(how = How.ID, using = "btnExport") WebElement exportToExcelBtn;
	public pf_DocstorePage(WebDriver driver){

		PageFactory.initElements(driver, this);
	}




	public void clickDocstore() throws Exception {
		cl_click(docStore);
		Thread.sleep(3000);
		System.out.println("Title Document Store is displayed: "+docStoreTitle.isDisplayed());
	}




	public void uploadDocument() throws Exception {

		cl_click(uploadDocBtn);
		cl_click(BrowseCategory);
		Thread.sleep(3000);
		System.out.println("Popup is displayed: "+BrowseCategoryPopup.isDisplayed());
		//Thread.sleep(3000);
		Random r = new Random();
		int randomValue = r.nextInt(WFSearchList.size());
		cl_click(b.w.findElement(By.xpath(Userwflist.replace("#DELIM#",String.valueOf(randomValue)))));
		Thread.sleep(3000);
		//		String path=Utility.getpropertydetails("DocStoreDocUpload");
		//		uploadDocument.sendKeys(path);
		//		cl_click(uploadDocument);
		//		Runtime.getRuntime().exec("D:\\sindhu\\HPEdrive\\Selenium Scripts\\autoit scripts\\validatefile.exe");
		//		Thread.sleep(8000);
		cl_click(uploadedDoc);
		Thread.sleep(4000);
	}




	public void actionSettings() throws Exception {
		int size=statusCount.size();
		System.out.println("size"+size);
		Random r1 = new Random();
		int ran = r1.nextInt(statusCount.size());
		WebElement statusv = b.w.findElement(By.xpath(status.replace("#DELIM#",String.valueOf(ran))));
		Thread.sleep(3000);
		String value=statusv.getText();
		if(value.equals("Initiate")) {
			cl_click(downloadDoc);
			Thread.sleep(2000);
			cl_click(shareFile);
			Thread.sleep(2000);
			String mailID=Utility.getpropertydetails("DocStoreShareMailID");
			cl_entertext(emailID, mailID);
			Thread.sleep(2000);
			cl_click(emailSendBtn);
			Thread.sleep(3000);
			String msg=sendBtnSuccessMsg.getText();
			System.out.println("Email send successfully: "+msg);
			cl_click(okBtn);
			Thread.sleep(2000);
			cl_click(tagWF);
			Random r = new Random();
			int randomValue = r.nextInt(WFSearchList.size());
			cl_click(b.w.findElement(By.xpath(Userwflist.replace("#DELIM#",String.valueOf(randomValue)))));
			Thread.sleep(3000);
			String msg1=sendBtnSuccessMsg.getText();
			System.out.println("Workflow mapped to the document: "+msg1);
			cl_click(okBtn);
			Thread.sleep(2000);
		}
		else if(value.equals("Completed")){
			cl_click(viewDoc);
			Thread.sleep(4000);
		}else {
			b.getScreenshot();
			Thread.sleep(2000);
		}
	}


	public void exportToExcel() {
	
		cl_click(exportToExcelBtn);
	}
}
