/** 
*
 <Proj3.java> 
 * 
<Chuck Swisher Scholars M W 9:30>
 * 
 * 
<The program revieces a potentialtext file and validates its existance. If the file is valid, it is passed to a method
 that breaks its lines into an array of strings. The individual elements of the array are then passed to a method that
 deterimes whether or not the string is a palindrome when spaces, commas, and periods are removed. Each array element is
 displayed with a description of whether or not the word is a palindrome and those lines that are palindromes are written
 into a new file. Then the total characters, lines and average number of words per line are written into the end of the 
 new file.
>
*/ 

import java.util.*;
import java.io.*;

public class Proj3
{
	
	/** main 
	 * A sequence of method calls to run the program.
	 */
	public static void main(String [] args) throws IOException
	{
		Scanner s = new Scanner(System.in);
		String name = getFileInfo();
		String [] words = new String [fileLength(name)];
		Boolean [] palindrome = new Boolean[fileLength(name)];
		System.out.println();
		readFile(name, words);
		
		
		for(int i = 0; i < words.length; i++)
		{
			palindrome[i] = isPalindrome(words[i]);
			
		}
		displayResults(words, palindrome);
		
		File results = new File("Results.txt");
		
		saveLine(results, words, palindrome);
		saveResults(results, words, fileLength(name));
		
		
	} //end main
	
	 /** getFileInfo 
	 * Reads in and validates a file name. 
	 *      
	 * @return fileName, once the file is validated the String fileName is returned.
	 */  
	public static String getFileInfo() throws IOException
	{
		Scanner s = new Scanner(System.in);
		System.out.print("Enter the name of the file: ");
		String fileName = s.nextLine();
		fileName += ".txt";
		Boolean isFile = false;
		
		do
		{
			File file = new File(fileName);
			if(file.exists())
			{
				Scanner inFile = new Scanner(fileName);
				isFile = true;
				inFile.close();
			}
			else
			{
				System.out.println("ERROR! File invalid.");
				System.out.print("Enter the name of the file: ");
				fileName = "";
				fileName = s.nextLine();
				fileName += ".txt";
			}
		}while(isFile == false);
				
		return fileName;
		
	} //end getFileInfo
	
	/** readFile 
	 * Reads in a file and places each line into an array element.
	 *   
	 * @param fileName, the name of the file being read in.  
	 * @param words, the array that will have have the file lines placed into it  
	 */ 
	public static void readFile(String fileName, String words []) throws IOException
	{
		File file = new File(fileName);
		Scanner inFile = new Scanner(file);
		
		int total = 0;
		
		while(inFile.hasNextLine())
		{
			words[total] = inFile.nextLine();
			total++;
		}
	} //end readFile
	
	/** isPalindrome 
	 * Takes a string removes spaces, commans, and periods. Then evaluates if
	 * is a palindrome.
	 *   
	 * @param word, the string being evaluated. 
	 * @return boolean, return true if the value is palindrome and false otherwise
	 */ 
	public static Boolean isPalindrome(String word)
	{
		word = word.toLowerCase();
		StringBuilder sb = new StringBuilder(word);
		
		for(int i = 0; i < sb.length(); i++)
		{
			if(sb.charAt(i) == ' ' || sb.charAt(i) == ',' || sb.charAt(i) == '.')
			{
				sb.deleteCharAt(i);
			}
		}
		for(int i = 0; i < sb.length(); i++)
		{
			if(sb.charAt(i) == ' ' || sb.charAt(i) == ',' || sb.charAt(i) == '.')
			{
				sb.deleteCharAt(i);
			}
		}
		word = sb.toString();
		sb.setLength(0);
		
		for(int k = word.length() - 1; k >= 0; k--)
		{
			sb.append(word.substring(k,k+1));
		}
		String reverseWord = sb.toString();
		reverseWord = reverseWord.toLowerCase();
		
		if(word.equals(reverseWord))
			return true;
		else
			return false;
	} //end isPalindrome
	
	/** displayResults 
	 * Takes an array of words and its parallel array of boolean values.
	 *   
	 * @param words, An array of the different lines of the input file.
	 * @param boolean, An array of the palindrome boolean values of each line.
	 */ 
	public static void displayResults(String [] words, Boolean [] palindrome)
	{
		for(int i = 0; i < words.length; i++)
		{
			if(palindrome[i] == true)
				System.out.println(words[i]+ " IS a palindrome.");
			else
				System.out.println(words[i] + " is NOT a palindrome.");
		}
	} //end displayResults
	
	/** saveLine 
	 * Takes a file, an array on strings, and an array of boolean values
	 * and writes the array to a file if it is a palindrome.
	 *   
	 * @param file, the file that is being written to.
	 * @param words, an array of strings that is being written to the file if
	 * its parallel array of boolean values holds true
	 * @param boolean, an array of the palindrome boolean values of each line.
	 */ 
	public static void saveLine(File file, String [] words, Boolean [] palindrome) throws IOException
	{
		PrintWriter outFile = new PrintWriter(file);
		
		for(int i = 0; i < palindrome.length; i++)
		{
			if(palindrome[i] == true)
				outFile.println(words[i]);
		}
		outFile.close();
	} //end saveLine
	
	/** fileLength 
	 * Calculates how many lines a file has to set the length of
	 * the arrays created in the main method.
	 *   
	 * @param fileName, the file that is being read in and is having
	 * its lines counted.
	 * @return lines, the amount of lines in the file
	 */ 
	public static int fileLength(String fileName) throws IOException
	{
		File file = new File(fileName);
		Scanner inFile = new Scanner(file);
		
		int lines = 0;
		
		while(inFile.hasNextLine())
		{
			lines++;
			inFile.nextLine();
		}
		
		inFile.close();
		
		return lines;
	} //end fileLength
	
	public static void saveResults(File file, String [] words, int length) throws IOException
	{
		int characters = 0;
		int spaces = 0;
		
		for(int i = 0; i < words.length; i++)
		{
			characters += words[i].length();
		}
		
		
		PrintWriter pw = new PrintWriter(new FileWriter(file, true));
		pw.println();
		pw.println("Input file contained a total number of " + characters + " characters.");
		pw.println("Input file contained a total number of " + length + " lines.");
		
		for(int k = 0; k < words.length; k++)
		{
			for(int x = 0; x < words[k].length(); x++)
			{
				if(words[k].substring(x, x+1).equals(" "))
				{
					spaces++;
				}
			}
			spaces++;
		}
		System.out.println("spaces: " + spaces);
		System.out.println("length: " + length);
		pw.println("Input file contained an average of " + (double)spaces/length + " words per line.");
		
		pw.close();
	} //end saveResults
} //end class