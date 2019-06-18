package edu.handong.analysis;

import java.io.File;
import java.util.ArrayList;

import edu.handong.analysis.datamodel.ExcelType1;
import edu.handong.analysis.datamodel.ExcelType2;
import edu.handong.analysis.datamodel.LinkedList;
import edu.handong.analysis.utils.ZipReader;

public class MultiThread implements Runnable{

	private File file;
	private LinkedList<ExcelType1> value1;
	private LinkedList<ExcelType2> value2;
	private ArrayList<String> errorFileName;
	
	public MultiThread(File file, LinkedList<ExcelType1> value1, LinkedList<ExcelType2> value2, ArrayList<String> errorFileName) {
		this.file = file;
		this.value1 = value1;
		this.value2 = value2;
		this.errorFileName = errorFileName;
	}
	
	@Override
	public void run() {
		ZipReader.readFileInZip(file, value1, value2, errorFileName);
	}
	
}
