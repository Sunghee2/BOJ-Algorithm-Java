import java.util.Scanner;

public class Main {	
	static int sum = 0;
	private static void count(int num) {
		if(num == 0) {
			sum++;
		}
		if(num-1 >= 0) count(num-1);
		if(num-2 >= 0) count(num-2);
		if(num-3 >= 0) count(num-3);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		
		while(testCase-- > 0) {
			count(sc.nextInt());
			System.out.println(sum);
			sum = 0;
		}
	}
}
