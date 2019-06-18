package edu.handong.analysis.utils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;

import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipFile;

import edu.handong.analysis.datamodel.ExcelType1;
import edu.handong.analysis.datamodel.ExcelType2;
import edu.handong.analysis.datamodel.LinkedList;

public class ZipReader {
	
	public static void readFileInZip(File file, LinkedList<ExcelType1> values1, LinkedList<ExcelType2> values2, ArrayList<String> errorFileName) {
		try {
			ZipFile zipFile = new ZipFile(file);

		    Enumeration<? extends ZipArchiveEntry> entries = zipFile.getEntries();
		    int i=0;
		    while(entries.hasMoreElements()){
		    	i++;
		        ZipArchiveEntry entry = entries.nextElement();
		        InputStream stream = zipFile.getInputStream(entry);
		        System.out.println(entry);
		        
		        ExcelReader myReader = new ExcelReader();
		        
		        if(i==1) {
		        	myReader.getDataOfFile1(stream, values1, file.getName(), errorFileName);
		        }
		        else if(i==2) {
		        	myReader.getDataOfFile2(stream, values2, file.getName(), errorFileName);
		        }
		    }
		    zipFile.close();
		} catch (IOException e) {
			e.getMessage();
		}
	}
}