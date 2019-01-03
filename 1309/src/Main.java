import java.io.*;

public class Main {
    static int[][] cage;

    static int countCases() {
        // 0번째 1로 초기화
        cage[0][0] = 1;
        cage[0][1] = 1;
        cage[0][2] = 1;

        for(int row = 0; row < cage.length - 1; row++) {
            cage[row + 1][0] += cage[row][0];
            cage[row + 1][1] += cage[row][0];
            cage[row + 1][2] += cage[row][0];

            cage[row + 1][0] += cage[row][1];
            cage[row + 1][2] += cage[row][1];

            cage[row + 1][0] += cage[row][2];
            cage[row + 1][1] += cage[row][2];

            cage[row + 1][0] %= 9901;
            cage[row + 1][1] %= 9901;
            cage[row + 1][2] %= 9901;
        }

        return cage[cage.length - 1][0] + cage[cage.length - 1][1] + cage[cage.length - 1][2];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        cage = new int[n][3];

        int result = countCases() % 9901;

        bw.write(String.valueOf(result));

        bw.close();
        br.close();
    }
}

/**
 * 처음에는 탑다운 재귀(메모이제이션)으로 하였는데 스택오버플로우에러가 났음..(94000줄쯤에서)
 * -> 재귀 쓰지 말고
 *
 * 0 - 한 마리도 배치하지 않는 경우 -> 다음 행에서는 0, 1, 2 가능
 * 1 - 왼쪽에 배치 -> 다음 행에서는 0, 2 가능
 * 2 - 오른쪽에 배치 -> 다음 행에서는 0, 1 가능
 *
 * int 오버플로우 나서 Biginteger썼는데 메모리초과됨
 * -> 다시 int array로 변경하고
 * 마지막에 mod하는게 아니라 중간마다 mod하여 해결.
 * **/