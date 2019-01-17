import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        for(int i = 1; i <= n; i++) {
            if(i % 2 == 1) {
                for(int j = 0; j < n; j++) {
                    bw.write("* ");
                }
            } else {
                for(int j = 0; j < n; j++) {
                    bw.write(" *");
                }
            }
            bw.write("\n");
        }

        bw.close();
        br.close();
    }
}

/**
 * 짝수이면 앞에 공백 + n만큼 별 숫자 증가
 * **/