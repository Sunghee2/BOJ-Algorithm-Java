import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int[][] test_map;
    static int max = 0;

    // dfs 부르는 것. 2를 dfs해서 바이러스 퍼뜨림.
    public static void spread_virus() {
        for(int i = 0; i < test_map.length; i++) {
            for(int j = 0; j < test_map[i].length; j++) {
                if(test_map[i][j] == 2) {
                    dfs(i, j);
                }
            }
        }
    }

    // dfs로 2를 상하좌우 이동
    public static void dfs(int i, int j) {
        test_map[i][j] = 2;

        if((i != test_map.length - 1) && (test_map[i + 1][j] == 0)) dfs(i + 1, j);
        if((i != 0) && (test_map[i - 1][j] == 0)) dfs(i - 1, j);
        if((j != 0) && (test_map[i][j - 1] == 0)) dfs(i, j - 1);
        if((j != test_map[i].length - 1) && (test_map[i][j + 1] == 0)) dfs(i, j + 1);
    }

    // 벽을 세움. 재귀함수로 0인 경우에 벽 세우고 2+벽숫자 넣어줌(나중에 지도 리셋할 때 벽 구분할 수 있도록)
    // 벽을 다 세운 경우(wall_num == 0) 바이러스 퍼뜨리고 0 세움.
    // 다시 리턴해서 돌아오면 지도 리셋 시킴
    public static void erect_walls(int wall_num) {
        if(wall_num == 0) {
            spread_virus();
            count_zero();
        } else {
            for (int i = 0; i < test_map.length; i++) {
                for (int j = 0; j < test_map[i].length; j++) {
                    if (test_map[i][j] == 0) {
                        test_map[i][j] = 2 + wall_num;
                        erect_walls(wall_num - 1);
                        copy_map(wall_num);
                    }
                }
            }
        }
    }

    // 지도에 있는 0을 카운트하고 max값과 비교
    public static void count_zero() {
        int count = 0;

        for(int i = 0; i < test_map.length; i++) {
            for(int j = 0; j < test_map[i].length; j++) {
                if(test_map[i][j] == 0) count++;
            }
        }

        if(count > max) max = count;
    }

    // 지도 리셋시키는 함수
    // wall_num에 따라 리셋시키는 게 다름
    public static void copy_map(int wall_num) {
        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map[i].length; j++) {
                if(wall_num == 1) {
                    if(test_map[i][j] == 3 || test_map[i][j] == 2) test_map[i][j] = map[i][j];
                } else if(wall_num == 2) {
                    if(test_map[i][j] == 4 ||test_map[i][j] == 3 || test_map[i][j] == 2) test_map[i][j] = map[i][j];
                } else {
                    test_map[i][j] = map[i][j];
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        test_map = new int[n][m];

        for(int i = 0; i < n; i++) {
            StringTokenizer input = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(input.nextToken());
            }
        }

        copy_map(3);
        erect_walls(3);

        bw.write(String.valueOf(max));

        bw.close();
        br.close();
    }
}

/**
 * 브루트 포스 - 그냥 모든 경우 다 하는 = 완전탐색
 * -> 벽 세우는 것 모든 경우 다 해보기
 * **/