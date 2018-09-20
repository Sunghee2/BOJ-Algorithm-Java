import java.util.Scanner;

public class Main {
	private static int[] pushNumToArray(String str, int[] arr_num) {
		if(str.equals("")) {
			if(arr_num[6] % 2 == 0) {
				arr_num[6] /= 2;
			} else {
				arr_num[6] = arr_num[6]/2 + 1;
			}
			return arr_num;
		}
		int firstNum = str.charAt(0) - '0';
		if(firstNum==9) {
			arr_num[6]++;
		} else {
			arr_num[firstNum]++;
		}
		return pushNumToArray(str.substring(1), arr_num);
	}
	
	private static int count(int[] arr_num) {
		int max = 0;
		for(int i = 0; i < arr_num.length; i++) {
			if(arr_num[i] > max) max = arr_num[i];
		}
		
		return max;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String roomNum = sc.nextLine();
		
		System.out.println(count(pushNumToArray(roomNum, new int[9])));
	}
}
