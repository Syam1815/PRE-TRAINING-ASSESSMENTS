package com.litmus7.sms;

import com.litmus7.sms.dto.Student;
import java.util.Scanner;

/**
 * The main class that handles Student Report Card generation. Handles multiple
 * students and display their report card
 * 
 * @version 1.0
 */
public class StudentApp {
	/**
	 * Main method : Entry point of the program
	 * 
	 * @param args Command-line arguments (not used)
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int nums; // number of students
		System.out.print("Enter the total number of students: ");
		nums = scanner.nextInt();

		Student student[] = new Student[nums]; // array of student objects

		for (int n = 0; n < nums; n++) {
			System.out.println("-----------------------------------------\nEnter details of Student " + (n + 1) + ": ");
			student[n] = new Student();
			student[n].inputDetails(scanner);
		}

		scanner.close();

		for (int n = 0; n < nums; n++) {
			System.out.println("------- Report Card : Student " + (n + 1) + " --------");
			student[n].printReportCard();
		}

	}

}
