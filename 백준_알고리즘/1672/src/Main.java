import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int length = Integer.parseInt(br.readLine());
        String str = br.readLine();

        char[] index = {'A', 'C', 'G', 'T'};
        char[][] matrix = {
                {'A', 'A', 'C', 'G'},
                {'A', 'C', 'T', 'G'},
                {'C', 'T', 'G', 'A'},
                {'G', 'G', 'A', 'T'}
        };

        char result = 0;

        for(int i = length - 2; i >= 0; i--) {
            result = result == 0?
                    matrix[Arrays.binarySearch(index, str.charAt(i + 1))][Arrays.binarySearch(index, str.charAt(i))]
                    :
                    matrix[Arrays.binarySearch(index, str.charAt(i))][Arrays.binarySearch(index, result)];
        }

        bw.write(result);
        bw.close();
        br.close();
    }
}
