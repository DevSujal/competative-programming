import java.util.ArrayList;
import java.util.Scanner;

public class NonRepeatingElement {

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        while(n-- > 0) {
            arr.add(sc.nextInt());
        }
        int result = 0;
        for(int i = 0; i < arr.size(); i++){
            result ^= arr.get(i);
        }

        System.out.println(result);

        sc.close();
    }
}