package com.amazon.Amazon;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class XlFromArray {
	//static String sheet ="Amazon";
	public static void main(String[] args) throws Throwable {
		
		int[][] a =new int[10][30];
		File f = new File("C:\\Users\\ELCOT\\ManiArjun\\Data1.xlsx");
		FileInputStream fi = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(fi);
		 Sheet s = w.getSheet("Amazon");
		for (int i = 0; i < 3; i++) {
			
			for (int j = 0; j < 30; j++) {
				Row r = s.getRow(i);
				 Cell c = r.getCell(j);
				CellType ct = c.getCellType();
				if (ct.equals(CellType.STRING)) {
					String s1 = c.getStringCellValue();

					System.out.println(s1);
				} else if (ct.equals(CellType.NUMERIC)) {
					double d = c.getNumericCellValue();
					int a1 = (int) d;
					a[i][j]=a1;
					
				}
				System.out.println(a[i][j]);

			}
		}
	}
}
