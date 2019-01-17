import java.io.*;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            int x = Integer.parseInt(br.readLine());
            int y = Integer.parseInt(br.readLine());

            int three = x * (y % 100 % 10);
            int four = x * (y % 100 / 10);
            int five = x * (y / 100);
            int six = three + (four * 10) + (five * 100);

            bw.write(three + "\n" + four + "\n" + five + "\n" + six);
            bw.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
