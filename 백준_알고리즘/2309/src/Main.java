import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] height = new int[9];
        int sum = 0;

        for(int i = 0; i < 9; i++) {
            int input = Integer.parseInt(br.readLine());
            height[i] = input;
            sum += input;
        }

        Arrays.sort(height);

        for(int i = 0; i < 8; i++) {
            for(int j = i + 1; j < 9; j++) {
                if(sum - height[i] - height[j] == 100) {
                    for(int k = 0; k < 9; k++) {
                        if(k == i || k == j) continue;

                        bw.write(height[k] + "\n");
                    }
                }
            }
        }

        bw.close();
        br.close();
    }
}
