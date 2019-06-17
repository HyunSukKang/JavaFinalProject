package edu.handong.analysis.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipFile;

import edu.handong.analysis.datamodel.ExcelType1;

public class ZipReader {

	public static void readFileInZip(File file, ArrayList<ExcelType1> values) {
		try {
			ZipFile zipFile = new ZipFile(file);

		    Enumeration<? extends ZipArchiveEntry> entries = zipFile.getEntries();
		    int i=0;
		    while(entries.hasMoreElements()){
		    	i++;
		    	System.out.println(i + "Times!!");
		        ZipArchiveEntry entry = entries.nextElement();
		        InputStream stream = zipFile.getInputStream(entry);
		        System.out.println(entry);
		        
		        ExcelReader myReader = new ExcelReader();
		        
		        myReader.getDataOfFile1(stream, values, file.getName());
		        
//		        for(String value:myReader.getDataOfFile1(stream)) {
//		        	System.out.println(value);
//		        }   
		    }
		    zipFile.close();
		} catch (IOException e) {
			e.getMessage();
		}
//		return values;
	}
}