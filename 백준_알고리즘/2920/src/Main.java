import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] num = new int[8];
        for(int i = 0; i < 8; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        boolean isSorted = true;
        for(int i = 0; i < 7; i++) {
            if(Math.abs(num[i] - num[i + 1]) != 1) {
                isSorted = false;
                break;
            }
        }

        if(isSorted) {
            if(num[0] == 1) {
                bw.write("ascending");
            } else {
                bw.write("descending");
            }
        } else {
            bw.write("mixed");
        }

        bw.close();
        br.close();
    }
}

/**
 * 배열에 넣고 앞 뒤 절댓값이 1인지 아닌지 판별
 * 1이면 맨 앞이 1인지 8인지 구별함
 * **/