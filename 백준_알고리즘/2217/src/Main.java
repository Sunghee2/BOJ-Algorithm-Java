import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            int n = Integer.parseInt(br.readLine());
            int[] weight = new int[n];
            for(int i = 0; i < n; i++) {
                weight[i] = Integer.parseInt(br.readLine());
            }

            Arrays.sort(weight);
            int max = 0;
            for(int i = n-1; i >= 0; i--) {
                if(max < (weight[i] * (n - i))) {
                    max = (weight[i] * (n - i));
                }
            }

            bw.write(String.valueOf(max));
            bw.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

/**
 * 그리디 알고리즘
 * 
 * 정렬 후
 * (현재 중량 * (몇 번째 큰지)) 값 선택
 * **/