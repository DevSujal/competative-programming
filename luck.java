import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class luck {

    public static int luckBalance(int k, List<List<Integer>> contests) {
        // Write your code here
        
        int count = 0;
        long sum = 0;
        for(List<Integer> al : contests) {
            sum += al.get(0);
            if(al.get(1) == 1) {
                count++;
            }
         }
         
         int gain = count - k;
         
         // comparator likhne ka shortcut tarika
         PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
         
          
        for(List<Integer> al : contests) {
            System.out.println(pq);
            pq.add(al.get(0));
            
            // else if(!pq.isEmpty() && pq.peek() > al.get(0)) {
            //     pq.poll();
            //     pq.add(al.get(0));
            // }
         }
         
         return (int)sum;
    
    }

    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>(List.of(5, 1)));
        list.add(new ArrayList<>(List.of(1, 1)));
        list.add(new ArrayList<>(List.of(4, 0)));
        System.out.println(luckBalance(1, list));
    }
}
