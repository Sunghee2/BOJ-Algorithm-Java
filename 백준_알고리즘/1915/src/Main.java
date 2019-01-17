import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] input_matrix = new int[n][m];
        int[][] count_matrix = new int[n][m];

        for(int i = 0; i < n; i++) {
            String input = br.readLine();
            for(int j = 0; j < m; j++) {
                input_matrix[i][j] = input.charAt(j) - '0';
            }
        }

        int max = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(input_matrix[i][j] == 0) {
                    count_matrix[i][j] = 0;
                } else {
                    int value = 1;
                    if((i != 0) && (j != 0) && (count_matrix[i - 1][j] != 0 ) && (count_matrix[i][j - 1] != 0) && (count_matrix[i - 1][j - 1] != 0)) {
                        value = Math.min(count_matrix[i - 1][j - 1], Math.min(count_matrix[i - 1][j], count_matrix[i][j - 1])) + 1;
                        count_matrix[i][j] = value;
                    } else {
                        count_matrix[i][j] = 1;
                    }

                    if(max < value) max = value;
                }
            }
        }

        bw.write(String.valueOf(max * max));
        bw.close();
        br.close();
    }
}

/**
 * 새로 행렬을 만들어서
 * 해당 칸의 왼, 위, 대각선이 1인지 확인하고 그 중 가장 작은 값 + 1
 * **/
