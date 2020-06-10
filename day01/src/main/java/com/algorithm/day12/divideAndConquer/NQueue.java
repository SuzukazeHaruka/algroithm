package com.algorithm.day12.divideAndConquer;

import java.util.ArrayList;
import java.util.List;

public class NQueue {

    /**
     * 皇后，是国际象棋中的棋子，意味着国王的妻子。
     * 皇后只做一件事，那就是“吃子”。当她遇见可以吃的棋子时，
     * 就迅速冲上去吃掉棋子。当然，她横、竖、斜都可走一到七步，
     * 可进可退。（引用自 百度百科 - 皇后 ）
     *
     * 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
     * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
     *
     * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
     *
     *输入: 4
     * 输出: [
     *  [".Q..",  // 解法 1
     *   "...Q",
     *   "Q...",
     *   "..Q."],
     *
     *  ["..Q.",  // 解法 2
     *   "Q...",
     *   "...Q",
     *   ".Q.."]
     * ]
     * 解释: 4 皇后问题存在两个不同的解法。
     *
     *
     * 在建立算法之前，我们来考虑两个有用的细节。
     *
     * 一行只可能有一个皇后且一列也只可能有一个皇后。
     *
     * 这意味着没有必要再棋盘上考虑所有的方格。只需要按列循环即可。
     *
     * 对于所有的主对角线有 行号 + 列号 = 常数，对于所有的次对角线有 行号 - 列号 = 常数.
     *
     * 这可以让我们标记已经在攻击范围下的对角线并且检查一个方格 (行号, 列号) 是否处在攻击位置。
     *
     *
     */
    class Solution {
        int rows[];
        // "hill" diagonals
        int hills[];
        // "dale" diagonals
        int dales[];
        int n;
        // output
        List<List<String>> output = new ArrayList();
        // queens positions
        int queens[];

        public boolean isNotUnderAttack(int row, int col) {
            int res = rows[col] + hills[row - col + 2 * n] + dales[row + col];
            return (res == 0) ? true : false;
        }

        public void placeQueen(int row, int col) {
            queens[row] = col;
            rows[col] = 1;
            hills[row - col + 2 * n] = 1;  // "hill" diagonals
            dales[row + col] = 1;   //"dale" diagonals
        }

        public void removeQueen(int row, int col) {
            queens[row] = 0;
            rows[col] = 0;
            hills[row - col + 2 * n] = 0;
            dales[row + col] = 0;
        }

        public void addSolution() {
            List<String> solution = new ArrayList<String>();
            for (int i = 0; i < n; ++i) {
                int col = queens[i];
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < col; ++j) sb.append(".");
                sb.append("Q");
                for(int j = 0; j < n - col - 1; ++j) sb.append(".");
                solution.add(sb.toString());
            }
            output.add(solution);
        }

        public void backtrack(int row) {
            for (int col = 0; col < n; col++) {
                if (isNotUnderAttack(row, col)) {
                    placeQueen(row, col);
                    // if n queens are already placed
                    if (row + 1 == n) addSolution();
                        // if not proceed to place the rest
                    else backtrack(row + 1);
                    // backtrack
                    removeQueen(row, col);
                }
            }
        }

        public List<List<String>> solveNQueens(int n) {
            this.n = n;
            rows = new int[n];
            hills = new int[4 * n - 1];
            dales = new int[2 * n - 1];
            queens = new int[n];

            backtrack(0);
            return output;
        }
    }

}
