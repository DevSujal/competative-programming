import java.util.*;

public class PrimeNos {
    public static boolean[] findPrimeNoFrom1toN(int n) {
        boolean ans[] = new boolean[n + 1];

        Arrays.fill(ans, true);
        int temp = (int) Math.sqrt(n);
        ans[0] = false;
        ans[1] = false;
        for (int i = 2; i <= temp; i++) {
            for (int j = 2 * i; j <= n; j += i) {
                if (ans[j] && j % i == 0) {
                    ans[j] = false;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean ans[] = findPrimeNoFrom1toN(sc.nextInt());
        System.out.println(Arrays.toString(ans));
        for (int i = 0; i < ans.length; i++) {
            if (ans[i])
                System.out.println(i);
        }
    }
}
