package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int test_case = sc.nextInt();

	    while(test_case-- > 0) {
	        int student_num = sc.nextInt();
	        int[] arr = new int[student_num];
	        int sum = 0;

	        for(int i = 0; i < student_num; i++) {
	            int score = sc.nextInt();
	            arr[i] = score;
	            sum += score;
            }

            double avg = sum / student_num;
	        int num = 0;

	        for(int score : arr) {
	            if (score > avg) num++;
            }

            System.out.println(String.format("%.3f", (num / (double) student_num) * 100) + "%");

        }
    }
}
