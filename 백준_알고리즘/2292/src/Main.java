import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        int rooms = 1;
        int multiply = 6;
        int result = 1;

        while(rooms < num) {
            rooms += multiply * result++;
        }

        bw.write(String.valueOf(result));
        bw.close();
        br.close();
    }
}
