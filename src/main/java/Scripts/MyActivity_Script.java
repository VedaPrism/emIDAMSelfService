package Scripts;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import Generic_Library.Basefunctions;
import Page_Factory.pf_myActivityPage;

public class MyActivity_Script extends Basefunctions {
	final static Logger log = Logger.getLogger(MyActivity_Script.class);

	@Test(enabled=true,priority=1,groups={"SMK","REG"})
	public void myActivity() throws Exception{		
		pf_myActivityPage actvty=new pf_myActivityPage(w);
		et =  es.startTest("My Activity");		
		actvty.myactivity();
		
	}
}
