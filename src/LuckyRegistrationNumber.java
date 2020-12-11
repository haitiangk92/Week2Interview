import java.util.Scanner;

/* Requirements
[*] Accept Registration number from the console
[*] If the Registration number is invalid, display **Invalid Registration number**
[*] If the Registration number is Valid but not lucky, display **Valid Registration number**
[*] If the Registration number is Valid and lucky, display **Lucky Registration number**
 */

public class LuckyRegistrationNumber {

	public static void main(String[] args) {
		Scanner scanner;
		String input;
		
		System.out.println("Enter a Registration Number: ");
		scanner = new Scanner(System.in);
		input = scanner.nextLine();
		
		scanner.close();
		
		switch (checkRegistrationNumber(input)) {
			case 0:
				System.out.println("Valid Registration number");
				break;
			case 1:
				System.out.println("Lucky Registration number");
				break;
			case -1:
				System.out.println("Invalid Registration number");
				break;
			default:
				System.out.println("I Dont know how we got here!");
		}
	}
	
	public static int checkRegistrationNumber(String regNumber) {
		if(regNumber == null || regNumber.length() < 9 || regNumber.length() > 10) {
			return -1;
		}
		
		if(regNumber.substring(0,2).equals("KA") || regNumber.substring(0,2).equals("DL")) {
			int xx;
			
			try {
				xx = Integer.parseInt(regNumber.substring(2,4));
			}catch(NumberFormatException e) {
				return -1;
			}
			
			if(xx > 0 && xx <= 10) {
				int next = regNumber.length() == 9 ? 5 : 6;
				
				String qq = regNumber.substring(4,next);
				
				for(int i = 0; i < qq.length();i++) {
					if(qq.charAt(i) <'A' || qq.charAt(i) > 'Z') {
						return -1;
					}
				}
				
				String yyyy = regNumber.substring(next,regNumber.length());
				
				try {
					if(Integer.parseInt(yyyy) < 1000) {
						throw new NumberFormatException();
					}
				}catch(NumberFormatException e) {
					return -1;
				}
				
				int total = 0;
				
				while(yyyy.length() > 1) {
					total = 0;
					for(int i = 0; i < yyyy.length(); i++) {
						total += Integer.parseInt(((Character)yyyy.charAt(i)).toString());
					}
					
					yyyy = ((Integer)total).toString();
				}
				
				if(total == 6) {
					return 1;
				}else {
					return 0;
				}
			}
		}
		return -1;
	}
}
