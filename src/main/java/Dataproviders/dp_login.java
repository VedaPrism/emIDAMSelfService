package Dataproviders;


import java.util.ListIterator;

import org.testng.annotations.DataProvider;

import Generic_Library.Utility;

public class dp_login {

	@DataProvider(name = "invalid_login")
	public ListIterator<Object[]> dp_invalid() throws Exception
	{
		return Utility.dp_commonlogic("Credentials","InvalidLogin");
	}
	
	@DataProvider(name = "valid_login")
	public static ListIterator<Object[]> dp_valid() throws Exception
	{
		return Utility.dp_commonlogic("Credentials", "ValidLogin");
	}
	
	@DataProvider(name = "makeARequest_Page")
	public static ListIterator<Object[]> dp_makearequest() throws Exception
	{
		return Utility.dp_commonlogic("MakeARequest", "Script_Name");
	}
	
	@DataProvider(name = "dashboard_Page")
	public static ListIterator<Object[]> dp_dashboard() throws Exception
	{		
		return Utility.dp_commonlogic("Dashboard", "Script_Name");
	}
	
	@DataProvider(name = "approval_Page")
	public static ListIterator<Object[]> dp_apprvl() throws Exception
	{		
		return Utility.dp_commonlogic("Approvals", "Script_Name");
	}
	
	@DataProvider(name = "authenticType_Page")
	public static ListIterator<Object[]> dp_authenticType() throws Exception
	{		
		return Utility.dp_commonlogic("AuthenticType", "Script_Name");
	}
	
	@DataProvider(name = "reviewAccess_Page")
	public static ListIterator<Object[]> dp_reviewAccess() throws Exception
	{		
		return Utility.dp_commonlogic("ReviewAccess", "Script_Name");
	}
	
	@DataProvider(name = "profile_Page")
	public static ListIterator<Object[]> dp_profile() throws Exception
	{		
		return Utility.dp_commonlogic("Profile", "Script_Name");
	}
}

