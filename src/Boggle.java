import java.util.ArrayList;
import java.util.Arrays;

// Boggle by Niam

public class Boggle {

    public static String[] findWords(char[][] board, String[] dictionary) {
        ArrayList<String> goodWords = new ArrayList<>();
        // Stores the dictionary in a tst for easy access
        TST dict = new TST();
        for (String s : dictionary) {
            dict.insert(s);
        }
        // 2d array to store whether the letter has been visited in the current path
        boolean[][] isFound = new boolean[board.length][board[0].length];
        // Checks for words for each possible starting location
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(i,j, dict,board,isFound, "", goodWords);
            }
        }

        // Convert the list into a sorted array of strings, then return the array.
        String[] sol = new String[goodWords.size()];
        goodWords.toArray(sol);
        Arrays.sort(sol);
        return sol;
    }

    public static void dfs(int row, int col, TST tst, char[][] board, boolean[][] isFound, String word, ArrayList<String> goodWords) {
        // Base case 1: if out of bounds
        if (row >= board.length || row < 0 || col >= board[0].length || col < 0) {
            return;
        }
        // Base case 2: if already visited
        if (isFound[row][col]) {
            return;
        }
        // Adds the letter to the String and marks letter as found
        word += board[row][col];
        isFound[row][col] = true;
        // If the String doesn't exist in the dictionary (like fx), return
         if (!tst.isPrefix(word)) {
             isFound[row][col] = false;
             return;
         }
         // Only adds the word if it is actually a word and if it is unique
         if (tst.lookup(word)) {
             if (!goodWords.contains(word)) {
                 goodWords.add(word);
             }
         }
         // Recursive step
         dfs(row, col + 1, tst, board, isFound, word, goodWords);
         dfs(row + 1, col, tst, board, isFound, word, goodWords);
         dfs(row, col - 1, tst, board, isFound, word, goodWords);
         dfs(row - 1, col, tst, board, isFound, word, goodWords);
         // Sets location to not visited for future paths.
         isFound[row][col] = false;
    }

}
