
import java.util.*;
class ArrayToReducedForm
{
	/*Sorting array*/		
	public static void sortCopyOfArrayToBeReduced(int copyOfArrayToBeReduced[])
	{
		int lengthOfCopyOfArrayToBeReduced = copyOfArrayToBeReduced.length;
		for(int index = 1; index < lengthOfCopyOfArrayToBeReduced; index++)
		{
			int currentElement = copyOfArrayToBeReduced[index];
			int previousIndex = index-1;
			while(previousIndex > -1 && copyOfArrayToBeReduced[previousIndex] > currentElement)
			{
				copyOfArrayToBeReduced[previousIndex+1] = copyOfArrayToBeReduced[previousIndex];
				previousIndex--;
			}
			copyOfArrayToBeReduced[previousIndex+1] = currentElement;
		}
	}
	/* Coverting the given array into reduced form*/
	public static void convertToReducedForm(int arrayToBeReduced[], int lengthOfArrayToBeReduced)
	{
		/*Creating a copy of the original array*/
		int copyOfArrayToBeReduced[] = arrayToBeReduced.clone();
		sortCopyOfArrayToBeReduced(copyOfArrayToBeReduced);
		/* I have created an hashmap to store elements along with their index*/
		HashMap<Integer, Integer> reducedElements = new HashMap<>();
		int reducedValue = 0;
		for(int index = 0; index < lengthOfArrayToBeReduced; index++)
		{
			reducedElements.put(copyOfArrayToBeReduced[index], reducedValue++);
		}
		
		for(int index = 0; index < lengthOfArrayToBeReduced; index++)
		{
			arrayToBeReduced[index] = reducedElements.get(arrayToBeReduced[index]);
		}
	}
	/*Printing the reduced array*/
	public static void printArray(int reducedArray[], int lengthOfReducedArray)
    	{	
        	for (int index = 0; index < lengthOfReducedArray; index++)
        	{
            		System.out.print(reducedArray[index] + " ");
            	}
    	}
	
	public static void main(String args[])
	{
		Scanner takeInput = new Scanner(System.in);
		System.out.print("Enter the length of array to be reduced: ");
		int lengthOfArrayToBeReduced = takeInput.nextInt();
		int arrayToBeReduced[] = new int[lengthOfArrayToBeReduced];
		System.out.println("Enter the array elements");
		for(int index=0; index < lengthOfArrayToBeReduced; index++)
		{
			arrayToBeReduced[index] = takeInput.nextInt();
		}
		System.out.println("Given Array is ");
        	printArray(arrayToBeReduced, lengthOfArrayToBeReduced);
        	convertToReducedForm(arrayToBeReduced, lengthOfArrayToBeReduced);
        	System.out.println();
        	System.out.println("Reduced Array is ");
        	printArray(arrayToBeReduced, lengthOfArrayToBeReduced);
	}
}
