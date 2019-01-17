/**
 * 0과 1로만 이루어진 수를 이진수라 한다. 이러한 이진수 중 특별한 성질을 갖는 것들이 있는데, 이들을 이친수(pinary number)라 한다. 이친수는 다음의 성질을 만족한다.
 *
 * 이친수는 0으로 시작하지 않는다.
 * 이친수에서는 1이 두 번 연속으로 나타나지 않는다. 즉, 11을 부분 문자열로 갖지 않는다.
 * 예를 들면 1, 10, 100, 101, 1000, 1001 등이 이친수가 된다. 하지만 0010101이나 101101은 각각 1, 2번 규칙에 위배되므로 이친수가 아니다.
 *
 * N(1 ≤ N ≤ 90)이 주어졌을 때, N자리 이친수의 개수를 구하는 프로그램을 작성하시오.
 * **/

import java.io.*;
import java.math.BigInteger;

public class Main {
    static BigInteger[][] prinaryNum;

    public static void get_pinaryNum(int n) {
        prinaryNum[0][0] = BigInteger.ZERO;
        prinaryNum[0][1] = BigInteger.ONE;

        for(int i = 1; i < n; i++) {
            prinaryNum[i][0] = prinaryNum[i - 1][0].add(prinaryNum[i - 1][1]);
            prinaryNum[i][1] = prinaryNum[i - 1][0];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        prinaryNum = new BigInteger[n][2];

        get_pinaryNum(n);

        bw.write(String.valueOf(prinaryNum[n - 1][0].add(prinaryNum[n - 1][1])));

        bw.close();
        br.close();
    }
}

/**
 * 90까지 가면 int로는 부족 -> BigInteger 사용
 *
 * 이런 유형은 대체로 2차원 행렬을 만들어서 x는 길이수 y는 마지막 글자(여기서는 0 또는 1) 로 하는 것 같음.
 *
 * 0이 마지막 숫자이면 다음 숫자로는 0과 1 모두 가능하므로
 * 다음 길이의 y가 0, 1 에 모두 더해주고
 * 1이 마지막 숫자이면 다음 숫자로는 0 밖에 나오지 못하므로
 * 다음의 y가 0인 부분에만 자신의 숫자를 더해줌
 * **/