import java.util.*;
public class MaxSumSubArray {

    public static int[] findCrossSum(int arr[], int left, int right, int mid) {
        int leftSum = Integer.MIN_VALUE, rightSum = Integer.MIN_VALUE;
        int sum = 0, leftIdx = mid, rightIdx = mid + 1;

        for (int i = mid; i >= left; i--) {
            sum += arr[i];
            if (sum > leftSum) {
                leftSum = sum;
                leftIdx = i;
            }
        }

        sum = 0;
        for (int i = mid + 1; i <= right; i++) {
            sum += arr[i];
            if (sum > rightSum) {
                rightSum = sum;
                rightIdx = i;
            }
        }

        return new int[] { leftIdx, rightIdx, leftSum + rightSum };
    }

    public static int[] maxSumSubArray(int arr[], int left, int right) {
        if (left >= right)
            return new int[] { left, right, arr[left] };

        int mid = left + ((right - left) >> 1);

        int a[] = maxSumSubArray(arr, left, mid);
        int b[] = maxSumSubArray(arr, mid + 1, right);
        int c[] = findCrossSum(arr, left, right, mid);

        if (a[2] >= b[2] && a[2] >= c[2])
            return a;

        else if (b[2] >= c[2])
            return b;
        else
            return c;

    }

    public static void main(String[] args) {
        int[] A = new int[]{-1, -1, -1, -1, -1, -1};
        int[] a = maxSumSubArray(A, 0, A.length - 1);

        int ans[] = new int[a[1] + 1];
        int idx = 0;
        for (int i = a[0]; i <= a[1]; i++) {
            ans[idx++] = A[i];
        }
        System.out.println(Arrays.toString(ans));
    }

}
