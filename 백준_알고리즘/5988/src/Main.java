import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        while(n-- > 0) {
            String input_num = br.readLine();
            switch (input_num.charAt(input_num.length() - 1)) {
                case '0': case '2': case '4': case '6': case '8':
                    bw.write("even\n");
                    break;
                case '1': case '3': case '5': case '7': case '9':
                    bw.write("odd\n");
                    break;
            }
        }

        bw.close();
        br.close();
    }
}

/**
 * 입력값이 최대 10^60이므로 string 상태에서 풀어야됨.
 * 마지막 숫자가 홀수인지 짝수인지 판단하여 출력.
 * **/