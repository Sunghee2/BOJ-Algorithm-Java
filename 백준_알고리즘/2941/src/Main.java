import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    static int count(String line, String alphabet) {
        Pattern p = Pattern.compile(alphabet);
        Matcher m = p.matcher(line);
        int count = 0;

        while(m.find()) count++;

        return count;
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] arr_alphabet = {
                "c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="
        };

        try {
            String line = br.readLine();
            int num = line.length();

            for(String alphabet : arr_alphabet) {
                num = line.contains(alphabet)? num - (count(line, alphabet)) : num;
            }

            bw.write(String.valueOf(num));
            bw.flush();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
