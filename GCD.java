public class GCD {
    public static int findGCD(int a, int b) {
        // amazing
        if (a <= 0)
            return b;
        if (b <= 0)
            return a;

        if (a >= b)
            return findGCD(a - b, b);
        else
            return findGCD(b - a, a);
    }

    public static int findGCDSecondMethod(int a, int b) {
        // amazing
        if ( b == 0)
            return a;

        return findGCD(b, a % b);
    }

    public static void main(String[] args) {
        System.out.println(findGCDSecondMethod(24, 60));
    }
}
