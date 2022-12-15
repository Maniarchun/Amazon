package com.amazon.Amazon;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLSXRead {
	static String value;
	static Workbook w;

	public static String singleDataReader(String sheet, int row, int cell) throws IOException {
		File f = new File("C:\\Users\\ELCOT\\OneDrive\\Desktop\\Data1.xlsx");
		FileInputStream fi = new FileInputStream(f);
		w = new XSSFWorkbook(fi);
		Sheet s = w.getSheet(sheet);
		Row r = s.getRow(row);
		Cell c = r.getCell(cell);
		CellType ct = c.getCellType();
		if (ct.equals(CellType.STRING)) {
			value = c.getStringCellValue();

		} else if (ct.equals(CellType.NUMERIC)) {
			double d = c.getNumericCellValue();
			value = Double.toString(d);
		}
		return value;
	}

	private static void multiDataReader() throws InvalidFormatException, IOException {
		File f = new File("C:\\Users\\ELCOT\\OneDrive\\Desktop\\Data.xlsx");
		FileInputStream fi = new FileInputStream(f);
		w = new XSSFWorkbook(fi);
		Sheet s = w.getSheet("Data1");
		int rowSize = s.getPhysicalNumberOfRows();
		for (int i = 0; i < rowSize; i++) {
			Row r = s.getRow(i);
			int cellSize = r.getPhysicalNumberOfCells();
			for (int j = 0; j < cellSize; j++) {
				Cell c = r.getCell(j);
				CellType ct = c.getCellType();
				if (ct.equals(CellType.STRING)) {
					String st = c.getStringCellValue();
					System.out.print(st);
				} else if (ct.equals(CellType.NUMERIC)) {
					double dd = c.getNumericCellValue();
					int a = (int) dd;
					System.out.print(a);
				}
				System.out.print(" | ");
			}
			System.out.println();
		}
		w.close();
	}

}
