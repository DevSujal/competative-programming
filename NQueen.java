import java.util.*;

public class NQueen {
    public static boolean nQueen(int row, ArrayList<ArrayList<Integer>> board, ArrayList<Integer> ans) {

        boolean isAllPlaced = false;
        for (int col = 0; col < board.size(); col++) {
            boolean isPlaced = isPlaced(row, col, ans);
            if (isPlaced) {
                ans.set(row, col);
                if (row >= board.size() - 1) {
                    System.out.println(ans);
                    return true;
                } else
                    isAllPlaced = nQueen(row + 1, board, ans);
            }
        }

        return isAllPlaced;
    }

    public static boolean isPlaced(int row, int col, ArrayList<Integer> ans) {

        for (int i = 0; i < row; i++) {
            if (ans.get(i) == col || Math.abs(ans.get(i) - col) == Math.abs(i - row))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> board = new ArrayList<>();
        board.add(new ArrayList<>(List.of(-1, -1)));
        board.add(new ArrayList<>(List.of(-1, -1)));

        ArrayList<Integer> ans = new ArrayList<>(List.of(-1, -1, -1, -1));
       if(!nQueen(0, board, ans)){
        System.out.println("no arrangment found");
       };
    }
}
