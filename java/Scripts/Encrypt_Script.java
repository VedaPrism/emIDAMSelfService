package Scripts;


import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.Test;

import Generic_Library.Basefunctions;
import Page_Factory.pf_EncryptPage;
import Page_Factory.pf_Settings;
import Page_Factory.pf_loginpage;

public class Encrypt_Script extends Basefunctions {
	
	final static Logger log = Logger.getLogger(Encrypt_Script.class);
		
	@Test(dataProvider= "valid_login",dataProviderClass=Dataproviders.dp_login.class,enabled=true,priority=1,groups={"SMK","REG"})
	public void Login(Map hm) throws Exception{		
		//login
		PropertyConfigurator.configure(System.getProperty("user.dir") + "\\src\\main\\resources\\log4j.properties");
		
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

	@Test(enabled=true,priority=2,groups={"SMK","REG"})
	public void settingPage() throws Exception{
		pf_Settings set=new pf_Settings(w);
		set.settings();
	}
	@Test(dataProvider= "Encrypt_Page",dataProviderClass=Dataproviders.dp_login.class,enabled=true,priority=3,groups={"SMK","REG"})
	public void EncryptPage(Map hm) throws Exception{
		
		
		String scriptname=hm.get("Script_Name").toString();
		tcid = hm.get("TC_ID").toString();
		order=hm.get("Order").toString();
		String sheetName ="Encrypt";

		pf_EncryptPage encrypt=new pf_EncryptPage(w);

		
		/*if(scriptname.equals("CancelBtnLndngPage")){
			//click on Encrypt button and Verify cancel button
			et =  es.startTest("Encrypt: "+tcid+"_" + order + "_" + browser_type);
			encrypt.verifyEncryptCancelBtn(sheetName,scriptname);
			pf_Settings set=new pf_Settings(w);
			set.settings();
		}*/

		 if(scriptname.equals("EncryptNowBtnMsg")){
			et =  es.startTest("Encrypt: "+tcid+"_" + order + "_" + browser_type);
			encrypt.verifyEncrypt(sheetName,scriptname);
		}

		else if(scriptname.equals("EncryptNowBtnDestMsg")){
			et =  es.startTest("Encrypt: "+tcid+"_" + order + "_" + browser_type);
			//verifying browse document by passing source
			encrypt.encryptNow(sheetName,scriptname);
		}

		else if(scriptname.equals("EncryptNowBtnCMsg")){
			et =  es.startTest("Encrypt: "+tcid+"_" + order + "_" + browser_type);
			//verifying browse document by passing source,dest path
			encrypt.encryptNowSourceDest(sheetName,scriptname);
		}

		else if(scriptname.equals("EncryptNowSuccess")){
			et =  es.startTest("Encrypt: "+tcid+"_" + order + "_" + browser_type);
			//verifying browse document by passing source,dest,certificate folder path
			encrypt.encryptNowSourceDestCert(sheetName,scriptname);
		}


	}
}
