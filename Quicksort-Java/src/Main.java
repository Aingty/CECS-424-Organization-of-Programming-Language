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

		doIteratively(input);
		// doRecursively(input);
	
	}





	public static void doIteratively(ArrayList<String> input)
	{
		System.out.println("Iteratively");
		ArrayList<String> answer = doIteratively2(input);
		printResults(answer);
	}

	public static ArrayList<String> doIteratively2(ArrayList<String> input)
	{
		Stack stack = new Stack(); 
		stack.push(0); 
		stack.push(input.length); 
		while (!stack.isEmpty()) 
		{ 
			int end = stack.pop(); 
			int start = stack.pop(); 
			if (end - start < 2) 
			{
				continue;
			}
			int p = start + ((end - start) / 2); 
			p = partition(input, p, start, end); 
			stack.push(p + 1); 
			stack.push(end); 
			stack.push(start);
			stack.push(p); 
		}
		return input;
	}

	public static void printResults(ArrayList<String> input)
	{
		System.out.print("Result in Increasing Order: \n\t");
		for (String i : input)
		{
			System.out.print(i +"  ");
		}
		System.out.println("\n");
	}


	/* This function takes last element as pivot, 
    places the pivot element at its correct 
    position in sorted array, and places all 
    smaller (smaller than pivot) to left of 
    pivot and all greater elements to right 
    of pivot */
    static int partition(int arr[], int low, int high) 
    { 
        int pivot = arr[high]; 
          
        // index of smaller element 
        int i = (low-1);  
        for (int j = low; j <= high-1; j++) 
        { 
            // If current element is smaller than or 
            // equal to pivot 
            if (arr[j] <= pivot) 
            { 
                i++; 
  
                // swap arr[i] and arr[j] 
                int temp = arr[i]; 
                arr[i] = arr[j]; 
                arr[j] = temp; 
            } 
        } 
  
        // swap arr[i+1] and arr[high] (or pivot) 
        int temp = arr[i+1]; 
        arr[i+1] = arr[high]; 
        arr[high] = temp; 
  
        return i+1; 
    } 
/*
 	public static void doRecursively(ArrayList<String> input)
	{
		System.out.println("Recursively");
		ArrayList<String> answer = doRecursively2(input);
		printResults(answer);
	}


*/
}