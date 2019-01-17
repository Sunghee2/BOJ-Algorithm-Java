import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int x = sc.nextInt();

        int[] arr_num = new int[n];

        for(int i = 0; i < n; i++) {
            arr_num[i] = sc.nextInt();
        }

        for(int i = 0; i < n; i++) {
            if(arr_num[i] < x) {
                System.out.print(arr_num[i] + " ");
            }
        }
    }
}
