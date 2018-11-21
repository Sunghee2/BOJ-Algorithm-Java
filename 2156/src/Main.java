import java.io.*;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] num;
        int[] incld; // 자기자신이 포함
        int[] excld; // 자기자신 포함x

        try {
            int n = Integer.parseInt(br.readLine());
            num = new int[n];
            incld = new int[n];
            excld = new int[n];

            for(int i = 0; i < n; i++) {
                num[i] = Integer.parseInt(br.readLine());
            }

            incld[0] = num[0];

            for(int i = 1; i < n; i++) {
                if(i == 1) {
                    incld[1] = incld[0] + num[1];
                } else {
                    incld[i] = Math.max(excld[i - 2] + num[i - 1], excld[i - 1]) + num[i];
                }
                excld[i] = Math.max(incld[i - 1], excld[i - 1]);
            }

            bw.write(String.valueOf(Math.max(incld[n - 1], excld[n - 1])));
            bw.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

/**
 * 1. 내(i)가 포함되어 있을 경우
 *  1) i-2 포함x + i-1 포함
 *  2) i-1 포함x
 * 2. 내(i)가 포함x 경우
 *  1) i-1 포함
 *  2) i-1 포함x
 * **/
