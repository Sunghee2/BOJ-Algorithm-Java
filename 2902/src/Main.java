import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        String[] names = str.split("-");

        for(String name : names) {
            bw.write(name.charAt(0));
        }

        bw.close();
        br.close();
    }
}
