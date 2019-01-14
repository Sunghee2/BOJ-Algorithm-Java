import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] students = new int[31];
        int input_num = 28;

        while(input_num-- > 0) {
            students[Integer.parseInt(br.readLine())] = 1;
        }

        for(int i = 1; i < students.length; i++) {
            if(students[i] == 0) bw.write(i + "\n");
        }

        bw.close();
        br.close();
    }
}

/**
 * 배열 만들어서 과제 제출한 index 는 1로 변경 후
 * 0인 index 찾아서 출력
 * **/