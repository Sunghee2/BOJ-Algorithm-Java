import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = 0;
        int n = Integer.parseInt(br.readLine());

        outerloop:
        for(int i = 1; i <= n; i++) {
            if(i < 100) {
                count++;
            } else {
                int d = 0;
                for(int j = 0; j < (int)(Math.log10(i) + 1) - 1; j++) {
                    if(j != 0 && d != String.valueOf(i).charAt(j) - String.valueOf(i).charAt(j + 1)) {
                        continue outerloop;
                    }
                    d = String.valueOf(i).charAt(j) - String.valueOf(i).charAt(j + 1);
                }
                count++;
            }
        }

        bw.write(String.valueOf(count));

        bw.close();
        br.close();
    }
}

/**
 * 100 미만은 모두 가능
 *
 * 100 이상부터 각 자리 수 공차 구해서 비교해보기
 * **/