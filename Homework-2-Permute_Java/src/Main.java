import java.io.*;
import java.util.*;

public class Main 
{
	/**
	 * @author Aingty Eung 013462772
	 * @param args is file input for sorting
	 */
	public static void main(String[] args) 
	{
		ArrayList<String> input = new ArrayList<String>();
		System.out.println();
		
		// Check if command line argument was given
		if (args.length == 0)
		{
			System.out.println("Please provide a file as command line argument!\n");
			System.exit(0);
		}

		// Check if file exist through try-catch
		File file = new File(args[0]);
		try 
		{
			Scanner reader = new Scanner(file);

			while (reader.hasNextLine()) 
			{
				input.add(reader.nextLine());
			}
			reader.close();
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("File was NOT FOUND!!!");
			e.printStackTrace();
		}
        //doIteratively(input);
        doRecursively(input);
    }
    
    /* ------------------ Functions ------------------- */

    // Functions that Iteratively do the Permute
    public static void doIteratively(ArrayList<String> input)
    {
        
        for(String s : input)
        {
            ArrayList<String> answer = doIteratively2(s);
            System.out.print("Original Iterative String: "+s);
            printResult(s, answer);
        }
    }

    public static ArrayList<String> doIteratively2(String s)
    {
        ArrayList<String> array = new ArrayList<String>();
        
        // initialization
        array.add(String.valueOf(s.charAt(0)));
        
        // for loop every character of the specified string
		for (int i = 1; i < s.length(); i++)
		{
			for (int j = array.size() - 1; j >= 0 ; j--)
			{
				String str = array.remove(j);
				for (int k = 0; k <= str.length(); k++)
				{
					array.add(str.substring(0, k) + s.charAt(i) + str.substring(k));
				}
			}
		}
        return array;
    }

    // Functions that Recursively do the Permute
    public static void doRecursively(ArrayList<String> input)
    {
        ArrayList<String> testing = new ArrayList<String>();
        for(String s : input)
        {
            ArrayList<String> answer = doRecursively2(s, 0, s.length()-1, testing);
            System.out.println("Original Recursive String: "+s);
            printResult(s, answer);
        }
    }

    public static ArrayList<String> doRecursively2(String s, int current, int next, ArrayList<String> array)
    {
        if (current == next)
        {
            System.out.println(s);
            array.add(s);
            return array; 
        } 
        else
        { 
            for (int i = current; i <= next; i++) 
            { 
                s = swap(s,current,i); 
                array = doRecursively2(s,current+1, next, array); 
                s = swap(s,current,i); 
            } 
            return array;
        } 
    }
    // Function used to swap two characters of a given string
    public static String swap(String s, int first, int second)
    {
        char[] c = s.toCharArray();
        char temp = c[first];
        c[first] = c[second];
        c[second] = temp;
        return new String(c);
    }

    // Printing all the possible Permute
    public static void printResult(String s, ArrayList<String> list)
    {
        System.out.print("Permute(s):\n");
        for(int i = 1; i < list.size(); i++)
        {
            System.out.println("\t"+list.get(i));
        }
        System.out.println();
    }


}
