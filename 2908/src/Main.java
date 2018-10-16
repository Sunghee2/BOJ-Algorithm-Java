package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();

        int max = Integer.max(reverse_num(num1), reverse_num(num2));

        System.out.println(max);
    }

    public static int reverse_num(int num) {
        int result = 0;

        for (int i = 2; i >= 0; i--) {
            result += (Integer.toString(num).charAt(i) - '0') * Math.pow(10, i);
        }

        return result;
    }
}
