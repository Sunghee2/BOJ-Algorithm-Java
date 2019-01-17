import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextLine()) {
			String s = sc.nextLine();
			if(s.equals("") || s==null) {
				break;
			} else {
				System.out.println(s);
			}
		}
		
		//얘 없으면 런타임 에러 
		sc.close();

	}

}
