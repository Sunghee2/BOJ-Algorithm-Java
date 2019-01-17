import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static int get_gcd(int x, int y) {
        if(y == 0) return x;

        return get_gcd(y, x % y);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int gcd = get_gcd(x, y);
        int lcm = (x * y) / gcd;

        bw.write(String.valueOf(gcd) + "\n" + String.valueOf(lcm));
        bw.close();
        br.close();
    }
}
