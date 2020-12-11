import java.util.Arrays;
import java.util.Scanner;

public class Exercise01StudentNameSort {

	public static void main(String[] args) {
		Scanner scanner;
		String input;
		
		System.out.println("Enter a String: ");
		scanner = new Scanner(System.in);
		input = scanner.nextLine();
		
		scanner.close();
		
		String[] splitInput = input.split(";");
		String[] names = new String[splitInput.length];
		int[] percents = new int[splitInput.length];
		
		System.out.println("Names : Percents.   Length : " + splitInput.length);
		
		for(int i = 0; i < splitInput.length; i++) {
			String[] splitAgain = splitInput[i].split(":");
			names[i] = splitAgain[0];
			percents[i] = Integer.parseInt(splitAgain[1]); 
		}
		
		System.out.println(Arrays.toString(sortStudents(names,percents)));
	}
	
	public static String[] sortStudents(String[] names, int[] percentages) {
		if(names.length != percentages.length) {
			return new String[0];
		}else if(names.length == 1) {
			return names;
		}
		
		for(int i = 1; i < names.length; i ++) {
			if (percentages[i] <= percentages[i -1]) {
				String tempName = names[i];
				int tempPerc = percentages[i];
				int j = i;
				while(j > 0){
					if(percentages[j-1] < tempPerc) {
						break;
					}
					names[j] = names[j-1];
					percentages[j] = percentages[j - 1];
					j--;
				}
				names[j] = tempName;
				percentages[j] = tempPerc;
			}
		}
		return names;
	}
}
