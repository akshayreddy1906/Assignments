package com.JavaCollections.ak;

import java.util.Scanner;
import java.util.concurrent.LinkedBlockingQueue;

public class StageBasedTaskRunner {

	public static void main(String[] args) {
		LinkedBlockingQueue<Tasks> stage1 = new LinkedBlockingQueue<>();
		Scanner sc = new Scanner(System.in);
		while (true) {
		System.out.println("enter a task ");
		String task = sc.next();
		if (task.equalsIgnoreCase("end")) break;
		int id = sc.nextInt();
		stage1.add(new Tasks(task,id));
		}sc.close();
		 System.out.println("Filteredg tasks are: ");
		 LinkedBlockingQueue<Tasks> stage2 = new LinkedBlockingQueue<>();
		 
		 for(Tasks item:stage1) {
				if(item.getId()%2 == 0) {
					stage2.add(item);
				}
			}

		 System.out.println("Filteredg tasks are: ");
		for(Tasks item:stage2) {
			System.out.println(item);
		}
	}
}
class Tasks{
	String task;
	int id;
	public Tasks(String task,int id) {
		super();
		this.task = task;
		this.id = id;
	}
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
	public int getId() {
		return id;
	}
	@Override
	public String toString() {
		return "[task=" + task + ", id=" + id + "]";
	}
	public void setId(int id) {
		this.id = id;
	}
	
}