import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[][] graph;
    static int[] vertex;
    static int num = 0;

    public static void connectedComponentNum() {
        for(int i = 0; i < graph.length; i++) {
            for(int j = 0; j < graph.length; j++) {
                if(graph[i][j] == 1) DFS(i, j);
            }
        }
    }

    public static void DFS(int i, int j) {
        graph[i][j] = 0; // 중복 호출될까봐 한 번 호출 된 것은 0으로 바꿈

        if(vertex[i] == 0 && vertex[j] == 0) {
            vertex[i] = ++num;
            vertex[j] = num;
        } else if(vertex[i] == 0) {
            vertex[i] = vertex[j];
        } else if(vertex[j] == 0){
            vertex[j] = vertex[i];
        }

        for(int k = 0; k < graph.length; k++) {
            if(graph[j][k] == 1) {
                DFS(j, k);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        graph = new int[n + 1][n + 1];
        vertex = new int[n + 1];

        while(m-- > 0) {
            StringTokenizer edge = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(edge.nextToken());
            int y = Integer.parseInt(edge.nextToken());
            graph[x][y] = 1;
        }

        connectedComponentNum();

        for(int i = 1; i < vertex.length; i++) {
            if(vertex[i] == 0) num++;
        }

        bw.write(String.valueOf(num));
        bw.close();
        br.close();
    }
}


/**
 * 인접행렬과 DFS 사용
 *
 * DFS(i, j)가 호출되면 DFS(j, ~) j인 간선 찾고 없을 때까지 DFS
 * vertex배열은 정점 같은 그룹(연결요소)인지 확인하기 위해 만들었음.
 * num은 연결요소 개수임.
 *
 * DFS 호출될 때 (i, j)는 같은 연결요소이므로 vertex[i][j]에 같은 수가 들어가야됨
 *
 * 맨 마지막에 vertex배열에서 0인 것은 간선이 없는 정점(다 다른 연결요소)이므로 num에 해당 개수를 추가하고 출력함.
 * **/