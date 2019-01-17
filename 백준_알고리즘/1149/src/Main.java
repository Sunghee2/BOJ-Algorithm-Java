import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            int n = Integer.parseInt(br.readLine()); // 집의 수

            int[][] cost = new int[n][3];

            for(int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                for(int j = 0; j < 3; j++) {
                    cost[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i = 1; i < n; i++) {
                for(int j = 0; j < 3; j++) {
                    if(j == 0) {
                        cost[i][0] += Math.min(cost[i - 1][1], cost[i - 1][2]);
                    } else if(j == 1) {
                        cost[i][1] += Math.min(cost[i - 1][0], cost[i - 1][2]);
                    } else if(j == 2) {
                        cost[i][2] += Math.min(cost[i - 1][0], cost[i - 1][1]);
                    }
                }
            }

            int min = Math.min(Math.min(cost[n - 1][0], cost[n - 1][1]), cost[n - 1][2]);

            bw.write(String.valueOf(min));
            bw.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

/**
 * 돌넣기와 비슷한 유형
 * 1~n-1까지 이전과 패턴 맞는 것 중 min값 구하기
 **/
