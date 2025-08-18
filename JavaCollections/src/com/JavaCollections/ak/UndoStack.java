package com.JavaCollections.ak;


import java.util.Scanner;
import java.util.Stack;

public class UndoStack {
	public static void main(String[] args) {
        Stack<String> st = new Stack<>();
        Scanner sc = new Scanner(System.in);
        String undo = "";
        for(int i=0;i<3;i++) {
			System.out.println("enter a command: ");
			String command = sc.nextLine();
			st.push(command);
        } while(true) {
	        System.out.println("Type 'undo' or 'redo' last command:");
	        String command = sc.nextLine();
	        if (command.equalsIgnoreCase("undo")) {
	            undo = st.pop();
	            System.out.println("Undone command: " + undo);
	        }
	        if(command.equalsIgnoreCase("redo")) {
	        	if(!undo.isEmpty()) {
	              st.push(undo);
	              System.out.println("Redone command: " + undo);
	        	}
	        }if(command.equalsIgnoreCase("exit")) {break;}
        }
        System.out.println("Final stack: " + st);
        sc.close();
	}
}
