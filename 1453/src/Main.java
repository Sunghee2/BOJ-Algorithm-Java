import java.util.HashMap;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int customerNum = sc.nextInt();
		int count = 0;
		
		while(customerNum-- > 0) {
			int computerNum = sc.nextInt();
			if(map.containsKey(computerNum)) {
				count++;
			} else {
				map.put(computerNum, 0);
			}
		}
		System.out.println(count);
	}
}
