import java.util.ArrayList;

public class Factorial {
    public static String findFactorial(int n) {

        ArrayList<Integer> ans = new ArrayList<>();

        ans.add(1);

        for (int i = 0; i < n; i++) {
            int carry = 0;
            for (int j = 0; j < ans.size(); j++) {
                int temp = ans.get(j);
                int mul = temp * (i + 1) + carry;
                ans.set(j, mul % 10);
                carry = mul / 10;
            }
            while (carry > 0) {
                ans.add(carry % 10);
                carry /= 10;
            }
        }

        String Ans = "";

        for (int i = ans.size() - 1; i > -1; i--) {
            Ans += ans.get(i);
        }

        return Ans;
    }

    public static void main(String[] args) {
        System.out.println(findFactorial(10000));
    }
}
