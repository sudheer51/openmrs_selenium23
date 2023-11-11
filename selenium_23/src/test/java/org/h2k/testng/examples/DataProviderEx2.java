package org.h2k.testng.examples;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(org.h2k.testng.examples.ListenerExample.class)
public class DataProviderEx2 {
	
	@DataProvider(name = "DP")
	public String[][] readXLSX() throws IOException
	{
		File f = new File("InputData.xlsx");
		f.createNewFile();
		FileInputStream fis = new FileInputStream(f);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.getSheetAt(0);
		int rows = sheet.getPhysicalNumberOfRows();
		int cols = sheet.getRow(0).getPhysicalNumberOfCells();
		System.out.println("Number of rows:" + rows);
		System.out.println("Number of cols::" + cols);
		String data[][] = new String[rows][cols];
		for(int i=0;i<rows;i++)
		{
			for(int j=0;j<cols;j++)
			{
				XSSFCell cell = sheet.getRow(i).getCell(j);
				data[i][j]=cell.getStringCellValue();
				System.out.print(data[i][j]);
			}
			System.out.println();
		}
		return data;
		
	}
	@Test(testName="Executing the DataProvider Example",dataProvider = "DP")
	public void verifyData1(String n1, String n2) {
		System.out.println(n1 + " " + n2);
	}

}
