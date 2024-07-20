public class FastPower {

    public static long calcPower(int a, int b){
        long res = 1;

        while (b > 0) {
            if((b & 1) == 1){
                res *= a;
            }

            a *= a;
            b = b >> 1;
            System.out.println("steps");
        }

        return res;
    }
    public static long calcPowerWithModulo(long a, int b, int n){
        long res = 1;

        while (b > 0) {
            if((b & 1) == 1){
                res = (res * (a % n)) % n;
            }

            a = ((a % n) * (a % n)) % n;
            b = b >> 1;
            System.out.println("steps");
        }

        return res;
    }
    public static void main(String[] args) {
        System.out.println(Math.pow(3895, 4) % 100000000);
        System.out.println(calcPowerWithModulo(3895, 4, 100000000));
    }
}
