import java.util.Scanner;


/* Requirements
[*] Accept inputs from the console
[*] The first input is integer(n) denoting the count of integers, followed by  'n' integers
[*] The integers should be stored in an array and passed to the method
[*] The output should be displayed as per the format given in example section
 */

public class LargestDifference {

	public static void main(String[] args) {
		
		int[] numbers;
		Scanner scanner;
		String input;
		
		
		while(true) {
			try {
				System.out.println("Enter the number of numbers: ");
				scanner = new Scanner(System.in);
				input = scanner.nextLine();
				
				numbers = new int[Integer.parseInt(input)];
				
				break;
			}catch(NumberFormatException e){
				System.out.println("You Entered something other than a number");
			}
		}
		
		for(int i = 0; i < numbers.length; i ++) {
			while(true) {
				try {
					System.out.println("Enter number " + (i + 1) + ": ");
					scanner = new Scanner(System.in);
					input = scanner.nextLine();
					
					numbers[i] = Integer.parseInt(input);
					break;
				}catch(NumberFormatException e) {
					System.out.println("You Entered something other than a number");
				}
			}
		}
		scanner.close();
		System.out.println("Index of Largest Number in Largest Difference: " + findLargestDifference(numbers));
		
		
	}
	
	public static int findLargestDifference(int[] numbers) {
		int maxDiff = 0;
		int maxVal = 0;
		int maxIdx = -1;
		
		if(numbers.length < 3){
			return -1;
		}
		
		for(int i = 0, j = 1; j < numbers.length; i++,j++ ) {
			int diff = Math.abs(numbers[i] - numbers[j]); //gets the difference
			int idxOfMax = numbers[i] > numbers[j] ? i : j; //keeps track of the higher number
			
			if(diff > maxDiff) { 
				maxDiff = diff; 
				maxVal = numbers[idxOfMax]; 
				maxIdx = idxOfMax;					
			}else if(diff == maxDiff) { //Special case if differences are the same
				if(numbers[idxOfMax] > maxVal) {
					maxVal = numbers[idxOfMax];
					maxIdx = idxOfMax;
				}
			}
		}
		return maxIdx;
	}
}
