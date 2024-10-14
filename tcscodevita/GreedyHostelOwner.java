public class GreedyHostelOwner {

  public static boolean hasNext(char a, char b) {
    if(a == 'J' && b == 'A')
        return true;
    if(a == 'I' && b == 'B')
        return true;
    if(a == 'H' && b == 'C')
        return true;
    if(a == 'G' && b == 'D')
        return true;

    return false;
  }
  public static void main(String[] args) {
    String arr[] = {
      "JAABHF", "JAACJA", "JAACDA"
    };
      long totalReading = 0;
      long central = 500;
      for(String str : arr) {
        long reading = 0;
        char array[] = str.toCharArray();
        int n = array.length;
        for(int i = 0; i < n-1; i++) {
          char a = array[i];
          char b = array[i+1];
          if(hasNext(a, b)) 
            reading = reading * 10 + b - 'A';
          else
            reading = reading * 10 + a - 'A';
        }
        reading = reading * 10 + array[n-1] - 'A';
        totalReading += reading;
      }

    if(totalReading < central) {
      System.out.println("INNOCENT");
      System.out.println(totalReading);
    }else {
      System.out.println("GREEDY");
      System.out.println(totalReading - central);
    }
  }
}