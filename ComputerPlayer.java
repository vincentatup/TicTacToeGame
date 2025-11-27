import java.util.Random;

/**
 * Represents a computer player with random move strategy.
 * Demonstrates inheritance and polymorphism.
 */
public class ComputerPlayer extends Player {
    private Random random;

    /**
     * Constructor for ComputerPlayer
     * @param name The player's name
     * @param symbol The player's symbol ('X' or 'O')
     */
    public ComputerPlayer(String name, char symbol) {
        super(name, symbol);
        this.random = new Random();
    }

    /**
     * Overrides makeMove to implement random move selection.
     * Demonstrates polymorphism through method overriding.
     * @param board The game board
     * @return Array containing [row, col] of the move
     */
    @Override
    public int[] makeMove(Board board) {
        int row, col;
        
        // Keep generating random positions until finding an empty cell
        do {
            row = random.nextInt(3);
            col = random.nextInt(3);
        } while (!board.isCellEmpty(row, col));

        System.out.println(getName() + " is thinking...");
        try {
            Thread.sleep(1000); // Simulate thinking time
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println(getName() + " chose: Row " + (row + 1) + ", Column " + (col + 1));
        return new int[]{row, col};
    }
}