import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[][][] dp = new int[21][21][21];

    public static int w(int a, int b, int c) {
        if(a <= 0 || b <= 0 || c <= 0) return 1;

        if(a > 20 || b > 20 || c > 20) {
            return w(20, 20, 20);
        } else if(dp[a][b][c] != 0) {
            return dp[a][b][c];
        } else if(a < b && b < c) {
            int result = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
            dp[a][b][c] = result;
            return result;
        } else {
            int result = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
            dp[a][b][c] = result;
            return result;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        boolean startFlag = true;

        while(startFlag) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(a == -1 && b == -1 && c == -1) {
                startFlag = false;
            } else {
                bw.write("w(" + a + ", " + b + ", " + c + ") = " + w(a, b, c) + "\n");
            }
        }

        bw.close();
        br.close();
    }
}
