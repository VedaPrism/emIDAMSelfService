package Generic_Library;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.testng.Assert;



public class Utility {

	final static Logger log = Logger.getLogger(Utility.class);
	public static int rc;
	public static int cc;
	public static int sc;
	public static ListIterator<Object[]> dp_commonlogic(String sheetname, String scriptname) throws Exception{

		ExcelRw er = new ExcelRw(System.getProperty("user.dir")+"\\src\\main\\resources\\emASIDAM.xlsx");

		//Get the Row count and column count

		rc = er.getrowcount(sheetname);
		cc = er.getcolumncount(sheetname);

		//Creation of list object array

		List<Object[]> al = new ArrayList<Object[]>();

		for(int i=1;i<=rc;i++)
		{

			//Getting the Flag & Scriptname

			String flag = er.readvalue(i,1, sheetname);
			//System.out.println("Flag is : "+flag );

			String script = er.readvalue(i, 3, sheetname);
			//String expted = er.readvalue(i, 6, sheetname);

			scriptname = script;

			if(flag.equals("Y") && script.equalsIgnoreCase(scriptname)){

				Map<String, String> hp = new HashMap<String, String>();
				Object[] o = new Object[1];

				for(int j=0;j<cc;j++){

					String Key = er.readvalue(0, j,sheetname);
					String Value = er.readvalue(i,j, sheetname);
					hp.put(Key, Value);
				}
				o[0]=hp;
				al.add(o);
			}
		}
		return al.listIterator();
	}

	//Compare expected result from excel and actual result, if matches write actual result to excel


	public static void comparelogic(String actual,String sheetname,String scriptname) throws Exception{

		for(int i=1;i<=rc;i++){
			
			ExcelRw er = new ExcelRw(System.getProperty("user.dir")+"\\src\\main\\resources\\emASIDAM.xlsx");				
			String expted = er.readvalue(i, 6, sheetname);

			String script = er.readvalue(i, 3, sheetname);
			
			if(script.equalsIgnoreCase(scriptname)) {
				if(actual.equalsIgnoreCase(expted)) {

					log.info("Actual and expected result matches");
					System.out.println("Actual Result: "+actual +" and "+"Expected result: "+ expted +" matches" );
					er.writevalue(i, 7, sheetname, actual);	
					er.saveclose(System.getProperty("user.dir")+"\\src\\main\\resources\\emASIDAM.xlsx");
					break;
				}
			}
			else if(script.equalsIgnoreCase(scriptname)) {
				if(!actual.equalsIgnoreCase(expted)) {
					log.info("Expected result and Actual result didn't match");
					Basefunctions.getScreenshot();
					log.info("Screenshot Taken");
					System.out.println("Screenshot Taken");
					Assert.fail();
					//break;
				}
			}
			else if(!script.equalsIgnoreCase(scriptname)) {				
//					break;
			}
		}
	}

	//	Getting Property data

	public static String getpropertydetails(String Key) throws Exception{

		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\emASIDAM-Config.properties");
		Properties p = new Properties();
		p.load(fis);
		return p.getProperty(Key);
	}
}

