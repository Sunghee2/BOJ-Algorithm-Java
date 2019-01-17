import java.io.*;
        import java.util.Arrays;
        import java.util.StringTokenizer;

public class Main {
    public static int getLISLength(int[] arr) {
        int[] tail = new int[arr.length];
        tail[0] = arr[0];
        int length = 1;

        for(int i = 1; i < arr.length; i++) {
            if(arr[i] < tail[0]) { // 첫 수보다 작은 경우 맨 앞에 위치
                tail[0] = arr[i];
            } else if (arr[i] > tail[length - 1]) { // 가장 마지막 수보다 큰 경우 맨 끝에 위치
                tail[length] = arr[i];
                length++;
            } else { // 그 외 들어갈 곳 index 찾기. 0보다 크면 이미 존재. 작은 경우 -index-1하여 삽입
                int index = Arrays.binarySearch(tail, 0, length, arr[i]);
                index = index < 0 ? -index - 1 : index;
                tail[index] = arr[i];
            }
        }

        return length;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int input_num = Integer.parseInt(br.readLine());
        int[] nums = new int[input_num];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < input_num; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        bw.write(String.valueOf(getLISLength(nums)));
        bw.close();
        br.close();
    }
}

/**
 * LIS
 * **/