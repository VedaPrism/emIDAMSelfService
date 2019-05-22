package Scripts;

import java.util.Map;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import Generic_Library.Basefunctions;
import Page_Factory.pf_profilePage;

public class Profile_Script extends Basefunctions {

	final static Logger log = Logger.getLogger(Profile_Script.class);

	@Test(dataProvider= "profile_Page",dataProviderClass=Dataproviders.dp_login.class,enabled=true,priority=1,groups={"SMK","REG"})
	public void profileDetail(Map hm) throws Exception{	
	
		pf_profilePage p=new pf_profilePage(w);
		tcid = hm.get("TC_ID").toString();
		order=hm.get("Order").toString();
		String scriptname=hm.get("Script_Name").toString();
		String shtname="Profile";
		et =  es.startTest("Profile");
		if(scriptname.equalsIgnoreCase("profileUpdate")) {
		p.profileDetails(shtname,scriptname);
		}
	}
	
	/*@Test(enabled=true,priority=2,groups={"SMK","REG"})
	public void autodelegation() throws Exception{	
	
		pf_profilePage p=new pf_profilePage(w);
		p.autoDelegation();
	}*/
}
