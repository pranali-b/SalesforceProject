package reusableMethods;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class Automationnew extends ReusableMethodsnew {

	
	//t1
	public static void loginErrorMessage() throws IOException {
		Properties pro=new Properties();
		BufferedReader reader = new BufferedReader(new FileReader("/Users/pranalibankar/eclipse-workspace/SalesforceAutomation/src/test/resources/datafiles/Configuration.properties"));
		pro.load(reader);
		
		Properties credpro=new Properties();
		BufferedReader credreader = new BufferedReader(new FileReader("/Users/pranalibankar/eclipse-workspace/SalesforceAutomation/src/test/resources/datafiles/usercredentials.properties"));
		credpro.load(credreader);
	
	
		logger = extent.createTest("loginErrorMessage");
		IntializeDriver("firefox", pro.getProperty("firefoxpath"));
		
		driver.get(pro.getProperty("salesforceUrl"));
		//driver.get(pro.getProperty("implicitwait"));
		
		logger.log(Status.PASS, MarkupHelper.createLabel("Firefox driver is launched", ExtentColor.GREEN));
		//System.out.println("Pass: Firefox driver is launched");
		

		logger.log(Status.PASS, MarkupHelper.createLabel("SFDC login page is launched..", ExtentColor.GREEN));
		//System.out.println("Pass: SFDC login page is launched..");

		/*Enter username to username field*/
		WebElement un = driver.findElement(By.xpath("//input[@id='username']"));
		enterText(un, credpro.getProperty("loginusername"), "userName");

		/*Enter password to password field*/
		WebElement pwd = driver.findElement(By.xpath("//input[@id='password']"));
		pwd.clear();

		/*Click login*/
		WebElement login = driver.findElement(By.xpath("//input[@id='Login']")) ;
		clickObj(login, "Login Button");

		WebElement  pwderror= driver.findElement(By.xpath("//div[@id='error']")) ;

		validate_Error_message(pwderror,"Password Error","Please enter your password.");


		closeDriver();
		logger.log(Status.PASS, MarkupHelper.createLabel("Firefox browser is Closed...", ExtentColor.GREEN));


	}
	//t2
	public static void loginFreetrial() throws IOException {
		Properties pro=new Properties();
		BufferedReader reader = new BufferedReader(new FileReader("/Users/pranalibankar/eclipse-workspace/SalesforceAutomation/src/test/resources/datafiles/Configuration.properties"));
		pro.load(reader);
		
		Properties credpro=new Properties();
		BufferedReader credreader = new BufferedReader(new FileReader("/Users/pranalibankar/eclipse-workspace/SalesforceAutomation/src/test/resources/datafiles/usercredentials.properties"));
		credpro.load(credreader);
	
		logger = extent.createTest("loginFreetrial");
	
		IntializeDriver("firefox", pro.getProperty("firefoxpath"));
		logger.log(Status.PASS, MarkupHelper.createLabel("Firefox driver is launched", ExtentColor.GREEN));
		//System.out.println("Pass: Firefox driver is launched");
		driver.get(pro.getProperty("salesforceUrl"));
		
		
		logger.log(Status.PASS, MarkupHelper.createLabel("SFDC login page is launched..", ExtentColor.GREEN));
		//System.out.println("Pass: SFDC login page is launched..");

		/*Enter username to username field*/
		WebElement un = driver.findElement(By.xpath("//input[@id='username']"));
		enterText(un, credpro.getProperty("loginusername"), "userName");

		/*Enter password to password field*/
		WebElement pwd = driver.findElement(By.xpath("//input[@id='password']"));
		enterText(pwd, credpro.getProperty("loginpassword"), "Password");

		/*Click login*/
		WebElement login = driver.findElement(By.xpath("//input[@id='Login']")) ;
		clickObj(login, "Login Button");


		 String oldWindow=  driver.getWindowHandle();
		Set<String> getAllWindows=driver.getWindowHandles();
		String [] getWindow=getAllWindows.toArray(new String[getAllWindows.size()]);

		driver.switchTo().window(getWindow[0]);
		driver.get("https://www.salesforce.com/form/signup/freetrial-service-essentials.jsp?d=cta-li-promo-45");
		System.out.println(driver.getCurrentUrl());


		/*free trial page*/
		WebElement  freetrial = driver.findElement(By.xpath("//h4[@id='sign-up-now-to-start-your-free-service-trial']")) ;
		validate_Error_message(freetrial,"free trial page","Sign up now to start your free service trial."); 

		closeDriver();
		logger.log(Status.PASS, MarkupHelper.createLabel("Firefox browser is Closed...", ExtentColor.GREEN));

	}

	//t3
	public static void RememberMe() throws InterruptedException, IOException {
		Properties pro=new Properties();
		BufferedReader reader = new BufferedReader(new FileReader("/Users/pranalibankar/eclipse-workspace/SalesforceAutomation/src/test/resources/datafiles/configuration.properties"));
		pro.load(reader);
		
		Properties credpro=new Properties();
		BufferedReader credreader = new BufferedReader(new FileReader("/Users/pranalibankar/eclipse-workspace/SalesforceAutomation/src/test/resources/datafiles/usercredentials.properties"));
		credpro.load(credreader);
	
		logger = extent.createTest("RememberMe");

		IntializeDriver("firefox", pro.getProperty("firefoxpath"));
		driver.get(pro.getProperty("salesforceUrl"));
		
		logger.log(Status.PASS, MarkupHelper.createLabel("Firefox driver is launched", ExtentColor.GREEN));
		//System.out.println("Pass: Firefox driver is launched");
	
		
		logger.log(Status.PASS, MarkupHelper.createLabel("SFDC login page is launched..", ExtentColor.GREEN));
		//System.out.println("Pass: SFDC login page is launched..");

		/*Enter username to username field*/
		WebElement un = driver.findElement(By.xpath("//input[@id='username']"));
		enterText(un, credpro.getProperty("loginusername"), "userName");
		/*Enter password to password field*/
		WebElement pwd = driver.findElement(By.xpath("//input[@id='password']"));
		enterText(pwd, credpro.getProperty("loginpassword"), "Password");
		/*rememberme */
		WebElement rememberme =driver.findElement(By.id("rememberUn"));
		clickObj(rememberme, "rememberme Button");

		/*Click login*/
		WebElement login = driver.findElement(By.xpath("//input[@id='Login']")) ;
		clickObj(login, "Login Button");

		driver.get("https://na49.lightning.force.com/lightning/setup/SetupOneHome/home");
		System.out.println(driver.getCurrentUrl());
		Thread.sleep(5000);



		WebElement profile = driver.findElement(By.xpath("//li[@class='slds-dropdown-trigger slds-dropdown-trigger--click slds-m-left--x-small']//button[@type='button']"));
		clickObj(profile, "profile Button");

		WebElement logout =driver.findElement(By.xpath("//a[@class='profile-link-label logout uiOutputURL']"));
		Thread.sleep(3000);
		clickObj(logout, "logout Button");


		closeDriver();
		logger.log(Status.PASS, MarkupHelper.createLabel("Firefox browser is Closed...", ExtentColor.GREEN));


	}

	//t4a
	public static void forGotPassword() throws IOException {
		Properties pro=new Properties();
		BufferedReader reader = new BufferedReader(new FileReader("/Users/pranalibankar/eclipse-workspace/SalesforceAutomation/src/test/resources/datafiles/configuration.properties"));
		pro.load(reader);
		
		Properties credpro=new Properties();
		BufferedReader credreader = new BufferedReader(new FileReader("/Users/pranalibankar/eclipse-workspace/SalesforceAutomation/src/test/resources/datafiles/usercredentials.properties"));
		credpro.load(credreader);
	
		logger = extent.createTest("forGotPassword");
	
		IntializeDriver("firefox", pro.getProperty("firefoxpath"));
		
		driver.get(pro.getProperty("salesforceUrl"));
		
		
		logger.log(Status.PASS, MarkupHelper.createLabel("Firefox driver is launched", ExtentColor.GREEN));
		//System.out.println("Pass: Firefox driver is launched");
		
		logger.log(Status.PASS, MarkupHelper.createLabel("SFDC login page is launched..", ExtentColor.GREEN));
		//System.out.println("Pass: SFDC login page is launched..");

		/*forgot passwoed*/
		WebElement forgotpassword = driver.findElement(By.xpath("//a[@id='forgot_password_link']"));
		clickObj(forgotpassword, "forgotpassword Button");


		/*Enter username to username field*/
		WebElement un = driver.findElement(By.xpath("//input[@id='un']"));
		enterText(un, credpro.getProperty("loginusername"), "userName");

		/*continue button*/
		WebElement continuebutton =driver.findElement(By.xpath("//input[@id='continue']"));
		clickObj(continuebutton, "continue Button");
		logger.log(Status.PASS, MarkupHelper.createLabel("Check Your Email.", ExtentColor.GREEN));

		WebElement  passworreset = driver.findElement(By.xpath("//p[contains(text(),'We’ve sent you an email with a link to finish rese')]")) ;
		validate_Error_message(passworreset,"Password reset message","We’ve sent you an email with a link to finish resetting your password."); 


		closeDriver();
		logger.log(Status.PASS, MarkupHelper.createLabel("Firefox browser is Closed...", ExtentColor.GREEN));

	}
	//t4b
	public static void ValidateLoginErrorMessage() throws IOException {
		Properties pro=new Properties();
		BufferedReader reader = new BufferedReader(new FileReader("/Users/pranalibankar/eclipse-workspace/SalesforceAutomation/src/test/resources/datafiles/configuration.properties"));
		pro.load(reader);
		
		Properties credpro=new Properties();
		BufferedReader credreader = new BufferedReader(new FileReader("/Users/pranalibankar/eclipse-workspace/SalesforceAutomation/src/test/resources/datafiles/usercredentials.properties"));
		credpro.load(credreader);
	
		logger = extent.createTest("ValidateLoginErrorMessage");
		
		IntializeDriver("firefox", pro.getProperty("firefoxpath"));

		driver.get(pro.getProperty("salesforceUrl"));
		
		logger.log(Status.PASS, MarkupHelper.createLabel("Firefox driver is launched", ExtentColor.GREEN));
		//System.out.println("Pass: Firefox driver is launched");
		
		logger.log(Status.PASS, MarkupHelper.createLabel("SFDC login page is launched..", ExtentColor.GREEN));
		//System.out.println("Pass: SFDC login page is launched..");

		/*Enter username to username field*/
		WebElement un = driver.findElement(By.xpath("//input[@id='username']"));
		enterText(un, "123", "userName");
		logger.log(Status.PASS, MarkupHelper.createLabel("Wrong username is entered", ExtentColor.GREEN));


		/*Enter password to password field*/
		WebElement pwd = driver.findElement(By.xpath("//input[@id='password']"));
		enterText(pwd, "22131", "Password");
		logger.log(Status.PASS, MarkupHelper.createLabel("Wrong password is entered...", ExtentColor.GREEN));


		/*Click login*/
		WebElement login = driver.findElement(By.xpath("//input[@id='Login']")) ;
		clickObj(login, "Login Button");


		/*check error message */
		WebElement  LoginValidation = driver.findElement(By.xpath("//div[@id='error']")) ;
		validate_Error_message(LoginValidation,
				"Login Validation", 
				"Please check your username and password. "
						+ "If you still can't log in, contact "
						+ "your Salesforce administrator.");

		closeDriver();
		logger.log(Status.PASS, MarkupHelper.createLabel("Firefox browser is Closed...", ExtentColor.GREEN));


	}

	//t5
	public static void userMenu() throws InterruptedException, IOException {
	
		FirefoxProfile profile = new FirefoxProfile();
		//Set Location to store files after downloading.
		profile.setPreference("browser.download.dir", "user/pranalibankar/Downloads");
		profile.setPreference("browser.download.folderList", 2);
		//Set Preference to not show file download confirmation dialogue using MIME types Of different file extension types.
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk", 
				"application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;"); 

		profile.setPreference( "browser.download.manager.showWhenStarting", false );
		profile.setPreference( "pdfjs.disabled", true );

		DesiredCapabilities dc = DesiredCapabilities.firefox();
		dc.setCapability(FirefoxDriver.PROFILE, profile);
		FirefoxDriver driver = new FirefoxDriver(dc);
		
		Properties pro=new Properties();
		BufferedReader reader = new BufferedReader(new FileReader("/Users/pranalibankar/eclipse-workspace/SalesforceAutomation/src/test/resources/datafiles/configuration.properties"));
		pro.load(reader);
		
		Properties credpro=new Properties();
		BufferedReader credreader = new BufferedReader(new FileReader("/Users/pranalibankar/eclipse-workspace/SalesforceAutomation/src/test/resources/datafiles/usercredentials.properties"));
		credpro.load(credreader);

		logger = extent.createTest("userMenu");

		
		IntializeDriver("firefox", pro.getProperty("firefoxpath"));

		driver.get(pro.getProperty("salesforceUrl"));
		
		logger.log(Status.PASS, MarkupHelper.createLabel("Firefox driver is launched", ExtentColor.GREEN));
		//System.out.println("Pass: Firefox driver is launched");
		
		logger.log(Status.PASS, MarkupHelper.createLabel("SFDC login page is launched..", ExtentColor.GREEN));
		//System.out.println("Pass: SFDC login page is launched..");

		/*Enter username to username field*/
		WebElement un = driver.findElement(By.xpath("//input[@id='username']"));
		enterText(un, credpro.getProperty("loginusername"), "userName");

		/*Enter password to password field*/
		WebElement pwd = driver.findElement(By.xpath("//input[@id='password']"));
		enterText(pwd, credpro.getProperty("loginpassword"), "Password");
		/*Click login*/
		WebElement login = driver.findElement(By.xpath("//input[@id='Login']")) ;
		clickObj(login, "Login Button");

		driver.get("https://na49.salesforce.com/home/home.jsp?source=lex");
		System.out.println(driver.getCurrentUrl());


		/*usermenu link */
		WebElement usermenu =driver.findElement(By.xpath("//div[@id='userNavButton']")); 
		Thread.sleep(3000);
		clickObj(usermenu,"usermenu Button");

		Thread.sleep(3000);


		closeDriver();
		logger.log(Status.PASS, MarkupHelper.createLabel("Firefox browser is Closed...", ExtentColor.GREEN));


	}

	//t7
	public static void mySetting() throws InterruptedException, IOException {
		Properties pro=new Properties();
		BufferedReader reader = new BufferedReader(new FileReader("/Users/pranalibankar/eclipse-workspace/SalesforceAutomation/src/test/resources/datafiles/configuration.properties"));
		pro.load(reader);
		
		Properties credpro=new Properties();
		BufferedReader credreader = new BufferedReader(new FileReader("/Users/pranalibankar/eclipse-workspace/SalesforceAutomation/src/test/resources/datafiles/usercredentials.properties"));
		credpro.load(credreader);

		logger = extent.createTest("mySetting");

		
		IntializeDriver("firefox", pro.getProperty("firefoxpath"));
		driver.get(pro.getProperty("salesforceUrl"));
		
		
		logger.log(Status.PASS, MarkupHelper.createLabel("Firefox driver is launched", ExtentColor.GREEN));
		//System.out.println("Pass: Firefox driver is launched");
		
		logger.log(Status.PASS, MarkupHelper.createLabel("SFDC login page is launched..", ExtentColor.GREEN));
		//System.out.println("Pass: SFDC login page is launched..");

		/*Enter username to username field*/
		WebElement un = driver.findElement(By.xpath("//input[@id='username']"));
		enterText(un, credpro.getProperty("loginusername"), "userName");

		/*Enter password to password field*/
		WebElement pwd = driver.findElement(By.xpath("//input[@id='password']"));
		enterText(pwd, credpro.getProperty("loginpassword"), "Password");
		/*Click login*/
		WebElement login = driver.findElement(By.xpath("//input[@id='Login']")) ;
		clickObj(login, "Login Button");

		driver.get("https://na49.salesforce.com/home/home.jsp?source=lex");
		System.out.println(driver.getCurrentUrl());


		/*usermenu link */
		WebElement usermenu =driver.findElement(By.xpath("//div[@id='userNavButton']")); 
		Thread.sleep(3000);
		clickObj(usermenu,"usermenu Button");

		Thread.sleep(3000);

		/*mysetting button */
		WebElement mysetting =driver.findElement(By.xpath("//a[contains(text(),'My Setting')]")); 
		Thread.sleep(3000);
		clickObj(mysetting, "mysetting Button");

		/*personallink button */
		WebElement personallink =driver.findElement(By.xpath("//span[@id='PersonalInfo_font']")); 
		clickObj(personallink, "personallink Button");

		/*loginhistory button */
		WebElement loginhistory =driver.findElement(By.xpath("//span[@id='LoginHistory_font']")); 
		clickObj(loginhistory, "loginhistory Button");

		/*historydownload button */
		WebElement historydownload =driver.findElement(By.xpath("//a[@href='/servlet/servlet.LoginHistory?id=0055A000009uCS1']"));

		clickObj(historydownload, "historydownload Button");

		/*displaylayout button */
		WebElement displaylayout =driver.findElement(By.xpath("//div[@id='DisplayAndLayout']//a[@class='header setupFolder']")); 
		clickObj(displaylayout, "displaylayout Button");

		/*customize button */
		WebElement customize =driver.findElement(By.xpath("//span[@id='CustomizeTabs_font']")); 
		clickObj(customize, "customize Button");

		/*custmerapp button */
		WebElement custmerapp =driver.findElement(By.xpath("//select[@name='p4']")); 
		selectByValue( custmerapp,  "custmerapp button" , "02u5A000000wUtS");
		Thread.sleep(3000);


		/*save button */
		WebElement save =driver.findElement(By.xpath("//input[@class='btn primary']")); 
		clickObj(save, "save Button");

		WebElement email =driver.findElement(By.xpath("//div[@id='EmailSetup']//a[@class='header setupFolder']")); 
		clickObj(email, "email Button");

		WebElement emailsetting =driver.findElement(By.xpath("//a[@id='EmailSettings_font']")); 
		clickObj(emailsetting, "emailsetting Button");

		WebElement emailnamefield =driver.findElement(By.xpath("//input[@id='sender_name']")); 
		emailnamefield.clear();
		emailnamefield.sendKeys("pranali");

		/*Enter username to username field*/
		WebElement un1 = driver.findElement(By.xpath("//input[@id='sender_email']"));
		enterText(un1, credpro.getProperty("loginusername"), "userName");

		WebElement automaticbcc =driver.findElement(By.xpath("//input[@id='auto_bcc1']")); 
		clickObj(automaticbcc, "automaticbcc Button");

		WebElement clicksave = driver.findElement(By.xpath("//input[@title='Save']")) ;
		clickObj(clicksave, "clicksave Button");

		WebElement calenders =driver.findElement(By.xpath("//span[@id='CalendarAndReminders_font']")); 
		clickObj(calenders, "calenders Button");

		WebElement activityrmn =driver.findElement(By.xpath("//span[@id='Reminders_font']")); 
		clickObj(activityrmn, "activityrmn Button");

		WebElement test =driver.findElement(By.xpath("//input[@id='testbtn']")); 
		clickObj(test, "test Button");


		closeDriver();
		logger.log(Status.PASS, MarkupHelper.createLabel("Firefox browser is Closed...", ExtentColor.GREEN));


	}

	//t8
	public static void developerConsole() throws InterruptedException, IOException{
		Properties pro=new Properties();
		BufferedReader reader = new BufferedReader(new FileReader("/Users/pranalibankar/eclipse-workspace/SalesforceAutomation/src/test/resources/datafiles/configuration.properties"));
		pro.load(reader);

		Properties credpro=new Properties();
		BufferedReader credreader = new BufferedReader(new FileReader("/Users/pranalibankar/eclipse-workspace/SalesforceAutomation/src/test/resources/datafiles/usercredentials.properties"));
		credpro.load(credreader);
		
		logger = extent.createTest("developerConsole");
		IntializeDriver("firefox", pro.getProperty("firefoxpath"));
		driver.get(pro.getProperty("salesforceUrl"));
		
		logger.log(Status.PASS, MarkupHelper.createLabel("Firefox driver is launched", ExtentColor.GREEN));
		//System.out.println("Pass: Firefox driver is launched");
		
		logger.log(Status.PASS, MarkupHelper.createLabel("SFDC login page is launched..", ExtentColor.GREEN));
		//System.out.println("Pass: SFDC login page is launched..");

		/*Enter username to username field*/
		WebElement un = driver.findElement(By.xpath("//input[@id='username']"));
		enterText(un, credpro.getProperty("loginusername"), "userName");

		/*Enter password to password field*/
		WebElement pwd = driver.findElement(By.xpath("//input[@id='password']"));
		enterText(pwd, credpro.getProperty("loginpassword"), "Password");
		/*Click login*/
		WebElement login = driver.findElement(By.xpath("//input[@id='Login']")) ;
		clickObj(login, "Login Button");

		String Window1 = driver.getWindowHandle();

		driver.get("https://na49.salesforce.com/home/home.jsp?source=lex");
		System.out.println(driver.getCurrentUrl());


		/*usermenu link */
		WebElement usermenu =driver.findElement(By.xpath("//div[@id='userNavButton']")); 
		Thread.sleep(3000);
		clickObj(usermenu,"usermenu Button");

		Thread.sleep(3000);

		WebElement developerconsole =driver.findElement(By.xpath("//a[contains(text(),'Developer')]")); 
		clickObj(developerconsole,"developerconsole Button");

		Set<String>windows=driver.getWindowHandles();
		for(String x: windows) {
			if(x.equals(Window1)==false) {
				driver.switchTo().window(x);
				Thread.sleep(5000);
				driver.close();
			}

		}

		//closeDriver();
		logger.log(Status.PASS, MarkupHelper.createLabel("Firefox browser is Closed...", ExtentColor.GREEN));


	}
	//t9
	public static void logoutSalesforce() throws InterruptedException, IOException{
		Properties pro=new Properties();
		BufferedReader reader = new BufferedReader(new FileReader("/Users/pranalibankar/eclipse-workspace/SalesforceAutomation/src/test/resources/datafiles/configuration.properties"));
		pro.load(reader);

		Properties credpro=new Properties();
		BufferedReader credreader = new BufferedReader(new FileReader("/Users/pranalibankar/eclipse-workspace/SalesforceAutomation/src/test/resources/datafiles/usercredentials.properties"));
		credpro.load(credreader);
		
		logger = extent.createTest("logoutSalesforce");
		
		IntializeDriver("firefox", pro.getProperty("firefoxpath"));
		driver.get(pro.getProperty("salesforceUrl"));
		
		
		logger.log(Status.PASS, MarkupHelper.createLabel("Firefox driver is launched", ExtentColor.GREEN));
		//System.out.println("Pass: Firefox driver is launched");
		
		logger.log(Status.PASS, MarkupHelper.createLabel("SFDC login page is launched..", ExtentColor.GREEN));
		//System.out.println("Pass: SFDC login page is launched..");

		/*Enter username to username field*/
		WebElement un = driver.findElement(By.xpath("//input[@id='username']"));
		enterText(un, credpro.getProperty("loginusername"), "userName");

		/*Enter password to password field*/
		WebElement pwd = driver.findElement(By.xpath("//input[@id='password']"));
		enterText(pwd, credpro.getProperty("loginpassword"), "Password");
		/*Click login*/
		WebElement login = driver.findElement(By.xpath("//input[@id='Login']")) ;
		clickObj(login, "Login Button");

		String oldWindow=  driver.getWindowHandle();
		Set<String> getAllWindows=driver.getWindowHandles();
		String [] getWindow=getAllWindows.toArray(new String[getAllWindows.size()]);
		driver.switchTo().window(getWindow[0]);
		driver.get("https://na49.salesforce.com/home/home.jsp?source=lex");
		System.out.println(driver.getCurrentUrl());


		/*usermenu link */
		WebElement usermenu =driver.findElement(By.xpath("//div[@id='userNavButton']")); 
		Thread.sleep(3000);
		clickObj(usermenu,"usermenu Button");

		Thread.sleep(3000);

		WebElement logout =driver.findElement(By.xpath("//a[contains(text(),'Logout')]")); 
		clickObj(logout,"logout Button");

		closeDriver();
		logger.log(Status.PASS, MarkupHelper.createLabel("Firefox browser is Closed...", ExtentColor.GREEN));

	}
	//t10
	public static void createAccount() throws InterruptedException, IOException{
		Properties pro=new Properties();
		BufferedReader reader = new BufferedReader(new FileReader("/Users/pranalibankar/eclipse-workspace/SalesforceAutomation/src/test/resources/datafiles/configuration.properties"));
		pro.load(reader);
		
		Properties credpro=new Properties();
		BufferedReader credreader = new BufferedReader(new FileReader("/Users/pranalibankar/eclipse-workspace/SalesforceAutomation/src/test/resources/datafiles/usercredentials.properties"));
		credpro.load(credreader);
		
		logger = extent.createTest("createAccount");
		
		IntializeDriver("firefox", pro.getProperty("firefoxpath"));
		driver.get(pro.getProperty("salesforceUrl"));
				
		logger.log(Status.PASS, MarkupHelper.createLabel("Firefox driver is launched", ExtentColor.GREEN));
		//System.out.println("Pass: Firefox driver is launched");
		
		logger.log(Status.PASS, MarkupHelper.createLabel("SFDC login page is launched..", ExtentColor.GREEN));
		//System.out.println("Pass: SFDC login page is launched..");

		/*Enter username to username field*/
		WebElement un = driver.findElement(By.xpath("//input[@id='username']"));
		enterText(un, credpro.getProperty("loginusername"), "userName");

		/*Enter password to password field*/
		WebElement pwd = driver.findElement(By.xpath("//input[@id='password']"));
		enterText(pwd, credpro.getProperty("loginpassword"), "Password");
		/*Click login*/
		WebElement login = driver.findElement(By.xpath("//input[@id='Login']")) ;
		clickObj(login, "Login Button");

		String oldWindow=  driver.getWindowHandle();
		Set<String> getAllWindows=driver.getWindowHandles();
		String [] getWindow=getAllWindows.toArray(new String[getAllWindows.size()]);
		driver.switchTo().window(getWindow[0]);
		driver.get("https://na49.salesforce.com/home/home.jsp?source=lex");
		System.out.println(driver.getCurrentUrl());

		WebElement accounts =driver.findElement(By.id("Account_Tab"));
		clickObj(accounts, "accounts Button");

		//WebElement close =driver.findElement(By.id("tryLexDialogX"));
		//clickObj(close, "close Button");

		WebElement createnewaccounts =driver.findElement(By.xpath("//div[@id='createNewButton']"));
		clickObj(createnewaccounts, "createnewaccounts Button");

		WebElement newaccount =driver.findElement(By.xpath("//a[@class='accountMru menuButtonMenuLink']"));
		clickObj(newaccount, "newaccount Button");

		WebElement accountfield =driver.findElement(By.xpath(" //input[@id='acc2']"));
		Thread.sleep(3000);
		enterText(accountfield, "prana", "accountfield");


		WebElement savename =driver.findElement(By.xpath("//input[@name='save']"));
		clickObj(savename, "savename Button");

		closeDriver();
		logger.log(Status.PASS, MarkupHelper.createLabel("Firefox browser is Closed...", ExtentColor.GREEN));


	}
	//t11
	public static void createaccountnewView() throws InterruptedException, IOException{
		Properties pro=new Properties();
		BufferedReader reader = new BufferedReader(new FileReader("/Users/pranalibankar/eclipse-workspace/SalesforceAutomation/src/test/resources/datafiles/configuration.properties"));
		pro.load(reader);
		
		Properties credpro=new Properties();
		BufferedReader credreader = new BufferedReader(new FileReader("/Users/pranalibankar/eclipse-workspace/SalesforceAutomation/src/test/resources/datafiles/usercredentials.properties"));
		credpro.load(credreader);
		
		logger = extent.createTest("createaccountnewView");
		
		IntializeDriver("firefox", pro.getProperty("firefoxpath"));
		driver.get(pro.getProperty("salesforceUrl"));
		
		logger.log(Status.PASS, MarkupHelper.createLabel("Firefox driver is launched", ExtentColor.GREEN));
		//System.out.println("Pass: Firefox driver is launched");
		
		logger.log(Status.PASS, MarkupHelper.createLabel("SFDC login page is launched..", ExtentColor.GREEN));
		//System.out.println("Pass: SFDC login page is launched..");

		/*Enter username to username field*/
		WebElement un = driver.findElement(By.xpath("//input[@id='username']"));
		enterText(un, credpro.getProperty("loginusername"), "userName");

		/*Enter password to password field*/
		WebElement pwd = driver.findElement(By.xpath("//input[@id='password']"));
		enterText(pwd, credpro.getProperty("loginpassword"), "Password");
		/*Click login*/
		WebElement login = driver.findElement(By.xpath("//input[@id='Login']")) ;
		clickObj(login, "Login Button");


		driver.get("https://na49.salesforce.com/home/home.jsp?source=lex");
		System.out.println(driver.getCurrentUrl());

		WebElement accounts =driver.findElement(By.id("Account_Tab"));
		clickObj(accounts, "accounts Button");

		WebElement newvielink =driver.findElement(By.xpath("//a[contains(text(),'Create New View')]"));
		clickObj(newvielink, "newvielink Button");

		WebElement viewname = driver.findElement(By.xpath("//input[@id='fname']"));
		enterText(viewname, "prana", "viewname");

		WebElement uniqueviewname =driver.findElement(By.xpath("//input[@id='devname']"));
		enterText(uniqueviewname, "prana", "uniqueviewname");

		WebElement saveviewname =driver.findElement(By.xpath("//input[@name='save']"));
		clickObj(saveviewname, "saveviewname Button");

		closeDriver();
		logger.log(Status.PASS, MarkupHelper.createLabel("Firefox browser is Closed...", ExtentColor.GREEN));

	}

	//t12
	public static void EditView() throws InterruptedException, IOException{
		Properties pro=new Properties();
		BufferedReader reader = new BufferedReader(new FileReader("/Users/pranalibankar/eclipse-workspace/SalesforceAutomation/src/test/resources/datafiles/configuration.properties"));
		pro.load(reader);
		
		Properties credpro=new Properties();
		BufferedReader credreader = new BufferedReader(new FileReader("/Users/pranalibankar/eclipse-workspace/SalesforceAutomation/src/test/resources/datafiles/usercredentials.properties"));
		credpro.load(credreader);
		
		logger = extent.createTest("EditView");
		
		IntializeDriver("firefox", pro.getProperty("firefoxpath"));
		driver.get(pro.getProperty("salesforceUrl"));
		
		logger.log(Status.PASS, MarkupHelper.createLabel("Firefox driver is launched", ExtentColor.GREEN));
		//System.out.println("Pass: Firefox driver is launched");
		
		logger.log(Status.PASS, MarkupHelper.createLabel("SFDC login page is launched..", ExtentColor.GREEN));
		//System.out.println("Pass: SFDC login page is launched..");

		/*Enter username to username field*/
		WebElement un = driver.findElement(By.xpath("//input[@id='username']"));
		enterText(un, credpro.getProperty("loginusername"), "userName");

		/*Enter password to password field*/
		WebElement pwd = driver.findElement(By.xpath("//input[@id='password']"));
		enterText(pwd, credpro.getProperty("loginpassword"), "Password");
		/*Click login*/
		WebElement login = driver.findElement(By.xpath("//input[@id='Login']")) ;
		clickObj(login, "Login Button");


		driver.get("https://na49.salesforce.com/home/home.jsp?source=lex");
		System.out.println(driver.getCurrentUrl());

		WebElement accounts =driver.findElement(By.id("Account_Tab"));
		clickObj(accounts, "accounts Button");

		//WebElement close =driver.findElement(By.id("tryLexDialogX"));
		//Thread.sleep(3000);
		//clickObj(close, "close Button");


		WebElement view =driver.findElement(By.xpath("//option[@value='00B5A0000091PDu']"));
		clickObj(view, "view Button");

		WebElement editview =driver.findElement(By.xpath("//a[@href='/ui/list/FilterEditPage?id=00B5A0000091PDu&retURL=%2F001%3Ffcf%3D00B5A0000091PDu%26rolodexIndex%3D-1%26page%3D1']"));
		Thread.sleep(3000);
		clickObj(editview, "editview Button");


		WebElement viewnamenew =driver.findElement(By.xpath("//input[@id='fname']"));
		Thread.sleep(3000);
		enterText(viewnamenew, "prr", "viewnamenew");

		WebElement uniqueviewname =driver.findElement(By.xpath("//input[@id='devname']"));
		Thread.sleep(3000);
		enterText(uniqueviewname, "prr", "uniqueviewname");

		WebElement selectfield =driver.findElement(By.xpath("//select[@id='fcol1']"));
		Thread.sleep(3000);
		Select select = new Select(selectfield);
		select.selectByVisibleText("Account Name");


		WebElement selectoperator=driver.findElement(By.xpath("//select[@id='fop1']"));
		Thread.sleep(3000);
		Select selectop = new Select(selectoperator);
		selectop.selectByVisibleText("contains");

		WebElement value=driver.findElement(By.xpath("//input[@id='fval1']"));
		Thread.sleep(3000);
		enterText(value, "a", "value");

		WebElement fielddisplay =driver.findElement(By.xpath("//label[@for='colselector_select_0']"));
		Thread.sleep(3000);

		WebElement lastactivity =driver.findElement(By.xpath("//select[@id='colselector_select_0']//option[@value='ACCOUNT.LAST_ACTIVITY'][contains(text(),'Last Activity')]"));
		Thread.sleep(3000);
		clickObj(lastactivity, "lastactivity Button");


		WebElement add =driver.findElement(By.xpath("//a[@id='colselector_select_0_right']//img[@title='Add']"));
		Thread.sleep(3000);
		clickObj(add, "add Button");

		WebElement savefields=driver.findElement(By.xpath("//div[@class='pbBottomButtons']//input[@title='Save']"));
		Thread.sleep(3000);
		clickObj(savefields, "savefields Button");

		closeDriver();
		logger.log(Status.PASS, MarkupHelper.createLabel("Firefox browser is Closed...", ExtentColor.GREEN));


	}
	//t13
	public static void MergeAccounts() throws InterruptedException, IOException{
		Properties pro=new Properties();
		BufferedReader reader = new BufferedReader(new FileReader("/Users/pranalibankar/eclipse-workspace/SalesforceAutomation/src/test/resources/datafiles/configuration.properties"));
		pro.load(reader);
		
		Properties credpro=new Properties();
		BufferedReader credreader = new BufferedReader(new FileReader("/Users/pranalibankar/eclipse-workspace/SalesforceAutomation/src/test/resources/datafiles/usercredentials.properties"));
		credpro.load(credreader);
		
		logger = extent.createTest("MergeAccounts");
		
		IntializeDriver("firefox", pro.getProperty("firefoxpath"));
		driver.get(pro.getProperty("salesforceUrl"));
		
		logger.log(Status.PASS, MarkupHelper.createLabel("Firefox driver is launched", ExtentColor.GREEN));
		//System.out.println("Pass: Firefox driver is launched");
				logger.log(Status.PASS, MarkupHelper.createLabel("SFDC login page is launched..", ExtentColor.GREEN));
		//System.out.println("Pass: SFDC login page is launched..");

		/*Enter username to username field*/
		WebElement un = driver.findElement(By.xpath("//input[@id='username']"));
		enterText(un, credpro.getProperty("loginusername"), "userName");

		/*Enter password to password field*/
		WebElement pwd = driver.findElement(By.xpath("//input[@id='password']"));
		enterText(pwd, credpro.getProperty("loginpassword"), "Password");
		/*Click login*/
		WebElement login = driver.findElement(By.xpath("//input[@id='Login']")) ;
		clickObj(login, "Login Button");


		driver.get("https://na49.salesforce.com/home/home.jsp?source=lex");
		System.out.println(driver.getCurrentUrl());

		WebElement accounts =driver.findElement(By.id("Account_Tab"));
		clickObj(accounts, "accounts Button");

		//WebElement close =driver.findElement(By.id("tryLexDialogX"));
		//Thread.sleep(3000);
		//clickObj(close, "close Button");

		WebElement mergeaccounts =driver.findElement(By.xpath("//a[contains(text(),'Merge Accounts')]"));
		Thread.sleep(3000);
		clickObj(mergeaccounts, "mergeaccounts Button");


		WebElement mergeaccountsaccname =driver.findElement(By.xpath("//input[@id='srch']"));
		Thread.sleep(3000);
		enterText(mergeaccountsaccname, "prana", "mergeaccountsaccname");

		WebElement findacc =driver.findElement(By.xpath("//div[@class='pbWizardBody']//input[2]"));
		Thread.sleep(3000);
		clickObj(findacc, "findacc Button");


		WebElement acc1 =driver.findElement(By.xpath("//input[@id='cid0']"));
		Thread.sleep(3000);
		clickObj(acc1, "acc1 Button");


		WebElement acc2 =driver.findElement(By.xpath("//input[@id='cid1']"));
		Thread.sleep(3000);
		clickObj(acc2, "acc2 Button");


		WebElement next =driver.findElement(By.xpath("//div[contains(@class,'pbBottomButtons')]//input[contains(@title,'Next')]"));
		Thread.sleep(3000);
		clickObj(next, "next Button");


		Thread.sleep(3000);

		WebElement alertbox = driver.findElement(By.xpath("//div[@class='pbTopButtons']//input[@title='Merge']"));
		alertbox.click();
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		System.out.print("alertText");
		Thread.sleep(2000);
		alert.accept();

		closeDriver();
		logger.log(Status.PASS, MarkupHelper.createLabel("Firefox browser is Closed...", ExtentColor.GREEN));


	}
	//t14
	public static void activeWithLastActivity() throws InterruptedException, IOException{
		Properties pro=new Properties();
		BufferedReader reader = new BufferedReader(new FileReader("/Users/pranalibankar/eclipse-workspace/SalesforceAutomation/src/test/resources/datafiles/configuration.properties"));
		pro.load(reader);
		
		Properties credpro=new Properties();
		BufferedReader credreader = new BufferedReader(new FileReader("/Users/pranalibankar/eclipse-workspace/SalesforceAutomation/src/test/resources/datafiles/usercredentials.properties"));
		credpro.load(credreader);
		
		logger = extent.createTest("activeWithLastActivity");
		
		IntializeDriver("firefox", pro.getProperty("firefoxpath"));
		driver.get(pro.getProperty("salesforceUrl"));
		
		logger.log(Status.PASS, MarkupHelper.createLabel("Firefox driver is launched", ExtentColor.GREEN));
		//System.out.println("Pass: Firefox driver is launched");
		
		logger.log(Status.PASS, MarkupHelper.createLabel("SFDC login page is launched..", ExtentColor.GREEN));
		//System.out.println("Pass: SFDC login page is launched..");


		/*Enter username to username field*/
		WebElement un = driver.findElement(By.xpath("//input[@id='username']"));
		enterText(un, credpro.getProperty("loginusername"), "userName");

		/*Enter password to password field*/
		WebElement pwd = driver.findElement(By.xpath("//input[@id='password']"));
		enterText(pwd, credpro.getProperty("loginpassword"), "Password");
		/*Click login*/
		WebElement login = driver.findElement(By.xpath("//input[@id='Login']")) ;
		clickObj(login, "Login Button");


		driver.get("https://na49.salesforce.com/home/home.jsp?source=lex");
		System.out.println(driver.getCurrentUrl());

		WebElement accounts =driver.findElement(By.id("Account_Tab"));
		clickObj(accounts, "accounts Button");

		/* WebElement close =driver.findElement(By.id("tryLexDialogX"));
		    Thread.sleep(3000);
		    clickObj(close, "close Button");
		 */
		WebElement accntwithlastactv =driver.findElement(By.xpath("//a[contains(text(),'Accounts with last activity > 30 days')]"));
		Thread.sleep(3000);
		clickObj(accntwithlastactv, "accntwithlastactv Button");

		WebElement datefield =driver.findElement(By.xpath("//input[@id='ext-gen20']"));
		Thread.sleep(3000);
		clickObj(datefield, "datefield Button");

		WebElement createdate =driver.findElement(By.xpath("//div[@class='x-combo-list-item x-combo-selected']"));
		Thread.sleep(3000);
		clickObj(createdate, "createdate Button");

		WebElement from =driver.findElement(By.xpath("//input[@id='ext-comp-1042']"));
		Thread.sleep(3000);
		clickObj(from, "from Button");


		WebElement fromdate =driver.findElement(By.xpath("//img[@id='ext-gen152']"));
		Thread.sleep(3000);
		clickObj(fromdate, "fromdate Button");

		WebElement fromdatetoday =driver.findElement(By.xpath("//td[@class='x-date-active x-date-today x-date-selected']"));
		Thread.sleep(3000);
		clickObj(fromdatetoday, "fromdatetoday Button");

		WebElement to =driver.findElement(By.xpath("//input[@id='ext-comp-1045']"));
		Thread.sleep(3000);
		clickObj(to, "to Button");

		WebElement todate =driver.findElement(By.xpath("//img[@id='ext-gen154']"));
		Thread.sleep(3000);
		clickObj(todate, "todate Button");

		WebElement todatetoday =driver.findElement(By.xpath("//td[@class='x-date-active x-date-selected']"));
		Thread.sleep(3000);
		clickObj(todatetoday, "todatetoday Button");

		WebElement save =driver.findElement(By.xpath("//button[@id='ext-gen49']"));
		Thread.sleep(3000);
		clickObj(save, "save Button");

		WebElement reportname =driver.findElement(By.xpath("//input[@id='saveReportDlg_reportNameField']"));
		Thread.sleep(3000);
		enterText(reportname, "pr", "reportname");

		WebElement uniquereportname =driver.findElement(By.xpath("//input[@id='saveReportDlg_DeveloperName']"));
		enterText(uniquereportname, "pr", "uniquereportname");

		WebElement reportsave =driver.findElement(By.xpath("//table[@id='dlgSaveReport']//td[@class='x-btn-mc']"));
		Thread.sleep(3000);
		clickObj(reportsave, "reportsave Button");


		closeDriver();
		logger.log(Status.PASS, MarkupHelper.createLabel("Firefox browser is Closed...", ExtentColor.GREEN));


	}
	//t15
	public static void opportunityMenu() throws InterruptedException, IOException{
		Properties pro=new Properties();
		BufferedReader reader = new BufferedReader(new FileReader("/Users/pranalibankar/eclipse-workspace/SalesforceAutomation/src/test/resources/datafiles/configuration.properties"));
		pro.load(reader);
		
		Properties credpro=new Properties();
		BufferedReader credreader = new BufferedReader(new FileReader("/Users/pranalibankar/eclipse-workspace/SalesforceAutomation/src/test/resources/datafiles/usercredentials.properties"));
		credpro.load(credreader);
		
		logger = extent.createTest("opportunityMenu");
		
		IntializeDriver("firefox", pro.getProperty("firefoxpath"));
		driver.get(pro.getProperty("salesforceUrl"));
		
		logger.log(Status.PASS, MarkupHelper.createLabel("Firefox driver is launched", ExtentColor.GREEN));
		//System.out.println("Pass: Firefox driver is launched");
		
		logger.log(Status.PASS, MarkupHelper.createLabel("SFDC login page is launched..", ExtentColor.GREEN));
		//System.out.println("Pass: SFDC login page is launched..");


		/*Enter username to username field*/
		WebElement un = driver.findElement(By.xpath("//input[@id='username']"));
		enterText(un, credpro.getProperty("loginusername"), "userName");

		/*Enter password to password field*/
		WebElement pwd = driver.findElement(By.xpath("//input[@id='password']"));
		enterText(pwd, credpro.getProperty("loginpassword"), "Password");
		/*Click login*/
		WebElement login = driver.findElement(By.xpath("//input[@id='Login']")) ;
		clickObj(login, "Login Button");


		driver.get("https://na49.salesforce.com/home/home.jsp?source=lex");
		System.out.println(driver.getCurrentUrl());

		WebElement opportunities =driver.findElement(By.id("Opportunity_Tab"));
		Thread.sleep(3000);
		clickObj(opportunities, "opportunities Button");

		//WebElement close =driver.findElement(By.id("tryLexDialogX"));
		//Thread.sleep(3000);
		//clickObj(close, "close Button");

		WebElement oppmenu =driver.findElement(By.xpath("//select[@id='fcf']"));
		Thread.sleep(3000);
		clickObj(oppmenu, "oppmenu Button");

		closeDriver();
		logger.log(Status.PASS, MarkupHelper.createLabel("Firefox browser is Closed...", ExtentColor.GREEN));

	}

	//t16
	public static void selectUserMenu() throws InterruptedException, IOException{
		Properties pro=new Properties();
		BufferedReader reader = new BufferedReader(new FileReader("/Users/pranalibankar/eclipse-workspace/SalesforceAutomation/src/test/resources/datafiles/configuration.properties"));
		pro.load(reader);
		
		Properties credpro=new Properties();
		BufferedReader credreader = new BufferedReader(new FileReader("/Users/pranalibankar/eclipse-workspace/SalesforceAutomation/src/test/resources/datafiles/usercredentials.properties"));
		credpro.load(credreader);
		
		logger = extent.createTest("selectUserMenu");
		
		
		IntializeDriver("firefox", pro.getProperty("firefoxpath"));
		driver.get(pro.getProperty("salesforceUrl"));
		
		logger.log(Status.PASS, MarkupHelper.createLabel("Firefox driver is launched", ExtentColor.GREEN));
		//System.out.println("Pass: Firefox driver is launched");
		
		logger.log(Status.PASS, MarkupHelper.createLabel("SFDC login page is launched..", ExtentColor.GREEN));
		//System.out.println("Pass: SFDC login page is launched..");


		/*Enter username to username field*/
		WebElement un = driver.findElement(By.xpath("//input[@id='username']"));
		enterText(un, credpro.getProperty("loginusername"), "userName");

		/*Enter password to password field*/
		WebElement pwd = driver.findElement(By.xpath("//input[@id='password']"));
		enterText(pwd, credpro.getProperty("loginpassword"), "Password");
		/*Click login*/
		WebElement login = driver.findElement(By.xpath("//input[@id='Login']")) ;
		clickObj(login, "Login Button");


		driver.get("https://na49.salesforce.com/home/home.jsp?source=lex");
		System.out.println(driver.getCurrentUrl());

		WebElement opportunities =driver.findElement(By.id("Opportunity_Tab"));
		Thread.sleep(3000);
		clickObj(opportunities, "opportunities Button");

		// WebElement close =driver.findElement(By.id("tryLexDialogX"));
		// Thread.sleep(3000);
		//clickObj(close, "close Button");

		WebElement createnewoptymenu =driver.findElement(By.xpath("//div[@id='createNewButton']"));
		Thread.sleep(3000);
		clickObj(createnewoptymenu, "create new opty menu Button");

		WebElement createnewopty =driver.findElement(By.xpath("//a[@class='opportunityMru menuButtonMenuLink']"));
		Thread.sleep(3000);
		clickObj(createnewopty, "create new opty Button");

		WebElement oppname =driver.findElement(By.xpath("//input[@id='opp3']"));
		Thread.sleep(3000);
		enterText(oppname, "abc", "opportunity name");


		WebElement accname =driver.findElement(By.xpath("//input[@id='opp4']"));
		Thread.sleep(3000);
		enterText(accname, "ppp", "account name");

		WebElement closedate =driver.findElement(By.xpath("//input[@id='opp9']"));
		Thread.sleep(3000);
		clickObj(closedate, "closedate Button");

		WebElement closedatetoday =driver.findElement(By.xpath("//a[@class='calToday']"));
		Thread.sleep(3000);
		clickObj(closedatetoday, "closedatetoday Button");

		WebElement amntrandomclk =driver.findElement(By.xpath("//label[@for='opp7']"));
		clickObj(amntrandomclk, "amnt random clk Button");

		WebElement stage =driver.findElement(By.xpath("//select[@id='opp11']"));
		Thread.sleep(3000);
		clickObj(stage, "stage Button");

		WebElement qualification =driver.findElement(By.xpath("//option[contains(@value,'Qualification')]"));
		Thread.sleep(3000);
		clickObj(qualification, "qualification Button");


		WebElement probability =driver.findElement(By.xpath("//input[@id='opp12']"));
		Thread.sleep(3000);
		enterText(probability, "1", "probability name");


		WebElement leadsource =driver.findElement(By.xpath("//select[@id='opp6']"));
		Thread.sleep(3000);
		Select select = new Select(leadsource);
		select.selectByVisibleText("Web");



		WebElement optysave=driver.findElement(By.xpath("//td[@id='bottomButtonRow']//input[@title='Save']"));
		Thread.sleep(3000);
		clickObj(optysave, "opty save Button");

		Thread.sleep(5000);  
		closeDriver();
		logger.log(Status.PASS, MarkupHelper.createLabel("Firefox browser is Closed...", ExtentColor.GREEN));


	}

	//t17
	public static void pipelineReport() throws InterruptedException, IOException{
		Properties pro=new Properties();
		BufferedReader reader = new BufferedReader(new FileReader("/Users/pranalibankar/eclipse-workspace/SalesforceAutomation/src/test/resources/datafiles/configuration.properties"));
		pro.load(reader);
		
		Properties credpro=new Properties();
		BufferedReader credreader = new BufferedReader(new FileReader("/Users/pranalibankar/eclipse-workspace/SalesforceAutomation/src/test/resources/datafiles/usercredentials.properties"));
		credpro.load(credreader);
		
		logger = extent.createTest("pipelineReport");
	
	
		IntializeDriver("firefox", pro.getProperty("firefoxpath"));
		driver.get(pro.getProperty("salesforceUrl"));
	
		logger.log(Status.PASS, MarkupHelper.createLabel("Firefox driver is launched", ExtentColor.GREEN));
		//System.out.println("Pass: Firefox driver is launched");
		
		logger.log(Status.PASS, MarkupHelper.createLabel("SFDC login page is launched..", ExtentColor.GREEN));
		//System.out.println("Pass: SFDC login page is launched..");



		/*Enter username to username field*/
		WebElement un = driver.findElement(By.xpath("//input[@id='username']"));
		enterText(un, credpro.getProperty("loginusername"), "userName");

		/*Enter password to password field*/
		WebElement pwd = driver.findElement(By.xpath("//input[@id='password']"));
		enterText(pwd, credpro.getProperty("loginpassword"), "Password");
		/*Click login*/
		WebElement login = driver.findElement(By.xpath("//input[@id='Login']")) ;
		clickObj(login, "Login Button");


		driver.get("https://na49.salesforce.com/home/home.jsp?source=lex");
		System.out.println(driver.getCurrentUrl());


		WebElement opportunities =driver.findElement(By.id("Opportunity_Tab"));
		Thread.sleep(3000);
		clickObj(opportunities, "opportunities Button");

		// WebElement close =driver.findElement(By.id("tryLexDialogX"));
		// Thread.sleep(3000);
		//clickObj(close, "close Button");


		WebElement opppipeline =driver.findElement(By.xpath("//a[contains(text(),'Opportunity Pipeline')]"));
		Thread.sleep(3000);
		clickObj(opppipeline, "opppipeline Button");

		closeDriver();
		logger.log(Status.PASS, MarkupHelper.createLabel("Firefox browser is Closed...", ExtentColor.GREEN));


	}
	//t18
	public static void stuckOpportunitiesReport() throws InterruptedException, IOException{
		Properties pro=new Properties();
		BufferedReader reader = new BufferedReader(new FileReader("/Users/pranalibankar/eclipse-workspace/SalesforceAutomation/src/test/resources/datafiles/configuration.properties"));
		pro.load(reader);
		
		Properties credpro=new Properties();
		BufferedReader credreader = new BufferedReader(new FileReader("/Users/pranalibankar/eclipse-workspace/SalesforceAutomation/src/test/resources/datafiles/usercredentials.properties"));
		credpro.load(credreader);
		
		logger = extent.createTest("stuckOpportunitiesReport");
		
		IntializeDriver("firefox", pro.getProperty("firefoxpath"));
		driver.get(pro.getProperty("salesforceUrl"));
		
		logger.log(Status.PASS, MarkupHelper.createLabel("Firefox driver is launched", ExtentColor.GREEN));
		//System.out.println("Pass: Firefox driver is launched");
		
		logger.log(Status.PASS, MarkupHelper.createLabel("SFDC login page is launched..", ExtentColor.GREEN));
		//System.out.println("Pass: SFDC login page is launched..");


		/*Enter username to username field*/
		WebElement un = driver.findElement(By.xpath("//input[@id='username']"));
		enterText(un, credpro.getProperty("loginusername"), "userName");

		/*Enter password to password field*/
		WebElement pwd = driver.findElement(By.xpath("//input[@id='password']"));
		enterText(pwd, credpro.getProperty("loginpassword"), "Password");
		/*Click login*/
		WebElement login = driver.findElement(By.xpath("//input[@id='Login']")) ;
		clickObj(login, "Login Button");


		driver.get("https://na49.salesforce.com/home/home.jsp?source=lex");
		System.out.println(driver.getCurrentUrl());


		WebElement opportunities =driver.findElement(By.id("Opportunity_Tab"));
		Thread.sleep(3000);
		clickObj(opportunities, "opportunities Button");

		// WebElement close =driver.findElement(By.id("tryLexDialogX"));
		// Thread.sleep(3000);
		//clickObj(close, "close Button");

		WebElement stuckopp =driver.findElement(By.xpath("//a[contains(text(),'Stuck Opportunities')]"));
		clickObj(stuckopp, "stuckopp Button");


		closeDriver();
		logger.log(Status.PASS, MarkupHelper.createLabel("Firefox browser is Closed...", ExtentColor.GREEN));

	}
	//t19
	public static void quarterlySummaryReport() throws InterruptedException, IOException{
		Properties pro=new Properties();
		BufferedReader reader = new BufferedReader(new FileReader("/Users/pranalibankar/eclipse-workspace/SalesforceAutomation/src/test/resources/datafiles/configuration.properties"));
		pro.load(reader);
		Properties credpro=new Properties();
		BufferedReader credreader = new BufferedReader(new FileReader("/Users/pranalibankar/eclipse-workspace/SalesforceAutomation/src/test/resources/datafiles/usercredentials.properties"));
		credpro.load(credreader);
		
		logger = extent.createTest("quarterlySummaryReport");
	
		IntializeDriver("firefox", pro.getProperty("firefoxpath"));
		driver.get(pro.getProperty("salesforceUrl"));
		
		logger.log(Status.PASS, MarkupHelper.createLabel("Firefox driver is launched", ExtentColor.GREEN));
		//System.out.println("Pass: Firefox driver is launched");
		
		logger.log(Status.PASS, MarkupHelper.createLabel("SFDC login page is launched..", ExtentColor.GREEN));
		//System.out.println("Pass: SFDC login page is launched..");


		/*Enter username to username field*/
		WebElement un = driver.findElement(By.xpath("//input[@id='username']"));
		enterText(un, credpro.getProperty("loginusername"), "userName");

		/*Enter password to password field*/
		WebElement pwd = driver.findElement(By.xpath("//input[@id='password']"));
		enterText(pwd, credpro.getProperty("loginpassword"), "Password");
		/*Click login*/
		WebElement login = driver.findElement(By.xpath("//input[@id='Login']")) ;
		clickObj(login, "Login Button");


		driver.get("https://na49.salesforce.com/home/home.jsp?source=lex");
		System.out.println(driver.getCurrentUrl());

		WebElement opportunities =driver.findElement(By.id("Opportunity_Tab"));
		Thread.sleep(3000);
		clickObj(opportunities, "opportunities Button");

		// WebElement close =driver.findElement(By.id("tryLexDialogX"));
		// Thread.sleep(3000);
		//clickObj(close, "close Button");


		WebElement interval =driver.findElement(By.xpath("//select[@id='quarter_q']"));
		Thread.sleep(3000);
		clickObj(interval, "interval Button");


		WebElement crntnnextfq =driver.findElement(By.xpath("//option[@value='curnext1']"));
		Thread.sleep(3000);
		clickObj(crntnnextfq, "current and next fq Button");

		WebElement include =driver.findElement(By.xpath("//select[@id='open']"));
		Thread.sleep(3000);
		clickObj(include, "include Button");

		WebElement openandclose =driver.findElement(By.xpath("	//option[contains(@value,'open')]"));
		Thread.sleep(3000);
		clickObj(openandclose, "openandclose Button");

		WebElement runreport =driver.findElement(By.xpath("//input[contains(@title,'Run Report')]"));
		Thread.sleep(3000);
		clickObj(runreport, "runreport Button");

		closeDriver();
		logger.log(Status.PASS, MarkupHelper.createLabel("Firefox browser is Closed...", ExtentColor.GREEN));


	}
	//t20
	public static void leadsTabLink() throws InterruptedException, IOException{
		Properties pro=new Properties();
		BufferedReader reader = new BufferedReader(new FileReader("/Users/pranalibankar/eclipse-workspace/SalesforceAutomation/src/test/resources/datafiles/configuration.properties"));
		pro.load(reader);
		
		Properties credpro=new Properties();
		BufferedReader credreader = new BufferedReader(new FileReader("/Users/pranalibankar/eclipse-workspace/SalesforceAutomation/src/test/resources/datafiles/usercredentials.properties"));
		credpro.load(credreader);
		
		logger = extent.createTest("leadsTabLink");
		IntializeDriver("firefox", pro.getProperty("firefoxpath"));
		driver.get(pro.getProperty("salesforceUrl"));
		
		logger.log(Status.PASS, MarkupHelper.createLabel("Firefox driver is launched", ExtentColor.GREEN));
		//System.out.println("Pass: Firefox driver is launched");
		
		logger.log(Status.PASS, MarkupHelper.createLabel("SFDC login page is launched..", ExtentColor.GREEN));
		//System.out.println("Pass: SFDC login page is launched..");


		/*Enter username to username field*/
		WebElement un = driver.findElement(By.xpath("//input[@id='username']"));
		enterText(un, credpro.getProperty("loginusername"), "userName");

		/*Enter password to password field*/
		WebElement pwd = driver.findElement(By.xpath("//input[@id='password']"));
		enterText(pwd, credpro.getProperty("loginpassword"), "Password");
		/*Click login*/
		WebElement login = driver.findElement(By.xpath("//input[@id='Login']")) ;
		clickObj(login, "Login Button");


		driver.get("https://na49.salesforce.com/home/home.jsp?source=lex");
		System.out.println(driver.getCurrentUrl());


		WebElement leads =driver.findElement(By.id("Lead_Tab"));
		Thread.sleep(3000);
		clickObj(leads, "leads Button");

		// WebElement close =driver.findElement(By.id("tryLexDialogX"));
		// Thread.sleep(3000);
		//clickObj(close, "close Button");


		WebElement profileclick =driver.findElement(By.xpath("//span[@id='userNavLabel']"));
		Thread.sleep(3000);
		clickObj(profileclick, "profile click Button");

		WebElement profileclicklogout =driver.findElement(By.xpath("//a[text()='Logout']"));
		Thread.sleep(3000);
		clickObj(profileclicklogout, "profile click m, m jh5mlogout Button");

		closeDriver();
		logger.log(Status.PASS, MarkupHelper.createLabel("Firefox browser is Closed...", ExtentColor.GREEN));


	}
	//t21
	public static void validateViewDropdown() throws InterruptedException, IOException{
		Properties pro=new Properties();
		BufferedReader reader = new BufferedReader(new FileReader("/Users/pranalibankar/eclipse-workspace/SalesforceAutomation/src/test/resources/datafiles/configuration.properties"));
		pro.load(reader);
		
		Properties credpro=new Properties();
		BufferedReader credreader = new BufferedReader(new FileReader("/Users/pranalibankar/eclipse-workspace/SalesforceAutomation/src/test/resources/datafiles/usercredentials.properties"));
		credpro.load(credreader);
		
		logger = extent.createTest("validateViewDropdown");
		
		IntializeDriver("firefox", pro.getProperty("firefoxpath"));
		driver.get(pro.getProperty("salesforceUrl"));
		
		logger.log(Status.PASS, MarkupHelper.createLabel("Firefox driver is launched", ExtentColor.GREEN));
		//System.out.println("Pass: Firefox driver is launched");
		
		logger.log(Status.PASS, MarkupHelper.createLabel("SFDC login page is launched..", ExtentColor.GREEN));
		//System.out.println("Pass: SFDC login page is launched..");


		/*Enter username to username field*/
		WebElement un = driver.findElement(By.xpath("//input[@id='username']"));
		enterText(un, credpro.getProperty("loginusername"), "userName");

		/*Enter password to password field*/
		WebElement pwd = driver.findElement(By.xpath("//input[@id='password']"));
		enterText(pwd, credpro.getProperty("loginpassword"), "Password");
		/*Click login*/
		WebElement login = driver.findElement(By.xpath("//input[@id='Login']")) ;
		clickObj(login, "Login Button");


		driver.get("https://na49.salesforce.com/home/home.jsp?source=lex");
		System.out.println(driver.getCurrentUrl());


		WebElement leads =driver.findElement(By.id("Lead_Tab"));
		Thread.sleep(3000);
		clickObj(leads, "leads Button");

		// WebElement close =driver.findElement(By.id("tryLexDialogX"));
		// Thread.sleep(3000);
		//clickObj(close, "close Button");


		WebElement leadsmenu =driver.findElement(By.xpath("//select[@id='fcf']"));
		Thread.sleep(3000);
		clickObj(leadsmenu, "leadsmenu Button");


		WebElement profileclick =driver.findElement(By.xpath("//span[@id='userNavLabel']"));
		Thread.sleep(3000);
		clickObj(profileclick, "profile click Button");

		WebElement profileclicklogout =driver.findElement(By.xpath("//a[text()='Logout']"));
		Thread.sleep(3000);
		clickObj(profileclicklogout, "profile click m, m jh5mlogout Button");

		closeDriver();
		logger.log(Status.PASS, MarkupHelper.createLabel("Firefox browser is Closed...", ExtentColor.GREEN));

	}
	//t22
	public static void functionalityGoButton() throws InterruptedException, IOException{
		Properties pro=new Properties();
		BufferedReader reader = new BufferedReader(new FileReader("/Users/pranalibankar/eclipse-workspace/SalesforceAutomation/src/test/resources/datafiles/configuration.properties"));
		pro.load(reader);
		
		Properties credpro=new Properties();
		BufferedReader credreader = new BufferedReader(new FileReader("/Users/pranalibankar/eclipse-workspace/SalesforceAutomation/src/test/resources/datafiles/usercredentials.properties"));
		credpro.load(credreader);
		
		logger = extent.createTest("functionalityGoButton");
	
		IntializeDriver("firefox", pro.getProperty("firefoxpath"));
		driver.get(pro.getProperty("salesforceUrl"));
		
		logger.log(Status.PASS, MarkupHelper.createLabel("Firefox driver is launched", ExtentColor.GREEN));
		//System.out.println("Pass: Firefox driver is launched");
		
		logger.log(Status.PASS, MarkupHelper.createLabel("SFDC login page is launched..", ExtentColor.GREEN));
		//System.out.println("Pass: SFDC login page is launched..");


		/*Enter username to username field*/
		WebElement un = driver.findElement(By.xpath("//input[@id='username']"));
		enterText(un, credpro.getProperty("loginusername"), "userName");

		/*Enter password to password field*/
		WebElement pwd = driver.findElement(By.xpath("//input[@id='password']"));
		enterText(pwd, credpro.getProperty("loginpassword"), "Password");
		/*Click login*/
		WebElement login = driver.findElement(By.xpath("//input[@id='Login']")) ;
		clickObj(login, "Login Button");


		driver.get("https://na49.salesforce.com/home/home.jsp?source=lex");
		System.out.println(driver.getCurrentUrl());


		WebElement leads =driver.findElement(By.id("Lead_Tab"));
		Thread.sleep(3000);
		clickObj(leads, "leads Button");

		// WebElement close =driver.findElement(By.id("tryLexDialogX"));
		// Thread.sleep(3000);
		//clickObj(close, "close Button");


		WebElement todayslead =driver.findElement(By.xpath("//option[@value='00B5A000008oGV0']"));
		Thread.sleep(3000);
		clickObj(todayslead, "todays lead Button");

		WebElement profileclick =driver.findElement(By.xpath("//span[@id='userNavLabel']"));
		Thread.sleep(3000);
		clickObj(profileclick, "profile click Button");

		WebElement profileclicklogout =driver.findElement(By.xpath("//a[text()='Logout']"));
		Thread.sleep(3000);
		clickObj(profileclicklogout, "profile click m, m jh5mlogout Button");

		driver.get("https://login.salesforce.com");

		/*Enter username to username field*/
		WebElement un1 = driver.findElement(By.xpath("//input[@id='username']"));
		enterText(un1, credpro.getProperty("loginusername"), "userName");


		/*Enter password to password field*/
		WebElement pwd1 = driver.findElement(By.xpath("//input[@id='password']"));
		enterText(pwd1, credpro.getProperty("loginpassword"), "Password");

		/*Click login*/
		WebElement login1 = driver.findElement(By.xpath("//input[@id='Login']")) ;
		clickObj(login1, "Login Button");

		WebElement leads1 =driver.findElement(By.id("Lead_Tab"));
		Thread.sleep(3000);
		clickObj(leads1, "leads Button");

		WebElement gobutton =driver.findElement(By.xpath("//input[@title='Go!']"));
		Thread.sleep(3000);
		clickObj(gobutton, "gobutton Button");


		WebElement profileclick1 =driver.findElement(By.xpath("//span[@id='userNavLabel']"));
		Thread.sleep(3000);
		clickObj(profileclick1, "profile click Button");

		WebElement profileclicklogout1 =driver.findElement(By.xpath("//a[text()='Logout']"));
		Thread.sleep(3000);
		clickObj(profileclicklogout1, "profile click m, m jh5mlogout Button");

		closeDriver();
		logger.log(Status.PASS, MarkupHelper.createLabel("Firefox browser is Closed...", ExtentColor.GREEN));


	}
	//t23
	public static void todaysLeadsWork() throws InterruptedException, IOException{
		Properties pro=new Properties();
		BufferedReader reader = new BufferedReader(new FileReader("/Users/pranalibankar/eclipse-workspace/SalesforceAutomation/src/test/resources/datafiles/configuration.properties"));
		pro.load(reader);
		
		Properties credpro=new Properties();
		BufferedReader credreader = new BufferedReader(new FileReader("/Users/pranalibankar/eclipse-workspace/SalesforceAutomation/src/test/resources/datafiles/usercredentials.properties"));
		credpro.load(credreader);
		
		logger = extent.createTest("todaysLeadsWork");
		
		IntializeDriver("firefox", pro.getProperty("firefoxpath"));
		driver.get(pro.getProperty("salesforceUrl"));
		
		
		logger.log(Status.PASS, MarkupHelper.createLabel("Firefox driver is launched", ExtentColor.GREEN));
		//System.out.println("Pass: Firefox driver is launched");
		
		logger.log(Status.PASS, MarkupHelper.createLabel("SFDC login page is launched..", ExtentColor.GREEN));
		//System.out.println("Pass: SFDC login page is launched..");



		/*Enter username to username field*/
		WebElement un = driver.findElement(By.xpath("//input[@id='username']"));
		enterText(un, credpro.getProperty("loginusername"), "userName");

		/*Enter password to password field*/
		WebElement pwd = driver.findElement(By.xpath("//input[@id='password']"));
		enterText(pwd, credpro.getProperty("loginpassword"), "Password");
		/*Click login*/
		WebElement login = driver.findElement(By.xpath("//input[@id='Login']")) ;
		clickObj(login, "Login Button");


		driver.get("https://na49.salesforce.com/home/home.jsp?source=lex");
		System.out.println(driver.getCurrentUrl());


		WebElement leads =driver.findElement(By.id("Lead_Tab"));
		Thread.sleep(3000);
		clickObj(leads, "leads Button");

		// WebElement close =driver.findElement(By.id("tryLexDialogX"));
		// Thread.sleep(3000);
		//clickObj(close, "close Button");


		WebElement todayslead =driver.findElement(By.xpath("//option[@value='00B5A000008oGV0']"));
		Thread.sleep(3000);
		clickObj(todayslead, "todays lead Button");

		WebElement profileclick =driver.findElement(By.xpath("//span[@id='userNavLabel']"));
		Thread.sleep(3000);
		clickObj(profileclick, "profile click Button");

		WebElement profileclicklogout =driver.findElement(By.xpath("//a[text()='Logout']"));
		Thread.sleep(3000);
		clickObj(profileclicklogout, "profile click m, m jh5mlogout Button");

		closeDriver();
		logger.log(Status.PASS, MarkupHelper.createLabel("Firefox browser is Closed...", ExtentColor.GREEN));

	}
	//t24
	public static void newButtonLeadsHome() throws InterruptedException, IOException{
		Properties pro=new Properties();
		BufferedReader reader = new BufferedReader(new FileReader("/Users/pranalibankar/eclipse-workspace/SalesforceAutomation/src/test/resources/datafiles/configuration.properties"));
		pro.load(reader);
		Properties credpro=new Properties();
		BufferedReader credreader = new BufferedReader(new FileReader("/Users/pranalibankar/eclipse-workspace/SalesforceAutomation/src/test/resources/datafiles/usercredentials.properties"));
		credpro.load(credreader);
		
		logger = extent.createTest("newButtonLeadsHome");
		
		IntializeDriver("firefox", pro.getProperty("firefoxpath"));
		driver.get(pro.getProperty("salesforceUrl"));
		
		logger.log(Status.PASS, MarkupHelper.createLabel("Firefox driver is launched", ExtentColor.GREEN));
		//System.out.println("Pass: Firefox driver is launched");
		
		logger.log(Status.PASS, MarkupHelper.createLabel("SFDC login page is launched..", ExtentColor.GREEN));
		//System.out.println("Pass: SFDC login page is launched..");



		/*Enter username to username field*/
		WebElement un = driver.findElement(By.xpath("//input[@id='username']"));
		enterText(un, credpro.getProperty("loginusername"), "userName");

		/*Enter password to password field*/
		WebElement pwd = driver.findElement(By.xpath("//input[@id='password']"));
		enterText(pwd, credpro.getProperty("loginpassword"), "Password");
		/*Click login*/
		WebElement login = driver.findElement(By.xpath("//input[@id='Login']")) ;
		clickObj(login, "Login Button");


		driver.get("https://na49.salesforce.com/home/home.jsp?source=lex");
		System.out.println(driver.getCurrentUrl());


		WebElement leads =driver.findElement(By.id("Lead_Tab"));
		Thread.sleep(3000);
		clickObj(leads, "leads Button");

		// WebElement close =driver.findElement(By.id("tryLexDialogX"));
		// Thread.sleep(3000);
		//clickObj(close, "close Button");


		WebElement createnewleadmenu =driver.findElement(By.xpath("//div[@id='createNewButton']"));
		Thread.sleep(3000);
		clickObj(createnewleadmenu, "create new lead menu Button");

		WebElement createnewlead =driver.findElement(By.xpath("//a[@class='leadMru menuButtonMenuLink']"));
		Thread.sleep(3000);
		clickObj(createnewlead, "create new lead Button");


		WebElement lastname =driver.findElement(By.xpath("//input[@id='name_lastlea2']"));
		Thread.sleep(3000);
		enterText(lastname, "ABCD", "lastname");

		WebElement companyname =driver.findElement(By.xpath("//input[@id='lea3']"));
		Thread.sleep(3000);
		enterText(companyname, "ABCD", "company name");


		WebElement newleadsave =driver.findElement(By.xpath("//td[@id='bottomButtonRow']//input[@title='Save']"));
		Thread.sleep(3000);
		clickObj(newleadsave, "new lead save Button");

		WebElement profileclick =driver.findElement(By.xpath("//span[@id='userNavLabel']"));
		Thread.sleep(3000);
		clickObj(profileclick, "profile click Button");

		WebElement profileclicklogout =driver.findElement(By.xpath("//a[text()='Logout']"));
		Thread.sleep(3000);
		clickObj(profileclicklogout, "profile click m, m jh5mlogout Button");

		closeDriver();
		logger.log(Status.PASS, MarkupHelper.createLabel("Firefox browser is Closed...", ExtentColor.GREEN));

	} 
	//t25
	public static void createNewContact() throws InterruptedException, IOException{
		Properties pro=new Properties();
		BufferedReader reader = new BufferedReader(new FileReader("/Users/pranalibankar/eclipse-workspace/SalesforceAutomation/src/test/resources/datafiles/configuration.properties"));
		pro.load(reader);
		
		Properties credpro=new Properties();
		BufferedReader credreader = new BufferedReader(new FileReader("/Users/pranalibankar/eclipse-workspace/SalesforceAutomation/src/test/resources/datafiles/usercredentials.properties"));
		credpro.load(credreader);
		
		logger = extent.createTest("createNewContact");
		
		IntializeDriver("firefox", pro.getProperty("firefoxpath"));
		driver.get(pro.getProperty("salesforceUrl"));
		
		logger.log(Status.PASS, MarkupHelper.createLabel("Firefox driver is launched", ExtentColor.GREEN));
		//System.out.println("Pass: Firefox driver is launched");
		
		logger.log(Status.PASS, MarkupHelper.createLabel("SFDC login page is launched..", ExtentColor.GREEN));
		//System.out.println("Pass: SFDC login page is launched..");


		/*Enter username to username field*/
		WebElement un = driver.findElement(By.xpath("//input[@id='username']"));
		enterText(un, credpro.getProperty("loginusername"), "userName");

		/*Enter password to password field*/
		WebElement pwd = driver.findElement(By.xpath("//input[@id='password']"));
		enterText(pwd, credpro.getProperty("loginpassword"), "Password");
		/*Click login*/
		WebElement login = driver.findElement(By.xpath("//input[@id='Login']")) ;
		clickObj(login, "Login Button");


		driver.get("https://na49.salesforce.com/home/home.jsp?source=lex");
		System.out.println(driver.getCurrentUrl());


		WebElement leads =driver.findElement(By.id("Lead_Tab"));
		Thread.sleep(3000);
		clickObj(leads, "leads Button");

		// WebElement close =driver.findElement(By.id("tryLexDialogX"));
		// Thread.sleep(3000);
		//clickObj(close, "close Button");

		WebElement createnewcontactmenu =driver.findElement(By.xpath("//div[@id='createNewButton']"));
		Thread.sleep(3000);
		clickObj(createnewcontactmenu, "create new contact menu Button");

		WebElement newcontact =driver.findElement(By.xpath("//a[@class='contactMru menuButtonMenuLink']"));
		Thread.sleep(3000);
		clickObj(newcontact, "new contact Button");


		WebElement lastname =driver.findElement(By.xpath("//input[@id='name_lastcon2']"));
		Thread.sleep(3000);
		enterText(lastname, "bbb", "lastname");

		WebElement accname =driver.findElement(By.xpath("//input[@id='con4']"));
		Thread.sleep(3000);
		enterText(accname, "ppp", "account name");

		WebElement contactsave =driver.findElement(By.xpath("//td[@id='bottomButtonRow']//input[@title='Save']"));
		Thread.sleep(3000);
		clickObj(contactsave, "contact save Button");

		Thread.sleep(5000);

		closeDriver();
		logger.log(Status.PASS, MarkupHelper.createLabel("Firefox browser is Closed...", ExtentColor.GREEN));
	}

}


