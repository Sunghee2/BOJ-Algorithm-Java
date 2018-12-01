import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            int n = Integer.parseInt(br.readLine()); // 사람 수

            int[] time = new int[n];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++) {
                time[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(time);

            int max = 0; // 필요한 시간의 합의 최솟값
            int sum = 0;
            for(int i = 0; i < n; i++) {
                sum += time[i];
                max += sum;
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
 * 오랜 시간이 걸리는 사람이 앞 번호에 있으면 그 만큼 많이 더해지므로
 * 시간이 오래걸린다
 * 따라서 가장 적게 걸리는 사람을 앞 번호에 배치한다
 * **/