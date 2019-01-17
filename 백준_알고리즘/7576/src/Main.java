/**
 * 철수의 토마토 농장에서는 토마토를 보관하는 큰 창고를 가지고 있다. 토마토는 아래의 그림과 같이 격자 모양 상자의 칸에 하나씩 넣어서 창고에 보관한다.
 * 창고에 보관되는 토마토들 중에는 잘 익은 것도 있지만, 아직 익지 않은 토마토들도 있을 수 있다. 보관 후 하루가 지나면, 익은 토마토들의 인접한 곳에 있는 익지 않은 토마토들은 익은 토마토의 영향을 받아 익게 된다.
 * 하나의 토마토의 인접한 곳은 왼쪽, 오른쪽, 앞, 뒤 네 방향에 있는 토마토를 의미한다. 대각선 방향에 있는 토마토들에게는 영향을 주지 못하며, 토마토가 혼자 저절로 익는 경우는 없다고 가정한다.
 * 철수는 창고에 보관된 토마토들이 며칠이 지나면 다 익게 되는지, 그 최소 일수를 알고 싶어 한다.
 *
 * 토마토를 창고에 보관하는 격자모양의 상자들의 크기와 익은 토마토들과 익지 않은 토마토들의 정보가 주어졌을 때, 며칠이 지나면 토마토들이 모두 익는지, 그 최소 일수를 구하는 프로그램을 작성하라.
 * 단, 상자의 일부 칸에는 토마토가 들어있지 않을 수도 있다.
 * **/

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] box;
    static int[] dx = { 1, -1, 0, 0 };
    static int[] dy = { 0, 0, 1, -1 };

    public static void bfs() {
        Queue<Point> queue = new LinkedList<Point>();

        // 1인 좌표 모두 큐에 넣기
        for(int i = 0; i < box.length; i++) {
            for(int j = 0; j < box[0].length; j++) {
                if(box[i][j] == 1) queue.offer(new Point(i, j));
            }
        }

        while(!queue.isEmpty()) {
            Point point = queue.poll();

            for(int i = 0; i < 4; i++) {
                int next_x = point.x + dx[i];
                int next_y = point.y + dy[i];

                if(0 <= next_x && next_x < box.length && 0 <= next_y && next_y < box[0].length && box[next_x][next_y] == 0) {
                    queue.offer(new Point(next_x, next_y));
                    box[next_x][next_y] = box[point.x][point.y] + 1;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        box = new int[n][m];
        for(int i = 0; i < n; i++) {
            StringTokenizer st_box = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                box[i][j] = Integer.parseInt(st_box.nextToken());
            }
        }

        bfs();

        int max = 0;
        outerloop:
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(box[i][j] > max) max = box[i][j];
                if(box[i][j] == 0) {
                    max = 0;
                    break outerloop;
                }
            }
        }

        bw.write(String.valueOf(max - 1));

        bw.close();
        br.close();
    }
}

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

/**
 * bfs문제
 *
 * 맨 처음에 1인 토마토를 다 큐에 넣고
 * 빼면서 상하좌우 좌표에 +1을 넣어줌.
 *
 * 나중에 배열의 max 값 출력하거나
 * 만약 0이 나오면(익지 않은 토마토) -1
 * **/