import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int input_n = n;

        for(int j = 1; j <= input_n; j++) {
            for(int i = 0; i < n - j; i++) {
                System.out.print(" ");
            }

            if(j % 3 == 0) {
                if(j < input_n/2) {
                    for (int i = 0; i < j / 3; i++) {
                        System.out.print("***** ");
                    }
                } else {
                    for (int i = 0; i < )
                }
            } else if(j % 3 == 1){
                System.out.print("* ");
                for(int i = 1; i < j - 1; i++) {
                    System.out.print("  ");
                }
                if(j > 3) {
                    System.out.print("*");
                }
            } else {
                System.out.print("* * ");
                for(int i = 1; i < j - 3; i++) {
                    System.out.print("  ");
                }
                if(j > 3) {
                    System.out.print("* *");
                }
            }
            System.out.print("\n");
        }
    }
}
