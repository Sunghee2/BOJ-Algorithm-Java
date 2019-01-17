import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            int testcase = Integer.parseInt(br.readLine());

            while(testcase-- > 0) {
                // 공백으로 숫자 구분
                StringTokenizer st = new StringTokenizer(br.readLine());

                int sum = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());

                bw.write(String.valueOf(sum)+"\n");
            }

            // flush를 마지막에 한번만 해야 시간초과가 안남.
            bw.flush();
            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
