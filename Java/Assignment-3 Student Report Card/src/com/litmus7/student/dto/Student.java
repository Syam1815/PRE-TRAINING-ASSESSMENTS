package com.litmus7.student.dto;

import java.util.Scanner;


enum Grade{
	A,B,C,D,F;
}


public class Student {
	
	private String name;
	private int rollno;
	private int marks[]= new int [5];
	
	
	public void inputDetails(Scanner scanner) {
		scanner.nextLine(); //to consume '\n'
		
		System.out.print("Enter the Student name: ");
		name = scanner.nextLine();

		System.out.print("Enter the Student Roll no: ");
		rollno = scanner.nextInt();
		
		System.out.println("Enter the marks in 5 subjects: ");
		for(int i=0;i<5;i++) {
			System.out.print("Subject "+(i+1)+": ");
			marks[i]=scanner.nextInt();
		}
	}
	
	
	private int calculateTotal() {
		int sum=0;
		for(int m: marks) 
			sum+=m;

		return sum;
	}
	
	private double calculateAverage() {
		return calculateTotal()/5.0 ;

	}
	
	private Grade getGrade() {
		double avg=calculateAverage();
		if (avg>=90) 
			return Grade.A;
		else if (avg>=75) 
			return Grade.B;
		else if (avg>=65) 
			return Grade.C;
		else if (avg>=50)
			return Grade.D;
		else
			return Grade.F;
	}
	
	public void printReportCard() {
		System.out.println("Name: " + name);
		System.out.println("Roll Number: " + rollno);
		System.out.println("Total Marks: " + calculateTotal());
		System.out.println("Average Marks: " + calculateAverage());
		System.out.println("Grade: " + getGrade());

	}	
}