import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Boolean> primeList;

    public static void getPrime() {
        for(int i = 0; i <= 1000; i++) {
            primeList.add(true);
        }

        primeList.set(0, false);
        primeList.set(1, false);

        for(int i = 2; (i * i) <= 1000; i++) {
            if(primeList.get(i)) {
                for(int j = (i * i); j <= 1000; j += i) {
                    primeList.set(j, false);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testcase = Integer.parseInt(br.readLine());
        int[] num = new int[testcase];
        primeList = new ArrayList<Boolean>(1001);

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < testcase; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        getPrime();

        int count = 0;
        for(int i = 0; i < num.length; i++) {
            if(primeList.get(num[i])) count++;
        }

        bw.write(String.valueOf(count));

        bw.close();
        br.close();
    }
}

/**
 * 에라토스테네스의 체로 1000까지 구한 뒤
 * 입력 값을 index로 소수인지 찾기
 * **/