package com.litmus7.student;

import com.litmus7.student.dto.*;
import java.util.Scanner;

public class StudentApp {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int nums; //no of students
		System.out.print("Enter the total number of students: ");
		nums = scanner.nextInt();
		
		
		Student stud[] = new Student[nums]; //array of student objects
		
		for(int n=0;n<nums;n++) {
			System.out.println("-----------------------------------------\nEnter details of Student " + (n+1) + ": ");
			stud[n]=new Student();
			stud[n].inputDetails(scanner);
//			System.out.println("-----------------------------------------");
		}
		
		scanner.close();
		
		for(int n=0;n<nums;n++) {
			System.out.println("------- Report Card : Student " + (n+1) + " --------");
			stud[n].printReportCard();
		}
		
	}

}


