import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        int index = Integer.parseInt(st.nextToken()) - 1;

        int[] nums = new int[num];

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i = 0; i < num; i++) {
            nums[i] = Integer.parseInt(st2.nextToken());
        }

        Arrays.sort(nums);

        bw.write(String.valueOf(nums[index]));
        bw.close();
        br.close();
    }
}
