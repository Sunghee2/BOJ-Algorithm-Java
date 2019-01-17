import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Boolean> primeList;
    static boolean[] visited;

    public static void get_prime(int n) {
        for (int i = 0; i <= n; i++) {
            primeList.add(true);
        }

        primeList.set(0, false);
        primeList.set(1, false);

        for (int i = 2; i <= n; i++) {
            if (primeList.get(i)) {
                for (int j = i * 2; j <= n; j += i) {
                    primeList.set(j, false);
                }
            }
        }
    }

    public static String bfs(int start_num, int end_num) {
        if(start_num == end_num) return "0";

        Queue<Prime> queue = new LinkedList<Prime>();
        queue.offer(new Prime(start_num, 0));
        int min = Integer.MAX_VALUE;

        while(!queue.isEmpty()) {
            Prime prime = queue.poll();

            int digit = prime.number;
            int multiply = 1;
            for(int n = 0; n <= 3; n++) {
                int test_num = prime.number - ((digit % 10) * multiply);
                for(int i = 0; i <= 9; i++) {
                    // 1000대에 있는 숫자를 바꿀 때 천의 자리 수가 0이 되면 안됨.
                    // 그리고 이전 숫자와 같은 숫자를 중복체크 하지 않도록 체크.
                    if(((n == 3) && (i == 0)) || (i == (digit % 10))) continue;

                    if((primeList.get(test_num + (i * multiply))) && (!visited[test_num + (i * multiply)])) {
                        queue.offer(new Prime(test_num + (i * multiply), prime.dist + 1));
                        visited[test_num + (i * multiply)] = true;
                    }

                    // 원하는 숫자를 만났을 때 min보다 작으면 저장
                    if(test_num + (i * multiply) == end_num) min = min > prime.dist + 1? prime.dist + 1 : min;
                }
                digit /= 10;
                multiply *= 10;
            }
        }

        if(min == Integer.MAX_VALUE) {
            return "Impossible";
        } else {
            return String.valueOf(min);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testcase = Integer.parseInt(br.readLine());
        primeList = new ArrayList<Boolean>(10000);
        get_prime(10000);

        while(testcase-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            visited = new boolean[10000];

            bw.write(bfs(n, m) + "\n");
        }
        bw.close();
        br.close();
    }
}

class Prime {
    public int number;
    public int dist;
    public boolean visited;

    public Prime(int number, int dist) {
        this.number = number;
        this.dist = dist;
        this.visited = true;
    }
}

/**
 *
 * 맨 처음에 숫자 하나만 냅두고 다 바꿔야되는 것인줄 알고 한참 삽질함..
 * 문제 제대로 읽지 않는 건 정말.. 여전한 듯...
 *
 * 먼저 10000까지 에라토스테네스의 체를 이용하여 소수를 구함(true, false)
 * 입력을 받고 자릿수 바꿔가며 bfs
 * visited 방문했는지 체크를 안하면 무한루프를 돌게됨. 방문한 곳은 다시 방문하지 않도록 체크함
 * **/