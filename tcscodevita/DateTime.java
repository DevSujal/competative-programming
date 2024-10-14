import java.util.*;
public class DateTime {
  public static void main(String[] args) {
    // Scanner sc = new Scanner(System.in);
    // String s = sc.nextLine();
    List<Integer> digits= new ArrayList<>(List.of(3, 3, 3, 3, 3, 3, 3 ,3 ,3, 3, 3, 3));
    
    // for(String temp : s.split(",")) {
    //   digits.add(Integer.parseInt(temp));
    // }

    System.out.println(digits);
    int set[] = new int[10];
    for(int i : digits) {
      set[i] += 1;
    }

    // month;
    int start = 0, end = 0;
    String month = "";
    if(set[1] > 0) {
      month = "1";
      start = 2;
      set[1]--;
    }
    else if(set[0] > 0) {
      month = "0";
      start = 9;
      end = 1;
      set[0]--;
    }else {
      System.out.println("not possible");
      return;
    }

    for(int i = start; i >= end; i--) {
        if(set[i] > 0) {
          month += i;
          set[i]--;
          break;
        }
        break;
      }
    


    // day;
    String day = "";
    if(set[3] > 0) {
      start = 1;
      end = 0;
      set[3]--;
      day = "3";
    }else {
      for(int i = 2; i >= 0; i--) {
        if(set[i] > 0) {
          day += i;
          set[i]--;
          start = 9;
          if(i == 0) {
            end = 1;
          }else end = 0;
          break;
        }
      }
    }
    
    for(int i = start; i >= end; i--) {
      if(set[i] > 0) {
        day += i;
        set[i]--;
        break;
      }
    }

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
    System.out.println(month + "/" + day + " " + hour + ":" + minute);
    
  }
}