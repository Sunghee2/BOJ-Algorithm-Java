import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            int n = Integer.parseInt(br.readLine()); // 회의의 수

            int[][] meetings = new int[n][2];

            for(int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                meetings[i][0] = Integer.parseInt(st.nextToken());
                meetings[i][1] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(meetings, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if(o1[1] == o2[1]) { // 끝나는 시간이 동일하면 시작시간에 맞춰서 정렬
                        return Integer.compare(o1[0], o2[0]);
                    } else { // 끝나는 시간 기준으로 정렬
                        return Integer.compare(o1[1], o2[1]);
                    }
                }
            });

            int num_meetings = 1;
            int end_time = meetings[0][1];
            for(int i = 1; i < n; i++) {
                if(end_time <= meetings[i][0]) { // 끝나는 시작이 시작 시간보다 작거나 같으면 회의할 수 있음.
                    end_time = meetings[i][1];
                    num_meetings++;
                }
            }

            bw.write(String.valueOf(num_meetings));
            bw.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}