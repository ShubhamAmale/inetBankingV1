package com.inetBankingV1.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtils {

	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static HSSFWorkbook wb;
	public static HSSFSheet ws;
	public static HSSFRow row;
	public static HSSFCell cell;
		
	
	public static int getRowCount(String xlpath, String xlsheet) throws IOException{
		try {
		Thread.sleep(4000);	
		fi = new FileInputStream(xlpath);
		wb = new HSSFWorkbook(fi);
		ws= wb.getSheet(xlsheet);
		}
		
		catch(Exception e){
			System.out.println("Error accessing excel file");
			
		}
		int rowcount = ws.getLastRowNum();
		wb.close();
		fi.close();
		return rowcount;
	}
	
	
	public static int getCellCount(String xlpath, String xlsheet, int rownum) throws IOException{
		fi = new FileInputStream(xlpath);
		wb = new HSSFWorkbook(fi);
		ws= wb.getSheet(xlsheet);
		row=ws.getRow(rownum);
		int cellcount = row.getLastCellNum();
		wb.close();
		fi.close();
		return cellcount;
	}
	
	
	public static String getCellData(String xlpath, String xlsheet, int rownum, int colnum) throws IOException{
		fi = new FileInputStream(xlpath);
		wb = new HSSFWorkbook(fi);
		ws= wb.getSheet(xlsheet);
		row=ws.getRow(rownum);
		cell=row.getCell(colnum);
		String data;
		try {
			DataFormatter formatter = new DataFormatter();
	        String cellData = formatter.formatCellValue(cell);
	        return cellData;
		}
		catch (Exception e){
			data = "";
			
		}
		wb.close();
		fi.close();
		return data;
	}
	
	
	public static void setCellData(String xlpath, String xlsheet, int rownum, int colnum, String data) throws IOException{
		fi = new FileInputStream(xlpath);
		wb = new HSSFWorkbook(fi);
		ws= wb.getSheet(xlsheet);
		row=ws.getRow(rownum);
		cell=row.createCell(colnum);
		cell.setCellValue(data);
		fo = new FileOutputStream(xlpath);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();
	}
}
