import java.io.*;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            int score = Integer.parseInt(br.readLine());

            if(score >= 90) {
                bw.write("A");
            } else if(80 <= score) {
                bw.write("B");
            } else if(70 <= score) {
                bw.write("C");
            } else if(60 <= score) {
                bw.write("D");
            } else {
                bw.write("F");
            }

            bw.flush();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
