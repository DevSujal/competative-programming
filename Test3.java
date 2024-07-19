import java.util.*;;

public class Test3 {

    public static String replaceDuplicates(String str, int idx, String ans) {
        if (idx >= str.length() - 1)
            return ans + str.charAt(str.length() - 1);

        if (str.charAt(idx) == str.charAt(idx + 1)) {
            ans += str.charAt(idx) + "*";
        } else {
            ans += str.charAt(idx);
        }

        return replaceDuplicates(str, idx + 1, ans);
    }

    public static String replacePi(String str, int idx, String ans) {
        if (idx >= str.length() - 1) {

            if (str.charAt(str.length() - 1) == 'p' && str.charAt(str.length() - 1) == 'i')
                return ans;
            else
                return ans + str.charAt(str.length() - 1);
        }

        if (str.charAt(idx) == 'p' && str.charAt(idx + 1) == 'i') 
                return replacePi(str, idx + 2, ans + "3.14");
         else 
            return replacePi(str, idx + 1, ans + str.charAt(idx));

    }

    public static String returnBw(String str, int idx, String ans, boolean isBracketOpen) {

        if(idx >= str.length()) return ans;

        if(str.charAt(idx) == '(') return returnBw(str, idx+1, ans, true);
        if(str.charAt(idx) == ')') return returnBw(str, idx+1, ans, false);

        if(isBracketOpen) return returnBw(str, idx+1, ans + str.charAt(idx), isBracketOpen);
        else return returnBw(str, idx+1, ans, isBracketOpen);
    }

    public static void coinToss(int n, String ans){
        if(n <= 0) {
            System.out.println(ans);
            return;
        }

        coinToss(n-1, ans + "H");
        coinToss(n-1, ans + "T");
    }
    public static void makeCombString(String str, String ans, int idx){
        if(idx >= str.length()) {
            System.out.println(ans);
            return;
        }

        if(str.charAt(idx) == '?') {
            makeCombString(str, ans + "1", idx + 1);
            makeCombString(str, ans + "0", idx + 1);
        }else{
            makeCombString(str, ans + str.charAt(idx), idx + 1);
        }

    }

    public static void climbStares(int steps, int ans, String s){
        if(ans > steps) return;
        if(ans == steps) {
            System.out.println(s);
            return;
        }

        climbStares(steps, ans + 1, s + "1");
        climbStares(steps, ans + 2, s + "2");
    }
    public static void generateParenthesis(int idx, String s, int n){
      if(idx == 0){
        s += "(";
      }
      
      if (idx >= 2 * n-1){
        System.out.println(s);
        return;
      }
      idx += 1;
      if(idx > 0){
        generateParenthesis(idx, s + "(", n);
        generateParenthesis(idx, s + ")", n);
      }
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // String str = sc.nextLine();

        // System.out.println(replaceDuplicates(str, 0, ""));
        // System.out.println(replacePi(str, 0, ""));
        //  System.out.println(returnBw(str, 0, "", false));
        //   makeCombString(str, "", 0);

        int n = sc.nextInt();
        // coinToss(n, "");
        // System.out.println(str);

        // climbStares(n, 0, "");
        generateParenthesis(0, "", n);
        sc.close();
    }
}
