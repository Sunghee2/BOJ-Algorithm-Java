/**
 * 수빈이는 동생과 숨바꼭질을 하고 있다. 수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고, 동생은 점 K(0 ≤ K ≤ 100,000)에 있다.
 * 수빈이는 걷거나 순간이동을 할 수 있다. 만약, 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다.
 * 순간이동을 하는 경우에는 1초 후에 2*X의 위치로 이동하게 된다.
 *
 * 수빈이와 동생의 위치가 주어졌을 때, 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 구하는 프로그램을 작성하시오.
 * **/

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] path;
    static boolean[] visited;
    static int n;
    static int k;

    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(start);
        visited[start] = true;

        while(!queue.isEmpty()) {
            int point = queue.poll();

            if(point == k) {
                if((!visited[k]) || path[k] > path[point] + 1) {
                    path[k] = path[point] + 1;
                    visited[point - 1] = true;
                }
                continue;
            }

            // -1로 이동
            if(0 < point) {
                if((!visited[point - 1]) || path[point - 1] > path[point] + 1) {
                    path[point - 1] = path[point] + 1;
                    queue.offer(point - 1);
                    visited[point - 1] = true;
                }
            }
            // + 1로 이동
            if(point < 100000) {
                if((!visited[point + 1]) || path[point + 1] > path[point] + 1) {
                    path[point + 1] = path[point] + 1;
                    queue.offer(point + 1);
                    visited[point + 1] = true;
                }
            }
            // * 2 로 이동
            if(point <= 50000) {
                if((!visited[2 * point]) || path[2 * point] > path[point] + 1) {
                    path[2 * point] = path[point] + 1;
                    queue.offer(2 * point);
                    visited[2 * point] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        path = new int[100001];
        visited = new boolean[100001];

        bfs(n);

        bw.write(String.valueOf(path[k]));

        bw.close();
        br.close();
    }
}

/**
 * dfs로 풀었는데 아무리 조건을 넣어봐도 50000 100000 넣어봤을 때 계속 스택오버플로우남 -> dfs로 풀 수 없는 문제였다...
 *
 * bfs로 막상 풀게 되면 쉬움..
 * 인덱스에 벗어나는지 확인하고 방문했는지 확인하면서 -1, +1, *2 로 이동함
 *
 * 나는 도착했을 때 이전 보다 더 작은 path인 경우를 넣었는데
 * 생각해보니 bfs에서 먼저 도착하면 그냥 그게 무조건 빠른 것이라 필요 없는 조건문이었다...(조심하기)
 * **/