package edu.handong.analysis.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipFile;

public class ZipReader {

	public static void readFileInZip(File file) {
		try {
			ZipFile zipFile = new ZipFile(file);

		    Enumeration<? extends ZipArchiveEntry> entries = zipFile.getEntries();

		    while(entries.hasMoreElements()){
		        ZipArchiveEntry entry = entries.nextElement();
		        InputStream stream = zipFile.getInputStream(entry);
		        System.out.println(entry);
		        
		        ExcelReader myReader = new ExcelReader();
		        
		        for(String value:myReader.getData(stream)) {
		        	System.out.println(value);
		        }
		    }
		    zipFile.close();
		} catch (IOException e) {
			e.getMessage();
		}
	}
}