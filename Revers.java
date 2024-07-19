import java.util.Scanner;

public class Revers {
    public static void printReverse(long num) {
        if(num <= 0) {
            return;
        }
        System.out.print(num % 10);
        printReverse(num/10);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long num = sc.nextLong();

        System.out.print("the reverse is : ");
        printReverse(num);
    }
}
