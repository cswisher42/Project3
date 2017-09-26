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
		//displayResults(words);
		
		for(int i = 0; i < words.length; i++)
		{
			isPalindrome(words[i]);
		}
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
		word.toLowerCase();
		StringBuilder sb = new StringBuilder(word);
		
		for(int i = 0; i < sb.length(); i++)
		{
			if(sb.charAt(i) == ' ' || sb.charAt(i) == ',' || sb.charAt(i) == '.')
			{
				sb.deleteCharAt(i);
			}
		}
		System.out.println(sb);
		return true;
	} //end isPalindrome
	
	public static void displayResults(String [] words)
	{
		for(int i = 0; i < words.length; i++)
			System.out.println(words[i]);
	} //end displayResults
	
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