import java.util.Arrays;

public class Pick {
    static int max = Integer.MIN_VALUE;

    public static int pick(int[] a, int b, int ans) {
        int prefixSum[] = new int[b];
        prefixSum[0] = a[0];
        for (int i = 1; i < b; i++) {
            prefixSum[i] = prefixSum[i - 1] + a[i];
        }

        int suffixSum[] = new int[b];
        suffixSum[0] = a[a.length - 1];
        for (int i = 1; i < b; i++) {
            suffixSum[i] = suffixSum[i - 1] + a[a.length - 1 - i];
        }

        System.out.println(Arrays.toString(prefixSum) + " " + Arrays.toString(suffixSum));
        int sum = suffixSum[b - 1];

        for (int i = 0; i < b - 1; i++) {
            if (sum < prefixSum[i] + suffixSum[b - i - 2]) {
                sum = prefixSum[i] + suffixSum[b - i - 2];
            }
            ;
        }

        if (sum < prefixSum[b - 1]) {
            sum = prefixSum[b - 1];
        }
        return sum;
    }

    public static int pickUsingRecursion(int[] a, int b, int ans) {
        if (b <= 0) {
            return ans;
        }
        return Math.max(pickUsingRecursion(a, b - 1, ans + a[b - 1]),
                pickUsingRecursion(a, b - 1, ans + a[a.length - b]));
    }

    public static int solve(int[] A, int B) {
        return pickUsingRecursion(A, B, 0);
    }

    public static void main(String[] args) {
        System.out.println(solve(new int[] { }, 1));
    }
}
