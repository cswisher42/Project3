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
		String [] words = new String [50];
		String name = getFileInfo();
		
		readFile(name, words);
		displayResults(words); 
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
		
		while(inFile.hasNext())
		{
			words[total] = inFile.nextLine();
			total++;
		}
	} //end readFile
	
	public static void displayResults(String [] words)
	{
		for(int i = 0; i < words.length; i++)
			System.out.println(words[i]);
	}
} //end class