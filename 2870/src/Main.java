import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    static ArrayList<BigInteger> numbers;

    public static ArrayList<BigInteger> mergeSort(ArrayList<BigInteger> list) {
        ArrayList<BigInteger> left = new ArrayList<BigInteger>();
        ArrayList<BigInteger> right = new ArrayList<BigInteger>();
        int mid;

        if(list.size() != 1) {
            mid = list.size() / 2;
            for(int i = 0; i < mid; i++) {
                left.add(list.get(i));
            }

            for(int i = mid; i < list.size(); i++) {
                right.add(list.get(i));
            }

            left = mergeSort(left);
            right = mergeSort(right);

            merge(left, right, list);
        } else {
            return list;
        }
        return list;
    }

    public static void merge(ArrayList<BigInteger> left, ArrayList<BigInteger> right, ArrayList<BigInteger> list) {
        int left_index = 0;
        int right_index = 0;
        int whole_index = 0;

        while(left_index < left.size() && right_index < right.size()) {
            if(left.get(left_index).compareTo(right.get(right_index)) < 0) {
                list.set(whole_index++, left.get(left_index++));
            } else {
                list.set(whole_index++, right.get(right_index++));
            }
        }

        ArrayList<BigInteger> rest;
        int rest_index;
        if(left_index >= left.size()) {
            rest = right;
            rest_index = right_index;
        } else {
            rest = left;
            rest_index = left_index;
        }

        for(int i = rest_index; i < rest.size(); i++) {
            list.set(whole_index++, rest.get(i));
        }
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Pattern p = Pattern.compile("[-?0-9]+");
        numbers = new ArrayList<BigInteger>();

        try {
            int n = Integer.parseInt(br.readLine());

            while(n-- > 0) {
                Matcher m = p.matcher(br.readLine());
                while(m.find()) {
                    numbers.add(new BigInteger(m.group()));
                }
            }

            mergeSort(numbers);

            for(BigInteger num : numbers) {
                bw.write(num + "\n");
            }

            bw.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

/**
 * ArrayList로 병합정렬
 *
 * 숫자 제한이 없기 때문에 int로는 풀지 못함 -> 1) string 2) biginteger
 * 이미 int로 구현했기 때문에 편하게 biginteger로 바꿨음..
 *
 * 혹시라도 음수값 들어올까봐 정규식에 -도 포함시켰는데 없는 것 같음..
 * **/