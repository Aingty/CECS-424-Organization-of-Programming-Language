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
        ArrayList<String> input2 = new ArrayList<String>();
        input2.add("Cat");
        doIteratively(input2);

    }
    

    // Functions that Iteratively Do the Permute
    public static void doIteratively(ArrayList<String> input)
    {
        System.out.print("Original Iterative String: ");

        for(String s : input)
        {
            ArrayList<String> answer = doIteratively2(s);
            //printResult(s, answer);
        }
    }

    public static ArrayList<String> doIteratively2(String s)
    {
        ArrayList<String> array = new ArrayList<String>();
        String temp = s;
        int startingPos = 0, nextPos = -1; // counter to the next position
        if(temp.size()==1)
        {
            array.add(temp);
            return array;
        }
        while(startingPos != temp.size()-1)
        {

            array.add(temp);
            temp = swap(temp, startingPos, nextPos);
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
