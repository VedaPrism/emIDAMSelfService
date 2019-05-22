package Scripts;

import java.util.Map;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import Generic_Library.Basefunctions;
import Page_Factory.pf_AuthenticationPage;
import Page_Factory.pf_DashboardPage;
import Page_Factory.pf_LoginPage;

public class AuthenticationType_Script extends Basefunctions {

	final static Logger log = Logger.getLogger(AuthenticationType_Script.class);
	
	/*@Test(dataProvider= "authenticType_Page",dataProviderClass=Dataproviders.dp_login.class,enabled=true,priority=1,groups={"SMK","REG"})
	public void authenticationType(Map hm) throws Exception{	
		tcid = hm.get("TC_ID").toString();
		order=hm.get("Order").toString();
		String scriptname=hm.get("Script_Name").toString();
		String crntPass=hm.get("Current_Pass").toString();
		String newPass=hm.get("New_Pass").toString();
		String cnfrmPass=hm.get("Confrm_Pass").toString();
		String uid=hm.get("Uname").toString();
		
		
		String shtname="AuthenticType";
		pf_AuthenticationPage d=new pf_AuthenticationPage(w);
		if(scriptname.equalsIgnoreCase("changePassword")) {
			d.authenticChangePw(crntPass,newPass,cnfrmPass,shtname,scriptname);
			pf_LoginPage pl = new pf_LoginPage(w);
			pl.logincredentials(uid,cnfrmPass);
			
		}
	}
	
	@Test(dataProvider= "authenticType_Page",dataProviderClass=Dataproviders.dp_login.class,enabled=true,priority=2,groups={"SMK","REG"})
	public void authenticationTypeMobileNo(Map hm) throws Exception{	
		tcid = hm.get("TC_ID").toString();
		order=hm.get("Order").toString();
		String scriptname=hm.get("Script_Name").toString();
		String crntNumber=hm.get("Current_MobileNo").toString();
		String newNumber=hm.get("New_MobileNo").toString();
				
		String shtname="AuthenticType";
		pf_AuthenticationPage d=new pf_AuthenticationPage(w);
		if(scriptname.equalsIgnoreCase("changeMobileNo")) {
			d.authenticChangeMobileNo(crntNumber,newNumber,shtname,scriptname);						
		}
	}
	
	@Test(dataProvider= "authenticType_Page",dataProviderClass=Dataproviders.dp_login.class,enabled=true,priority=3,groups={"SMK","REG"})
	public void authenticationTypeEmailID(Map hm) throws Exception{	
		tcid = hm.get("TC_ID").toString();
		order=hm.get("Order").toString();
		String scriptname=hm.get("Script_Name").toString();
		String crntEmail=hm.get("Current_EmailID").toString();
		String newEmail=hm.get("New_EmailID").toString();
				
		String shtname="AuthenticType";
		pf_AuthenticationPage d=new pf_AuthenticationPage(w);
		if(scriptname.equalsIgnoreCase("changeEmailID")) {
			d.authenticChangeEmailID(crntEmail,newEmail,shtname,scriptname);						
		}
	}*/
	
	@Test(enabled=true,priority=4,groups={"SMK","REG"})
	public void authenticationType() throws Exception{	
	
		pf_AuthenticationPage d=new pf_AuthenticationPage(w);

		d.authenticDSC();
		
		d.authenticFIDO();

		d.authenticFngrPrint();

		d.authenticFaceRec();
	}
	
							
	@Test(dataProvider= "authenticType_Page",dataProviderClass=Dataproviders.dp_login.class,enabled=true,priority=5,groups={"SMK","REG"})
	public void authenticationTypeKBA(Map hm) throws Exception{	
		tcid = hm.get("TC_ID").toString();
		order=hm.get("Order").toString();
		String scriptname=hm.get("Script_Name").toString();
		String kbaQ1=hm.get("KBAQ1").toString();
		String kbaA1=hm.get("KBAA1").toString();
		String kbaQ2=hm.get("KBAQ2").toString();
		String kbaA2=hm.get("KBAA2").toString();
		String kbaQ3=hm.get("KBAQ3").toString();
		String kbaA3=hm.get("KBAA3").toString();
		String kbaQ4=hm.get("KBAQ4").toString();
		String kbaA4=hm.get("KBAA4").toString();
				
		String shtname="AuthenticType";
		
		pf_AuthenticationPage d=new pf_AuthenticationPage(w);
		et =  es.startTest("AuthenticationType KBA");
		if(scriptname.equalsIgnoreCase("editKBA")) {			
			d.authenticKBA(kbaQ1,kbaA1,kbaQ2,kbaA2,kbaQ3,kbaA3,kbaQ4,kbaA4,shtname,scriptname);						
		}
	}
}
