package zmaster.framework.utilities;

import java.lang.reflect.Method;
import java.util.Hashtable;

import org.testng.annotations.DataProvider;

public class DataClass {
	
	@DataProvider(name = "CommonDataProvider", parallel = true)
	public Object[][] getData(Method m) {
		
		ExcelReader reader = new ExcelReader(DataConstants.MASTER_FILE_PATH);
		reader.sheetToUse(m.getName());
		
		int rows = reader.getNumberOfRows(m.getName());
		int cols = reader.getNumberOfCols(m.getName());
		
		if(rows < 2) {
			System.out.println("Found No Rows");
			return null;
		}
		
		Object [][] data = new Object[rows-1][1];
		Hashtable<String, String> ht;
		
       for(int i = 2; i <= rows; i++) {
    	   ht = new Hashtable<String, String>();
    	   for(int j = 1; j <= cols; j++) {
    		   ht.put(reader.readData(0, j-1), reader.readData(i-1, j-1));
    	   }
    	   data[i-2][0] = ht;
       }
		
		return data;
		
		
	}
	
	
	
	
	
	
	

}
