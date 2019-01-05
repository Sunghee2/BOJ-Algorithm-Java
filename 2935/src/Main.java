import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long count0_x = br.readLine().chars().filter(ch -> ch == '0').count();
        String operator = br.readLine();
        long count0_y = br.readLine().chars().filter(ch -> ch == '0').count();

        switch (operator) {
            case "*":
                bw.write("1");
                for(int i = 0; i < count0_x + count0_y; i++) {
                    bw.write("0");
                }
                break;
            case "+":
                if(count0_x == count0_y) {
                    bw.write("2");
                    for(int i = 0; i < count0_x; i++) {
                        bw.write("0");
                    }
                } else if(count0_x > count0_y) {
                    bw.write("1");
                    for(int i = 0; i < count0_x - count0_y - 1; i++) {
                        bw.write("0");
                    }

                    bw.write("1");
                    for(int i = 0; i < count0_y; i++) {
                        bw.write("0");
                    }
                } else {
                    bw.write("1");
                    for(int i = 0; i < count0_y - count0_x - 1; i++) {
                        bw.write("0");
                    }

                    bw.write("1");
                    for(int i = 0; i < count0_x; i++) {
                        bw.write("0");
                    }
                }
                break;
        }

        bw.close();
        br.close();
    }
}

/**
 * 길이가 100 까지 나오므로
 * 입력받을 때 0의 개수를 세어서
 *
 * 곱셈 -> 0의 개수를 더해서 출력
 * 덧셈 -> 큰 길이 - 작은길이 - 1 만큼 0 먼저 출력 -> 1 출력 -> 작은 길이 만큼 0 출력
 * **/