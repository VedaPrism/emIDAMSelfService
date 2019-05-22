package Page_Factory;

import java.util.Calendar;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.LogStatus;

import Generic_Library.Utility;

public class pf_makeaRequestPage extends pf_genericmethods {

	final static Logger log = Logger.getLogger(pf_makeaRequestPage.class);

	@FindBy(how = How.ID, using = "MakeRequest") WebElement MakeRequest;
	@FindBy(how = How.ID, using = "Myself") WebElement myselfRadioBtn;
	//Request type
	@FindBy(how = How.XPATH, using = "//select[@class='formField']") public WebElement requestType;
	//select group
	@FindBy(how = How.ID, using = "groupSelectionVal") WebElement selectGroup; 
	//Priority
	@FindBy(how = How.ID, using = "priorityId") WebElement priorityID;
	//Reason textBox
	@FindBy(how = How.ID, using = "makeReqReasonId") WebElement reason;
	//submit button
	@FindBy(how = How.XPATH, using = "//input[@class='btn btn-primary']") public WebElement submitBtn;
	//sucess msg
	//@FindBy(how = How.ID, using = "succesMsg") WebElement succesMsg;
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Request submitted successfully.')]") WebElement succesMsg;
	//error msg
	//@FindBy(how = How.ID, using = "errorMsg") WebElement errorMsg;
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Already exist')]") WebElement errorMsg;
	
	//close button of success msg
	@FindBy(how = How.ID, using = "closeWindowAlert") WebElement closeWindowAlert;

	//app
	@FindBy(how = How.ID, using = "appNameDiv") WebElement appName;
	//app name search button
	@FindBy(how = How.XPATH, using = "//li[@id='appSelectionId']/a[1]") public WebElement appNameSearchBtn;
	//app names list 
	@FindAll({@FindBy(how = How.XPATH, using = "//table[@id='searchedapps']/tbody/tr/td/input")}) public List<WebElement> appCheckbxList;
	String appCheckbox="//table[@id='searchedapps']/tbody/tr[#DELIM#]/td/input";
	//submit app
	@FindBy(how = How.ID, using = "showSelectedApp") public WebElement submitApp;

	//resource type
	@FindBy(how = How.ID, using = "resourceTypeId") public WebElement resourceType;
	//resource
	@FindBy(how = How.ID, using = "resNameDiv") public WebElement resName;	
	@FindBy(how = How.XPATH, using = "//form[@id='makeRequestForm']/div/ul/li[8]/a/i") public WebElement resNameSearchBtn;
	//app names list 
	@FindAll({@FindBy(how = How.XPATH, using = "//table[@id='searchedresources']/tbody/tr[not(@class='jqgfirstrow')]")}) public List<WebElement> resCheckbxList;
	String resCheckbox="//table[@id='searchedresources']/tbody/tr[@class='jqgfirstrow']/following-sibling::tr[#DELIM#]/td[1]/input";
	//submit resource
	@FindBy(how = How.XPATH, using = "//div[@id='searchResourceDIV']/div/div/div[3]/input") public WebElement submitRes;
	// @FindBy(how = How.ID, using = "showSelectedResources") WebElement submitResult;

	@FindBy(how = How.XPATH, using = "//form[@id='makeRequestForm']/div/ul/li[9]/div/label[1]") public WebElement readRBtn;

	@FindBy(how = How.XPATH, using = "//form[@id='makeRequestForm']/div/ul/li[9]/div/label[2]") public WebElement writeRBtn;

	@FindBy(how = How.XPATH, using = "//form[@id='makeRequestForm']/div/ul/li[10]/div/label[1]") public WebElement noLimitRBtn;
	@FindBy(how = How.XPATH, using = "//form[@id='makeRequestForm']/div/ul/li[10]/div/label[2]") public WebElement tempRBtn;


