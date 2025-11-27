/**
 * Abstract base class representing a player in the Tic-Tac-Toe game.
 * Demonstrates abstraction and encapsulation principles.
 */
public abstract class Player {
    private String name;
    private char symbol;
    private int score;

    /**
     * Constructor to initialize a player
     * @param name The player's name
     * @param symbol The player's symbol ('X' or 'O')
     */
    public Player(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
        this.score = 0;
    }

    // Getters demonstrating encapsulation
    public String getName() {
        return name;
    }

    public char getSymbol() {
        return symbol;
    }

    public int getScore() {
        return score;
    }

    // Setter for score
    public void incrementScore() {
        this.score++;
    }

    /**
     * Abstract method that must be implemented by subclasses.
     * Demonstrates abstraction - each player type will have different move logic.
     * @param board The game board
     * @return Array containing [row, col] of the move
     */
    public abstract int[] makeMove(Board board);

    @Override
    public String toString() {
        return name + " (" + symbol + ")";
    }
}