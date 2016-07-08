package com.log4jexceptions;

import com.pkg.LogFile;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.commons.lang3.math.NumberUtils;


public class MyExceptions {

	public void readFromFile() {
		BufferedReader br = null;
	    try {
	    	br = new BufferedReader(new FileReader("F:/temp/file.txt"));
	        String line = null;     
	        while((line = br.readLine()) != null){
	        	System.out.println(line);
	        }
	        br.close();
		} catch (FileNotFoundException e) {
			LogFile.warn(this, "readFromFile()", Constants.FILE_NOT_FOUND_EXCEPTION, e);
		} catch (IOException e) {
			LogFile.warn(this, "readFromFile()", Constants.FILE_NOT_FOUND_EXCEPTION, e);
		} 
	}
	
	public void arithmeticException(){
		int num;
		Scanner scanner = new Scanner(System.in);
		while(true){
			System.out.print("Enter number between 0 and 5:     ");
			String input = scanner.next();
			boolean isNumber = NumberUtils.isNumber(input);
			if(isNumber){
				num = (int) NumberUtils.createNumber(input);
				if(num >= 0 && num <= 5) break;
				else System.out.println("Number must be between 0 and 5.");
			}
			else System.out.println("Input entered is not a number.");
		}
		try {
			if(num == 0) throw new ArithmeticException();
			else {
				int n = 5 / num;
				System.out.println("Result of 5 / " + String.valueOf(num) + " = " + String.valueOf(n));
			}
		}
		catch(Exception e) {
			LogFile.warn(this, "arithmeticException()", Constants.NULL_POINTER_EXCEPTION, e);
		}
	}
	
	public void outOfBoundsException(){
		String[] array = {"a", null, "b", "c", "d", "null", null, null, "e"};
		try {
			System.out.print(array[array.length]);
		}
		catch(IndexOutOfBoundsException e){
			LogFile.severe(this, "outOfBoundsException()", Constants.INDEX_OUT_OF_BOUNDS_EXCEPTION, e);
		}
	}

	public void nullPointerException(){
		String[] array = {"a", "b", "c", "d", "null", null, null, "e"};
		try {
			for(int i = 0; i < array.length; i++){
				System.out.print(array[i].toString() + " ");
			}
		}
		catch(NullPointerException e){
			LogFile.severe(this, "nullPointerException()", Constants.NULL_POINTER_EXCEPTION, e);
		}
	}
}
