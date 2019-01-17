import java.io.*;

public class Main {
    static int[] edge;
    static int[] vertex;

    public static int DFS_cycle(int i) {
        if(vertex[i] == -1) return i; // 이미 지나온 길이면 리턴(cycle 발견)

        vertex[i] = -1;
        int start_vertex = DFS_cycle(edge[i]);
        if(start_vertex > 0) {
            vertex[i] = 1;
            if(start_vertex != i) {
                return start_vertex;
            } else {
                return 0;
            }
        } else {
            vertex[i] = -2;
            return 0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        edge = new int[n + 1];
        vertex = new int[n + 1];

        for(int i = 1; i <= n; i++) {
            edge[i] = Integer.parseInt(br.readLine());
        }

        // call DFS
        for(int i = 1; i <= n; i++) {
            if(vertex[i] == 0) DFS_cycle(i);
        }

        int num = 0;
        for(int i = 1; i <= n; i++) {
            if(vertex[i] == 1) num++;
        }

        bw.write(String.valueOf(num) + "\n");

        for(int i = 1; i <= n; i++) {
            if(vertex[i] == 1) bw.write(i + "\n");
        }

        br.close();
        bw.close();
    }
}

/**
 * dfs로 사이클이 만들어지는 것을 체크하는 문제
 *
 * vertex배열을 만들어서 같은 DFS를 도는 것은 -1(지나온 것을 체크하기 위해)을 넣고
 * DFS하다가 vertex배열이 -1이 나오면 사이클이므로 해당 index를 리턴함
 * 재귀함수가 돌아오면서 리턴되는 index가 나올때까지 vertex배열에 1을 넣음(1은 사이클이라는 표시)
 * index가 나오는 데도 재귀함수가 안끝나는 경우가 있음(중간에 사이클이 만들어지는 경우)
 * 그 때에는 vertex에 -2를 넣음(-2는 방문했다는 것을 체크하기 위해. DFS중복으로 도는 것 방지)
 *
 * 결과로 vertex배열이 1인 것만 세고
 * 출력하면 됨.
 * **/