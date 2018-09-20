import java.util.Scanner;

public class Main {
	private static int sum(String word) {
		char[] arr_word = word.toCharArray();
		int sum = 0;
		
		for(int i = 0; i < arr_word.length; i++) {
			if(Character.isUpperCase(arr_word[i])==true) {
				sum += arr_word[i] - 'a' + 59;
			} else {
				sum += arr_word[i] - 'a' + 1;
			}
		}
		
		return sum;
	}
	
	private static void checkPrime(int num) {
		boolean flag = false;
		
		for(int i = 2; i < num; i++) {
			if(num % i == 0) {
				flag = true;
				break;
			}
		}
		if(flag) {
			System.out.println("It is not a prime word.");
		} else {
			System.out.println("It is a prime word.");
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String word = sc.nextLine();
		
		checkPrime(sum(word));
	}

}
