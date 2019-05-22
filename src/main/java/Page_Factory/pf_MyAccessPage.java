package Page_Factory;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.LogStatus;

import Generic_Library.Basefunctions;
import Scripts.Login_Script;

public class pf_MyAccessPage extends pf_genericmethods {

	Basefunctions b=new Basefunctions();
	final static Logger log = Logger.getLogger(pf_MyAccessPage.class);
	
	@FindBy(how = How.ID, using = "MyAccess") public WebElement MyAccess;

	@FindBy(how = How.XPATH, using = "//a[text()='Grid view']") public WebElement gridView;

	@FindAll({@FindBy(how = How.XPATH, using = "//div[@id='Applications']/ul/li")}) public List<WebElement> applctnCnt;
	String aplctn="//div[@id='Applications']/ul/li[#DELIM#]/div/a";

	@FindBy(how = How.XPATH, using = "//td[@id='myAccesspager_left']/table/tbody/tr/td[1]/div") public WebElement searchBtn;
	@FindBy(how = How.XPATH, using = "//td[@id='myAccesspager_left']/table/tbody/tr/td[2]/div") public WebElement clearBtn;
	
	@FindAll({@FindBy(how = How.XPATH, using = "//table[@id='myAccess']/tbody/tr[@class='jqgfirstrow']/following-sibling::tr")}) public List<WebElement> gridApplctnCnt;
	@FindBy(how = How.XPATH, using = "//table[@id='myAccess']/tbody/tr[@class='jqgfirstrow']/following-sibling::tr[1]/td[1]") public WebElement Appname;
	String aName="//table[@id='myAccess']/tbody/tr[@class='jqgfirstrow']/following-sibling::tr[#DELIM#]/td[1]";
	
	@FindBy(how = How.ID, using = "gs_appName") public WebElement searchAppName;
	
	@FindBy(how = How.XPATH, using = "//a[@href='selfservice-dashboard.htm']") public WebElement homeLink;
	
	public pf_MyAccessPage(WebDriver driver){

		PageFactory.initElements(driver, this);
	}


	public void myaccess() throws Exception {
		cl_click(MyAccess);
		log.info("My access page is displayed");
		b.getScreenshot();
		Thread.sleep(1000);
		et.log(LogStatus.PASS,"My Access present in left menu is clicked- passed");
		int size=applctnCnt.size();
		System.out.println(size);
		Random rand = new Random();
		int n = rand.nextInt(size);
		System.out.println("n"+n);
		if (n==0){

			n= n+1;
		}
		WebElement a = w.findElement(By.xpath(aplctn.replace("#DELIM#",String.valueOf(n))));
		cl_click(a);
		Thread.sleep(4000);
		et.log(LogStatus.PASS,"Application is clicked- passed");
		try {
		ArrayList<String> tabs2 = new ArrayList<String> (w.getWindowHandles());
		w.switchTo().window(tabs2.get(1));
		log.info("My access Application opened");
		Thread.sleep(7000);
		et.log(LogStatus.PASS,"Application URl is opened in new tab- passed");
		b.getScreenshot();
		w.close();
		w.switchTo().window(tabs2.get(0));		 
		Thread.sleep(5000);
		log.info("My access Application closed ");
		cl_click(homeLink);
		Thread.sleep(2000);
		et.log(LogStatus.PASS,"Home Link is clicked- passed");
		
		}catch(Exception e) {
			System.out.println("Application did not open");
			et.log(LogStatus.FAIL,"Application did not open- failed");
		}
		
	}


	public void myaccessGridView() throws Exception {
		cl_click(MyAccess);
		log.info("My access page is displayed");
		cl_click(gridView);
		Thread.sleep(3000);
		log.info("My access Gridview is clicked ");
		et.log(LogStatus.PASS,"Grid view is clicked- passed");
		b.getScreenshot();
		Thread.sleep(2000);
		int c=gridApplctnCnt.size();
		if(c>0)
		{
			String appName=Appname.getText();
			cl_click(searchBtn);
			et.log(LogStatus.PASS,"Search button is clicked- passed");
			cl_entertext(searchAppName, appName);
			Robot r=new Robot();
			r.keyPress(KeyEvent.VK_ENTER);
			Thread.sleep(3000);
			int c1=gridApplctnCnt.size();
			for(int i=1;i<=c1;i++) {
				WebElement name = w.findElement(By.xpath(aName.replace("#DELIM#",String.valueOf(i))));
				String searchR=name.getText();
				if(searchR.equalsIgnoreCase(appName)) {
					System.out.println("Searched result displayed correctly");
					et.log(LogStatus.PASS,"Searched result displayed correctly- passed");
				}else {
					System.out.println("Searched result did not display correctly");
					et.log(LogStatus.FAIL,"Searched result did not display correctly- failed");
				}
			}
			Thread.sleep(3000);
			cl_click(clearBtn);
			et.log(LogStatus.PASS,"clear button is clicked- passed");
			Thread.sleep(3000);
			cl_click(homeLink);
			Thread.sleep(2000);
			et.log(LogStatus.PASS,"Home Link is clicked- passed");
					
		}else {
			System.out.println("No data available in the grid view");
			cl_click(homeLink);
			Thread.sleep(2000);
			et.log(LogStatus.PASS,"Home Link is clicked- passed");
		}
		
	}

}
