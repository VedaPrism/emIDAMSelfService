package Page_Factory;

import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.LogStatus;

import Generic_Library.Basefunctions;

public class pf_myActivityPage extends pf_genericmethods {
	Basefunctions b=new Basefunctions();
	final static Logger log = Logger.getLogger(pf_myActivityPage.class);
	
	@FindBy(how = How.ID, using = "MyActivity") WebElement myActivity;
	
	@FindBy(how = How.XPATH, using = "//div[@class='exbtnBlk']/a") WebElement exportToExcl;
	
	@FindAll({@FindBy(how = How.XPATH, using = "//table[@id='activityLogTable']/tbody/tr/td[7]/ul/li/a/i")}) public List<WebElement> viewList;
	String viewBtn="//table[@id='activityLogTable']/tbody/tr[#DELIM#]/td[7]/ul/li/a";
	//close button	
	@FindBy(how = How.XPATH, using = "//a[text()='Close']") WebElement closeBtn;
	
	//@FindAll({@FindBy(how = How.XPATH, using = "//table[@id='activityLogTable']/tbody/tr[@class='jqgfirstrow']/following-sibling::tr")}) public List<WebElement> activityCnt;
	
	@FindBy(how = How.XPATH, using = "//a[@href='selfservice-dashboard.htm']") public WebElement homeLink;
	public pf_myActivityPage(WebDriver driver){

		PageFactory.initElements(driver, this);
	}

	public void myactivity() throws Exception {
		cl_click(myActivity);
		et.log(LogStatus.PASS,"My Activity present in left menu is clicked- passed");
		log.info("--My Activity page is displayed--");
		cl_click(exportToExcl);
		log.info("--Exported My Activity to Excel--");
		et.log(LogStatus.PASS,"Export to Excel is clicked- passed");
		int size=viewList.size();
		if(size>0) {
		Random r=new Random();
		int n = r.nextInt(size);
		if(n==0) {
			n=n+1;
		}else if(n==1) {
			n=n+2;
		}
		cl_click(w.findElement(By.xpath(viewBtn.replace("#DELIM#",String.valueOf(n)))));
		Thread.sleep(3000);
		et.log(LogStatus.PASS,"View the selected record- passed");
		b.getScreenshot();
		cl_click(closeBtn);
		et.log(LogStatus.PASS,"Close button is clicked- passed");
		Thread.sleep(3000);
		cl_click(homeLink);
		Thread.sleep(2000);
		et.log(LogStatus.PASS,"Home Link is clicked- passed");
		}
	}
}
