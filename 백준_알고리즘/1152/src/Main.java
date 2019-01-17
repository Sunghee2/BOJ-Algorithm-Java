import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc_input = new Scanner(System.in);
		String str = sc_input.nextLine();
		int count = 0;
		
		Scanner sc_str = new Scanner(str);
		
		while(sc_str.hasNext()) {
			count++;
			sc_str.next();
		}
		
		System.out.println(count);
	}
}
