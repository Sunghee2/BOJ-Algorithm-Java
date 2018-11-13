public class Main {
    static int[] arr_num = new int[10000];
    static int[] visited = new int[10000];

    public static void main(String[] args) {
        sequence(1);

        for(int j = 1; j < 10000; j++) {
            if(visited[j] == 0) sequence(j);
        }

        for(int i = 1; i < 10000; i++) {
            if(arr_num[i] == 0) System.out.println(i);
        }
    }

    public static void sequence(int num) {
        visited[num] = 1;

        int sum = num;
        while(num != 0) {
            sum += num % 10;
            num /= 10;
        }

        if(sum >= 10000 || arr_num[sum] == 1) return;

        arr_num[sum] = 1;
        sequence(sum);
    }
}
