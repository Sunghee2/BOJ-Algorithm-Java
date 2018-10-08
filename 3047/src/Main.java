import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    /* ABC 순서에 맞게 출력 */
    public static void printArray(int[] arr_num, String alphabet) {
        int[] sorted_arr = insertionSort(arr_num);

        for(int i = 0; i < 3; i++) {
            int order = StringToOrder(alphabet.charAt(i));
            System.out.print(sorted_arr[order] + " ");
        }
    }

    /* 입력받은 숫자를 정렬 */
    public static int[] insertionSort(int[] arr_num) {
        for(int i = 1; i < arr_num.length; i++) {
            int loc = i - 1;
            int newItem = arr_num[i];

            while(loc >= 0 && newItem < arr_num[loc]) {
                arr_num[loc + 1] = arr_num[loc];
                loc--;
            }
            arr_num[loc + 1] = newItem;
        }

        return arr_num;
    }

    /* 입력받은 ABC를 순서로 변경 */
    public static int StringToOrder(char alphabet) {
        int order = 0;

        switch (alphabet) {
            case 'A':
                order = 0;
                break;
            case 'B':
                order = 1;
                break;
            case 'C':
                order = 2;
                break;
        }

        return order;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        int[] arr_num = new int[3];
        String alphabet;

        String[] arr_temp = br.readLine().split(" ");
        for(int i = 0; i < 3; i++) {
            arr_num[i] = Integer.parseInt(arr_temp[i]);
        }

        alphabet = br.readLine();

        printArray(arr_num, alphabet);
    }
}
