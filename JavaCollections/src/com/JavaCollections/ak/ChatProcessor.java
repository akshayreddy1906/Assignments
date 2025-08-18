package com.JavaCollections.ak;

import java.util.Scanner;
import java.util.concurrent.LinkedBlockingQueue;

public class ChatProcessor {

	public static void main(String[] args) {
		LinkedBlockingQueue<String> chat = new LinkedBlockingQueue<>(5);
		Scanner sc = new Scanner(System.in);
		while (chat.remainingCapacity()>0) {
		System.out.println("enter a msg: ");
		String msg = sc.nextLine();
		chat.add(msg);
		}sc.close();
		 System.out.println("Queue is full. Cant add new msgs.");
		for(String item:chat) {
			System.out.println(item);
		}
	}

}
