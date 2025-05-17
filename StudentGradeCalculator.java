package Calculator;
import java.util.Scanner;

public class StudentGradeCalculator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int numberOfSubjects = 5;
        int[] marks = new int[numberOfSubjects];
        int totalMarks = 0;

        System.out.println("Welcome to the Student Grade Calculator!");
        System.out.println("- You will enter marks for " + numberOfSubjects + " subjects.");
        System.out.println("- Please enter marks out of 100 for each subject.\n");

        // Get marks for each subject
        for (int i = 0; i < numberOfSubjects; i++) {
            marks[i] = getValidMarks(sc, i + 1);
            totalMarks += marks[i];
        }

        double averagePercentage = calculateAveragePercentage(totalMarks, numberOfSubjects);
        char grade = calculateGrade(averagePercentage);

        System.out.println("\nResult:");
        System.out.println("--------");
        System.out.println("Individual Subject Grades:");
        for (int i = 0; i < numberOfSubjects; i++) {
            char subjectGrade = calculateGrade((double) marks[i]);
            System.out.println("Subject " + (i + 1) + " Marks: " + marks[i] + ", Grade: " + subjectGrade);
        }
        System.out.println("\nTotal Marks: " + totalMarks);
        System.out.printf("Average Percentage: %.2f%%\n", averagePercentage);
        System.out.println("Overall Grade: " + grade);

        sc.close();
    }

    // Method to get valid marks from user
    private static int getValidMarks(Scanner sc, int subjectNumber) {
        int marks;
        while (true) {
            System.out.print("Enter marks for subject " + subjectNumber + ": ");
            if (sc.hasNextInt()) {
                marks = sc.nextInt();
                if (marks >= 0 && marks <= 100) {
                    break;
                } else {
                    System.out.println("Invalid input. Marks should be between 0 and 100.");
                }
            } else {
                System.out.println("Invalid input. Please enter an integer value.");
                sc.next(); // Clear the invalid input
            }
        }
        return marks;
    }

    // Method to calculate average percentage
    private static double calculateAveragePercentage(int totalMarks, int numberOfSubjects) {
        return (double) totalMarks / numberOfSubjects;
    }

    // Method to calculate grade based on average percentage



    // Method to calculate grade based on individual subject marks
    private static char calculateGrade(double marks) {
        if (marks >= 91 && marks <= 100) {
            return 'A';
        } else if (marks >= 81 && marks <= 90) {
            return 'B';
        } else if (marks >= 71 && marks <= 80) {
            return 'C';
        } else if (marks >= 0 && marks <= 70) {
            return 'D';
        } else {
            return 'F'; // Handle any unexpected edge case
        }
    }
}
