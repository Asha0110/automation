package com.ebanking.library;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	final static Logger logger = Logger.getLogger(ExcelUtils.class);

	private static String filePath;
	private static Workbook wb;
	private static Sheet sh;

	public ExcelUtils(String excelFile, String sheetName) { // constructor
		try {
			File exceldataFile = new File(excelFile); // read the excelFile
			filePath = exceldataFile.getAbsolutePath();
			FileInputStream fs = new FileInputStream(exceldataFile);
			wb = getWorkbook(fs, filePath);
			sh = wb.getSheet(sheetName);
		} catch (Exception e) {
			logger.error("Error: ", e);

		}

	}

	public ExcelUtils(String path) {
		
	}

	public String readExcelData(int rowindex, int colIndex) {
		String cellData = null;
		try {
			Row row = sh.getRow(rowindex);
			Cell cell = row.getCell(colIndex);
			cellData = formatdataCellToString(cell);
			logger.info("reading data cell at row" + rowindex + ",column" + colIndex + ",data:" + cellData);
		} catch (Exception e) {
			logger.error("Error: ", e);

		}
		return cellData;

	}

	public String[][] getExcelData() {
		String[][] arrayExcelData = null;
		try {
			Iterator<Row> iterator = sh.iterator();
			int totalCols = sh.getRow(0).getPhysicalNumberOfCells();
			int totalRows = sh.getPhysicalNumberOfRows();
			arrayExcelData = new String[totalRows - 1][totalCols];
			int irowCount = 0;
			while (iterator.hasNext()) {
				Row nextRow = iterator.next();
				// skipping row 1, because its table header info
				if (irowCount > 0) {
					Iterator<Cell> cellIterator = nextRow.iterator();
					int icolCount = 0;
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						// need to format the cells before read it as a string
						String data = formatdataCellToString(cell);
						arrayExcelData[irowCount - 1][icolCount] = data;
						logger.info("Row:" + irowCount + ",col:" + icolCount);
						icolCount++;

					}
				}
				irowCount++;
			}

		} catch (Exception e) {
			logger.error("Error: ", e);

		}

		return arrayExcelData;
	}

	private String formatdataCellToString(Cell cell) {
		String cellString = null;
		try {
			DataFormatter formatter = new DataFormatter();
			cellString = formatter.formatCellValue(cell);
		} catch (Exception e) {
			logger.error("Error: ", e);

		}

		return cellString;
	}

	private Workbook getWorkbook(FileInputStream fis, String excelFilePath) {

		Workbook workbook = null;
		try {
			if (excelFilePath.endsWith("xlsx")) {
				workbook = new XSSFWorkbook(fis);
			} else if (excelFilePath.endsWith("xls")) {
				workbook = new HSSFWorkbook(fis);

			} else {
				throw new IllegalArgumentException("The specified file is not excel file");
			}

		} catch (Exception e) {
			logger.error("Error: ", e);
		}

		return workbook;

	}

	public static void main(String[] args) {
		ExcelUtils excel = new ExcelUtils("/src/test/resources/TestData/guru99testdata.xlsx","Sheet1");
		logger.info("Excel data.........");
		logger.info(excel.getExcelData());
	}

}// closing tag
