package Scripts;


import java.io.File;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.Test;

import Generic_Library.Basefunctions;
import Generic_Library.Utility;
import Page_Factory.pf_form16SigningPage;
import Page_Factory.pf_loginpage;

public class Form16Sign_Script extends Basefunctions {

	final static Logger log = Logger.getLogger(Form16Sign_Script.class);
	
	@Test(dataProvider= "valid_login",dataProviderClass=Dataproviders.dp_login.class,enabled=true,priority=1,groups={"SMK","REG"})
	public void Login(Map hm) throws Exception{	
		PropertyConfigurator.configure(System.getProperty("user.dir") + "\\src\\main\\resources\\log4j.properties");
		//login
		
		tcid = hm.get("TC_ID").toString();
		order=hm.get("Order").toString();
		
		et =  es.startTest("Login: "+tcid+"_" + order + "_" + browser_type);
		log.info("this is login information");
		String uid = hm.get("Uname").toString();
		String pas = hm.get("Pwd").toString();
		pf_loginpage pl = new pf_loginpage(w);
		
		log.info("Username picked from Excel is "+uid);
		log.info("Username picked from Excel is "+pas);
		pl.logincredentials(uid, pas );
		log.info("Logged in successfully");
		
	}

	@Test(dataProvider= "Form16_sign",dataProviderClass=Dataproviders.dp_login.class,enabled=true,priority=2,groups={"SMK","REG"})
	public void Form16Sign1(Map hm) throws Exception{

		
		String scriptname=hm.get("Script_Name").toString();
		tcid = hm.get("TC_ID").toString();
		order=hm.get("Order").toString();


		String sheetName ="Form16";

		pf_form16SigningPage form16=new pf_form16SigningPage(w);

		if(scriptname.equals("Continueclick")) {
			et =  es.startTest("Form16: "+tcid+"_" + order + "_" + browser_type);
			form16.form16Signing(sheetName,scriptname);
			
		}
		//uploading non PDF file
		else if(scriptname.equals("uploadNonPDF")) {
			et =  es.startTest("Form16: "+tcid+"_" + order + "_" + browser_type);
			File f1=new File(Utility.getpropertydetails("nonPDF"));
			String path=f1.getAbsolutePath();
			form16.uploadNonPDF(path,sheetName,scriptname);
		}		
		//uploading PDF file
		else if(scriptname.equals("saveBtnMsg")) {
			File f2=new File(Utility.getpropertydetails("PDF"));
			String pdfpath=f2.getAbsolutePath();
			form16.uploadPDF(pdfpath,sheetName,scriptname);
		}

		//verify select page in template setting
		else if(scriptname.equals("crossBtnMsg")) {
			form16.verifySelectPage(sheetName,scriptname);
		}
		
		else if (scriptname.equals("browseContinueMsg")) {
			//upload document
			form16.uploadDocument();

			form16.browseDocIsDisplayed();
			
			//verifing browse doc continue btn
			form16.browseContinue(sheetName,scriptname);
		}

		else if(scriptname.equals("folderAcBtn")) {
			//verifing browse doc continue btn by passing part A path
			form16.browseAContinue(sheetName,scriptname);
		}

		else if(scriptname.equals("folderABcBtn")) {
			//verifing browse doc continue btn by passing part A and part B path
			form16.browseABContinue(sheetName,scriptname);
		}

		else if(scriptname.equals("folderABDcBtn")) {
			//verifing browse doc continue btn by passing part A and part B and destination path
			form16.browseABDestContinue(sheetName,scriptname);
		}
		/*//email option by selecting only emSignerSMTP and from address
		String fromAddress=Utility.getpropertydetails("FromAdd");
		String subject=Utility.getpropertydetails("Subject");
		form16.verifyemSignerSMTP(fromAddress,subject,sheetName);

		//email option by selecting Other SMTP and from address
		form16.verifyOtherSMTP(subject,sheetName);*/


	}
}

