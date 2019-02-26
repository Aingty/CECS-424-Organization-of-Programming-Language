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
			System.out.println("Please provide a file as command line argument!");
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
    }
}
