import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] num;

        try {
            int n = Integer.parseInt(br.readLine());
            num = new int[n];
            int[] arr_sum = new int[n];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++) {
                num[i] = Integer.parseInt(st.nextToken());
            }

            arr_sum[0] = num[0];
            for(int i = 1; i < n; i++) {
                if(arr_sum[i - 1] < num[i] && arr_sum[i - 1] < 0) {
                    arr_sum[i] = num[i];
                } else {
                    arr_sum[i] = arr_sum[i - 1] + num[i];
                }
            }

            Arrays.sort(arr_sum);

            bw.write(String.valueOf(arr_sum[n - 1]));
            bw.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


/**
 * 7
 * -5 32 9 -11 38 -11 31 같은 경우 32부터 31까지 합쳐져야 88 max값이 나옴
 * 이전까지 합해오던 것이 현재 것보다 작고 -이면 버리고 새로 시작!
 * **/
