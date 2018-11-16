import java.io.*;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n + 1];

            if (n == 1) arr[1] = 0;
            else {
                for(int i = 2; i <= n; i++) {
                    int x = i;

                    if(i % 3 == 0 && i % 2 == 0) {
                        arr[i] = Math.min(Math.min(arr[i/3], arr[i/2]), arr[i - 1]) + 1;
                    } else if (i % 3 == 0) {
                        arr[i] = Math.min(arr[i/3], arr[i - 1]) + 1;
                    } else if (i % 2 == 0){
                        arr[i] = Math.min(arr[i/2], arr[i - 1]) + 1;
                    } else {
                        arr[i] = arr[i - 1] + 1;
                    }
                }
            }

            bw.write(String.valueOf(arr[n]));
            bw.flush();
            bw.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
