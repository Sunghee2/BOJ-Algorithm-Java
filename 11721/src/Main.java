import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String word = sc.nextLine();
		
		for(int i = 0; i<word.length(); i++) {
			System.out.print(word.charAt(i));
			if((i+1)%10==0) {
				System.out.println();
			}
		}
	}
}
