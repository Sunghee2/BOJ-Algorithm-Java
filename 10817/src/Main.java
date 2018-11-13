import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int[] arr_num = new int[3];

        try {
            st = new StringTokenizer(br.readLine());

            for(int i = 0; i < 3; i++) {
                arr_num[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr_num);
            bw.write(String.valueOf(arr_num[1]));

            bw.flush();
            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
