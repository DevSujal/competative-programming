import java.math.BigInteger;

public class BigIntegerVal {
    public static void main(String[] args) {
        BigInteger a = new BigInteger("878748739875382759873498579847587349857983475987349857983475987349857349857983475987349857347598347598");
        BigInteger b = new BigInteger("2");

        BigInteger c = a.add(b);
        System.out.println(c);  
    }
}
