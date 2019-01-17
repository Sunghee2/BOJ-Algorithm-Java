import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int num2= num;
		int cycle = 0;
		
		do {
			int sum = (num2/10) + (num2%10);
			num2 = ((num2%10)*10) + (sum%10);
			cycle++;
		} while(num != num2);
		
		System.out.println(cycle);
	}
}
