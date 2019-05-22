package Scripts;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import Generic_Library.Basefunctions;
import Page_Factory.pf_MyAccessPage;

public class MyAccess_Script extends Basefunctions {

	final static Logger log = Logger.getLogger(MyAccess_Script.class);

	@Test(enabled=true,priority=1,groups={"SMK","REG"})
	public void myAccess() throws Exception{	
		log.info("--My Access--");
		et =  es.startTest("My Access");
		pf_MyAccessPage access=new pf_MyAccessPage(w);
		access.myaccess();
	}
	
	@Test(enabled=true,priority=2,groups={"SMK","REG"})
	public void myAccessGrid() throws Exception{	
		log.info("--My Access Grid--");
		et =  es.startTest("My Access Grid View");
		pf_MyAccessPage access=new pf_MyAccessPage(w);
		access.myaccessGridView();
	}
}
