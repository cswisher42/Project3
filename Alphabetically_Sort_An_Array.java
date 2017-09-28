import java.util.*;

public class Alphabetically_Sort_An_Array
	public static void main(String [] args)
	{
		String [] words = { "Aa", "aAa", "Elle", "Hannah", "Pee Wee", "mom", "dad", "mirror", "radar", "Racecar Bob", "Pot top.", "Dennis sinned." };
		
		sortArray(words);
	}
	
	public static void sortArray(String [] words)
	{
		for(int i = 0; i < words.length; i++)
		{
			for(int k = 0; k < words.length-1; k++)
			{
				if((int)words[k].toUpperCase().charAt(0) == (int)words[k+1].toUpperCase().charAt(0))
				{
					int count = 0;
					while((int)words[k].toUpperCase().charAt(count) == (int)words[k+1].toUpperCase().charAt(count))
					{
						if(count+1 > words[k].length()-1 || count+1 > words[k+1].length()-1)
						{
							if(words[k].length() > words[k+1].length())
							{
								String temp = words[k];
								words[k] = words[k+1];
								words[k+1] = temp;
								break;
							}
							else
								break;
						}
						else
							count++;
					}
					
					if((int)words[k].toUpperCase().charAt(count) > (int)words[k+1].toUpperCase().charAt(count))
					{
						String temp = words[k];
						words[k] = words[k+1];
						words[k+1] = temp;
					}
				}
				
				else
				{
					if((int)words[k].toUpperCase().charAt(0) > (int)words[k+1].toUpperCase().charAt(0))
					{
						String temp = words[k];
						words[k] = words[k+1];
						words[k+1] = temp;
					}
				}
			}
		}
		
		for(int x = 0; x < words.length; x++)
			System.out.println(words[x]);
	} //end sortArray
}