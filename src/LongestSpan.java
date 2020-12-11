import java.util.HashMap;
import java.util.Scanner;

public class LongestSpan {
	
/* Requirements
[*] Accept inputs from the console
[*] The first input is integer(n) denoting the count of integers, followed by  'n' integers
[*] The integers should be stored in an array and passed to the method
[*] The output should be displayed as per the format given in example section 
[*] Main method should display **Empty Array**, if the input array to the method is empty
*/

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
		String output = findLongestSpan(numbers);
		System.out.println(output.equals("-1") ? "Empty Array" : output);		
	}
	
	public static String findLongestSpan(int[] numbers) {
		HashMap<Integer,Integer[]> values = new HashMap<Integer,Integer[]>();
		int maxSpan = 0;
		int valueOfMaxSpan = -1;
		
		if(numbers == null || numbers.length == 0) {
			return "-1";
		}
		
		for(int i = 0; i < numbers.length; i++) {
			if(values.get(numbers[i]) == null) {
				Integer[] newArr = {i,1};
				values.put(Integer.valueOf(numbers[i]), newArr);
				if(maxSpan == 0) {
					maxSpan = 1;
					valueOfMaxSpan = numbers[i];
				}
			}else {
				Integer[] vals = values.get(Integer.valueOf(numbers[i]));
				vals[1] = i - vals[0] + 1; 
				values.put(Integer.valueOf(numbers[i]), vals);
				
				if(vals[1] > maxSpan) {
					maxSpan = vals[1];
					valueOfMaxSpan = numbers[i];
				}else if (vals[1] == maxSpan)
					maxSpan = vals[1];
					valueOfMaxSpan = Math.max(valueOfMaxSpan,numbers[i]);
			}
		}
		return valueOfMaxSpan + ":" + maxSpan;
	}
}
