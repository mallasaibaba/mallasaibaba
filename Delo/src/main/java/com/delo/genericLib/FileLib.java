package com.delo.genericLib;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * This generic class contains file handling generic methods 
 * @author sai malla 
 *
 */

public class FileLib {
	/**
	 * This generic reusable method is used to read data from property file 
	 * @param propPath
	 * @param key
	 * @return propValue
	 * @throws Throwable
	 */
	public String readPropertyData(String propPath ,String key) throws Throwable 
	{
		FileInputStream fis = new FileInputStream(propPath);
		Properties prop=new Properties();
		prop.load(fis);
		String propValue = prop.getProperty(key,"Incorrect key");
		return propValue;
		
		}
	/**
	 * This generic reusable method is used to read data from excel file
	 * @param excelPath
	 * @param SheetName
	 * @param row
	 * @param cell
	 * @return Excelvalue
	 * @throws Throwable
	 */
	public String readExcelData(String excelPath , String Sheet, int row , int cell) throws Throwable
	{
		FileInputStream fis = new FileInputStream(excelPath);
		Workbook wb = WorkbookFactory.create(fis);
		String Excelvalue = wb.getSheet(Sheet).getRow(row).getCell(cell).toString();
		
		return Excelvalue;
		
		
	}
	/**
	 * This Generic reusable method is used to write the data inside excel file 
	 * @param excelPath
	 * @param SheetName
	 * @param row
	 * @param cell
	 * @param data
	 * @throws Throwable
	 */
	public void WriteExcelData(String excelPath , String SheetName , int row ,int cell,String data) throws Throwable
	{
		FileInputStream fis = new FileInputStream(excelPath);
		Workbook wb = WorkbookFactory.create(fis);
		  wb.getSheet(SheetName).getRow(row).createCell(cell).setCellValue(data);
		   FileOutputStream fos = new FileOutputStream(excelPath);
		   wb.write(fos);
		
	}
	/**
	 * This generic reusable method is used to count the total rows filled in any sheet of an excel file 
	 * @param path
	 * @param sheet
	 * @return
	 * @throws Throwable
	 */
	public int getRowCount(String path , String sheet) throws Throwable
	{
		FileInputStream fis = new FileInputStream(path);
		Workbook wb=WorkbookFactory.create(fis);
		int rowCount = wb.getSheet(sheet).getLastRowNum();
		return rowCount;
		
		
		
		
	}
	

}
