import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        while(n-- > 0) {
            String str = br.readLine();
            int count = 0;
            String[] arr = str.split("X");

            for(String string : arr) {
                for(int i = 1; i <= string.length(); i++) {
                    count += i;
                }
            }

            bw.write(String.valueOf(count) + "\n");
        }


        bw.close();
        br.close();
    }
}

/**
 * X 기준으로 나눠서
 * O의 길이만큼 중복으로 더해줌
 * **/