import java.io.*;

public class Main {
    static int[] zero_num = new int[41];
    static int[] one_num = new int[41];

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        zero_num[0] = 1;
        zero_num[1] = 0;
        one_num[0] = 0;
        one_num[1] = 1;

        get_arr();

        try {
            int testcase = Integer.parseInt(br.readLine());
            while(testcase-- > 0 ) {
                int n = Integer.parseInt(br.readLine());
                bw.write(zero_num[n] + " " + one_num[n] + "\n");
            }

            bw.flush();
            bw.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static public void get_arr() {
        for(int i = 2; i < 41; i++) {
            zero_num[i] = zero_num[i - 1] + zero_num[i - 2];
            one_num[i] = one_num[i - 1] + one_num[i - 2];
        }
    }
}
