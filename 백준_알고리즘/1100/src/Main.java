import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	private static int countFNum(List list) {
		int count = 0;
		for(int i = 0; i < list.size(); i++) {
			char[] charArr = (char[]) list.get(i);
			for(int j = 0; j < 8 ; j++) {
				if ((i + j) % 2 == 0 && charArr[j]=='F') {
					count++;
				}
			}
		}
		return count;
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<char[]> list = new ArrayList();
		int inputNum = 8;
		
		while(inputNum-- > 0) {
			char[] charList = sc.nextLine().toCharArray();
			list.add(charList);
		}
		
		System.out.println(countFNum(list));
	}
}
