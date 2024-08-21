import java.util.*;

/**
 * Test
 */
public class Test {

    public static int divide(int dividend, int divisor) {

        if (dividend == divisor)
            return 1;

        int sign = 1;

        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0))
            sign = -1;
        long n = Math.abs((long) dividend);
        long d = Math.abs(divisor);

        long ans = 0;

        System.out.println(n);
        System.out.println(d);
        while (n >= d) {
            int count = 0;

            while (n >= (d << (count + 1)))
                count++;

            n -= (d << count);

            ans += (1 << count);
        }

        System.out.println(ans);
        if (-ans == (1 << 31))
            return Integer.MAX_VALUE;

        return (int) ans * sign;
    }

    public static int findKthLargestElement(int a[], int k) {
        PriorityQueue<Integer> p = new PriorityQueue<>(Collections.reverseOrder());

        for (int i : a)
            p.add(i);

        while (k-- > 1) {
            p.poll();
        }

        return p.poll();
    }

    public static int findKthLargestElementModifiedWay(int a[], int k) {
        PriorityQueue<Integer> p = new PriorityQueue<>();

        for (int i = 0; i < k; i++) {
            p.add(a[i]);
        }

        for (int i = k; i < a.length; i++) {
            if (p.peek() < a[i]) {
                p.poll();
                p.add(a[i]);
            }
        }
        return p.peek();
    }

    public static int findKthSmallestElement(int a[], int k) {
        PriorityQueue<Integer> p = new PriorityQueue<>();

        for (int i : a)
            p.add(i);

        while (k-- > 1) {
            p.poll();
        }

        return p.poll();
    }

    public static int connectNRopesWithMinCost(int a[]) {
        PriorityQueue<Integer> p = new PriorityQueue<>();

        for (int i : a)
            p.add(i);
        int cost = 0;
        while (p.size() > 1) {
            int rope1Length = p.poll();
            int rope2Length = p.poll();
            int sum = rope1Length + rope2Length;
            p.add(sum);
            cost += sum;
        }

        return cost;
    }

    // public static void me(int al[][]) {
    // PriorityQueue<int[]> p = new PriorityQueue<>((a, b) -> a[0] - b[0]);
    // for (int arrayList[] : al) {
    // p.add(arrayList);
    // }
    // int cost = 0;
    // for (Object object : ans) {
    // System.out.println(object);
    // }

    // while (p.size() > 1) {
    // int[] a = p.poll();
    // int[] b = p.peek();

    // int sum = Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    // cost += sum;
    // }

    // System.out.println(cost);
    // }

    public static void insert(PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap, int a) {

        if (maxHeap.isEmpty() || a <= maxHeap.peek()) {
            maxHeap.add(a);
        } else
            minHeap.add(a);

        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.add(maxHeap.poll());
        }
        if (minHeap.size() > maxHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
    }

    public static double findMedian(PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap) {
        if (maxHeap.size() == minHeap.size())
            return (maxHeap.peek() + minHeap.peek()) / 2.0;

        return maxHeap.peek();
    }

    public static double findMedianOfrunningStram(PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap, int a) {
     
        insert(maxHeap, minHeap, a);
        return findMedian(maxHeap, minHeap);
    }

    public static void main(String[] args) {

        // int a = 10;
        // int b = 20;
        // System.out.println("Sum of a and b is: " + (a + b));
        // System.out.println("Difference of a and b is: " + (a - b));
        // System.out.println("Product of a and b is: " + (a * b));
        // System.out.println("Division of a and b is: " + (a / b));

        // System.out.println(divide(-2147483648, -1));
        // System.out.println(findKthLargestElement(new int[]{1, 2, 3, 4, 5, 6, 7, 7},
        // 3));
        // System.out.println(findKthLargestElementModifiedWay(new int[]{1, 2, 3, 4, 5,
        // 6, 7, 7}, 3));
        // System.out.println(findKthSmallestElement(new int[]{1, 2, 3, 4, 5, 6, 7, 7},
        // 3));
        // System.out.println(connectNRopesWithMinCost(new int[]{1, 2, 3, 4, 5}));
        // PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        // PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        // System.out.println(findMedianOfrunningStram(maxHeap, minHeap, 1));
        // System.out.println(findMedianOfrunningStram(maxHeap, minHeap, 2));
        // System.out.println(findMedianOfrunningStram(maxHeap, minHeap, 3));
        // System.out.println(findMedianOfrunningStram(maxHeap, minHeap, 4));


        Solution s = new Solution();

        System.out.println(s.countAndSay(3));   
    }

}

class Solution {
    public String cs(int n) {
        if(n == 1) return "1";

        String str = cs(n-1);
        
        String newStr = "";
        for(int i = str.length() - 1; i >= 1; i--) {
            int count = 1;

            while(str.charAt(i) == str.charAt(i-1)) count++;

            newStr = count + str.charAt(i) + newStr;
        }
        if(str.length() == 1) {
            newStr = "1" + str.charAt(0);
        }
        else if(str.charAt(0) != str.charAt(1)) {
            newStr = "1" + str.charAt(0) + newStr;
        }
        return newStr;
    }
    public String countAndSay(int n) {
       return cs(n);
    }
}