import java.util.Scanner;

public class Main {
    public static void heapSort(int[] arr) {
        buildHeap(arr);

        int length = arr.length;
        for(int i = length; i > 0; i--) {
            swap(arr, 0, i - 1);
            length--;
            heapify(arr, 0, length);
        }
        printArray(arr);
    }

    public static void buildHeap(int[] arr) {
        for(int i = (arr.length/2) - 1; i >= 0; i--) {
            heapify(arr, i, arr.length);
        }
    }

    public static void heapify(int[] arr, int k, int n) {
        int left = (2 * k) + 1;
        int right = (2 * k) + 2;
        int smaller = 0;

        /* 자식 노드 중 가장 작은 것 찾기 */
        if (right < n) {
            if (arr[left] < arr[right]) {
                smaller = left;
            } else {
                smaller = right;
            }
        } else if (left < n) {
            smaller = left;
        } else return;


        /* 자식 노드가 더 작다면 swap */
        if(arr[smaller] < arr[k]) {
            swap(arr, k, smaller);
            heapify(arr, smaller, n);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int[] strArrToIntArr(String[] str_arr) {
        int[] result = new int[str_arr.length];

        for(int i = 0; i < str_arr.length; i++)  {
            result[i] = Integer.parseInt(str_arr[i]);
        }

        return result;
    }

    public static void printArray(int[] arr) {
        for(int num : arr) {
            System.out.print(num);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input_num = sc.nextLine();
        String[] arr_num;

        arr_num = input_num.split("");

        heapSort(strArrToIntArr(arr_num));

    }
}
