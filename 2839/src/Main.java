import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sugar = sc.nextInt();
		int sugar2 = sugar;
		int bag = 0;

		calculator:
		for (int i = sugar / 5; i >= 0; i--) {
			sugar2 -= (5 * i);
			if(sugar2 ==0) {
				bag = i;
				break;
			}
			for (int j = 1; j <= sugar/3; j++) {
				sugar2 -= 3;
				if (sugar2 == 0) {
					bag = i + j;
					break calculator;
				}
			}
			sugar2 = sugar;
		}

		if(bag==0) {
			System.out.print(-1);
		} else {
			System.out.print(bag);
		}
	}
}
