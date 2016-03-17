package com.file_io.core;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Scanner;

public class BaseFileInput {
	static ArrayList<Object> masterArray;
	
	public static void main(String[] args) throws FileNotFoundException {
		File inFile = new File("input.txt");	// Sets the file to check 
		masterArray = readFile(inFile);
		printMenu(inFile);
	}// End of method
	
	public static void printMenu(File inFile) throws FileNotFoundException{
		String openingMessage = "Please select a number for the action that you wish to perform.";
		String optionMenu = "1: Check the file for an oject, 2: Print the file in string form, 3: Print the file in int form, \n"
				+ "4: Print the file in double form, 5: Print the file in float form, 6: Print the file in long form, \n"
				+ "7: Print the file in char form, 0: EXIT";
		
		System.out.println(openingMessage);
		int option = getInputInt(optionMenu);
		optionHandler(option, inFile);		
	}
	
	public static void optionHandler(int option, File inFile) throws FileNotFoundException{
		
		switch(option){
			case 1:
				printCheckArray(masterArray);
				break;
			case 2:
				printArray(masterArray);
				break;
			case 3:
				printArray(masterArray);
				break;
			case 4:
				printArray(masterArray);
				break;
			case 5:
				printArray(masterArray);
				break;
			case 6:
				printArray(masterArray);
				break;
			case 7:
				printArray(masterArray);
				break;
			case 0:
				printConformation(inFile);
				break;
		}
	}
	
	public static void printConformationRestart(File inFile) throws FileNotFoundException{
		String conformation = "Would you like to perform another action? 1: Yes 0: No";
		int option = getInputInt(conformation);
		
		if(option == 1){
			printMenu(inFile);
		}else{
			printConformation(inFile);
		}
	}
	
	public static void printConformation(File inFile) throws FileNotFoundException{
		String conformation = "Are you sure you want to quit? 1: Yes 0: No";
		int option = getInputInt(conformation);
		
		if(option == 0){
			printMenu(inFile);
		}else{
			System.exit(0);
		}
	}

	public static void printCheckArray(ArrayList<Object> array) throws FileNotFoundException{
		System.out.println(checkFile(array));
		printConformationRestart(null);
	}
	
	public static void printArray(ArrayList<Object> array) throws FileNotFoundException{
		ArrayList<String> StringArray = toString(array);
		System.out.println(StringArray);
		printConformationRestart(null);
	}
	
	public static int getInputInt(String output){
		System.out.println(output);		// prints out the output to display to the user
		Scanner input = new Scanner(System.in);		// gets the users input
		return input.nextInt(); // returns the next input from the user
	}// End of getInput

	public static String getInput(String output){
		System.out.println(output);		// prints out the output to display to the user
		Scanner input = new Scanner(System.in);		// gets the users input
		return input.next(); // returns the next input from the user
	}// End of getInput
	
	public static boolean checkFile(ArrayList<Object> array){
		boolean isFound;	// the value that stores if the value is found
		
		// Checks if the object exists
		if(array.contains(getInput("Please enter a object to search for."))){
			isFound = true;	
		}else{
			isFound = false;
		}// End of if array contains
		
		return isFound;		// return if the file is found
	}// End of checkFile
	
	public static ArrayList<Object> readFile(File file) throws FileNotFoundException{
		
		ArrayList<Object> stringArray = new ArrayList<Object>();	// Creats a object arraylist
		Scanner scanner = new Scanner (file);	// scans in the new file
		while(scanner.hasNextLine()){	// while there is more lines in the file
			Object line = scanner.next();	// create a line object for the value of the line
			stringArray.add(line);	// Add the line to the object array
		}// End of while hasNextLine 
		scanner.close();	// Ends the scanner
		return stringArray;	// Returns the string array
	}// End of readFile
		
	public static char[] readFileToChar(File file) throws FileNotFoundException{
		
		char[] charArray = new char[(int) file.length()];	// Creats a object arraylist
		Scanner scanner = new Scanner (file);	// scans in the new file
		for(int i = 0; i < file.length(); i++){
			String string = scanner.next();
			char charToAdd = string.charAt(i);
			charArray[i] = charToAdd;
		}
		scanner.close();	// Ends the scanner
		return charArray;	// Returns the string array
	}// End of readFile
	
	
	 @SuppressWarnings("unchecked")
	public static ArrayList<String> toString(ArrayList<Object> arrays){		// to String array for conversion of object array to string array
		 ArrayList<String> stringArray = new ArrayList<String>();	// makes a string 
		 stringArray = (ArrayList<String>)arrays.clone();	// clones the object array to the string array
		 return stringArray; // Returns the string array
	 }// End of toInt
		
	
	 @SuppressWarnings("unchecked")
	public static ArrayList<Integer> toInt(ArrayList<Object> arrays){ 	// to int array converts a object array to int array
		 ArrayList<Integer> intArray = new ArrayList<Integer>();	// makes a int array
		 intArray = (ArrayList<Integer>)arrays.clone();	// clones the int array from the object array
		 return intArray; // Returns the int array
	 }// End of toInt
	 
	 @SuppressWarnings("unchecked")
	 public static ArrayList<Double> toDouble(ArrayList<Object> arrays){	// converts the object array to a double array
		 ArrayList<Double> doubleArray = new ArrayList<Double>();	// Creates a double array
		 doubleArray = (ArrayList<Double>)arrays.clone();	// Clones the object array to a double array
		 return doubleArray; // returns the double array
	 }// End of toInt
	 
	 @SuppressWarnings("unchecked")
	 public static ArrayList<Charset> toChar(ArrayList<Object> arrays){		// converts the object array to a char array 
		 ArrayList<Charset> charArray = new ArrayList<Charset>();	// Creates a char array
		 charArray = (ArrayList<Charset>)arrays.clone();	// clones the object array to a char array
		 return charArray; // returns the char array
	 }// End of toInt
	 
	 @SuppressWarnings("unchecked")	
	 public static ArrayList<Float> toFloat(ArrayList<Object> arrays){ 		// converts the object array to a float array
		 ArrayList<Float> floatArray = new ArrayList<Float>();	// creates a float array
		 floatArray = (ArrayList<Float>)arrays.clone();		// clones the object array to the float array
		 return floatArray; 	// Returns the float array 
	 }// End of toInt
	 
	 @SuppressWarnings("unchecked")
	 public static ArrayList<Long> toLong(ArrayList<Object> arrays){ 
		 ArrayList<Long> longArray = new ArrayList<Long>();
		 longArray = (ArrayList<Long>)arrays.clone();
		 return longArray; 
	 }// End of toInt
}// End of class