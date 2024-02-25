public class TicTacToe {
    private char[][] board;
    private char currentPlayerMark;

    public TicTacToe() {
        board = new char[3][3];
        currentPlayerMark = 'X';
        initializeBoard();
    }

    public void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = (i+1) * (j+1);
            }
        }
    }

    public String printBoard() {
        String printout = "";
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                printout = printout + (board[i][j]) + " ";
            }
            printout = printout + ("\n");
        }
        return printout;
    }

    public boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkForWin() {
        return (checkRowsForWin() || checkColumnsForWin() || checkDiagonalsForWin());
    }

    private boolean checkRowsForWin() {
        for (int i = 0; i < 3; i++) {
            if (checkForMatch(board[i][0], board[i][1], board[i][2]) == true) {
                return true;
            }
        }
        return false;
    }

    private boolean checkColumnsForWin() {
        for (int i = 0; i < 3; i++) {
            if (checkForMatch(board[0][i], board[1][i], board[2][i]) == true) {
                return true;
            }
        }
        return false;
    }

    private boolean checkDiagonalsForWin() {
        return (checkForMatch(board[0][0], board[1][1], board[2][2])
                || checkForMatch(board[0][2], board[1][1], board[2][0]));
    }

    private boolean checkForMatch(char c1, char c2, char c3) {
        return ((c1 != '-') && (c1 == c2) && (c2 == c3));
    }

    public boolean changePlayer() {
        if (currentPlayerMark == 'X') {
            currentPlayerMark = 'O';
        }
        else {
            currentPlayerMark = 'X';
        }
        return true;
    }

    public boolean placeMark(int row, int col) {
        if ((row >= 0) && (row < 3)) {
            if ((col >= 0) && (col < 3)) {
                if (board[row][col] == '-') {
                    board[row][col] = currentPlayerMark;
                    return true;
                }
            }
        }
        return false;
    }
}