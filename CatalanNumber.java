import java.util.Arrays;

public class CatalanNumber {

    public static int findCatalanNumberOfNthPosition(int n) {
        // these is by recursive method
        if(n <= 1) return 1;
        int res = 0;
        for (int i = 0; i < n; i++) {
            res += findCatalanNumberOfNthPosition(i) * findCatalanNumberOfNthPosition(n - i - 1);
        }

        return res;
    }

    public static int findCatalanNumberOfNthPositionByDP(int n, int catalanAns[]) {
        // these is by dynamic programming method
        if(n <= 1) return 1;

        catalanAns[0] = 1;
        catalanAns[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                catalanAns[i] += catalanAns[j] * catalanAns[i - j - 1];
            }
        }
        System.out.println(Arrays.toString(catalanAns));
        return catalanAns[n];
    }
    public static int findCatalanNumberOfNthPositionByBinomialCoefficient(int n) {
        // these is by binomial coefficient method
        if(n > 2 * n - n)
            n = 2*n - n;
        int res = 1;
        for (int i = 0; i < n; i++) {
            res *= (2 * n - i);
            res /= (i + 1);
        }
        return res / (n+1);
    }

    public static void main(String[] args) {
        System.out.println(findCatalanNumberOfNthPosition(9));
        System.out.println(findCatalanNumberOfNthPositionByDP(9, new int[10]));
        System.out.println(findCatalanNumberOfNthPositionByBinomialCoefficient(9));
    }
}
