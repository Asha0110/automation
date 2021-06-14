package com.ebanking.library;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {

	public FileInputStream input;
	public XSSFWorkbook wb;
	public XSSFSheet sh;
	public XSSFRow row;
	public XSSFCell cell;
	String path = null;

	public ExcelUtil(String path) { // constructor
		this.path = path;
	}

	public int getRowCount(String sheetName) throws IOException {

		input = new FileInputStream(path);
		wb = new XSSFWorkbook(input);
		sh = wb.getSheet(sheetName);
		int rowcount = sh.getLastRowNum();
		wb.close();
		input.close();

		return rowcount;

	}

	public int getCellCount(String sheetName, int rownum) throws IOException {

		input = new FileInputStream(path);
		wb = new XSSFWorkbook(input);
		sh = wb.getSheet(sheetName);
		row = sh.getRow(rownum);
		int cellcount = row.getLastCellNum();
		wb.close();
		input.close();
		return cellcount;
	}

	public String getCellData(String sheetName, int rownum, int colnum) throws IOException {
		input = new FileInputStream(path);
		wb = new XSSFWorkbook(input);
		sh = wb.getSheet(sheetName);
		row = sh.getRow(rownum);
		cell = row.getCell(colnum);

		DataFormatter formatter = new DataFormatter();
		String data;
		try {

			data = formatter.formatCellValue(cell);
		} catch (Exception e) {

			data = "";
		}
		wb.close();
		input.close();

		return sheetName;

	}

} // closing tag
