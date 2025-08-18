package com.JavaCollections.ak;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Last3Searches {
    public static void main(String[] args) {
        Deque<String> searches = new ArrayDeque<>();
        Scanner sc = new Scanner(System.in);
			while (true) {
			System.out.println("enter a search Keyword: ");
			String keyword = sc.nextLine();
			if (keyword.equals("exit")) break;
			if(searches.size()<3) searches.add(keyword);
			else {
				searches.removeFirst();
				searches.addLast(keyword);				
			}
			System.out.println(searches);
		}	
		System.out.println("Exited the search history program.");
		sc.close();
    }
}
