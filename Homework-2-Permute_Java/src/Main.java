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
        String temp = s, temp1;
        int startingPos = 0, nextPos = 0; // counter to the next position
        if(temp.length()==1)
        {
            array.add(temp);
            return array;
        }
        while(startingPos != temp.length()-1)
        {
            // Swapping the main string to get the next possible combinations
            temp = swap(temp, startingPos, nextPos);

            // Adding to array but only if it doesn't already
            if(!array.contains(temp))
            {
                array.add(temp);
            }
            // Swapping all the possible combination of current string
            for(int j=1; j < temp.length(); j++)
            {
                temp1 = swap(temp,0,j);
                // Adding to array but only if it doesn't already
                if(!array.contains(temp1))
                {
                    array.add(temp1);
                }
            }

            // Moving the nextPos pointer to swap the main string with the next possible combinations
            nextPos++;
            if(nextPos == temp.length())
            {
                startingPos++;
                nextPos = startingPos+1;
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
        System.out.print(list.get(0) + "\nPermute(s):\n");
        for(int i = 1; i < list.size(); i++)
        {
            System.out.println("\t"+list.get(i));
        }
        System.out.println();
    }
}
