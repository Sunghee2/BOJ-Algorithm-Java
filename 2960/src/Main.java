import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int count = 0;

        ArrayList<Boolean> primeList = new ArrayList<Boolean>(n + 1);

        // 소수 판별을 위한 초기
        for(int i = 0; i <= n; i++) {
            primeList.add(true);
        }

        outerloop:
        for(int i = 2; i <= n; i++) {
            for(int j = i; j <= n; j += i) {
                if(primeList.get(j)) {
                    primeList.set(j, false);
                    count++;
                    if(count == k) {
                        bw.write(String.valueOf(j));
                        break outerloop;
                    }
                }
            }
        }

        bw.close();
        br.close();
    }
}


/**
 * 에라토스테네스의 체 공부!
 * https://ko.wikipedia.org/wiki/에라토스테네스의_체
 * **/