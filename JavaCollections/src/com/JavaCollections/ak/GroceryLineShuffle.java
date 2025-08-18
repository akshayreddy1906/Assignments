package com.JavaCollections.ak;

import java.util.ArrayDeque;
import java.util.Scanner;

public class GroceryLineShuffle {
	 public static void main(String[] args) {
		ArrayDeque<String> line = new ArrayDeque<>();
		Scanner sc = new Scanner(System.in);
		System.out.print("type 'END' to end queue  ");
		while (true) {
			
            System.out.print("Add your name: ");
            String name = sc.nextLine();

            if (name.equalsIgnoreCase("END")) {
                break;
            }

            if (name.length() % 2 == 0) {
                line.addFirst(name);
            } else {
                line.addLast(name);
            }
		}sc.close();
		System.out.print("present queue is: ");
		for (String human:line) {
			System.out.println(human);
		}
	 }
}
