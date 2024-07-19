import java.util.Scanner;

public class Test5 {

    public static long findFactorial(int num) {
        long ans = 1;

        while (num-- > 0) {
            ans *= (num+1);
        }

        return ans;
    }

    public static long trailingZerosInFactorial(long num) {
        long ans = 0;

        while(num / 5 > 0){
            ans += num /5;
            num /= 5;
        }

        return ans;
    }

    public static boolean isPalindrom(int num){
        
        int temp = num;
        int ans = 0;
        while (temp > 0) {
            ans = (ans * 10) + (temp % 10);
            temp /= 10;
        }
        return ans == num;
    }

    public static int highestPowerDivides(int num){
        long ans = 0;

        while(num / 5 > 0){
            ans += num / 5;
            num /= 5;
        }

        return (int)ans / 2;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // System.out.println(findFactorial(sc.nextInt()));
        // System.out.println(trailingZerosInFactorial(sc.nextLong()));
        System.out.println(isPalindrom(sc.nextInt()));
        // System.out.println(highestPowerDivides(sc.nextInt()));
    }
}
