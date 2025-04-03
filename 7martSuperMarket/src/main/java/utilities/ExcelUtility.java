package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import constants.Constant;

public class ExcelUtility {
	static FileInputStream f; //static-to get access through out the program
	static XSSFWorkbook w;  
	static XSSFSheet sh;
	public static String getStringData(int a,int b,String sheet) throws IOException 
	{	
		String filepath=Constant.TESTDATA;
		f=new FileInputStream(filepath);// to get the path
		w=new XSSFWorkbook(f); //to get the excel workbook
		sh=w.getSheet(sheet); // to get the particular sheet from workbook
		XSSFRow r=sh.getRow(a); // to get the row from the sheet
		XSSFCell c=r.getCell(b); //to get the cell from the sheet
		return c.getStringCellValue();//its a method	(Get the value of the cell as a string )																																																																																							
		
	}



public static String getIntegerData(int a,int b,String sheet) throws IOException
{	
	String filepath=Constant.TESTDATA;
	f=new FileInputStream(filepath);
	w=new XSSFWorkbook(f);
	sh=w.getSheet(sheet);
	XSSFRow r=sh.getRow(a);
	XSSFCell c=r.getCell(b);
	int x=   (int) c.getNumericCellValue();//we will get float as output so we need to type cast it to integer
	return String.valueOf(x); //converts the integer value to String
}

}
