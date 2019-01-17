import java.io.*;

public class Main {
    static int[] nums;

    public static void fib(int n) {
        nums = new int[n];
        nums[0] = 1;

        if(n > 1) {
            nums[1] = 1;
            for(int i = 2; i < n; i++) {
                nums[i] = nums[i - 1] + nums[i - 2];
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        fib(n - m + 1);

        int before_value = 0;
        int count = 1;
        while(m-- > 0) {
            int value = Integer.parseInt(br.readLine());
            int diff = value - before_value - 1;
            count *= nums[diff];
            before_value = value;
        }

        count *= nums[n - before_value];

        bw.write(String.valueOf(count));
        bw.close();
        br.close();
    }
}

/**
 * m이 0일 때,
 * n = 1 1가지
 * n = 2 2가지
 * n = 3 3가지
 * n = 4 5가지
 * n = 5 8가지
 *
 * 직접 해보니깐 피보나치 수열 이었음.
 * VIP석 사이의 석 개수를 피보나치 수열로 구한 뒤 각 값을 곱하면 됨.
 * **/