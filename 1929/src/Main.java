import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        ArrayList<Boolean> primeList = new ArrayList<Boolean>(n + 1);

        for(int i = 0; i <= n; i++) {
            primeList.add(true);
        }

        // 0과 1은 소수 아님
        primeList.add(0, false);
        primeList.add(1, false);

        for(int i = 2; (i * i) <= n; i++) {
            if(primeList.get(i)) {
                for(int j = i * i; j <= n; j += i) {
                    primeList.set(j, false);
                }
            }
        }

        for(int i = m; i <= n; i++) {
            if(primeList.get(i) == true) bw.write(String.valueOf(i) + "\n");
        }

        bw.close();
        br.close();
    }
}


/**
 * 에라토스테네스의 체 공부!
 * https://ko.wikipedia.org/wiki/에라토스테네스의_체
 *
 * 중복(5*3, 5*2 -> 이미 2, 3일때 처리했음)이 없기 위해 5*5(제곱한 수)부터 삭제함
 * **/