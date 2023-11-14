package com.inetBanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public  class XlUtility {
	public FileInputStream  fi;
	public FileOutputStream fo;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	
	public XSSFCellStyle style;
	
	public int getRowcount(String xlfile,String sheetname) throws IOException {
		fi = new FileInputStream(xlfile);
		workbook = new XSSFWorkbook(fi); 
		sheet = workbook.getSheet(sheetname);
		int rowcount = sheet.getLastRowNum();
		workbook.close();
		fi.close();
		return rowcount;
			 
	}
	public int getCellcount(String xlfile,String sheetname,int Rowcount) throws IOException {
		fi = new FileInputStream(xlfile);
		workbook = new XSSFWorkbook(fi); 
		sheet = workbook.getSheet(sheetname);
		int cellcount = sheet.getRow(Rowcount).getLastCellNum();
		workbook.close();
		fi.close();
		return cellcount;			 
	}
	public String getCellData(String xlfile,String sheetname,int Rowcount,int cellcount) throws IOException {
		fi = new FileInputStream(xlfile);
		workbook = new XSSFWorkbook(fi); 
		sheet = workbook.getSheet(sheetname);
		row = sheet.getRow(Rowcount);
		cell = row.getCell(cellcount);
		
		DataFormatter dataformater = new DataFormatter();
		String data;
		try {
			data = dataformater.formatCellValue(cell);
		}catch(Exception e) {
			data ="";
		}
		workbook.close();
		fi.close();
		return data;
	}
	public void SetCellData(String xlfile,String sheetname,int Rowcount,int cellcount,String data) throws IOException {
		fi = new FileInputStream(xlfile);
		workbook = new XSSFWorkbook(fi); 
		sheet = workbook.getSheet(sheetname);
		row = sheet.getRow(Rowcount);
		cell = row.createCell(cellcount);
		cell.setCellValue(data);
		
		fo = new FileOutputStream(xlfile);
		workbook.write(fo);
		workbook.close();
		fi.close();
		fo.close();
	}
	
	public void setcellData(String xlfile,String sheetname,int rownum,int colnum,String data) throws IOException, InvalidFormatException {
		File exlfile = new File(xlfile);
		//file not exists create 
		if(!exlfile.exists()) {
			workbook = new XSSFWorkbook();
			fo = new FileOutputStream(xlfile);
			workbook.write(fo);
		}
		fi = new FileInputStream(xlfile);
		workbook = new XSSFWorkbook(fi);
		//sheet not exists create sheet
		if(workbook.getSheetIndex(sheetname)== -1) 
			workbook.createSheet(sheetname);
			sheet = workbook.getSheet(sheetname);
			//row not exists create new row
		if(sheet.getRow(rownum)== null)
			sheet.createRow(rownum);
		row = sheet.getRow(rownum);
		
		cell =row.createCell(colnum);
		cell.setCellValue(data);
		fo= new FileOutputStream(xlfile);
		workbook.write(fo);
		workbook.close();
		fo.close();
		fi.close();
		
	}
	
	
	
	

}
