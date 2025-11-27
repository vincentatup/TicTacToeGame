import java.util.Random;

/**
 * Represents a smart computer player with strategic move selection.
 * Demonstrates inheritance and advanced polymorphism.
 */
public class SmartComputerPlayer extends Player {
    private Random random;

    public SmartComputerPlayer(String name, char symbol) {
        super(name, symbol);
        this.random = new Random();
    }

    /**
     * Overrides makeMove with intelligent strategy.
     * Strategy: 1. Win if possible, 2. Block opponent, 3. Take center, 4. Take corner, 5. Random
     */
    @Override
    public int[] makeMove(Board board) {
        System.out.println(getName() + " is thinking strategically...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        int[] move;

        // Try to win
        move = findWinningMove(board, getSymbol());
        if (move != null) {
            System.out.println(getName() + " is going for the win!");
            System.out.println(getName() + " chose: Row " + (move[0] + 1) + ", Column " + (move[1] + 1));
            return move;
        }

        // Block opponent from winning
        char opponentSymbol = (getSymbol() == 'X') ? 'O' : 'X';
        move = findWinningMove(board, opponentSymbol);
        if (move != null) {
            System.out.println(getName() + " is blocking opponent!");
            System.out.println(getName() + " chose: Row " + (move[0] + 1) + ", Column " + (move[1] + 1));
            return move;
        }

        // Take center if available
        if (board.isCellEmpty(1, 1)) {
            System.out.println(getName() + " chose: Row 2, Column 2 (Center)");
            return new int[]{1, 1};
        }

        // Take a corner
        int[][] corners = {{0, 0}, {0, 2}, {2, 0}, {2, 2}};
        for (int[] corner : corners) {
            if (board.isCellEmpty(corner[0], corner[1])) {
                System.out.println(getName() + " chose: Row " + (corner[0] + 1) + ", Column " + (corner[1] + 1));
                return corner;
            }
        }

        // Take any available cell
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board.isCellEmpty(i, j)) {
                    System.out.println(getName() + " chose: Row " + (i + 1) + ", Column " + (j + 1));
                    return new int[]{i, j};
                }
            }
        }

        return null; // Should never reach here
    }

    /**
     * Finds a winning move for the given symbol
     * @param board The game board
     * @param symbol The symbol to check for winning move
     * @return The winning move [row, col] or null if none exists
     */
    private int[] findWinningMove(Board board, char symbol) {
        // Check all empty cells
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board.isCellEmpty(i, j)) {
                    // Temporarily store the current cell value
                    char originalValue = board.getCell(i, j);
                    
                    // Try this move
                    board.makeMove(i, j, symbol);
                    
                    // Check if this creates a win
                    boolean isWin = checkWinForSymbol(board, symbol);
                    
                    // Undo the move by restoring original value (should be ' ')
                    board.makeMove(i, j, ' ');
                    
                    if (isWin) {
                        return new int[]{i, j};
                    }
                }
            }
        }
        return null;
    }

    /**
     * Checks if the given symbol has won
     */
    private boolean checkWinForSymbol(Board board, char symbol) {
        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if ((board.getCell(i, 0) == symbol && board.getCell(i, 1) == symbol && board.getCell(i, 2) == symbol) ||
                (board.getCell(0, i) == symbol && board.getCell(1, i) == symbol && board.getCell(2, i) == symbol)) {
                return true;
            }
        }

        // Check diagonals
        if ((board.getCell(0, 0) == symbol && board.getCell(1, 1) == symbol && board.getCell(2, 2) == symbol) ||
            (board.getCell(0, 2) == symbol && board.getCell(1, 1) == symbol && board.getCell(2, 0) == symbol)) {
            return true;
        }

        return false;
    }
}