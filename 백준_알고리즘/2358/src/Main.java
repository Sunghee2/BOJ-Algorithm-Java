import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int count = 0;

        try {
            int n = Integer.parseInt(br.readLine());
            Map<Integer, Integer> x = new HashMap<Integer, Integer>();
            Map<Integer, Integer> y = new HashMap<Integer, Integer>();

            for(int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int input_x = Integer.parseInt(st.nextToken());
                int input_y = Integer.parseInt(st.nextToken());

                if(x.containsKey(input_x)) {
                    x.put(input_x, x.get(input_x) + 1);
                } else {
                    x.put(input_x, 1);
                }

                if(y.containsKey(input_y)) {
                    y.put(input_y, y.get(input_y) + 1);
                } else {
                    y.put(input_y, 1);
                }
            }

            for(int key : x.keySet()) {
                if(x.get(key) > 1) count++;
            }

            for(int key : y.keySet()) {
                if(y.get(key) > 1) count++;
            }

            bw.write(String.valueOf(count));
            bw.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


/**
 * 주의할 점
 * 모든 점에 대해 직선을 만들어놓고 count하는 것임.
 * 좌표가 동일한 것은 직선 만들지 못함. -> 문제 데이터에서 좌표 동일한 경우는 없는 듯.... 처리 안해도 됨..
 *
 * 처음에는 이중배열만들어서 정렬한 뒤 x, y 같은 좌표인 것을 찾아서 count하였지만 시간초과
 * 그래서 map으로 입력받은 x,y 개수를 세어 2개 이상인 것을 count함..
 * (좌표 동일한 경우는 생각 안해도됨.. 원래는 중복처리까지 해줘야할 것 같은데..)
 *
 * ex)
 * 2
 * 1 3
 * 1 3
 * 입력받는 경우에 2가 나오는데도 성공.... 
 * **/