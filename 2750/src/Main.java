import java.util.Scanner;

public class Main {
    public static int[] arr;

    public static void selectionSort(int[] arr) {
        for(int i = arr.length - 1; i > 0; i--) {
            int max = getMax(i);
            if(arr[max] > arr[i]) swap(max, i);
        }

    }

    public static int getMax(int index) {
        int max = 0;

        for(int i = 1; i < index; i++) {
            if (arr[i] > arr[max]) max = i;
        }

        return max;
    }

    public static void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        arr = new int[num];

        for(int i = 0; i < num; i++) {
            arr[i] = sc.nextInt();
        }

        selectionSort(arr);

        /* print array elements */
        for(int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
