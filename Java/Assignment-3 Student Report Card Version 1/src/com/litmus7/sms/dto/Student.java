package com.litmus7.sms.dto;

import java.util.Scanner;

/**
 * Enum representing the grades with their description. Assigned based on
 * average marks
 * 
 * @version 1.0
 */
enum Grade {
	/**
	 * Grade A - Excellent (average >= 90)
	 */
	A("Excellent"),
	/**
	 * Grade B - Good (average >= 75)
	 */
	B("Good"),
	/**
	 * Grade C - Average (average >= 60)
	 */
	C("Average"),
	/**
	 * Grade D - Pass (average >= 50)
	 */
	D("Pass"),
	/**
	 * Grade F - Fail (Below 50)
	 */
	F("Fail");

	/**
	 * The description of corresponding grade.
	 */
	private String description;

	/**
	 * Constructor to initialize the grade with description.
	 * 
	 * @param description The description of grade.
	 */
	private Grade(String description) {
		this.description = description;
	}

	/**
	 * Gets the description of the grade.
	 * 
	 * @return Grade description.
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the grade description.
	 * 
	 * @param description The description to set.
	 */
	public void setDescription(String description) {
		this.description = description;
	}

}

/**
 * The class that represents a student. Takes student details as input and
 * calculates the total marks, average marks and grade of a student. Generates
 * the report card.
 * 
 * @version 1.0
 */
public class Student {

	/**
	 * Name of the student.
	 */
	private String name;
	/**
	 * Roll number of the student.
	 */
	private int rollNo;
	/**
	 * Marks obtained by student in 5 subjects.
	 */
	private int[] marks = new int[5];

	/**
	 * Reads the name, roll number and marks.
	 * 
	 * @param scanner Scanner object to read user inputs.
	 */
	public void inputDetails(Scanner scanner) {
		scanner.nextLine(); // to consume leftover newline

		System.out.print("Enter the Student name: ");
		name = scanner.nextLine();

		System.out.print("Enter the Student Roll no: ");
		rollNo = scanner.nextInt();

		System.out.println("Enter the marks in 5 subjects: ");
		for (int i = 0; i < 5; i++) {
			System.out.print("Subject " + (i + 1) + ": ");
			marks[i] = scanner.nextInt();
		}
	}

	/**
	 * Method to calculate the total mark of a student.
	 * 
	 * @return The total mark of a student.
	 */
	private int calculateTotal() {
		int sum = 0;
		for (int mark : marks)
			sum += mark;

		return sum;
	}

	/**
	 * Method to determine the average mark of a student.
	 * 
	 * @return The average mark of a student.
	 */
	private double calculateAverage() {
		return calculateTotal() / 5.0;

	}

	/**
	 * Calculates the grade of a student based on their average mark
	 * <ul>
	 * <li>Average >= 90 → Grade A</li>
	 * <li>Average >= 75 → Grade B</li>
	 * <li>Average >= 65 → Grade C</li>
	 * <li>Average >= 50 → Grade D</li>
	 * <li>Below 50 → Grade F</li>
	 * </ul>
	 * 
	 * @return The grade of student
	 */
	private Grade getGrade() {
		double avg = calculateAverage();
		if (avg >= 90)
			return Grade.A;
		else if (avg >= 75)
			return Grade.B;
		else if (avg >= 65)
			return Grade.C;
		else if (avg >= 50)
			return Grade.D;
		else
			return Grade.F;
	}

	/**
	 * Method to print the report card of a student
	 */
	public void printReportCard() {
		Grade grade = getGrade();

		System.out.println("Name: " + name);
		System.out.println("Roll Number: " + rollNo);
		System.out.println("Total Marks: " + calculateTotal());
		System.out.println("Average Marks: " + calculateAverage());
		System.out.println("Grade: " + grade + " - " + grade.getDescription());

	}
}