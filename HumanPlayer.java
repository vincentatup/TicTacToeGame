import java.util.Scanner;

/**
 * Represents a human player who inputs moves via console.
 * Demonstrates inheritance by extending Player class.
 */
public class HumanPlayer extends Player {
    private Scanner scanner;

    /**
     * Constructor for HumanPlayer
     * @param name The player's name
     * @param symbol The player's symbol ('X' or 'O')
     */
    public HumanPlayer(String name, char symbol) {
        super(name, symbol);
        this.scanner = new Scanner(System.in);
    }

    /**
     * Overrides the abstract makeMove method from Player class.
     * Demonstrates polymorphism through method overriding.
     * @param board The game board
     * @return Array containing [row, col] of the move
     */
    @Override
    public int[] makeMove(Board board) {
        int row = -1;
        int col = -1;
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.print("Enter row (1-3): ");
                row = scanner.nextInt() - 1; // Convert to 0-based index

                System.out.print("Enter column (1-3): ");
                col = scanner.nextInt() - 1; // Convert to 0-based index

                // Validate the move
                if (row >= 0 && row < 3 && col >= 0 && col < 3) {
                    if (board.isCellEmpty(row, col)) {
                        validInput = true;
                    } else {
                        System.out.println("❌ Cell already occupied! Try again.");
                    }
                } else {
                    System.out.println("❌ Invalid coordinates! Enter numbers between 1 and 3.");
                }
            } catch (Exception e) {
                System.out.println("❌ Invalid input! Please enter numbers only.");
                scanner.nextLine(); // Clear invalid input
            }
        }

        return new int[]{row, col};
    }
}