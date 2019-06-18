package edu.handong.analysis.utils;

public class NotADirectoryException extends Exception {
	
	public NotADirectoryException() {
		super ("Input path is not a Directory. Please check!");
	}
	public NotADirectoryException(String message) {
		super (message);
	}
}
