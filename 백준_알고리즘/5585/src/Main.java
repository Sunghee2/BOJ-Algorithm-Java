import java.io.*;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            int n = 1000 - Integer.parseInt(br.readLine()); // 잔돈

            int[] coins = { 500, 100, 50, 10, 5, 1 };

            int min = 0;
            for(int i = 0; i < 6; i++) { // 가장 큰 동전 먼저
                if(n == 0) break;
                int num = n / coins[i]; // 나눠서 몫 구함
                n -= (num * coins[i]);
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
 * 그리디 알고리즘
 * **/