import java.io.*;

public class Main {
    public static void countingSort(int[] arr_input, int max) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr_count = new int[max + 1];
        int[] output = new int[arr_input.length];


        for (int i = 0; i < arr_input.length; i++) {
            arr_count[arr_input[i]]++;
        }

        /* 아래와 같이 일반적인 counting sort로 풀었는데 아무리해도 시간초과가 되어서 변형해서 풀었습니다.. */
//        /* arr_count 누적 */
//        for(int j = 1; j < arr_count.length; j++) {
//            arr_count[j] += arr_count[j - 1];
//        }
//
//        /* output에 넣음 */
//        for(int k = arr_input.length - 1; k >= 0; k--) {
//            output[--arr_count[arr_input[k]]] = arr_input[k];
//        }


        for (int j = 0; j < arr_count.length; j++) {
            for (int k = 0; k < arr_count[j]; k++) {
                bw.write(Integer.toString(j) + '\n');
            }
        }

        bw.close();
    }

    public static int getMax(int[] arr) {
        int max = arr[0];

        for(int i = 1; i < arr.length; i++) {
            if (arr[i] > max) max = arr[i];
        }

        return max;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        int num = Integer.parseInt(br.readLine());
        int[] arr_input = new int[num];

        for(int i = 0; i < num; i++) {
            arr_input[i] = Integer.parseInt(br.readLine());
        }

        countingSort(arr_input, getMax(arr_input));
    }
}
