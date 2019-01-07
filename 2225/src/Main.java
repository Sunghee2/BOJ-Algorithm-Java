import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] num_cases = new int[n][k];

        // n = 1일 경우 초기화
        for(int column = 0; column < k; column++) {
            num_cases[0][column] = column + 1;
        }

        for(int row = 1; row < n; row++) {
            for(int column = 0; column < k; column++) {
                if(column == 0) { // k = 1일 경우는 무조건 1
                    num_cases[row][column] = 1;
                } else {
                    num_cases[row][column] = (num_cases[row][column - 1] + num_cases[row - 1][column]) % 1000000000;
                }
            }
        }

        int result = num_cases[n - 1][k - 1] % 1000000000;

        bw.write(String.valueOf(result));
        bw.close();
        br.close();
    }
}

/**
 * n = 1, k = 1  - 1가지
 * n = 1, k = 2  - (1, 0) (0, 1) 2가지
 * n = 1, k = 3  - (1, 0, 0) (0, 1, 0) (0, 0, 1) 3가지
 * n = 1, k = 4  - (1, 0, 0, 0) (0, 1, 0, 0) (0, 0, 1, 0) (0, 0, 0, 1) 4가지
 *
 * n = 2, k = 1  - 1가지
 * n = 2, k = 2  - (2, 0) (0, 2) (1, 1) 3가지
 * n = 2, k = 3  - (2, 0, 0) (0, 2, 0) (0, 0, 2) (1, 1, 0) (1, 0, 1) (0, 1, 1) 6가지
 * n = 2, k = 4  - (2, 0, 0, 0) (0, 2, 0, 0) (0, 0, 2, 0) (0, 0, 0, 2) (1, 1, 0, 0) (1, 0, 1, 0) (0, 1, 0, 1) (1, 0, 0, 1) (0, 1, 1, 0) (0, 0, 1, 1) 10가지
 *
 * n = 3, k = 1  - 1가지
 * n = 3, k = 2  - (3, 0) (0, 3) (1, 2) (2, 1) 4가지
 * n = 3, k = 3  - (3, 0, 0) (0, 3, 0) (0, 0, 3) (1, 2, 0) (2, 1, 0) (1, 0, 2) (0, 1, 2) (2, 0, 1) (0, 2, 1) (1, 1, 1) 10가지
 *
 * 이전 수열 간격으로 계차수열이 이루어짐.
 * **/