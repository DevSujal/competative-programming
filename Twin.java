import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Twin {

    public static void findTwins(String s, int idx, HashMap<Character, Integer> arr) {

        if (idx >= s.length() - 2)
            return;
        if (s.charAt(idx) == s.charAt(idx + 2)) {

            if (arr.containsKey(s.charAt(idx)))
                arr.put(s.charAt(idx), arr.get(s.charAt(idx)) + 1);
            else arr.put(s.charAt(idx), 1);
        }

        findTwins(s, idx+1, arr);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        HashMap<Character, Integer> ans = new HashMap<>();
        findTwins(str, 0, ans);

        System.out.println(ans);
    }
}
