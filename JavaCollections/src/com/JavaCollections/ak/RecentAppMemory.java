package com.JavaCollections.ak;

import java.util.LinkedList;
import java.util.Scanner;

public class RecentAppMemory {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<String> recents = new LinkedList<>();
		Scanner sc = new Scanner(System.in);
		for(int i=0;i<5;i++) {
			System.out.println("enter a appName: ");
			String app = sc.nextLine();
			if(recents.contains(app)) {
				recents.remove(app);
				recents.addFirst(app);
			}else{recents.add(app);}
		}System.out.println(recents);
		sc.close();
	}
}
