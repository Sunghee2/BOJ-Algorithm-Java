import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        long[][] matrix = new long[n][10];

        // 초기화
        for(int i = 1; i < 10; i++) {
            matrix[0][i] = 1;
        }

        for(int i = 1; i < n; i++) {
            for(int j = 0; j < 10; j++) {
                if(j == 0) {
                    matrix[i][j] += matrix[i - 1][1];
                } else if (j == 9) {
                    matrix[i][j] += matrix[i - 1][8];
                } else {
                    matrix[i][j] += (matrix[i - 1][j - 1] + matrix[i - 1][j + 1]) % 1000000000;
                }
            }
        }

        long sum = 0;
        for(int i = 0; i < 10; i++) {
            sum += matrix[n - 1][i];
        }

        bw.write(String.valueOf(sum % 1000000000));
        bw.close();
        br.close();
    }
}

/**
 * matrix[숫자 길이 수][마지막 숫자]
 *
 * 마지막 숫자가 0이면 다음에 올 숫자는 1뿐
 * 마찬가지로 마지막 숫자가 9이면 다음에 올 숫자는 8뿐
 * 나머지는 i-1, i+1
 *
 * **/