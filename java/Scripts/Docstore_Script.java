package Scripts;

import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.Test;

import Generic_Library.Basefunctions;
import Page_Factory.pf_DocstorePage;
import Page_Factory.pf_Settings;
import Page_Factory.pf_loginpage;

public class Docstore_Script extends Basefunctions {
	
	final static Logger log = Logger.getLogger(Docstore_Script.class);
	
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
	public static void docStore() throws Exception{	
		
		pf_DocstorePage docstore=new pf_DocstorePage(w);
		docstore.clickDocstore();
		
		//docstore.uploadDocument();
		docstore.exportToExcel();
		docstore.actionSettings();
		
	}
}
