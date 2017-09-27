/*
* Chuck Swisher
* Proj3.java
* Project 3
************************************
*/

import java.util.*;
import java.io.*;

public class Proj3
{
	public static void main(String [] args) throws IOException
	{
		Scanner s = new Scanner(System.in);
		String name = getFileInfo();
		String [] words = new String [fileLength(name)];
		Boolean [] palindrome = new Boolean[fileLength(name)];
		readFile(name, words);
		
		
		for(int i = 0; i < words.length; i++)
		{
			palindrome[i] = isPalindrome(words[i]);
			
		}
		displayResults(words, palindrome);
		
		File results = new File("Results.txt");
		
		saveLine(results, words, palindrome);
		
		
	} //end main
	
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
} //end class