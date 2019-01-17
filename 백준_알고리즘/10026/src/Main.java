import java.io.*;

public class Main {
    static char[][] grid;
    static int[][] dp;
    static int[][] dp_daltonism;

    // 적록색약 아닌 사람
    public static void get_num(int i, int j, int num) {
        dp[i][j] = num;

        if((i != 0) && (grid[i - 1][j] == grid[i][j]) && (dp[i - 1][j] == 0)) get_num(i - 1, j, num);
        if((i != dp.length - 1) && (grid[i + 1][j] == grid[i][j]) && (dp[i + 1][j] == 0)) get_num(i + 1, j, num);
        if((j != 0) && (grid[i][j - 1] == grid[i][j]) && (dp[i][j - 1] == 0)) get_num(i, j - 1, num);
        if((j != dp.length - 1) && (grid[i][j + 1] == grid[i][j]) && (dp[i][j + 1] == 0)) get_num(i, j + 1, num);
    }

    // 적록색약인 사람
    public static void get_num_daltonism(int i, int j, int num) {
        dp_daltonism[i][j] = num;

        if((i != 0) && (dp_daltonism[i - 1][j] == 0)) {
            if(grid[i][j] == 'R' || grid[i][j] == 'G') {
                if(grid[i - 1][j] == 'R' || grid[i - 1][j] == 'G') get_num_daltonism(i - 1, j, num);
            } else if(grid[i - 1][j] == grid[i][j]) {
                get_num_daltonism(i - 1, j, num);
            }
        }

        if((i != dp_daltonism.length - 1) && (dp_daltonism[i + 1][j] == 0)) {
            if(grid[i][j] == 'R' || grid[i][j] == 'G') {
                if(grid[i + 1][j] == 'R' || grid[i + 1][j] == 'G') get_num_daltonism(i + 1, j, num);
            } else if(grid[i + 1][j] == grid[i][j]) {
                get_num_daltonism(i + 1, j, num);
            }
        }

        if((j != 0) && (dp_daltonism[i][j - 1] == 0)) {
            if(grid[i][j] == 'R' || grid[i][j] == 'G') {
                if(grid[i][j - 1] == 'R' || grid[i][j - 1] == 'G') get_num_daltonism(i, j - 1, num);
            } else if(grid[i][j - 1] == grid[i][j]) {
                get_num_daltonism(i, j - 1, num);
            }
        }

        if((j != dp_daltonism.length - 1) && (dp_daltonism[i][j + 1] == 0)) {
            if(grid[i][j] == 'R' || grid[i][j] == 'G') {
                if(grid[i][j + 1] == 'R' || grid[i][j + 1] == 'G') get_num_daltonism(i, j + 1, num);
            } else if(grid[i][j + 1] == grid[i][j]) {
                get_num_daltonism(i, j + 1, num);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        grid = new char[n][n];
        dp = new int[n][n];
        dp_daltonism = new int[n][n];

        for(int i = 0; i < n; i++) {
            String input_str = br.readLine();
            for(int j = 0; j < n; j++) {
                grid[i][j] = input_str.charAt(j);
            }
        }

        int num = 1;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(dp[i][j] == 0) get_num(i, j, num++);
            }
        }

        int num_daltonism = 1;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(dp_daltonism[i][j] == 0) get_num_daltonism(i, j, num_daltonism++);
            }
        }

        bw.write((num - 1) + " " + (num_daltonism - 1));

        bw.close();
        br.close();
    }
}


/**
 * 상하좌우 중 똑같은 것 재귀로 이동해서 구역숫자 dp 또는 dp_daltonism에 저장
 *
 * 적록색약인 경우는 R, G 체크함
 * **/