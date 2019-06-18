package edu.handong.analysis.utils;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ErrorFileWriter {
	public static void writeAFile(ArrayList<String> lines, String targetFileName) {
		FileWriter csvWriter = null;
		String filePath = targetFileName.trim().split(".xlsx")[0] + "(error).csv";
		try {
			csvWriter = new FileWriter(filePath);
		} catch (IOException e) {
			System.out.println("The file path does not exist. Please check your CLI argument!");
			System.exit(0);
		}
		try {
			csvWriter.write("FileName");
			csvWriter.append("\n");
		} catch (IOException e1) {
			e1.getMessage();
		}
		
		for(String s : lines) {
			try {
				csvWriter.write(s);
				csvWriter.append("\n");
			} catch (IOException e) {
				e.getMessage();
			}
		}
		
		try {
			csvWriter.flush();
			csvWriter.close();
		} catch (IOException e) {
			e.getMessage();
		}
	}
}
