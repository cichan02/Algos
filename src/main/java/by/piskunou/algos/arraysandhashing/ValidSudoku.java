package by.piskunou.algos.arraysandhashing;

public class ValidSudoku {
    private static final char EMPTY = '.';
    private static final byte SUDOKU_SIZE = 9;

    public boolean isValidSudoku1(char[][] board) {
        boolean[][] matrix = new boolean[SUDOKU_SIZE][3 * SUDOKU_SIZE];
        for (int i = 0; i < SUDOKU_SIZE; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == EMPTY) {
                    continue;
                }

                int number = board[i][j]- '1';

                if (matrix[number][i]) {
                    return false;
                }
                matrix[number][i] = true;

                if (matrix[number][j+SUDOKU_SIZE]) {
                    return false;
                }
                matrix[number][j+SUDOKU_SIZE] = true;

                int k = i / 3 + (j / 3) * 3 + 2 * SUDOKU_SIZE;
                if (matrix[number][k]) {
                    return false;
                }
                matrix[number][k] = true;
            }
        }
        return true;
    }

    //TODO: Пачытаць пра BitMask'і
    public boolean isValidSudoku2(char[][] board) {
        int[] rows = new int[9];
        int[] cols = new int[9];
        int[] squares = new int[9];

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] == '.') continue;

                int val = board[r][c] - '1';

                if ((rows[r] & (1 << val)) > 0 || (cols[c] & (1 << val)) > 0 ||
                        (squares[(r / 3) * 3 + (c / 3)] & (1 << val)) > 0) {
                    return false;
                }

                rows[r] |= (1 << val);
                cols[c] |= (1 << val);
                squares[(r / 3) * 3 + (c / 3)] |= (1 << val);
            }
        }
        return true;
    }
}
