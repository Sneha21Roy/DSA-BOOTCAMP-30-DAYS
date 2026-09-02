
class TicTacToe {

    int[] rows;
    int[] cols;
    int diagonal;
    int antiDiagonal;
    int n;

    public TicTacToe(int n) {
        this.n = n;
        rows = new int[n];
        cols = new int[n];
    }

    public int move(int row, int col, int player) {

        int value;

        if (player == 1) {
            value = 1;
        } else {
            value = -1;
        }

        rows[row] += value;
        cols[col] += value;

        if (row == col) {
            diagonal += value;
        }

        if (row + col == n - 1) {
            antiDiagonal += value;
        }

        if (Math.abs(rows[row]) == n
                || Math.abs(cols[col]) == n
                || Math.abs(diagonal) == n
                || Math.abs(antiDiagonal) == n) {

            return player;
        }

        return 0;
    }
}