	@FindBy(how = How.ID, using = "fromDay") WebElement fromDay;
	@FindBy(how = How.XPATH, using = "//div[@class='datepicker-days']/table/thead/tr[1]/th[3]") public WebElement fromNxtBtn;
	@FindBy(how = How.XPATH, using = "//div[@class='datepicker-days']/table/thead/tr[1]/th[2]") public WebElement fromMiddleBtn;
	@FindBy(how = How.XPATH, using = "//div[@class='datepicker-months']/table/thead/tr/th[2]") public WebElement fromMonMiddleBtn;

	@FindAll({@FindBy(how = How.XPATH, using = "//div[@class='datepicker-months']/table/tbody/tr/td/span[not(@class='month disabled')]")}) public List<WebElement> monthList;

	@FindBy(how = How.XPATH, using = "//div[@class='datepicker-years']/table/tbody/tr/td/span[@class='year']") public WebElement selectYrBtn;
	@FindAll({@FindBy(how = How.XPATH, using = "//div[@class='datepicker-days']/table/tbody/tr/td[@class='day']")}) public List<WebElement> dayList;
	@FindBy(how = How.XPATH, using = "//div[@class='datepicker-years']/table/thead/tr/th[3]") public WebElement fromYearNxtBtn;
	@FindBy(how = How.XPATH, using = "//table[@class=' table-condensed']/tbody/tr/td[@class='active day']") public WebElement selectFDate;
	@FindBy(how = How.ID, using = "toDay") WebElement toDay;
	@FindBy(how = How.XPATH, using = "//div[@id='timepicker1']/span/span") WebElement fromTime;

	@FindBy(how = How.XPATH, using = "//div[@id='timepicker2']/span/span") WebElement toTime;
	@FindBy(how = How.XPATH, using = "//div[@class='bootstrap-timepicker-widget dropdown-menu timepicker-orient-left timepicker-orient-bottom open']/table/tbody/tr[2]/td[1]/span") public WebElement displyedHr;
	@FindBy(how = How.XPATH, using = "//div[@class='bootstrap-timepicker-widget dropdown-menu timepicker-orient-left timepicker-orient-bottom open']/table/tbody/tr[2]/td[3]/span") public WebElement displayedMin;
	@FindBy(how = How.XPATH, using = "//div[@class='bootstrap-timepicker-widget dropdown-menu timepicker-orient-left timepicker-orient-bottom open']/table/tbody/tr[2]/td[5]/span") public WebElement displayedAMPM;

	@FindBy(how = How.XPATH, using = "//div[@class='bootstrap-timepicker-widget dropdown-menu timepicker-orient-left timepicker-orient-bottom open']/table/tbody/tr[3]/td[1]/a/span") public WebElement displyedHrDec;
	@FindBy(how = How.XPATH, using = "//div[@class='bootstrap-timepicker-widget dropdown-menu timepicker-orient-left timepicker-orient-bottom open']/table/tbody/tr[3]/td[3]/a/span") public WebElement displayedMinDec;
	@FindBy(how = How.XPATH, using = "//div[@class='bootstrap-timepicker-widget dropdown-menu timepicker-orient-left timepicker-orient-bottom open']/table/tbody/tr[3]/td[5]/a/span") public WebElement displayedAMPMDec;

	@FindBy(how = How.XPATH, using = "//div[@class='bootstrap-timepicker-widget dropdown-menu timepicker-orient-left timepicker-orient-bottom open']/table/tbody/tr[1]/td[1]/a/span") public WebElement displyedHrInc;
	@FindBy(how = How.XPATH, using = "//div[@class='bootstrap-timepicker-widget dropdown-menu timepicker-orient-left timepicker-orient-bottom open']/table/tbody/tr[3]/td[3]/a/span") public WebElement displayedMinInc;
	@FindBy(how = How.XPATH, using = "//div[@class='bootstrap-timepicker-widget dropdown-menu timepicker-orient-left timepicker-orient-bottom open']/table/tbody/tr[3]/td[5]/a/span") public WebElement displayedAMPMInc;


	@FindBy(how = How.ID, using = "operatorPicker") WebElement transParamtr;	
	@FindBy(how = How.ID, using = "cmnValFieldID") WebElement amountVal;

