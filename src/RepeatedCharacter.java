import java.util.HashMap;
import java.util.Scanner;

/*
[*] Accept a String from the console
[*] Display the most repeated character as shown in example section
[*] Display **No characters repeated**, if the String has no repeated characters or is empty 
 */

public class RepeatedCharacter {

	public static void main(String[] args) {
		Scanner scanner;
		String input;
		
		System.out.println("Enter a String: ");
		scanner = new Scanner(System.in);
		input = scanner.nextLine();
		
		scanner.close();
		
		Character maxRepeated = findRepeatedCharacter(input);
		
		System.out.println(maxRepeated != '0' ?  maxRepeated : "No characters repeated");
	}
	
	public static Character findRepeatedCharacter(String input) {
		HashMap <Character,Integer> values = new HashMap<Character,Integer>();
		int maxRepetitions = 0;
		char maxChar = '-';
		
		if(input.length() == 0 || input == null) {
			return '0';
		}
		
		for(int i = 0; i < input.length(); i++) {
			char character = input.charAt(i);
			if(values.get((Character)character) == null){
				values.put((Character)character, 1);
				if(maxRepetitions == 0) {
					maxRepetitions = 1;
					maxChar = character;
				}
			}else {
				int reps = values.get((Character)character) + 1;
				values.put((Character)character, reps);
				
				if(reps > maxRepetitions) {
					maxRepetitions = reps;
					maxChar = character;
				}else if(reps == maxRepetitions) {
					maxChar = (char) Math.min(character, maxChar);
				}
			}
		}
		
		if(maxRepetitions == 1) {
			return '0';
		}
		
		return maxChar;
	}

}
