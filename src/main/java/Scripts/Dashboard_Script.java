package Scripts;

import java.util.Map;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import Generic_Library.Basefunctions;
import Page_Factory.pf_DashboardPage;

public class Dashboard_Script extends Basefunctions {

	final static Logger log = Logger.getLogger(Dashboard_Script.class);

	@Test(enabled=true,priority=1,groups={"SMK","REG"})
	public void dashbordDetail() throws Exception{	

		pf_DashboardPage d=new pf_DashboardPage(w);
		et =  es.startTest("Dashboard Details");
		d.dashboardDetails();
	}

	@Test(dataProvider= "dashboard_Page",dataProviderClass=Dataproviders.dp_login.class,enabled=true,priority=2,groups={"SMK","REG"})
	public void dashbordPendingDetail(Map hm) throws Exception{	
		tcid = hm.get("TC_ID").toString();
		order=hm.get("Order").toString();
		String scriptname=hm.get("Script_Name").toString();
		String shtname="Dashboard";
		pf_DashboardPage d=new pf_DashboardPage(w);
		if(scriptname.equalsIgnoreCase("deletePendingReq")) {
			et =  es.startTest("Pending Status");
			d.deletependingStatus(shtname,scriptname);
		}
		/*if(scriptname.equalsIgnoreCase("editPendingReq")) {
			d.editpendingStatus(shtname,scriptname);
		}*/
	}

	@Test(enabled=true,priority=3,groups={"SMK","REG"})
	public void dashbordRejectedDetail() throws Exception{	

		pf_DashboardPage d=new pf_DashboardPage(w);
		et =  es.startTest("Reject Status");
		d.rejectedStatus();
	}


	@Test(enabled=true,priority=4,groups={"SMK","REG"})
	public void dashbordApprveDetail() throws Exception{	

		pf_DashboardPage d=new pf_DashboardPage(w);
		et =  es.startTest("Approved Status");
		d.approvedStatus();
	}
	
	@Test(enabled=true,priority=5,groups={"SMK","REG"})
	public void dashbordCancelDetail() throws Exception{	

		pf_DashboardPage d=new pf_DashboardPage(w);
		et =  es.startTest("Cancel Status");
		d.cancelStatus();
	}
	 }
