import java.util.Scanner;

public class Main {
	public static int getDigits(int num) {
		int length = (int)(Math.log10(num) + 1);
		int digits = 0;
		
		for(int i = 0; i < length-1; i++) {
			int max = 0;
			for(int j = i; j >= 0; j--) {
				max += 9 * (int) Math.pow(10, j);
				System.out.println("   j" + j + " °ª = " + 9 * (int) Math.pow(10, j));
			}
			digits += (max - (int) Math.pow(10, i) + 1)*(i+1);
			System.out.println("i = " + i + " max = "+ max + " min = "+(int) Math.pow(10, i) + " °ª = " + (max - (int) Math.pow(10, i) + 1)*(i+1));
		}
		
		digits += ((num - (int) Math.pow(10, length-1) + 1) * length);
		
		return digits;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		
		System.out.println(getDigits(num));
	}
}
