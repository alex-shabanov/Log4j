package com.log4jexceptions;


public class Main {

	public static void main(String[] args) {
		
		MyExceptions exception = new MyExceptions();
		exception.readFromFile();
		exception.arithmeticException();
		exception.outOfBoundsException();
		exception.nullPointerException();
	}

}
