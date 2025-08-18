package com.JavaCollections.ak;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class LimitedChatHistory {
    public static void main(String[] args) {
        Deque<String> history = new ArrayDeque<>();
        Scanner sc = new Scanner(System.in);
			while (true) {
			System.out.println("enter a message: ");
			String message = sc.nextLine();
			if (message.equalsIgnoreCase("exit")) break;
			if(history.size()<4) history.add(message);
			else {
				history.removeFirst();
				history.addLast(message);				
			}
			System.out.println(history);
		}	
		System.out.println("Exited the chat history program.");
		sc.close();
    }
}