import java.io.*;
import java.util.stream.IntStream;

public class Main {
    static int[] arr_num;
    static int[] arr_mode = new int[8001];

    public static void quick_sort(int[] arr, int p, int r) {
        if(p < r) {
            int q = partition(arr, p, r);
            quick_sort(arr, p, q - 1);
            quick_sort(arr, q + 1, r);
        }
    }

    public static int partition(int[] arr, int p, int r) {
        int pivot = arr[r];
        int i = p - 1;
        for(int j = p; j < r; j++) {
            if(arr[j] <= pivot) swap(arr, ++i, j);
        }
        swap(arr, i + 1, r);
        return i + 1;
    }

    public static void swap(int[] arr, int s1, int s2) {
        int temp = arr[s1];
        arr[s1] = arr[s2];
        arr[s2] = temp;
    }

    // 산술평균 : N개의 수들의 합을 N으로 나눈 값
    public static int get_mean() {
        int sum = IntStream.of(arr_num).sum();
        return (int)Math.round((double)sum / arr_num.length);
    }

    // 중앙값 : N개의 수들을 증가하는 순서로 나열했을 경우 그 중앙에 위치하는 값
    public static int get_median() {
        return arr_num[arr_num.length/2];
    }

    // 최빈값 : N개의 수들 중 가장 많이 나타나는 값 & 여러 개 있을 경우에는 최빈값 중 두 번째로 작은 값 리턴
    public static int get_mode() {
        int max = -1;
        int index = -1;
        int count = 0;

        for(int i = 0; i <= 8000; i++) {
            if(arr_mode[i] > max) {
                max = arr_mode[i];
                index = i;
                count = 0;
            } else if(arr_mode[i] == max) {
                if(count++ < 1) index = i;
            }
        }

        return index - 4000;
    }

    // 범위 : N개의 수들 중 최댓값과 최솟값의 차이
    public static int get_scope() {
        if(arr_num.length == 1) {
            return 0;
        } else {
            return arr_num[arr_num.length - 1] - arr_num[0];
        }
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            int num = Integer.parseInt(br.readLine());
            arr_num = new int[num];

            for(int i = 0; i < num; i++) {
                int input = Integer.parseInt(br.readLine());
                arr_num[i] = input;
                arr_mode[input + 4000]++;
            }

            quick_sort(arr_num,0, num - 1);

            bw.write(String.valueOf(get_mean() + "\n" + get_median() + "\n" + get_mode() + "\n" + get_scope() + "\n"));
            bw.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

/**
 * quick sort 이용
 *
 * n은 문제에서 홀수라고 가정
 * 최빈값은 입력값을 index로 하는 배열을 따로 만듦. count를 이용해서 두 번째 작은 값 구함.
 * **/