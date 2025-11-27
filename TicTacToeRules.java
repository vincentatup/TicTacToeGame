/**
 * Implementation of game rules for Tic-Tac-Toe.
 * Demonstrates interface implementation and encapsulation of game logic.
 */
public class TicTacToeRules implements GameRules {

    /**
     * Checks all possible winning conditions
     * @param board The game board
     * @return The winning symbol or ' ' if no winner
     */
    @Override
    public char checkWinner(Board board) {
        // Check rows
        for (int i = 0; i < 3; i++) {
            if (board.getCell(i, 0) != ' ' &&
                board.getCell(i, 0) == board.getCell(i, 1) &&
                board.getCell(i, 1) == board.getCell(i, 2)) {
                return board.getCell(i, 0);
            }
        }

        // Check columns
        for (int j = 0; j < 3; j++) {
            if (board.getCell(0, j) != ' ' &&
                board.getCell(0, j) == board.getCell(1, j) &&
                board.getCell(1, j) == board.getCell(2, j)) {
                return board.getCell(0, j);
            }
        }

        // Check main diagonal (top-left to bottom-right)
        if (board.getCell(0, 0) != ' ' &&
            board.getCell(0, 0) == board.getCell(1, 1) &&
            board.getCell(1, 1) == board.getCell(2, 2)) {
            return board.getCell(0, 0);
        }

        // Check anti-diagonal (top-right to bottom-left)
        if (board.getCell(0, 2) != ' ' &&
            board.getCell(0, 2) == board.getCell(1, 1) &&
            board.getCell(1, 1) == board.getCell(2, 0)) {
            return board.getCell(0, 2);
        }

        return ' '; // No winner
    }

    /**
     * Checks if the game is a draw (board full with no winner)
     * @param board The game board
     * @return true if draw, false otherwise
     */
    @Override
    public boolean isDraw(Board board) {
        return board.isFull() && checkWinner(board) == ' ';
    }

    /**
     * Validates if a move can be made at the specified position
     * @param board The game board
     * @param row The row index (0-2)
     * @param col The column index (0-2)
     * @return true if valid, false otherwise
     */
    @Override
    public boolean isValidMove(Board board, int row, int col) {
        return row >= 0 && row < 3 && col >= 0 && col < 3 && board.isCellEmpty(row, col);
    }
}