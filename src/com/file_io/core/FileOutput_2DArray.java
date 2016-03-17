package com.file_io.core;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class FileOutput_2DArray {
	public static void main(String args[]) throws IOException{
		File file = createFile("output.txt");
		FileWriter file_writer = createFileWriter(file, true);
		PrintWriter print_writer = createPrintWriter(file_writer);
		String[] numbers_array = populateArray(50, 500);
		writeFile(print_writer, numbers_array);
	}// End of class
	
	public static File createFile(String path){
		return new File(path); 
	}// End of createFile method
	
	public static FileWriter createFileWriter(File file, boolean append) throws IOException{
		return new FileWriter(file, append);
	}// End of createFileWriter method
	
	public static PrintWriter createPrintWriter(FileWriter file_writer){
		return new PrintWriter(file_writer);
	}// End of createPrintWriter method
	
	public static String[] populateArray(int numbersToGen, int range){
		String[] numbers = new String[numbersToGen];
		Random ran = new Random();
		
		for(int i = 0; i < numbersToGen; i++){
			numbers[i] = ran.nextInt(range) + "";
		}// End of numbersToGen
		
		return numbers;
	}// End of populateArray Method
	
	public static void writeFile(PrintWriter print_writer, String[] to_write){
		for(int i = 0; i < to_write.length; i++){
			print_writer.println(to_write[i]);
		}
		print_writer.close();
	}// End of writeFile method
}// End of class