	//others
	@FindBy(how = How.ID, using = "Others") WebElement otherRadioBtn;
	//user name
	@FindBy(how = How.ID, using = "userNameDiv") WebElement userNameDiv;

	public pf_makeaRequestPage(WebDriver driver){

		PageFactory.initElements(driver, this);
	}


	public void makeARequestGroup(String reqFor, String reqType, String selectGrp, String prio, String reasn, String scriptname, String shtname) throws Exception {
		cl_click(MakeRequest);
		et =  es.startTest("Make a Request: 4148");
		et.log(LogStatus.PASS,"Make A Request is clicked- passed");
		log.info("--Make a Request page is displayed--");
		if(reqFor.equalsIgnoreCase("Myself")) {
			if(myselfRadioBtn.isSelected()) {
				et =  es.startTest("Make a Request Group(Myself): 4152");
				et.log(LogStatus.PASS,"myself radio button is selected- passed");
				log.info("Request is for Myself");
				//System.out.println(myselfRadioBtn.isSelected());
				Select s1=new Select(requestType);
				s1.selectByVisibleText(reqType);
				if(reqType.equalsIgnoreCase("Group")) {
					et =  es.startTest("Make a Request: 4193");
					et.log(LogStatus.PASS,"Request type Group is selected- passed");
					log.info("Request Type is Group");
					Select s2=new Select(selectGroup);
					s2.selectByVisibleText(selectGrp);
					et =  es.startTest("Make a Request: 4195");
					et.log(LogStatus.PASS,"Group is selected from the dropdown- passed");
					Select s3=new Select(priorityID);
					s3.selectByVisibleText(prio);
					et.log(LogStatus.PASS,"Priority is selected from dropdown- passed");
					System.out.println(reasn);
					cl_entertext(reason, reasn);
					et.log(LogStatus.PASS,"Reason is entered- passed");
					cl_click(submitBtn);
					Thread.sleep(3000);
					et.log(LogStatus.PASS,"Make a request for myself,Request Type Group,submit button is clicked- passed");
					log.info("Make a request for Myself,Request Type Group is submitted");
					try {
					String msg=succesMsg.getText();
					Utility.comparelogic(msg, shtname, scriptname);
					cl_click(closeWindowAlert);
					Thread.sleep(3000);
					et.log(LogStatus.PASS,"Success message popup close button is clicked- passed");
					}
					catch(Exception e) {
						String msg=errorMsg.getText();
						System.out.println("Error Msg: "+msg);
						et =  es.startTest("Make a Request Already Exist");
						log.info("Make a request for Myself,Request Type Group is already Exist");
						et.log(LogStatus.PASS,"Make a request for Myself,Request Type Group is already Exist");
						cl_click(closeWindowAlert);
						Thread.sleep(3000);
						et.log(LogStatus.PASS,"Already exist message popup close button is clicked- passed");
					}
				}
			}
		}
	}



