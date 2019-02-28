import java.io.*;
import java.util.*;

public class Main 
{
	/**
	 * @author Aingty Eung
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

        doIteratively(input);

    }
    

    // Functions that Iteratively Do the Permute
    public static void doIteratively(ArrayList<String> input)
    {
        System.out.print("Original Iterative String: ");

        for(String s : input)
        {
            ArrayList<String> answer = doIteratively2(s);
            printResult(s, answer);
        }
    }

    public static ArrayList<String> doIteratively2(String s)
    {
        ArrayList<String> array = new ArrayList<String>();
        int j; // counter to count up from "i"
        for(int i=0; i < s.length(); i++)
        {
            System.out.println(s);
            for (j=i+1; j != i; j++)
            {
                if(!(j < s.length()))
                {
                    j=0;
                }
                array.add(swap(s,i,j));            
            }
        }
        return array;
    }

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
        System.out.print(s + "\nPermute(s):\n");
        for(int i = 0; i < list.size(); i++)
        {
            System.out.println("\t"+list.get(i));
        }
        System.out.println();
    }
}
