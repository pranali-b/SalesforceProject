package reusableMethods;

import java.io.IOException;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.testng.annotations.Test;

public class DriverScriptTest extends Automationnew{

	@Test
	public static void mainMethod() throws Exception{

		String dt_Path = "/Users/pranalibankar/eclipse-workspace/SalesforceAutomation/src/test/resources/Utility/Book1.xls";


		String[][] recdata = ReusableMethodsnew.readSheet(dt_Path, "Sheet1");
		String testCase =null;
		executionReport("TestReports");

		String flag = null;

		for(int i = 1; i< recdata.length; i++) {


			flag = recdata[i][1];
			if(flag.equalsIgnoreCase("Y")) {
				testCase = recdata[i][2];

				/*Java Reflection */
				Method testScript = Automationnew.class.getMethod(testCase);
				testScript.invoke(testScript);

			}else {
				System.out.println("**********Row  number " + i + " test case Name " + recdata[i][2] + " is not Executed*********");
			}

		}
		
		endExtentReport();
	}
	


}
