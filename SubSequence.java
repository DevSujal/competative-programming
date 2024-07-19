import java.util.Scanner;

public class SubSequence {
    
    public static void printAllSubArrays(String s, int idx, String str) {
        if(idx >= s.length()){
            if(str == "") System.out.println("-");
            else System.out.println(str);
            return;
        }

        printAllSubArrays(s, idx+1, str + s.charAt(idx));
        printAllSubArrays(s, idx+1, str);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        printAllSubArrays(str, 0, "");
        sc.close();
    }
}
