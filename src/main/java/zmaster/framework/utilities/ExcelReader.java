package zmaster.framework.utilities;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	private XSSFWorkbook workbook = null;
	private Sheet sheet = null;
	private Row row = null;
	private Cell cell = null;
	private File file = null;


	public ExcelReader(String filePath) {

		file = new File(filePath);
		try {
			workbook = new XSSFWorkbook(file);
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void sheetToUse(String sheetName) {
		
		 if(workbook == null)
			 System.out.println("No workbook selected. Please make sure file is selected");
		 else
		    sheet = workbook.getSheet(sheetName);
	}
	
	public int getNumberOfRows(String sheetName) {
		
		  if(workbook == null)
			  System.out.println("No workbook selected");
		  else
	        return workbook.getSheet(sheetName).getPhysicalNumberOfRows();	    
		
		  return -1;
	}
	
	public int getNumberOfCols(String sheetName) {
		
		  if(workbook == null)
		   System.out.println("No workbook selected");
		  else
		   return workbook.getSheet(sheetName).getRow(0).getPhysicalNumberOfCells();
		  
		  return -1;
	}
	
	public String readData(int row, int col) {
		
		String data = null;
		
		   if(sheet != null) {
			   this.row = sheet.getRow(row);
			   this.cell = this.row.getCell(col);
			   
			   switch(this.cell.getCellType()) {
			   
			   case BLANK: 
				     break;
			   case STRING: data = this.cell.getStringCellValue();
			        break;
			   case NUMERIC: data = String.valueOf(this.cell.getNumericCellValue()); 
			        break;
			   default: data = null;     
			   }
		   } else
			   System.err.println("Please set sheet first");
		
		   return data;
	}
	

}
