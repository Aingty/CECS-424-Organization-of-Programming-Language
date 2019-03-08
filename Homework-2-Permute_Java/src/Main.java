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
            temp1 = swap(temp, startingPos, nextPos);

            // Adding to array but only if it doesn't already
            if(!array.contains(temp))
            {
                array.add(temp);
            }
            // Swapping all the possible combination of current string
            for(int i=0; i != temp.length()-1; i++)
            {    
                for(int j=i+1; j < temp.length(); j++)
                {
                    temp1 = swap(temp1,i,j);
                    // Adding to array but only if it doesn't already
                    if(!array.contains(temp1))
                    {
                        array.add(temp1);
                    }
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


    // Iterative function to generate all permutations of a String in Java
	// using Collections
	public static ArrayList<String> permutations(String s)
	{
		// create an empty ArrayList to store (partial) permutations
		ArrayList<String> partial = new ArrayList<String>();

		// initialize the list with the first character of the string
		partial.add(String.valueOf(s.charAt(0)));

		// do for every character of the specified string
		for (int i = 1; i < s.length(); i++)
		{
			// consider previously constructed partial permutation one by one

			// (iterate backwards to avoid ConcurrentModificationException)
			for (int j = partial.size() - 1; j >= 0 ; j--)
			{
				// remove current partial permutation from the ArrayList
				String str = partial.remove(j);

				// Insert next character of the specified string in all
				// possible positions of current partial permutation. Then
				// insert each of these newly constructed string in the list

				for (int k = 0; k <= str.length(); k++)
				{
					// Advice: use StringBuilder for concatenation
					partial.add(str.substring(0, k) + s.charAt(i) + str.substring(k));
				}
			}
		}
        return partial;
	}
}
