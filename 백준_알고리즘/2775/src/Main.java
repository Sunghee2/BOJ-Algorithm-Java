import java.util.Scanner;
import java.math.BigInteger;

public class Main {
	
	public static BigInteger factorial(int n) {
		if(n <= 1) return BigInteger.ONE;
		else return  BigInteger.valueOf(n).multiply(factorial(n-1));
	}
	
	public static BigInteger combinations(int n, int k) {
		return factorial(n).divide((factorial(n-k).multiply(factorial(k))));
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		
		for(int i = 0; i < testcase; i++) {
			int floor = sc.nextInt();
			int unit = sc.nextInt();
			System.out.println(combinations(floor+unit, unit-1));
		}
		
	}

}



//ÆÄ½ºÄ®ÀÇ »ï°¢Çü ÀÌ¿ë.
