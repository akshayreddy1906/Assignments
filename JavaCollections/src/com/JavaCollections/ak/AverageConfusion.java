package com.JavaCollections.ak;

import java.util.Scanner;

public class AverageConfusion {

	public static void main(String[] args) {
		int[] arr = new int[5];
		int sum =0;
		Scanner sc = new Scanner(System.in);
		for(int i=0;i<5;i++) {
			System.out.println("enter a number: ");
			int temp = sc.nextInt();
			if (temp<10) temp *=2;
			sum += temp;
			arr[i] = temp;
		}
		double avg = sum/5.0;
		System.out.println("Average: " + avg);
		sc.close();
	}

}
