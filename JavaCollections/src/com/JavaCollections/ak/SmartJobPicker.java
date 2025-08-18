package com.JavaCollections.ak;

import java.util.PriorityQueue;
import java.util.Scanner;

public class SmartJobPicker {
	public static void main(String[] args) {
		PriorityQueue<Job> jobPicker= new PriorityQueue<>();
		Scanner sc = new Scanner(System.in);

		System.out.println("enter 'END' to end");
			while (true){
				System.out.println("Add jobs with priority");
				String name = sc.next();
				if(name.equalsIgnoreCase("END")) {
					break;
				}
				int priority = sc.nextInt();
				jobPicker.add(new Job(priority,name));
			}sc.close();
		while (!jobPicker.isEmpty()) {
		    Job job = jobPicker.poll();
		    System.out.println(job.getName() + " " + job.getPriority());
		}
	}
}

class Job implements Comparable<Job>{
	int priority;
	String name;
	
	public Job(int priority, String name) {
		super();
		this.priority = priority;
		this.name = name;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int compareTo(Job o) {
		return Integer.compare(this.priority, o.priority);
	}
	
	
}