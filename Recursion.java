import java.util.ArrayList;
import java.util.Scanner;

public class Recursion {

    public static void printArray(ArrayList<Integer> arr, int idx) {

        if (idx >= arr.size())
            return;

            printArray(arr, idx + 1);
            System.out.println(arr.get(idx)); 
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        while (n-- > 0) {
            arr.add(sc.nextInt());
        }
        printArray(arr, 0);
        sc.close();
    }
}
