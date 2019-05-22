package Scripts;

import java.util.Map;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import Generic_Library.Basefunctions;
import Page_Factory.pf_ApprovalsPage;
import Page_Factory.pf_DashboardPage;


public class Approvals_Script extends Basefunctions {

	final static Logger log = Logger.getLogger(Approvals_Script.class);
	
	@Test(dataProvider= "approval_Page",dataProviderClass=Dataproviders.dp_login.class,enabled=true,priority=1,groups={"SMK","REG"})
	public void approval(Map hm) throws Exception{	
		tcid = hm.get("TC_ID").toString();
		order=hm.get("Order").toString();
		String scriptname=hm.get("Script_Name").toString();
		String remrk=hm.get("Remarks").toString();
		String delgteUN=hm.get("DelegateUserName").toString();
		String delgteResn=hm.get("DeleagteReason").toString();
		String shtname="Approvals";
		pf_ApprovalsPage p=new pf_ApprovalsPage(w);
		if(scriptname.equalsIgnoreCase("approvals")) {
			p.pendingStatus(remrk,delgteUN,delgteResn,shtname,scriptname);
		}
	}
	
	/*@Test(enabled=true,priority=2,groups={"SMK","REG"})
	public void approved() throws Exception{	
	
		pf_ApprovalsPage p=new pf_ApprovalsPage(w);
		p.approvedStatus();
	}*/
	
	/*@Test(enabled=true,priority=3,groups={"SMK","REG"})
	public void rejected() throws Exception{	
	
		pf_ApprovalsPage p=new pf_ApprovalsPage(w);
		p.rejectedStatus();
	}
	
	@Test(enabled=true,priority=4,groups={"SMK","REG"})
	public void delegated() throws Exception{	
	
		pf_ApprovalsPage p=new pf_ApprovalsPage(w);
		p.delegatedStatus();
	}*/
}
