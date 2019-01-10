import java.io.*;
import java.util.ArrayList;

public class Main {
    static ArrayList<Boolean> primeList;

    public static void get_prime(int n) {
        for (int i = 0; i <= n; i++) {
            primeList.add(true);
        }

        primeList.set(0, false);
        primeList.set(1, false);

        for (int i = 2; i <= n; i++) {
            if (primeList.get(i)) {
                for (int j = i * 2; j <= n; j += i) {
                    primeList.set(j, false);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int input = Integer.parseInt(br.readLine());
        while(input != 0) {
            int count = 0;
            primeList = new ArrayList<Boolean>((2 * input) + 1);
            get_prime(2 * input);
            for(int i = input + 1; i <= 2 * input; i++) {
                if(primeList.get(i)) count++;
            }

            bw.write(String.valueOf(count + "\n"));

            input = Integer.parseInt(br.readLine());
        }
        bw.close();
        br.close();
    }
}