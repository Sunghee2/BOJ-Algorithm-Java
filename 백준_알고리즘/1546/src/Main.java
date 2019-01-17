import java.util.Scanner;

public class Main {
    static int getMax(int[] arr) {
        int max_value = 0;
        for(int num : arr) {
            max_value = max_value < num? num : max_value;
        }

        return max_value;
    }

    static double calculation(int[] arr) {
        int max_value = getMax(arr);
        double sum = 0;

        // 점수 재계산
        for(int i = 0; i < arr.length; i++) {
            sum += (arr[i] / (double) max_value) * 100;
        }

        return sum/arr.length;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int[] arr = new int[num];

        for(int i = 0; i < num; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.printf("%.2f", calculation(arr));

    }
}
