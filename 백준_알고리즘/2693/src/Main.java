import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr_num = new int[10];

        while(n-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < 10; i++) {
                arr_num[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr_num);

            bw.write(arr_num[7] + "\n");
        }

        bw.close();
        br.close();
    }
}
