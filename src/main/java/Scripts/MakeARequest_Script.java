package Scripts;

import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.Test;

import Generic_Library.Basefunctions;
import Page_Factory.pf_makeaRequestPage;

public class MakeARequest_Script extends Basefunctions{
	final static Logger log = Logger.getLogger(MakeARequest_Script.class);

	@Test(dataProvider= "makeARequest_Page",dataProviderClass=Dataproviders.dp_login.class,enabled=true,priority=1,groups={"SMK","REG"})
	public void makeRequest(Map hm) throws Exception{	
		PropertyConfigurator.configure(System.getProperty("user.dir") + "\\src\\main\\resources\\log4j.properties");
		//login

		tcid = hm.get("TC_ID").toString();
		order=hm.get("Order").toString();
		String scriptname=hm.get("Script_Name").toString();
		String reqFor=hm.get("Request_For").toString();
		String usrName=hm.get("Username").toString();
		String reqType=hm.get("Request_Type").toString();
		String selectGrp=hm.get("Select_Group").toString();
		String prio=hm.get("Priority").toString();
		String reasn=hm.get("Reason").toString();
		String app=hm.get("App").toString();
		String resType=hm.get("Resource_Type").toString();
		String res=hm.get("Resource").toString();
		String transParam=hm.get("Transaction_Parameter").toString();
		String amtVal=hm.get("Amount").toString();
		String amtsymbl=hm.get("AmtSymbl").toString();		
		String actn=hm.get("Actions").toString();
		String acessType=hm.get("Access_type").toString();
		
		String wkdays=hm.get("Week_days").toString();
		String fromD=hm.get("FromDate").toString();
		String toD=hm.get("ToDate").toString();
		String fromT=hm.get("TimeFrom").toString();
		String toT=hm.get("TimeTo").toString();
		
		String shtname="MakeARequest";
		pf_makeaRequestPage makeReq=new pf_makeaRequestPage(w);
		log.info("this is login information");
		if(scriptname.equalsIgnoreCase("ReqMyselfGroup")) {
			makeReq.makeARequestGroup(reqFor,reqType,selectGrp,prio,reasn,scriptname,shtname);
		}
		else if(scriptname.equalsIgnoreCase("ReqMyselfResource")) {
			makeReq.makeARequestResource(reqFor,reqType,app,resType,res,actn,acessType,transParam,amtVal,prio,reasn,wkdays,fromD,toD,fromT,toT,scriptname,shtname);
		}
		else if(scriptname.equalsIgnoreCase("ReqOthersGroup")) {
			makeReq.makeARequestOtherGroup(reqFor,usrName,reqType,selectGrp,prio,reasn,scriptname,shtname);
		}
		else if(scriptname.equalsIgnoreCase("ReqMyselfOtherResource")) {
			makeReq.makeARequestOtherResource(reqFor,usrName,reqType,app,resType,res,actn,acessType,transParam,amtVal,prio,reasn,wkdays,fromD,toD,fromT,toT,scriptname,shtname);
		}
		

		}
}
