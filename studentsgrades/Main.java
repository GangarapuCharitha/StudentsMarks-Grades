import java.util.Scanner;

public class Main {

    static int calculateTotal(int[] marks) {
        int total = 0;

        for (int mark : marks) {
            total += mark;
        }

        return total;
    }

    static double calculateAverage(int total, int numberOfSubjects) {
        return (double) total / numberOfSubjects;
    }

    static String calculateGrade(double average) {

        if (average >= 90) {
            return "A";
        } else if (average >= 80) {
            return "B";
        } else if (average >= 70) {
            return "C";
        } else if (average >= 60) {
            return "D";
        } else if (average >= 50) {
            return "E";
        } else {
            return "F";
        }
    }

    static boolean isPassed(int[] marks) {

        for (int mark : marks) {
            if (mark < 35) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] subjects = {
            "Java",
            "Database",
            "Web Development",
            "Data Structures",
            "Computer Networks"
        };

        int[] marks = new int[subjects.length];

        System.out.print("Enter student name: ");
        String studentName = scanner.nextLine();

        System.out.print("Enter student ID: ");
        String studentId = scanner.nextLine();

        for (int i = 0; i < subjects.length; i++) {

            while (true) {

                System.out.print("Enter marks for " + subjects[i] + " (0-100): ");

                if (scanner.hasNextInt()) {

                    int mark = scanner.nextInt();

                    if (mark >= 0 && mark <= 100) {
                        marks[i] = mark;
                        break;
                    } else {
                        System.out.println(
                            "Invalid marks! Enter a value between 0 and 100."
                        );
                    }

                } else {

                    System.out.println("Invalid input! Please enter a number.");
                    scanner.next();
                }
            }
        }

        int total = calculateTotal(marks);

        double average = calculateAverage(total, subjects.length);

        String grade = calculateGrade(average);

        boolean passed = isPassed(marks);

        System.out.println("\n========== STUDENT RESULT ==========");

        System.out.println("Student Name : " + studentName);
        System.out.println("Student ID   : " + studentId);

        System.out.println("\nSubject Marks:");

        for (int i = 0; i < subjects.length; i++) {
            System.out.println(subjects[i] + " : " + marks[i]);
        }

        System.out.println("\nTotal Marks  : " + total);
        System.out.println("Average      : " + average);
        System.out.println("Grade        : " + grade);

        if (passed) {
            System.out.println("Status       : PASS");
        } else {
            System.out.println("Status       : FAIL");
        }

        System.out.println("====================================");

        scanner.close();
    }
}
