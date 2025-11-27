/**
 * Represents the Tic-Tac-Toe game board.
 * Demonstrates encapsulation with private fields and public methods.
 */
public class Board {
    private static final int BOARD_SIZE = 3;
    private static final char EMPTY_CELL = ' ';
    private char[][] grid;

    /**
     * Constructor initializes an empty board
     */
    public Board() {
        grid = new char[BOARD_SIZE][BOARD_SIZE];
        reset();
    }

    /**
     * Resets the board to empty state
     */
    public void reset() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                grid[i][j] = EMPTY_CELL;
            }
        }
    }

    /**
     * Makes a move on the board
     * @param row The row index (0-2)
     * @param col The column index (0-2)
     * @param symbol The player's symbol
     * @return true if move was successful, false otherwise
     */
    public boolean makeMove(int row, int col, char symbol) {
        if (isCellEmpty(row, col)) {
            grid[row][col] = symbol;
            return true;
        }
        return false;
    }

    /**
     * Checks if a cell is empty
     * @param row The row index
     * @param col The column index
     * @return true if empty, false otherwise
     */
    public boolean isCellEmpty(int row, int col) {
        return grid[row][col] == EMPTY_CELL;
    }

    /**
     * Checks if the board is completely filled
     * @return true if full, false otherwise
     */
    public boolean isFull() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (grid[i][j] == EMPTY_CELL) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Gets the symbol at a specific cell
     * @param row The row index
     * @param col The column index
     * @return The symbol at that position
     */
    public char getCell(int row, int col) {
        return grid[row][col];
    }

    /**
     * Displays the current board state to console
     */
    public void display() {
        System.out.println("\nCurrent Board:");
        System.out.println("  1   2   3");
        
        for (int i = 0; i < BOARD_SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < BOARD_SIZE; j++) {
                System.out.print(grid[i][j]);
                if (j < BOARD_SIZE - 1) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            
            if (i < BOARD_SIZE - 1) {
                System.out.println("  -----------");
            }
        }
        System.out.println();
    }
}