package testScript;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class SalesforceBaseClass {

	public static WebDriver driver=null;
	public static WebDriver IntializeDriver(String name, String path){
		//System.setProperty("webdriver.firefox.bin","C:/Program Files/Mozilla Firefox53/firefox.exe");
		if(name.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver",path);
			driver=new FirefoxDriver();
		}
		else if(name.equalsIgnoreCase("chrome")){
			System.out.println("chrome entered");
			System.setProperty("webdriver.chrome.driver","./src/Utility/chromedriver");
			driver=new ChromeDriver();
		
		}
		else if(name.equalsIgnoreCase("ie")){
			System.out.println("internet explorer entered");
			System.setProperty("webdriver.ie.driver","./src/test/resources/IEDriverServer");
			driver=new InternetExplorerDriver();
		}
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		return driver;
	}
	public static void closeDriver(){
		driver.close();
	}
}
