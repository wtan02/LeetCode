package dfs.solveNQueens;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * Get all distinct N-Queen solutions
     * @param n: The number of queens
     * @return: All distinct solutions
     * For example, A string '...Q' shows a queen on forth position
     */
    List<List<String>> solveNQueens(int n) {
        List<List<String>> results = new ArrayList<>();
        if (n <= 0) {
            return results;
        }

        search(results, new ArrayList<Integer>(), n);
        return results;
    }

    /*
     * results store all of the chessboards
     * cols store the column indices for each row
     */
    private void search(List<List<String>> results,
                        List<Integer> chessboardRows,
                        int n) {
        if (chessboardRows.size() == n) {
            results.add(drawChessboard(chessboardRows));
            return;
        }

        for (int columnIndex = 0; columnIndex < n; columnIndex++) {
            if (!isValidPositionForNewQueen(chessboardRows, columnIndex)) {
                continue;
            }
            chessboardRows.add(columnIndex);
            search(results, chessboardRows, n);
            chessboardRows.remove(chessboardRows.size() - 1);
        }
    }

    private List<String> drawChessboard(List<Integer> chessboardRows) {
        List<String> chessboard = new ArrayList<>();
        //行循环
        for (int rowIndex = 0; rowIndex < chessboardRows.size(); rowIndex++) {
            StringBuilder sb = new StringBuilder();
            //列循环，chessboardRows中值为所在列数（横坐标）
            for (int columnIndex = 0; columnIndex < chessboardRows.size(); columnIndex++) {
                sb.append(columnIndex == chessboardRows.get(rowIndex) ? 'Q' : '.');
            }
            chessboard.add(sb.toString());
        }
        return chessboard;
    }

    private boolean isValidPositionForNewQueen(List<Integer> currentChessBoardRows, int columnIndexOfNewQueen) {
        //rowIndexOfNewQueen 为新皇后纵坐标， columnIndexOfNewQueen为新皇后横坐标
        int rowIndexOfNewQueen = currentChessBoardRows.size();

        for (int rowIndex = 0; rowIndex < currentChessBoardRows.size(); rowIndex++) {
            //不能在同一列 （因为每次把新皇后默认放到下一行，因策不可能为同一行，所以不用判断同一行的情况）
            if (currentChessBoardRows.get(rowIndex) == columnIndexOfNewQueen) {
                return false;
            }
            //横纵坐标之和不能相等（对角线）
            if (rowIndex + currentChessBoardRows.get(rowIndex) == rowIndexOfNewQueen + columnIndexOfNewQueen) {
                return false;
            }
            //横纵坐标之差不能相等（对角线）
            if (rowIndex - currentChessBoardRows.get(rowIndex) == rowIndexOfNewQueen - columnIndexOfNewQueen) {
                return false;
            }
        }
        return true;
    }
}