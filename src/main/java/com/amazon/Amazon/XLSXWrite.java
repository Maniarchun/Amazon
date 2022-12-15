package com.amazon.Amazon;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLSXWrite {
	private static void write() throws IOException {
		File  f  = new File("C:\\Users\\ELCOT\\OneDrive\\Desktop\\Data.xlsx");
		FileInputStream fi = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(fi);
		Sheet s = w.createSheet("Data2");
		Row r = s.createRow(0);
		Cell c = r.createCell(0);
		c.setCellValue("a");
		w.getSheet("Data2").getRow(0).createCell(1).setCellValue("b");
		w.getSheet("Data2").getRow(0).createCell(2).setCellValue("c");
		FileOutputStream jo = new FileOutputStream(f);
		w.write(jo);
		w.close();
	}
	public static void main(String[] args) throws IOException {
		write();
		System.out.println("Completed");
	}

}
