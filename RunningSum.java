import java.util.ArrayList;
import java.util.Scanner;

public class RunningSum {
    public static void prefixSum(Scanner sc, int n, ArrayList<Integer> prefixSum) {

        for (int i = 0; i < n; i++) {
            if(i == 0)
            prefixSum.add(sc.nextInt());
            else
            prefixSum.add(sc.nextInt() + prefixSum.get(i-1));
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =  sc.nextInt();
        ArrayList<Integer> al = new ArrayList<>();
        prefixSum(sc, n, al);

        System.out.println(al);
    }
}
