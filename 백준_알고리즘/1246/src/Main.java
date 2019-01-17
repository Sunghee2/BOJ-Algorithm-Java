import java.util.Arrays;
import java.util.Scanner;

public class Main {
	private static void getMaxRevenue(int egg, int[] arrDemandPrice) {
		int price = 0;
		int revenue = 0;
		for(int i = 0; i < arrDemandPrice.length; i++) {
			int temp_revenue = ((arrDemandPrice.length - i) >= egg)?  arrDemandPrice[i] * egg : arrDemandPrice[i] * (arrDemandPrice.length - i);
			if(revenue < temp_revenue) {
				price = arrDemandPrice[i];
				revenue = temp_revenue;
			}
		}
		
		System.out.print(price + " " + revenue);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int egg = sc.nextInt();
		int customer = sc.nextInt();
		
		int[] arrDemandPrice = new int[customer];
		int index = 0;
		
		while(customer-- > 0) {
			arrDemandPrice[index++] = sc.nextInt();
		}
		
		Arrays.sort(arrDemandPrice);
		getMaxRevenue(egg, arrDemandPrice);
	}
}
