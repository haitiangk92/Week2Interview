import java.util.Scanner;

/* Requirements
[*] Accept a String from the console
[*] Display the maximum digit using the getMaxDigit method as shown in example section
[*] Display **No digits in string**, if the String has no digits or is empty 
 */
public class MaxDigitInString {

	public static void main(String[] args) {
		Scanner scanner;
		String input;
		
		System.out.println("Enter a String: ");
		scanner = new Scanner(System.in);
		input = scanner.nextLine();
		
		scanner.close();
		
		int maxDigit = getMaxDigit(input);
		
		System.out.println(maxDigit > -1 ? "Max digit : " + maxDigit : "No digits in string");

	}
	
	public static int getMaxDigit(String input) {
		int max = -1;
		
		for(int i = 0; i < input.length(); i++) {
			try {
				int characterInt = Integer.parseInt(((Character)input.charAt(i)).toString());
				
				max = Math.max(characterInt, max);
			}catch(NumberFormatException e) {}
		}
		return max;
	}
}
