import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        String n = st.nextToken();
        int m = Integer.parseInt(st.nextToken());

        String result = "";
        for(int i = 0; i < Integer.parseInt(n); i++) {
            result += n;
        }

        if(result.length() > m) result = result.substring(0, m);

        bw.write(result);

        bw.close();
        br.close();
    }
}