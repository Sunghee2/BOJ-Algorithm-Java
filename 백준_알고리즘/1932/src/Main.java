import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[][] triangle;

        try {
            int n = Integer.parseInt(br.readLine());
            triangle = new int[n][n];

            for(int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j <= i; j++) {
                    triangle[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i = 1; i < n; i++) { // 행
                for(int j = 0; j <= i; j++) { // 열
                    if (j == 0) { // 맨 앞에 있는 원소일 경우
                        triangle[i][j] += triangle[i - 1][0];
                    } else if (j >= i) { // 맨 뒤에 있는 원소일 경우
                        triangle[i][j] += triangle[i - 1][j - 1];
                    } else {
                        triangle[i][j] += Math.max(triangle[i - 1][j - 1], triangle[i - 1][j]);
                    }
                }
            }

            int max = 0;

            for(int j = 0; j < n; j ++) {
                if(triangle[n - 1][j] > max) max = triangle[n - 1][j];
            }

            bw.write(String.valueOf(max));
            bw.flush();
            bw.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
