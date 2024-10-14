import java.util.*;
public class DigitalTime {
  public static void main(String[] args) {
    // Scanner sc = new Scanner(System.in);
    // String s = sc.nextLine();
    List<Integer> digits= new ArrayList<>(List.of(0, 0, 1, 1, 3, 5, 6, 7, 7));

    // for(String temp : s.split(",")) {
    //   digits.add(Integer.parseInt(temp));
    // }

    // ans -> HH:MM:SS

    System.out.println(digits);
    int set[] = new int[10];
    for(int i : digits) {
      set[i] += 1;
    }

    // month;

    int start = 0, end = 0;

    // Hour;
    String hour = "";
    if(set[2] > 0) {
      hour = "2";
      start = 3;
      end = 0;
      set[2]--;
    }else {
      for(int i = 1; i >= 0; i--) {
        if(set[i] > 0) {
          hour += i;
          start = 9;
          set[i]--;
          if(i == 0) {
            end = 1;
          }else end = 0;
          break;
        }
      }
    }

    for(int i = start; i >= end; i--) {
      if(set[i] > 0) {
        hour += i;
        set[i]--;
        break;
      }
    }

    // Minute;
    String minute = "";
    for(int i = 5; i >= 0; i--) {
      if(set[i] > 0) {
        minute += i;
        set[i]--;
        start = 9;
        if(i == 0) end = 1;
        else end = 0;
        break;
      }
    }

    for(int i = start; i >= end; i--) {
      if(set[i] > 0) {
        minute += i;
        set[i]--;
        break;
      }
    }

    
    // second
    String second = "";
    for(int i = 5; i >= 0; i--) {
      if(set[i] > 0) {
        second += i;
        set[i]--;
        start = 9;
        if(i == 0) end = 1;
        else end = 0;
        break;
      }
    }

    for(int i = start; i >= end; i--) {
      if(set[i] > 0) {
        second += i;
        set[i]--;
        break;
      }
    }


    
    System.out.println(hour + ":" + minute + ":" + second);

  }
}