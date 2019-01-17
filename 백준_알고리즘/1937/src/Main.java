import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[][] forest;
    static int[][] forestMax;

    static int getMax(int x, int y) {
        int max = 1;

        if ((x - 1 >= 0) && (forest[x - 1][y] > forest[x][y])) { // 상
            int k = (forestMax[x - 1][y] == 0)? getMax(x - 1, y) + 1 : forestMax[x - 1][y] + 1;
            if (k > max) max = k;
        }
        if ((x + 1 < forest.length) && (forest[x + 1][y] > forest[x][y])) { // 하
            int k = (forestMax[x + 1][y] == 0)? getMax(x + 1, y) + 1 : forestMax[x + 1][y] + 1;
            if (k > max) max = k;
        }
        if ((y - 1 >= 0) && (forest[x][y - 1] > forest[x][y])) { // 좌
            int k = (forestMax[x][y - 1] == 0)? getMax(x, y - 1) + 1 : forestMax[x][y - 1] + 1;
            if (k > max) max = k;
        }
        if ((y + 1 < forest.length) && (forest[x][y + 1] > forest[x][y])) { // 우
            int k = (forestMax[x][y + 1] == 0)? getMax(x, y + 1) + 1 : forestMax[x][y + 1] + 1;
            if (k > max) max = k;
        }

        forestMax[x][y] = max;
        return max;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int forest_size = Integer.parseInt(br.readLine());
        forest = new int[forest_size][forest_size];
        forestMax = new int[forest_size][forest_size];

        for(int i = 0; i < forest_size; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < forest_size; j++) {
                forest[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = 0;
        for(int i = 0; i < forest_size; i++) {
            for(int j = 0; j < forest_size; j++) {
                if(forestMax[i][j] == 0){
                    getMax(i, j);
                }

                max = (forestMax[i][j] > max)? forestMax[i][j] : max;
            }
        }

        bw.write(String.valueOf(max));
        bw.close();
        br.close();
    }
}

/**
 * 상, 하, 좌, 우 중 현재 값보다 크면 재귀함수 호출함
 *
 * 갈 수 있는 곳이 없으면 1(1일 살 수 있으므로)
 * 이동할 수 있으면 상, 하, 좌, 우 값 중 가장 큰 값 + 1
 *
 * 이 값을 forestMax에 메모이제이션 하여 재귀함수 호출을 줄임
 * **/