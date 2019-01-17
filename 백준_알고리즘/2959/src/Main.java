import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void radixSort(int[] list) {
        final int RADIX = 10;

        List<Integer>[] bucket = new ArrayList[RADIX];

        // 0부터 9까지 bucket 만들기!
        for(int i = 0; i < bucket.length; i++) {
            bucket[i] = new ArrayList<Integer>();
        }

        boolean maxLength = false;
        int tmp;
        int placement = 1;

        while(!maxLength) {
            maxLength = true;

            // 해당하는 자릿수를 bucket에 넣기
            for(Integer num : list) {
                tmp = num / placement;
                bucket[tmp % RADIX].add(num);
                if(maxLength && tmp > 0) {
                    maxLength = false;
                }
            }

            // 정렬값 옮기기
            int index = 0;
            for(int i = 0; i < RADIX; i++) {
                for (Integer num : bucket[i]) {
                    list[index++] = num;
                }
                bucket[i].clear();
            }

            // 10씩 곱해서 다음 자릿수 확인
            placement *= RADIX;
        }
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] num = new int[4];

        try {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < 4; i++) {
                num[i] = Integer.parseInt(st.nextToken());
            }

            radixSort(num);

            bw.write(String.valueOf(num[0] * num[2]));
            bw.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

/**
 * 입력값이 1~99이기 때문에 드디어 기수정렬을 사용!!
 *
 * 가장 큰 직사각형을 만드는 방법은
 * 가장 큰 수 2개가 가로가 되고 나머지 수가 세로가 되는 것(역도 가능)
 *
 * --> 이렇게 되면 넓이는 (3번째로 큰 수 * 가장 작은 수) 가 됨
 * **/