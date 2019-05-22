package Scripts;

import java.util.Map;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import Generic_Library.Basefunctions;
import Page_Factory.pf_ReviewAccessPage;


public class ReviewAccess_Script extends Basefunctions {

	final static Logger log = Logger.getLogger(ReviewAccess_Script.class);

	/*@Test(enabled=true,priority=1,groups={"SMK","REG"})
	public void pending() throws Exception{	
		et =  es.startTest("Review Access Pending status");
		pf_ReviewAccessPage p=new pf_ReviewAccessPage(w);	
			p.pendingStatus();
			
	}

	@Test(enabled=true,priority=2,groups={"SMK","REG"})
	public void rejected() throws Exception{	
		et =  es.startTest("Review Access Reject status");
		pf_ReviewAccessPage p=new pf_ReviewAccessPage(w);
		p.rejectedStatus();
	}

	@Test(enabled=true,priority=3,groups={"SMK","REG"})
	public void approved() throws Exception{	
		et =  es.startTest("Review Access Approved status");
		pf_ReviewAccessPage p=new pf_ReviewAccessPage(w);
		p.approvedStatus();
	}

	@Test(enabled=true,priority=4,groups={"SMK","REG"})
	public void expired() throws Exception{	
		et =  es.startTest("Review Access Expired status");
		pf_ReviewAccessPage p=new pf_ReviewAccessPage(w);
		p.expiredStatus();
	}
	
	@Test(enabled=true,priority=5,groups={"SMK","REG"})
	public void delegate() throws Exception{	
		et =  es.startTest("Review Access Delegate status");
		pf_ReviewAccessPage p=new pf_ReviewAccessPage(w);
		p.delegateStatus();
	}*/
	
	/*@Test(dataProvider= "reviewAccess_Page",dataProviderClass=Dataproviders.dp_login.class,enabled=true,priority=6,groups={"SMK","REG"})
	public void pendingApprove(Map hm) throws Exception{	
		tcid = hm.get("TC_ID").toString();
		order=hm.get("Order").toString();
		String scriptname=hm.get("Script_Name").toString();
		String shtname="ReviewAccess";
		et =  es.startTest("Review Access Pending Rcrd-Approve");
		pf_ReviewAccessPage p=new pf_ReviewAccessPage(w);
		if(scriptname.equalsIgnoreCase("apprveRequest")) {
			p.pendingSingleRcrdApprove(shtname,scriptname);
		}
	}
	
	@Test(dataProvider= "reviewAccess_Page",dataProviderClass=Dataproviders.dp_login.class,enabled=true,priority=7,groups={"SMK","REG"})
	public void pendingMultiApprove(Map hm) throws Exception{	
		tcid = hm.get("TC_ID").toString();
		order=hm.get("Order").toString();
		String scriptname=hm.get("Script_Name").toString();
		String shtname="ReviewAccess";
		pf_ReviewAccessPage p=new pf_ReviewAccessPage(w);
		if(scriptname.equalsIgnoreCase("apprveMultiRequest")) {
		//	p.pendingSingleRcrdApprove(shtname,scriptname);
			p.pendingMultiRcrdApprove(shtname,scriptname);
		}
	}*/
	

	@Test(dataProvider= "reviewAccess_Page",dataProviderClass=Dataproviders.dp_login.class,enabled=true,priority=8,groups={"SMK","REG"})
	public void pendingDelegate(Map hm) throws Exception{	
		tcid = hm.get("TC_ID").toString();
		order=hm.get("Order").toString();
		String scriptname=hm.get("Script_Name").toString();
		String shtname="ReviewAccess";
		String username=hm.get("DelegateUsername").toString();
		String reason=hm.get("DelegateReason").toString();
		et =  es.startTest("Review Access Pending Rcrd-Delegate");
		pf_ReviewAccessPage p=new pf_ReviewAccessPage(w);
		if(scriptname.equalsIgnoreCase("delegateRequest")) {
			p.pendingSingleRcrdDelegate(username,reason,shtname,scriptname);
		}
	}
	
	@Test(dataProvider= "reviewAccess_Page",dataProviderClass=Dataproviders.dp_login.class,enabled=true,priority=9,groups={"SMK","REG"})
	public void pendingMultiDelegate(Map hm) throws Exception{	
		tcid = hm.get("TC_ID").toString();
		order=hm.get("Order").toString();
		String scriptname=hm.get("Script_Name").toString();
		String shtname="ReviewAccess";
		String username=hm.get("DelegateUsername").toString();
		String reason=hm.get("DelegateReason").toString();
		et =  es.startTest("Review Access Pending Rcrd-Delegate");
		pf_ReviewAccessPage p=new pf_ReviewAccessPage(w);
		if(scriptname.equalsIgnoreCase("delegateMultiRequest")) {
			p.pendingMutlipleRcrdDelegate(username,reason,shtname,scriptname);
		}
	}

}
