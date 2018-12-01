import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 동전 개수
            int k = Integer.parseInt(st.nextToken()); // 만들어야 하는 값

            int[] coins = new int[n];

            for(int i = 0; i < n; i++) {
                coins[i] = Integer.parseInt(br.readLine());
            }

            int min = 0;
            for(int i = n - 1; i >= 0; i--) {
                if(k == 0) break;
                int num = k / coins[i];
                k -= (num * coins[i]);
                min += num;
            }

            bw.write(String.valueOf(min));
            bw.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

/**
 * 동전이 배수라는 조건이 있으므로
 * 그리디 알고리즘임
 *
 * 가장 큰 동전을 골라 채우면 됨.
 * **/