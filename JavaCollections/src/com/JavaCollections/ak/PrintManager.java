package com.JavaCollections.ak;

import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;

public class PrintManager {
	 public static void main(String[] args) {
		ArrayBlockingQueue<String> printList = new ArrayBlockingQueue<>(3);
		Scanner sc = new Scanner(System.in);
		while (printList.remainingCapacity()>0) {
		System.out.println("enter a job: ");
		String job = sc.nextLine();
		printList.add(job);
		}sc.close();
		 System.out.println("Queue is full. Cant add new jobs.");
		for(String item:printList) {
			System.out.println(item);
		}
	}
}
