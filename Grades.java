import java.util.Scanner;

public class Grades {

    public static void printGrade(int marks) {
        if (marks >= 90) {
            System.out.println("Grade A");
        } else if (marks >= 80) {
            System.out.println("Grade B");
        } else if (marks >= 70) {
            System.out.println("Grade C");
        } else if (marks >= 60) {
            System.out.println("Grade D");
        } else {
            System.out.println("Grade F");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int marks = sc.nextInt();

        printGrade(marks);

        int x = (int)sc.nextFloat();
        System.out.println(x);
    }
}
