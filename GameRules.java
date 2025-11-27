/**
 * Interface defining the contract for game rules.
 * Demonstrates abstraction through interface.
 */
public interface GameRules {
    /**
     * Checks if there is a winner on the board
     * @param board The game board
     * @return The winning symbol ('X' or 'O') or ' ' if no winner
     */
    char checkWinner(Board board);

    /**
     * Checks if the game is a draw
     * @param board The game board
     * @return true if the game is a draw, false otherwise
     */
    boolean isDraw(Board board);

    /**
     * Validates if a move is legal
     * @param board The game board
     * @param row The row index
     * @param col The column index
     * @return true if the move is valid, false otherwise
     */
    boolean isValidMove(Board board, int row, int col);
}