import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        int[] alphabet = new int[26];

        for(int i = 0; i < alphabet.length; i++) {
            alphabet[i] = -1;
        }

        for(int i = 0; i < str.length(); i++) {
            if(alphabet[(int)str.charAt(i) - (int)'a'] == -1) alphabet[(int)str.charAt(i) - (int)'a'] = i;
        }

        for(int i = 0; i < alphabet.length; i++) {
            bw.write(alphabet[i] + " ");
        }

        bw.close();
        br.close();
    }
}
