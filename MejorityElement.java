import java.util.*;

public class MejorityElement {
    public static int findMejorityElement(int a[]) {
        int ans[] = new int[2];
        for (int i = 0; i < a.length; i++) {
            if (ans[0] != a[i]) {
                if (ans[1] == 0) {
                    ans[0] = a[i];
                    ans[1] = 1;
                } else {
                    ans[1]--;
                }
            }else{
                ans[1]++;
            }
        }

        if(ans[1] == 0) return -1;

        int count = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == ans[0]) {
                count++;
            }
        }

        if(count > a.length / 2) return ans[0];
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(findMejorityElement(new int[] {1, 1, 5, 2, 1}));
    }
}
