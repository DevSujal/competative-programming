import java.util.*;

public class SudokuSolver {
    public static boolean solveSudoku(int board[][]) {

        int row = -1, col = -1;
        boolean isCompleted = true;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 0) {
                    row = i;
                    col = j;

                    isCompleted = false;
                    break;
                }
            }

            if (!isCompleted) {
                break;
            }
        }

        if (isCompleted)
            return true;

        for (int val = 1; val <= board.length; val++)
            if (isSafe(board, row, col, val)) {
                board[row][col] = val;

                if (solveSudoku(board)) {
                    return true;
                } else {
                    board[row][col] = 0;
                }
            }

        return false;
    }

    public static boolean isSafe(int board[][], int row, int col, int val) {
        for (int i = 0; i < board.length; i++)
            if (board[row][i] == val)
                return false;

        for (int i = 0; i < board.length; i++)
            if (board[i][col] == val)
                return false;

        int gridSize = (int) Math.sqrt(board.length),
                rowStart = row - row % gridSize,
                colStart = col - col % gridSize;

        for (int i = rowStart; i < 3 + rowStart; i++)
            for (int j = colStart; j < 3 + colStart; j++)
                if (board[i][j] == val && !(row == i && col == j))
                    return false;

        return true;
    }

    public static void printBoard(int board[][]) {
        for (int[] i : board) 
            System.out.println(Arrays.toString(i));
    }

    public static void main(String[] args) {
        int[][] board = new int[][] {
                { 3, 0, 6, 5, 0, 8, 4, 0, 0 },
                { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
                { 0, 0, 3, 0, 1, 0, 0, 8, 0 },
                { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
                { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
                { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
                { 0, 0, 5, 2, 0, 6, 3, 0, 0 }
        };

        if (solveSudoku(board)) {
            printBoard(board);
        }
    }
}