	public void makeARequestResource(String reqFor,String reqType,String app,String resType,String res,String actn,String acessType,String transParam,String amtVal,String prio,String reasn,String wkdays,String fromD,String toD,String fromT,String toT,String scriptname,String shtname) throws Exception {
		cl_click(MakeRequest);
		if(reqFor.equalsIgnoreCase("Myself")) {
			if(myselfRadioBtn.isSelected()) {
				log.info("Request is for Myself");
				System.out.println(myselfRadioBtn.isSelected());
				Select s1=new Select(requestType);
				s1.selectByVisibleText(reqType);
				if(reqType.equalsIgnoreCase("Resource")) {
					et =  es.startTest("Make a Request for Resource(Myself): 4161");
					et.log(LogStatus.PASS,"Request type Resource is selected- passed");
					log.info("Request Type is Resource");
					cl_entertext(appName, app);
					cl_click(appNameSearchBtn);
					Thread.sleep(3000);
					et =  es.startTest("Make a Request: 4196");
					et.log(LogStatus.PASS,"App Name search button is clicked- passed");
					int size=appCheckbxList.size();
					System.out.println(size);
					Random rand = new Random();
					int n = rand.nextInt(size);
					if (n==0){

						n= n+2;
					}
					else if(n==1) {
						n=n+1;
					}				
					cl_click(w.findElement(By.xpath(appCheckbox.replace("#DELIM#",String.valueOf(n)))));
					cl_click(submitApp);
					et =  es.startTest("Make a Request: 4198");
					et.log(LogStatus.PASS,"App Name is picked from the popup- passed");
					Select s2=new Select(resourceType);
					s2.selectByVisibleText(resType);
					Thread.sleep(2000);
					et =  es.startTest("Make a Request: 4203");
					et.log(LogStatus.PASS,"Resource type is selected from dropdown- passed");
					cl_entertext(resName, res);

					cl_click(resNameSearchBtn);
					Thread.sleep(2000);
					et =  es.startTest("Make a Request: 4205");
					et.log(LogStatus.PASS,"Resource search button is clicked- passed");
					int resSize=resCheckbxList.size();
					Random rand1 = new Random();
					int n1 = rand1.nextInt(resSize);
					if (n1==0){

						n1= n1+1;
					}
//					else if(n1==1) {
//						n1=n1+1;
//					}	
					cl_click(w.findElement(By.xpath(resCheckbox.replace("#DELIM#",String.valueOf(n1)))));
					cl_click(submitRes);
					Thread.sleep(4000);
					et =  es.startTest("Make a Request: 4207");
					et.log(LogStatus.PASS,"Resource is picked from the popup- passed");
					boolean write = writeRBtn.isSelected();
					Thread.sleep(2000);
					if(write == true) {
						System.out.println("By default write action is selected");
						et =  es.startTest("Make a Request: 4215");
						et.log(LogStatus.PASS,"By default write action is selected- passed");
					}
					if(actn.equalsIgnoreCase("Read")) {
						cl_click(readRBtn);
						et =  es.startTest("Make a Request: 4216");
						et.log(LogStatus.PASS,"Read action is clicked- passed");
						log.info("Action is to read");
					}else {

						cl_click(writeRBtn);
						et =  es.startTest("Make a Request: 4217");
						et.log(LogStatus.PASS,"Write action is clicked- passed");
						log.info("Action is to Write");
					}

					if(acessType.equalsIgnoreCase("No time limit")) {
						cl_click(noLimitRBtn);
						et.log(LogStatus.PASS,"No time limit is clicked- passed");
						log.info("Access Type is No time Limit");
					}
					else if(acessType.equalsIgnoreCase("Temporary access")) {
						cl_click(tempRBtn);
						Thread.sleep(2000);
						et.log(LogStatus.PASS,"Temporary access is clicked- passed");
						log.info("Access Type is Temporary access");
							
						((JavascriptExecutor)w).executeScript("document.getElementById('fromDay').setAttribute('value','"+fromD+"')");
						/*cl_click(fromDay);
						String date_dd_MM_yyyy[] = (fromD.split(" ")[0]).split("-");
						System.out.println(date_dd_MM_yyyy[0]);
						System.out.println(date_dd_MM_yyyy[1]);
						System.out.println(date_dd_MM_yyyy[2]);
						int yearDiff = Integer.parseInt(date_dd_MM_yyyy[2])- Calendar.getInstance().get(Calendar.YEAR);
						System.out.println(yearDiff);
						Thread.sleep(2000);
						cl_click(fromMiddleBtn);
						Thread.sleep(2000);
						cl_click(fromMonMiddleBtn);
						Thread.sleep(2000);
						if(yearDiff==0) {
							cl_click(selectYrBtn);
							Thread.sleep(2000);
						}
						if(yearDiff!=0){

				            //if you have to move next year

				            if(yearDiff>0){

				                for(int i=0;i< yearDiff;i++){

				                    System.out.println("Year Diff->"+i);

				                    fromYearNxtBtn.click();

				                }

				            }			           

				        }

						//monthList.get(Integer.parseInt(date_dd_MM_yyyy[1])-1).click();


						//cl_click(monthList.get(Integer.parseInt(date_dd_MM_yyyy[1])));
						Thread.sleep(2000);
						cl_click(dayList.get(Integer.parseInt(date_dd_MM_yyyy[0])-1));*/

						cl_click(fromTime);
						/*String[] time1 = fromT.split(":");
						String[] time2 = time1[1].split(" ");
						System.out.println(time1[0]);

						System.out.println(time2[0]);
						System.out.println(time2[1]);
						String ch=displyedHr.getText();
						String cm=displayedMin.getText();
						String cAMPM=displayedAMPM.getText();
						System.out.println(ch);
						System.out.println(cm);
						System.out.println(cAMPM);*/

						cl_click(displyedHrDec);
						Thread.sleep(1000);
						cl_click(displyedHrInc);
						Thread.sleep(1000);
						cl_click(displayedMinDec);
						Thread.sleep(1000);
						cl_click(displayedMinInc);
						Thread.sleep(1000);
						cl_click(displayedAMPMDec);
						Thread.sleep(1000);
						cl_click(displayedAMPMInc);
						Thread.sleep(1000);

						cl_click(toTime);
						cl_click(displyedHrDec);
						cl_click(displyedHrInc);
						cl_click(displayedMinDec);
						cl_click(displayedMinInc);
						cl_click(displayedAMPMDec);
						cl_click(displayedAMPMInc);
					}

					Select s3=new Select(transParamtr);
					s3.selectByVisibleText(transParam);
					et.log(LogStatus.PASS,"Trans Parameter is selected from dropdown- passed");
					Select s4=new Select(priorityID);
					s4.selectByVisibleText(prio);
					et.log(LogStatus.PASS,"Priority is selected from dropdown- passed");
					cl_entertext(amountVal, amtVal);
					et.log(LogStatus.PASS,"Amount value is entered- passed");
					cl_entertext(reason, reasn);
					Thread.sleep(5000);
					et.log(LogStatus.PASS,"Reason is entered- passed");
					cl_click(submitBtn);
					Thread.sleep(3000);
					et.log(LogStatus.PASS,"Make a request for resource,submit button is clicked- passed");
					log.info("Make a request for Myself,Request Type Resource is submitted");
					try {
					String msg=succesMsg.getText();
					cl_click(closeWindowAlert);
					Thread.sleep(3000);
					et.log(LogStatus.PASS,"Success message popup close button is clicked- passed");
					Utility.comparelogic(msg, shtname, scriptname);				
					}
					catch(Exception e) {
						String msg=errorMsg.getText();
						System.out.println("Error Msg: "+msg);
						et =  es.startTest("Make a Request Already Exist");
						log.info("Make a request for Myself,Request Type Resource is already Exist");
						et.log(LogStatus.PASS,"Make a request for Myself,Request Type Resource is already Exist");
						cl_click(closeWindowAlert);
						Thread.sleep(3000);
						et.log(LogStatus.PASS,"Already exist message popup close button is clicked- passed");
					}
					/*String wkdays=Utility.getpropertydetails("MyslfResWkDays");
							String fromD=Utility.getpropertydetails("MyslfResFromDate");
							String toD=Utility.getpropertydetails("MyslfResToDate");
							String fromT=Utility.getpropertydetails("MyslfResFromTime");
							String toT=Utility.getpropertydetails("MyslfResToTime");
							cl_click(submitBtn);
							Thread.sleep(3000);
							String msg=succesMsg.getText();
							Utility.comparelogic(msg, shtname, scriptname);
							cl_click(closeWindowAlert);*/

				}

			}
		}
	}

