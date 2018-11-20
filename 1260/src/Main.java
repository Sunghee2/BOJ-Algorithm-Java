import java.io.*;
import java.util.*;

public class Main {
    static public void bfs(Map<Integer, List<Integer>> graph, int start) {
        boolean[] visited = new boolean[graph.size() + 1];
        visited[start] = true;

        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(start);

        while(!queue.isEmpty()) {
            int u = queue.remove();
            System.out.print(u + " ");
            for(int v : graph.get(u)) {
                if(visited[v] == false) {
                    visited[v] = true;
                    queue.add(v);
                }
            }
        }
    }

    static public void dfs(Map<Integer, List<Integer>> graph, int start) {
        boolean[] visited = new boolean[graph.size() + 1];
        Set<Integer> keys = graph.keySet();
        int[] arr_key = new int[keys.size()];
        int index = 0;
        for(Integer element : keys) arr_key[index++] = element;
        Arrays.sort(arr_key);
        aDfs(graph, visited, start);
        for(int key : arr_key) {
            if(visited[key] == false) aDfs(graph, visited, key);
        }
    }

    static public void aDfs(Map<Integer, List<Integer>> graph, boolean[] visited, int v) {
        visited[v] = true;
        System.out.print(v + " ");
        for(int u : graph.get(v)) {
            if(visited[u] == false) aDfs(graph, visited, u);
        }
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken()); // 정점의 개수
            int m = Integer.parseInt(st.nextToken()); // 간선의 개수
            int v = Integer.parseInt(st.nextToken()); // 탐색을 시작할 정점 번호

            int[] arr_n = new int[n + 1];
            Map<Integer, List<Integer>> graph = new HashMap<>();

            for(int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int v1 = Integer.parseInt(st.nextToken());
                int v2 = Integer.parseInt(st.nextToken());

                if (!graph.containsKey(v1)) graph.put(v1, new ArrayList<Integer>());
                if (!graph.containsKey(v2)) graph.put(v2, new ArrayList<Integer>());

                graph.get(v1).add(v2);
                graph.get(v2).add(v1);


            }

            for(Map.Entry<Integer, List<Integer>> entry : graph.entrySet()) {
                List value_list = entry.getValue();
                Collections.sort(value_list);
            }


            dfs(graph, v);
            System.out.print("\n");
            bfs(graph, v);

            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

/**
 굳이 map 안쓰고 정점을 index로 인접정점을 list안에 넣었으면 더 쉽게 할 수 있었다
 **/