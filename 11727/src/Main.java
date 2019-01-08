import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];

        dp[0] = 1;
        dp[1] = 1;
        if(n > 1){
            for(int i = 2; i <= n; i++) {
                dp[i] = (dp[i - 1] + (2 * dp[i - 2])) % 10007;
            }
        }

        int result = dp[n];

        bw.write(String.valueOf(result));

        bw.close();
        br.close();
    }
}

/**
 * 3가지 경우가 있음
 * 1) 2 X 1 (세로)타일 하나를 쓰면 dp[i - 1]
 * 2) 1 X 2 (가로 두개) 타일을 쓰면 dp[i - 2] (가로 2개를 차지하기 때문)
 * 3) 2 X 2 타일을 하나 쓰면 dp[i - 2]
 *
 * 따라서 dp[i] = dp[i - 1] + (2 * dp[i - 2])임
 * **/