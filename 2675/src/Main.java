import java.util.Scanner;

public class Main {
	public static String repeat(int num, String s) {
		String result = "";
		s = s.replaceAll(" ", "");
		for(int i = 0; i < s.length(); i++) {
			for(int j = 0; j < num; j++) {
				result += s.charAt(i);
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int textcase = sc.nextInt();
		String[] result = new String[textcase];
		
		for(int i = 0; i<textcase; i++) {
			int num = sc.nextInt();
			String s = sc.nextLine();
			result[i] = repeat(num, s);
		}
		
		for(String s : result) {
			System.out.println(s);
		}
	}

}
