import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    static int[][] nums;

    public static int Q(int start, int end, int selection) {
        int count = 0;
        int result = 0;

        for(int[] n : nums) {
            if(start <= n[1] && n[1] <= end) {
                count++;
            }

            if(count == selection) {
                result = n[0];
                break;
            }
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int arr_size = Integer.parseInt(st.nextToken());
        int call_num = Integer.parseInt(st.nextToken());

        nums = new int[arr_size][2];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i = 0; i < arr_size; i++) {
            nums[i][0] = Integer.parseInt(st2.nextToken());
            nums[i][1] = i + 1;
        }

        Arrays.sort(nums, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });

        while(call_num-- > 0) {
            StringTokenizer st3 = new StringTokenizer(br.readLine());
            bw.write(Q(
                    Integer.parseInt(st3.nextToken()),
                    Integer.parseInt(st3.nextToken()),
                    Integer.parseInt(st3.nextToken())
            ) + "\n");
        }

        br.close();
        bw.close();
    }
}

/**
 * 원래는 세그먼트 트리로 푸는 문제지만...
 *
 * 입력할 때 숫자 값과 인덱스 값을 함께 저장함
 * 그리고 숫자 값 기준으로 정렬
 * Q함수에서 찾는 인덱스 안에 들어가면 count세어서 찾는 인덱스 만큼 count값이 되면 숫자값 리턴
 * **/