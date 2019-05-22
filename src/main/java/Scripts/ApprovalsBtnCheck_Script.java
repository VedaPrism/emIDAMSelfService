package Scripts;

import java.util.Map;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import Generic_Library.Basefunctions;
import Page_Factory.pf_ApprovalsPage;

public class ApprovalsBtnCheck_Script extends Basefunctions {

	final static Logger log = Logger.getLogger(ApprovalsBtnCheck_Script.class);
	
	@Test(dataProvider= "approval_Page",dataProviderClass=Dataproviders.dp_login.class,enabled=true,priority=1,groups={"SMK","REG"})
	public void approvalPageBtn(Map hm) throws Exception{	
		tcid = hm.get("TC_ID").toString();
		order=hm.get("Order").toString();
		String scriptname=hm.get("Script_Name").toString();
		String remrk=hm.get("Remarks").toString();
		String delgteUN=hm.get("DelegateUserName").toString();
		String delgteResn=hm.get("DeleagteReason").toString();
		String shtname="Approvals";
		pf_ApprovalsPage p=new pf_ApprovalsPage(w);
		if(scriptname.equalsIgnoreCase("approveErrorMsg")) {
			et =  es.startTest("Approve Button");
			p.approveWithoutRcrd(shtname,scriptname);
		}
		else if(scriptname.equalsIgnoreCase("delegateErrorMsg")) {
			et =  es.startTest("Delegate Button");
			p.delegateWithoutRcrd(shtname,scriptname);
		}
		else if(scriptname.equalsIgnoreCase("RejectErrorMsg")) {
			et =  es.startTest("Reject Button");
			p.RejectWithoutRcrd(shtname,scriptname);
		}
		
		else if(scriptname.equalsIgnoreCase("approveSingleRcrd")) {
			et =  es.startTest("Approve Single Record");
			p.approveWithSingleRcrd(shtname,scriptname);
		}
		else if(scriptname.equalsIgnoreCase("delegateSingleRcrd")) {
			et =  es.startTest("Delegate Single Record");
			p.delegateWithSingleRcrd(delgteUN,delgteResn,shtname,scriptname);
		}
		else if(scriptname.equalsIgnoreCase("rejectSingleRcrd")) {
			et =  es.startTest("Reject Single Record");
			p.rejectWithSingleRcrd(remrk,shtname,scriptname);
		}
		else if(scriptname.equalsIgnoreCase("approveMultipleRcrd")) {
			et =  es.startTest("Approve Multiple Record");
			p.approveWithMultpleRcrd(shtname,scriptname);
		}
		else if(scriptname.equalsIgnoreCase("delegateMultipleRcrd")) {
			et =  es.startTest("Delegate Multiple Record");
			p.delegateWithMultpleRcrd(delgteUN,delgteResn,shtname,scriptname);
		}
		else if(scriptname.equalsIgnoreCase("rejectMultipleRcrd")) {
			et =  es.startTest("Reject Multiple Record");
			p.rejectWithMultpleRcrd(remrk,shtname,scriptname);
		}
	}

}
