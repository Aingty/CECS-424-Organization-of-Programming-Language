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

		System.out.print("Unsorted ArrayList: \n\t");
		printResults(input);
		doIteratively(input);
		doRecursively(input);
	
	}




	////////////////// Iterative Quicksort /////////////////////////////////
	public static void doIteratively(ArrayList<String> input)
	{
		System.out.print("Iteratively:\n\t");
		ArrayList<String> answer = doIteratively2(input, 0, input.size()-1);
		printResults(answer);
	}

	public static ArrayList<String> doIteratively2(ArrayList<String>input, int low, int high) 
	{ 
		// Create an array mimicing a "stack" with same size as input size
		int[] stack = new int[high-low+1]; 
	
		// Initialize top of stack 
		int top = -1; 
	
		// Push initial values of low and high to stack 
		stack[++top] = low; 
		stack[++top] = high; 
	
		// Keep popping from stack
		while (top >= 0) 
		{ 
			high = stack[top--]; 
			low = stack[top--]; 
	
			// Call partition method to set the right pivot
			int p = partition(input, low, high); 
	
			// If there are elements on left side of pivot, 
			// then push left side to stack 
			if (p-1 > low) 
			{ 
				stack[++top] = low; 
				stack[++top] = p - 1; 
			} 
	
			// If there are elements on right side of pivot, 
			// then push right side to stack 
			if (p+1 < high) 
			{ 
				stack[++top] = p + 1; 
				stack[++top] = high; 
			} 
		}
		return input; 
	}

    public static int partition(ArrayList<String> input, int low, int high) 
    { 
        String pivot = input.get(high); 
          
        // Index of the small element at any given iteration 
        int i = (low-1);  
        for (int j = low; j <= high-1; j++) 
        { 
            if (input.get(j).compareTo(pivot) <= 0 )
            { 
                i++; 
                String temp = input.get(i); 
                input.set(i,input.get(j)); 
                input.set(j,temp); 
            } 
        }
		// Swapping the pivot index to the small element of index 
		String temp = input.get(i+1); 
		input.set(i+1, input.get(high));
        input.set(high, temp); 
  
        return i+1; 
    } 
	////////////////////End of Iterative Quicksort//////////////////////////


	////////////////// Recursive Quicksort /////////////////////////////////
 	public static void doRecursively(ArrayList<String> input)
	{
		System.out.print("Recursively:\n\t");
		ArrayList<String> answer = doRecursively2(input, 0, input.size()-1);
		printResults(answer);
	}


	public static ArrayList<String> doRecursively2(ArrayList<String> input, int start, int end)
	{

		int p = partition(input, start, end);

		// Recursive for left array
		if(start < p - 1) 
		{ 
			doIteratively2(input, start, p - 1); 
		}

		// Recursive for right array
		if(end > p)
		{
			doRecursively2(input, p, end);
		}

		return input;
	}

	////////////////////End of Recursive Quicksort//////////////////////////


	public static void printResults(ArrayList<String> input)
	{
		for (String i : input)
		{
			System.out.print(i +"  ");
		}
		System.out.println("\n");
	}
}