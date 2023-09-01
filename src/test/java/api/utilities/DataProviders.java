package api.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name="data")
	public String[][] getData() throws IOException{
		
		 ExcelUtility utlity= new ExcelUtility(".\\testData\\userdata.xlsx");
		 int rowCount=utlity.getRowCount("Sheet1");
		 int colCount=utlity.getCellCount("Sheet1", 1);
		 String data[][]= new String[rowCount][colCount];
		 for(int i=1;i<=rowCount;i++) {
			 for(int j=0;j<colCount;j++) {
				 data[i-1][j]=utlity.getCellData("Sheet1",i,j);
			 }
		 }
		 return data;
	}
	@DataProvider(name="username")
	
	public String[] getUserName() throws IOException {
		
		ExcelUtility utlity= new ExcelUtility(".\\testData\\userdata.xlsx");
		 int rowCount=utlity.getRowCount("Sheet1");
		 
		 String username[] = new String[rowCount];
		 for(int i=1;i<=rowCount;i++) {
			 username[i-1]=utlity.getCellData("Sheet1", i, 1);
			 
			 System.out.println("row data "+utlity.getCellData("Sheet1", i, 1));
		 }
		
		
		return username;
		
	}

}
 