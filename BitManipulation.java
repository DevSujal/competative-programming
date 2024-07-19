import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BitManipulation {

    public static void findNonRepeating() {
        // find two non reapeting numbers with xor
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        while (n-- > 0) {
            arr.add(sc.nextInt());
        }

        int ans = 0;

        for (int i = 0; i < arr.size(); i++) {
            ans = ans ^ arr.get(i);
        }
        System.out.println(ans);
        int temp = ans;
        int mask = 1;
        for (int i = 1; i < ans; i++) {
            if ((temp | mask) == temp) {
                break;
            }
            mask = mask >> i;
        }
        System.out.println(temp);
        System.out.println(mask);
        for (int i = 0; i < arr.size(); i++) {
            if ((arr.get(i) | mask) == arr.get(i)) {
                ans = ans ^ arr.get(i);
            }
        }

        System.out.println(temp);

        System.out.println(ans + " " + (temp ^ ans));
    }

    public static void findNonRepeatingThree(int k) {
        // find non reapeting number when numbers are k times repeating
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();

        // while (n-- > 0) {
        //     arr.add(sc.nextInt());
        // }

        arr.add(4);
        arr.add(4);
        arr.add(4);
        arr.add(4);
        arr.add(4);
        arr.add(4);
        arr.add(5);
        arr.add(6);
        arr.add(6);
        arr.add(6);
        arr.add(6);
        arr.add(6);
        arr.add(6);

        int[] bit = new int[32];

        for (int i = 0; i < arr.size(); i++) {
            int temp = arr.get(i);
            int counter = 0;
            while (temp > 0) {
                if ((temp & 1) == 1)
                    bit[counter] = (bit[counter] + 1)%k;
                temp = temp >> 1;
                counter++;
            }
        }

        System.out.println(Arrays.toString(bit));
        int ans = 0;
        for (int i = 0; i < bit.length; i++) {
            if (bit[i] % k == 0)
                continue;
            ans += (1 << i);
        }

        System.out.println(ans);
    }

    public static void main(String[] args) {
        findNonRepeatingThree(6);
    }
}