	public void makeARequestOtherGroup(String reqFor,String usrName, String reqType, String selectGrp, String prio, String reasn, String scriptname, String shtname) throws Exception {
		cl_click(MakeRequest);
		if(reqFor.equalsIgnoreCase("Others")) {
			cl_click(otherRadioBtn);
			log.info("Request for Others");
			cl_entertext(userNameDiv, usrName);
			et =  es.startTest("MakeARequest Group(Others): 4153");
			et.log(LogStatus.PASS,"Username is entered- passed");
			Select s1=new Select(requestType);
			s1.selectByVisibleText(reqType);
			if(reqType.equalsIgnoreCase("Group")) {
				et =  es.startTest("Make a Request Others: 4193");
				et.log(LogStatus.PASS,"Request type Group is selected- passed");
				Select s2=new Select(selectGroup);
				s2.selectByVisibleText(selectGrp);
				et =  es.startTest("Make a Request Others: 4195");
				et.log(LogStatus.PASS,"Group is selected from the dropdown- passed");
				log.info("Request Type is group");
				Select s3=new Select(priorityID);
				s3.selectByVisibleText(prio);
				et.log(LogStatus.PASS,"Priority is selected from dropdown- passed");
				cl_entertext(reason, reasn);
				et.log(LogStatus.PASS,"Reason is entered- passed");
				cl_click(submitBtn);
				Thread.sleep(3000);
				et.log(LogStatus.PASS,"Make a request for others,Request Type Group,submit button is clicked- passed");
				log.info("Make a request for others,Request Type Group is submitted");
				try {
				String msg=succesMsg.getText();
				cl_click(closeWindowAlert);
				Thread.sleep(2000);
				et.log(LogStatus.PASS,"Success message popup close button is clicked- passed");
				Utility.comparelogic(msg, shtname, scriptname);
				}
				catch(Exception e) {
					String msg=errorMsg.getText();
					System.out.println("Error Msg: "+msg);
					et =  es.startTest("Make a Request Already Exist");
					log.info("Make a request for Others,Request Type Group is already Exist");
					et.log(LogStatus.PASS,"Make a request for Others,Request Type Group is already Exist");
					cl_click(closeWindowAlert);
					Thread.sleep(3000);
					et.log(LogStatus.PASS,"Already exist message popup close button is clicked- passed");
				}
				
			}
		}
	}

