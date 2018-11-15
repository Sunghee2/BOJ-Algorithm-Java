import java.io.*;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] num_arr;
        int[] incld;
        int[] excld;

        try {
            int num = Integer.parseInt(br.readLine());

            num_arr = new int[num];
            incld = new int[num]; // i가 포함되어 있는 최댓값
            excld = new int[num]; // i가 포함되어 있지 않는 최댓값


            for(int i = 0; i < num; i++) {
                num_arr[i] = Integer.parseInt(br.readLine());
            }

            incld[0] = num_arr[0];

            for(int i = 1; i < num; i++) {
                if(i == 1) {
                    incld[1] = num_arr[0] + num_arr[1];
                } else {
                    incld[i] = Math.max(excld[i - 2] + num_arr[i - 1], excld[i - 1]) + num_arr[i];
                }
                excld[i] = incld[i - 1];
            }

            bw.write(String.valueOf(incld[num - 1]));
            bw.flush();
            bw.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

/**
 i가 포함되어있을 때의 최고값은
    포함 : i - 1 (근데 이게 i-2를 포함하지 않는 max 값이어야됨) => i-2가 포함되어있지않고 + i-1값
    포함x : i - 1
 의 max값 + i

 i가 포함되어있지 않을 때의 최고값은
    포함 : i - 1,  (i-1이 포함되어있지 않는 경우는 2계단을 건너뛰는 것이므로 불가능)


 '마지막 계단은 반드시 밟아야된다'를 못보고 계속 마지막도 max값을 구해 출력했음
 **/

