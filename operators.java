import java.util.Scanner;

public class operators {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println(~num + 1);

        int a = 5;
        int b = 7;

       a = (b = (a = (a ^ b)) ^ b) ^ a; 

    // a = a ^ b;
    // b = a ^ b;
    // a = a ^ b;



      System.out.println(a + " " + b);


      //set i th bit

      int n = 5;

      System.out.println(n | (1 << 1));
    }
}
