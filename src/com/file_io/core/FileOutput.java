package com.file_io.core;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/** 
 * 
 *	Name: Benjamin DosSantos 
 *	Assignment: Write to a File
 *	Project Description: The Program 
 *	is intended to take in a string 
 *	from the user and append that string
 *  to the output.txt file that is located
 *  in the project folder.
 * 
 **/

public class FileOutput {
	public static void main(String args[]) throws IOException{
		appendFile();
	}// End of class
	
	public static void appendFile() throws IOException{
		File file = createFile("output.txt");
		FileWriter file_writer = createFileWriter(file, true);
		PrintWriter print_writer = createPrintWriter(file_writer);
		Scanner scan = createScanner();
		openMessage();
		String input = getInput(scan);
		writeFile(print_writer, input);
		sendConformation();
		getContinue(scan);
	}
	
	public static Scanner createScanner(){
		return new Scanner(System.in);
	}

	public static String getInput(Scanner scan){
		return scan.next();
	}
	
	public static void openMessage(){
		System.out.println("Enter a String to be Appended to the File.");
	}
	
	public static void sendConformation(){
		System.out.println("The String Was Appended to the File.");
		System.out.println("Would you like to append another line. No: 0, Yes: 1");
	}
	
	public static void getContinue(Scanner scan) throws IOException{
		if(scan.nextInt() != 1){
			System.exit(0);
		}else{
			appendFile();
		}
	}
	
	public static File createFile(String path){
		return new File(path); 
	}// End of createFile method
	
	public static FileWriter createFileWriter(File file, boolean append) throws IOException{
		return new FileWriter(file, append);
	}// End of createFileWriter method
	
	public static PrintWriter createPrintWriter(FileWriter file_writer){
		return new PrintWriter(file_writer);
	}// End of createPrintWriter method
	
	public static void writeFile(PrintWriter print_writer, String to_write){
		print_writer.println(to_write);
		print_writer.close();
	}// End of writeFile method
}// End of class