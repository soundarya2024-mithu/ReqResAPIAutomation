package api.Utilities;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name="dp")
	public Object[][] getData(){
		return ExcelUtility.getExcelData((System.getProperty("user.dir")+"\\testdata\\Userdata.xlsx"),"Sheet1");
	}

}
