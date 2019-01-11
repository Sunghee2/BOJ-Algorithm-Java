import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static char[][] map;
    static int[][] final_distance;
    static int[] dx = { 1, -1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    public static int get_min() {
        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map[i].length; j++) {
                if(map[i][j] == 'L') bfs(i, j);
            }
        }

        int max = 0;
        for(int i = 0; i < final_distance.length; i++) {
            for(int j = 0; j < final_distance[0].length; j++) {
                if(final_distance[i][j] > max) max = final_distance[i][j];
            }
        }

        return max;
    }

    public static void bfs(int start_x, int start_y) {
        int[][] distance = new int[map.length][map[0].length];
        boolean[][] visited = new boolean[map.length][map[0].length];

        Queue<Point> queue = new LinkedList<Point>();
        queue.offer(new Point(start_x, start_y));
        visited[start_x][start_y] = true;

        while(!queue.isEmpty()) {
            Point point = queue.poll();

            for(int i = 0; i < 4; i++) {
                int next_x = point.x + dx[i];
                int next_y = point.y + dy[i];

                if((0 <= next_x) && (next_x < map.length) && (0 <= next_y) && (next_y < map[0].length) && (map[next_x][next_y] == 'L')) {
                    if((!visited[next_x][next_y]) || (distance[point.x][point.y] + 1 < distance[next_x][next_y])) {
                        distance[next_x][next_y] = distance[point.x][point.y] + 1;
                        queue.offer(new Point(next_x, next_y));
                        visited[next_x][next_y] = true;
                    }
                }
            }
        }

        // distance 모두 저장할 필요 없고 최장거리의 지점만 저장하면 됨.
        int max_dist = 0;
        int max_x = 0;
        int max_y = 0;
        for(int i = 0; i < distance.length; i++) {
            for(int j = 0; j < distance[0].length; j++) {
                if(distance[i][j] > max_dist) {
                    max_dist = distance[i][j];
                    max_x = i;
                    max_y = j;
                }
            }
        }
        copy_map(max_x, max_y, max_dist);
    }

    public static void copy_map(int x, int y, int distance) {
        if(final_distance[x][y] < distance) final_distance[x][y] = distance;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        final_distance = new int[n][m];

        for(int i = 0; i < n; i++) {
            String input = br.readLine();
            for(int j = 0; j < m; j++) {
                map[i][j] = input.charAt(j);
            }
        }

        bw.write(String.valueOf(get_min()));

        br.close();
        bw.close();
    }
}

class Point {
    public int x;
    public int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

/**
 * 보물 - 서로 간에 최단 거리로 이동하는데 있어 가장 긴 시간이 걸리는 육지 두 곳에 있음
 *
 * 맨 처음에 시작점 - 목표점 해서 for문 4개로 bfs 돌렸음. => 메모리 초과
 * 생각해보니깐 목표점은 필요없음 ㅠ 그냥 시작점으로 L있는 곳 모두 돌려서 비교하면 됨.
 *
 * 모든 점에 대해서 bfs 돌리고 최단거리를 구한 것 중에 최장거리를 저장해서
 * 가장 큰 값 출력하면 됨.
 * **/