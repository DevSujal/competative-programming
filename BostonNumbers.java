import java.util.Scanner;

public class BostonNumbers {

    public static boolean isPrime(long num) {
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static long sumDigit(long num) {
        long sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    public static boolean isBoston(long num) {

        long sum = sumDigit(num);
        long primeSum = 0;

        for (int i = 2; i <= num; i++) {
            while (num % i == 0) {
                    primeSum += sumDigit(i);
                    num /= i;
                }
        }

        return sum == primeSum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long num = sc.nextLong();

        System.out.println("the number is boston : " + isBoston(num));

        sc.close();
    }

}
