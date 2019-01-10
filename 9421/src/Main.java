import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Boolean> primeList;
    static HashMap<Integer, Boolean> sanggeunList;

    public static void get_prime(int n) {
        for(int i = 0; i <= n; i++) {
            primeList.add(true);
        }

        primeList.set(0, false);
        primeList.set(1, false);

        for(int i = 2; i <= n; i++) {
            if(primeList.get(i)) {
                for(int j = i * i; j <= n && 0 < j ; j += i) {
                    primeList.set(j, false);
                }

            }
        }
    }

    public static boolean get_sanggeunnum(int key) {
        if(key == 1) return true;
        if(sanggeunList.containsKey(key)) {
            return sanggeunList.get(key);
        }
        int sum = 0;
        int num = key;

        while(num != 0) {
            sum += Math.pow(num % 10, 2);
            num /= 10;
        }

        sanggeunList.put(key, false);

        boolean is_saggeunnum = get_sanggeunnum(sum);
        sanggeunList.put(key, is_saggeunnum);

        return is_saggeunnum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        primeList = new ArrayList<Boolean>(n + 1);
        sanggeunList = new HashMap<Integer, Boolean>();

        get_prime(n);

        for(int i = 0; i <= n; i++) {
            if(primeList.get(i)) {
                if(get_sanggeunnum(i)) {
                    bw.write(String.valueOf(i + "\n"));
                }
            }
        }

        bw.close();
        br.close();
    }
}


/**
 * 에라토스테네스의 체 공부!
 *
 * 런타임에러 -> 소수 구할 때 1000000 int 넘어가서 쓰레기값 나오게 됨 nullpointerror
 *
 * 소수상근수 제곱의 합은 계속 재귀로 구하면서 그 값을 map에 저장함
 * 만약 해당 값이 map에 있으면 리턴함(dp)
 *
 * 일단 처음 재귀 돌면서 false 돌아감 -> 배열에 저장된 false 만나면 false
 * ex ) 2 -> 4 -> 16 -> 37 -> 58 -> 89 -> 145 -> 42 -> 20 -> 4  : 이렇게 다시 돌아오면서 재귀함수 계속 돌기 때문에 false 설정해줌
 *
 * 만약 1이 되면 true를 리턴해서 이전에 false로 만들었던 것을 true로 다 고쳐줌
* **/