import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        int d = Integer.parseInt(br.readLine());
        int e = Integer.parseInt(br.readLine());

        a = a >= 40? a : 40;
        b = b >= 40? b : 40;
        c = c >= 40? c : 40;
        d = d >= 40? d : 40;
        e = e >= 40? e : 40;

        bw.write(String.valueOf((a + b + c + d + e) / 5));

        bw.close();
        br.close();
    }
}
