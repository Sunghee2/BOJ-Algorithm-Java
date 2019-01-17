import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] maze;
    static int[][] distance;
    static boolean[][] visited;

    // 상, 하, 좌, 우
    static int[] dx = { 1, -1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    public static void bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<Point>();
        queue.offer(new Point(x, y));
        distance[0][0] = 1;
        visited[0][0] = true;

        while(!queue.isEmpty()) {
            Point point = queue.poll();

            // for문 돌면서 큐에 다음 좌표 넣음
            for(int i = 0; i < 4; i++) {
                int next_x = point.x + dx[i];
                int next_y = point.y + dy[i];

                // 다음 좌표들이 범위 내에 있고 1인 곳(지나갈 수 있는 곳)
                if((0 <= next_x) && (next_x < maze.length) && (0 <= next_y) && (next_y < maze[0].length) && (maze[next_x][next_y] == 1)) {
                    if((!visited[next_x][next_y]) || (distance[point.x][point.y] + maze[next_x][next_y] < distance[next_x][next_y])) {
                        // 다음 좌표는 현재보다 + 1 이므로
                        distance[next_x][next_y] = distance[point.x][point.y] + 1;
                        // 방문했다 처리하고 큐에 넣음
                        queue.offer(new Point(next_x, next_y));
                        visited[next_x][next_y] = true;
                    }
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
        maze = new int[n][m];
        distance = new int[n][m];
        visited = new boolean[n][m];


        for(int i = 0; i < n ; i++) {
            String input = br.readLine();
            for(int j = 0; j < m; j++) {
                maze[i][j] = input.charAt(j) - '0';
            }
        }

        bfs(0, 0);

        bw.write(String.valueOf(distance[n - 1][m - 1]));

        bw.close();
        br.close();
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
 * 다른 bfs 문제 보다가 자꾸 dfs로 풀게 되고.. 너무 모르겠어서 기초부터 하자 해서 푼 문제..
 * 솔직히 이것도 모르겠어서 블로그 뒤적뒤적함ㅠ
 *
 * 큐는 배열을 이용하거나 연결리스트를 이용함. 배열은 크기를 동적으로 할 수 없기 때문에 대부분 연결 리스트 사용.
 * 큐는 보면 대체로 x, y 따로 2개씩 만들거나 아니면 x,y값이 있는 클래스를 만듦(후자가 좋은 것 같음).
 * offer로 입력 받고 poll로 리턴됨.
 * **/