package reusableMethods;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ReusableMethodsnew extends SalesforceBaseClass {
	
	 public static ExtentHtmlReporter htmlReporter;
	 public static ExtentReports extent=null;
	 public static ExtentTest logger=null;
	 
	 
	/* 
	 * Name of the Method: enterText
	 * Brief Description: Enters text to text field
	 * Arguments: obj --> Web object, textVal --> Text value to be entered in text box, objName --> Nam eof the object
	 * Created By: Automation team
	 * Creation Date: Oct 09 2018
	 * Last Modified: Oct 09 2018 
	 */

	// CMMI-V level standards 

	public static void enterText(WebElement obj, String textVal, String objName) {

		if(obj.isDisplayed()) {
			obj.clear();
			obj.sendKeys(textVal);
			logger.log(Status.PASS, MarkupHelper.createLabel(textVal + " is entered in "+ objName +" field", ExtentColor.GREEN));
			//System.out.println("Pass: " + textVal + " is entered in "+ objName +" field");
		}else {
			logger.log(Status.FAIL,MarkupHelper.createLabel(objName +" field does not exist, please check your application", ExtentColor.RED));
			//System.out.println("Fail: "+ objName +" field does not exist, please check your application" );
		}

	}

	/* 
	 * Name of the Method: clickObj
	 * Brief Description: click on the object
	 * Arguments: obj --> Web object, objName--> Name of the object 
	 * Created By: Automation team
	 * Creation Date: Oct 09 2018
	 * Last Modified: Oct 09 2018 
	 */

	public static void clickObj(WebElement obj, String objName) {
		if(obj.isDisplayed()) {
			obj.click();
			logger.log(Status.PASS, MarkupHelper.createLabel(objName +" is clicked", ExtentColor.GREEN));
			//System.out.println("Pass: "+ objName +" is clicked");
		}else {
			logger.log(Status.FAIL,MarkupHelper.createLabel(objName +" field does not exist, please check your application", ExtentColor.RED));
			//System.out.println("Fail: "+ objName +" Object does not exist, please check the application");
		}

	}

	/* 
	 * Name of the Method: validate_Login_Error_message
	 * Brief Description: validates error message
	 * Arguments: obj --> Web object, objName--> Name of the object 
	 * Created By: Automation team
	 * Creation Date: Oct 09 2018
	 * Last Modified: Oct 09 2018 
	 */
	public static void validate_Error_message(WebElement obj, String objName , String expData) throws IOException {
		if(obj.isDisplayed()) {
			String actualData = obj.getText();
			if(actualData.equals(expData)) {
				//System.out.println("Pass: "+ objName +" is verified");
				logger.log(Status.PASS, MarkupHelper.createLabel(objName +" is verified", ExtentColor.GREEN));

			} else {
				//System.out.println("Pass: "+ objName +" is not verified");
				logger.log(Status.FAIL,MarkupHelper.createLabel(objName +" is not verified", ExtentColor.RED));
				String imagePath=takeScreenShot();
				logger.addScreenCaptureFromPath(imagePath);
			}
		}else {
			//System.out.println("Fail: "+ objName +" Object does not exist, please check the application");
			logger.log(Status.FAIL,MarkupHelper.createLabel(objName +" field does not exist, please check your application", ExtentColor.RED));

		}
	}

	/* 
	 * Name of the Method: takeScreenShot
	 * Brief Description: takes screenshot of failed test
	 * Created By: Automation team
	 * Creation Date: Oct 11 2018
	 * Last Modified: Oct 11 2018 
	 */

	public static String takeScreenShot() throws IOException{
		String reportPath=new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		String curDir=System.getProperty("user.dir");
		String destination=curDir+"/TestReports/screenshots/"+reportPath+"image.PNG";
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(destination),true);
		return destination;
	}

	/* 
	 * Name of the Method: selectByValue
	 * Brief Description: select obj using value
	 * Arguments: obj --> Web object, objName--> Name of the object
	 * textVal --> Text value to be entered in text box 
	 * Created By: Automation team
	 * Creation Date: Oct 09 2018
	 * Last Modified: Oct 09 2018 
	 */
	public static void selectByValue(WebElement obj, String objName , String textValue) {
		if(obj.isDisplayed()) {
			obj.click();
			Select select = new Select(obj);
			select.selectByValue(textValue);
			//System.out.println("Pass: "+ objName +" is clicked");
			logger.log(Status.PASS, MarkupHelper.createLabel(objName +" is clicked", ExtentColor.GREEN));

		}else {
			//System.out.println("Fail: "+ objName +" Object does not exist, please check the application");
			logger.log(Status.FAIL,MarkupHelper.createLabel(objName +" field does not exist, please check your application", ExtentColor.RED));

		}
	}

	/* 
	 * Name of the Method:executionReport
	 * Brief Description: generates report
	 * Arguments: reportName --> name of report 
	 * textVal --> Text value to be entered in text box 
	 * Created By: Automation team
	 * Creation Date: Oct 10 2018
	 * Last Modified: Oct 10 2018 
	 */
	public static void executionReport(String reportName) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
		String timeNow = dtf.format(now);
		String s=new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());


		System.out.println(System.getProperty("user.dir")+ "/TestReports/" + reportName +"_"+s+"_MySimpleReport.html");

		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+ "/TestReports/" + reportName +"_"+s+"_MySimpleReport.html");

		extent = new ExtentReports ();
		extent.attachReporter(htmlReporter);
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Environment", "QA Automation");
		extent.setSystemInfo("User Name", "Pranali");

	}

	/* 
	 * Name of the Method:createTestScriptReport
	 * Brief Description: creates report
	 * Arguments: testScriptName --> name of script 
	 * Created By: Automation team
	 * Creation Date: Oct 11 2018
	 * Last Modified: Oct 11 2018 
	 */
	public static ExtentTest createTestScriptReport(String testScriptName){
		logger = extent.createTest(testScriptName);
		return logger;
	}

	/* 
	 * Name of the Method:endExtentReport
	 * Brief Description:ends report
	 * Created By: Automation team
	 * Creation Date: Oct 11 2018
	 * Last Modified: Oct 11 2018 
	 */
	public static void endExtentReport(){
		extent.flush();

	}

	public static String[][] readSheet(String dt_Path, String sheetName) throws IOException{


		/*Step 1: Get the XL Path*/
		File xlFile = new File(dt_Path);

		/*Step2: Access the Xl File*/
		FileInputStream xlDoc = new FileInputStream(xlFile);


		/*Step3: Access the work book */
		HSSFWorkbook wb = new HSSFWorkbook(xlDoc);


		/*Step4: Access the Sheet */
		HSSFSheet sheet = wb.getSheet(sheetName);

		int iRowCount = sheet.getLastRowNum()+1;
		int iColCount = sheet.getRow(0).getLastCellNum();

		String[][] xlData = new String[iRowCount][iColCount];

		for(int i=0; i<iRowCount; i++){
			for(int j = 0; j<iColCount; j++){
				HSSFCell cell= sheet.getRow(i).getCell(j);
				if(cell.getCellType()==CellType.STRING) {
					xlData[i][j]=cell.getStringCellValue();
				}else if(cell.getCellType()==CellType.NUMERIC)  {
					xlData[i][j]=String.valueOf(cell.getNumericCellValue());//type cast to string
					}
			}

		}

		return xlData;
	}


}
