import java.util.ArrayList;
import java.util.Scanner;

public class Max {
    public static int getMaxValue(ArrayList<Integer> arr, int idx) {
        if (idx >= arr.size()) {
            return Integer.MIN_VALUE;
        }
        return Math.max(getMaxValue(arr, idx + 1), arr.get(idx));
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        while (n-- > 0) {
            arr.add(sc.nextInt());
        }
        System.err.println("the max value is : " + getMaxValue(arr, 0));
        sc.close();
    }
}
