import java.io.*;
        import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int date = 0;
        int day = Integer.parseInt(st.nextToken());
        int night = Integer.parseInt(st.nextToken());
        int wood = Integer.parseInt(st.nextToken());

        date = (int)(Math.ceil((double)(wood - day) / (day - night)) + 1);

        bw.write(String.valueOf(date));
        br.close();
        bw.close();
    }
}

/**
 * 가장 마지막 날은 안미끄러지고 낮에 한번에 올라감(+1일)
 * 그리고 나머지(나무막대길이 - 낮에 올라가는 길이)는
 * (낮에 올라가는 길이 - 밤에 미끄러지는 길이)를 나눠서 날짜를 구함
 * **/