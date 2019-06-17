package edu.handong.analysis.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import edu.handong.analysis.datamodel.ExcelType1;

public class ExcelReader {
	
	public ArrayList<String> getData(String is){
		return null;	
	}
	
//	public ArrayList<String> getDataOfFile1(InputStream is) {
//		ArrayList<String> values = new ArrayList<String>();
//		
//		try (InputStream inp = is) {
//			Workbook wb = WorkbookFactory.create(inp);
//		    Sheet sheet = wb.getSheetAt(0);
//		    Row row = sheet.getRow(2);
//		    Cell cell = row.getCell(1);
//		    if (cell == null)
//		    	cell = row.createCell(3);
//		        
//		    CellType type = cell.getCellType();
//		    if(type.toString().contentEquals("STRING")) {
//		    	values.add(cell.getStringCellValue());
//		    }
//		    else if(type.toString().equals("NUMERIC")){
//		    	int n = (int) cell.getNumericCellValue();
//		    	values.add(Integer.toString(n));
//		    	}
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.getMessage();
//		}
//		
//		return values;
//	}
	
	public void getDataOfFile1(InputStream is, ArrayList<ExcelType1> values, String fileName) {
		ExcelType1 excel1 = null;
		String[] cellInfo = new String[5];
		try (InputStream inp = is) {
			Workbook wb = WorkbookFactory.create(inp);
		    Sheet sheet = wb.getSheetAt(0);
		    Row row = sheet.getRow(2);
		    for(int i=0; i<5; i++) {
		    	Cell cell = row.getCell(i);
		    	if (cell == null)
			    	cell = row.createCell(i);
		    	
		    	CellType type = cell.getCellType();
			    if(type.toString().contentEquals("STRING")) {
			    	cellInfo[i] = cell.getStringCellValue();
			    }
			    else if(type.toString().equals("NUMERIC")){
			    	int n = (int) cell.getNumericCellValue();
			    	cellInfo[i] = Integer.toString(n);
			    }
		    }
		    excel1 = new ExcelType1(fileName, cellInfo);
		    values.add(excel1);
		    System.out.println("Values Size in ExcelReader : " + values.size());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.getMessage();
		}
	}
	
	public void getDataOfFile2(InputStream is, ArrayList<ExcelType1> values, String fileName) {
		ExcelType1 excel1 = null;
		String[] cellInfo = new String[5];
		try (InputStream inp = is) {
			Workbook wb = WorkbookFactory.create(inp);
		    Sheet sheet = wb.getSheetAt(0);
		    Row row = sheet.getRow(2);
		    for(int i=0; i<5; i++) {
		    	Cell cell = row.getCell(i);
		    	if (cell == null)
			    	cell = row.createCell(i);
		    	
		    	CellType type = cell.getCellType();
			    if(type.toString().contentEquals("STRING")) {
			    	cellInfo[i] = cell.getStringCellValue();
			    }
			    else if(type.toString().equals("NUMERIC")){
			    	int n = (int) cell.getNumericCellValue();
			    	cellInfo[i] = Integer.toString(n);
			    }
		    }
		    excel1 = new ExcelType1(fileName, cellInfo);
		    values.add(excel1);
		    System.out.println("Values Size in ExcelReader : " + values.size());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.getMessage();
		}
	}
}