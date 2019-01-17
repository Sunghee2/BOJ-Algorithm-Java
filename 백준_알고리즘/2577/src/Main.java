import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());

        int[] number = new int[10];

        int multiply = a * b * c;

        while(multiply > 0) {
            number[multiply % 10]++;
            multiply /= 10;
        }

        for(int i = 0; i < 10; i++) {
            bw.write(String.valueOf(number[i] + "\n"));
        }

        bw.close();
        br.close();
    }
}