	public void makeARequestOtherResource(String reqFor,String usrName,String reqType,String app,String resType,String res,String actn,String acessType,String transParam,String amtVal,String prio,String reasn,String wkdays,String fromD,String toD,String fromT,String toT,String scriptname,String shtname) throws Exception {
		cl_click(MakeRequest);
		Thread.sleep(2000);
		if(reqFor.equalsIgnoreCase("Others")) {
			cl_click(otherRadioBtn);
			log.info("Request for Others");
			cl_entertext(userNameDiv, usrName);		
			Select s1=new Select(requestType);
			s1.selectByVisibleText(reqType);
			if(reqType.equalsIgnoreCase("Resource")) {
				et =  es.startTest("MakeARequest Resource(Others): 4161");
				et.log(LogStatus.PASS,"Request type Resource is selected- passed");
				cl_entertext(appName, app);
				cl_click(appNameSearchBtn);
				Thread.sleep(3000);
				log.info("Request Type is Resource");
				et =  es.startTest("Make a Request Others: 4196");
				et.log(LogStatus.PASS,"App Name search button is clicked- passed");
				int size=appCheckbxList.size();
				Random rand = new Random();
				int n = rand.nextInt(size);
				if (n==0){

					n= n+2;
				}
				else if(n==1) {
					n=n+1;
				}				
				cl_click(w.findElement(By.xpath(appCheckbox.replace("#DELIM#",String.valueOf(n)))));
				cl_click(submitApp);
				et =  es.startTest("Make a Request Others: 4198");
				et.log(LogStatus.PASS,"App Name is picked from the popup- passed");
				Select s2=new Select(resourceType);
				s2.selectByVisibleText(resType);
				Thread.sleep(2000);
				et =  es.startTest("Make a Request Others: 4203");
				et.log(LogStatus.PASS,"Resource type is selected from dropdown- passed");
				cl_entertext(resName, res);

				cl_click(resNameSearchBtn);
				Thread.sleep(2000);
				et =  es.startTest("Make a Request Others: 4205");
				et.log(LogStatus.PASS,"Resource search button is clicked- passed");
				int resSize=resCheckbxList.size();
				Random rand1 = new Random();
				int n1 = rand1.nextInt(resSize);
				if (n1==0){

					n1= n1+1;
				}
//				else if(n1==1) {
//					n1=n1+1;
//				}	
				cl_click(w.findElement(By.xpath(resCheckbox.replace("#DELIM#",String.valueOf(n1)))));
				cl_click(submitRes);
				Thread.sleep(4000);
				et =  es.startTest("Make a Request Others: 4207");
				et.log(LogStatus.PASS,"Resource is picked from the popup- passed");
				boolean write = writeRBtn.isSelected();
				Thread.sleep(2000);
				if(write == true) {
					System.out.println("By default write action is selected");
					et =  es.startTest("Make a Request Others: 4215");
					et.log(LogStatus.PASS,"By default write action is selected- passed");
				}
				if(actn.equalsIgnoreCase("Read")) {	
					cl_click(readRBtn);
					et =  es.startTest("Make a Request Others: 4216");
					et.log(LogStatus.PASS,"Read action is clicked- passed");
				}else {
					cl_click(writeRBtn);
					et =  es.startTest("Make a Request Others: 4217");
					et.log(LogStatus.PASS,"Write action is clicked- passed");
				}

				if(acessType.equalsIgnoreCase("No time limit")) {
					cl_click(noLimitRBtn);
					et.log(LogStatus.PASS,"No time limit is clicked- passed");
					log.info("Access Type is No time limit");
				}
				else if(acessType.equalsIgnoreCase("Temporary access")) {
					cl_click(tempRBtn);
					Thread.sleep(2000);
					et.log(LogStatus.PASS,"Temporary access is clicked- passed");
					log.info("Access Type is Temporary access");
					cl_click(fromDay);
					cl_click(selectFDate);
					Thread.sleep(2000);
					cl_click(fromMonMiddleBtn);

					/*((JavascriptExecutor)w).executeScript("document.getElementById('fromDay').setAttribute('value','"+fromD+"')");
								((JavascriptExecutor)w).executeScript("document.getElementById('toDay').setAttribute('value','"+toD+"')");
								((JavascriptExecutor)w).executeScript("document.getElementById('timepicker3').setAttribute('value','"+fromT+"')");
								((JavascriptExecutor)w).executeScript("document.getElementById('timepicker4').setAttribute('value','"+toT+"')");*/
				}

				Select s3=new Select(transParamtr);
				s3.selectByVisibleText(transParam);
				et.log(LogStatus.PASS,"Trans Parameter is selected from dropdown- passed");
				Select s4=new Select(priorityID);
				s4.selectByVisibleText(prio);
				et.log(LogStatus.PASS,"Priority is selected from dropdown- passed");
				cl_entertext(amountVal, amtVal);
				et.log(LogStatus.PASS,"Amount value is entered- passed");
				cl_entertext(reason, reasn);
				Thread.sleep(3000);
				et.log(LogStatus.PASS,"Reason is entered- passed");
				cl_click(submitBtn);
				Thread.sleep(3000);
				et.log(LogStatus.PASS,"Make a request for resource,submit button is clicked- passed");
				log.info("Make a request for others,Request Type Resource is submitted");
				try {
				String msg=succesMsg.getText();
				cl_click(closeWindowAlert);
				Thread.sleep(3000);
				et.log(LogStatus.PASS,"Success message popup close button is clicked- passed");
				Utility.comparelogic(msg, shtname, scriptname);				
			}
			catch(Exception e) {
				String msg=errorMsg.getText();
				System.out.println("Error Msg: "+msg);
				et =  es.startTest("Make a Request Already Exist");
				log.info("Make a request for Others,Request Type Resource is already Exist");
				et.log(LogStatus.PASS,"Make a request for Others,Request Type Resource is already Exist");
				cl_click(closeWindowAlert);
				Thread.sleep(3000);
				et.log(LogStatus.PASS,"Already exist message popup close button is clicked- passed");
			}



			}
		}
	}
}
