import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int vacation = Integer.parseInt(br.readLine());
        int all_math = Integer.parseInt(br.readLine());
        int all_korean = Integer.parseInt(br.readLine());
        int max_math = Integer.parseInt(br.readLine());
        int max_korean = Integer.parseInt(br.readLine());

        int date = vacation - (int)Math.ceil(Math.max((double)all_math / max_math, (double)all_korean / max_korean));
        if(date < 0) {
            date = 0;
        }
        bw.write(String.valueOf(date));
        bw.close();
        br.close();
    }
}
