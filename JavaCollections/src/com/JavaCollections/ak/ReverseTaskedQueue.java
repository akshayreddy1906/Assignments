package com.JavaCollections.ak;

import java.util.LinkedList;
import java.util.Scanner;

public class ReverseTaskedQueue {

	public static void main(String[] args) {
		LinkedList<String> tasks = new LinkedList<>();
		Scanner sc = new Scanner(System.in);
		for(int i=0;i<4;i++) {
			System.out.println("enter a task: ");
			String task = sc.nextLine();
			if(task.endsWith("!")) tasks.add(0,task);
			else {tasks.add(task);}
		}
		for(int i=3;i>=0;i--) {
			System.out.println(tasks.get(i));
		}
		sc.close();
	}

}
