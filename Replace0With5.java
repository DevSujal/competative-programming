import java.util.Scanner;

public class Replace0With5 {

    public static long replace0With5(long num) {
        long dupNum = num;
        long ans = 0;
        while (dupNum > 0) {
            if (dupNum % 10 == 0) {
                ans = ans*10 + 5;
            } else {
                ans = ans*10 + dupNum % 10;
            }
            dupNum /= 10;
        }
        dupNum = ans;
        ans = 0;
        while (dupNum > 0) {
            ans = ans*10 + dupNum % 10;
            dupNum /= 10;
        }

        return ans;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        long num = sc.nextLong();
        System.out.println("replaced number from 0 to 5 is : " + replace0With5(num));
    }
}
