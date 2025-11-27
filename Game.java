import java.util.Scanner;

/**
 * Main game controller that manages the game flow.
 * Demonstrates composition and coordination of different classes.
 */
public class Game {
    private Board board;
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private GameRules rules;
    private boolean isGameActive;
    private Scanner scanner;

    /**
     * Constructor initializes the game with two players
     * @param player1 First player
     * @param player2 Second player
     */
    public Game(Player player1, Player player2) {
        this.board = new Board();
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = player1; // Player 1 starts
        this.rules = new TicTacToeRules();
        this.isGameActive = false;
        this.scanner = new Scanner(System.in);
    }

    /**
     * Starts and manages the game loop
     */
    public void start() {
        boolean playAgain = true;

        while (playAgain) {
            playRound();
            displayScoreboard();
            playAgain = askPlayAgain();
            
            if (playAgain) {
                board.reset();
                currentPlayer = player1; // Reset to player 1
            }
        }

        displayFinalScores();
    }

    /**
     * Plays a single round of the game
     */
    private void playRound() {
        System.out.println("\n========================================");
        System.out.println("      NEW GAME STARTED!");
        System.out.println("========================================");
        System.out.println(player1 + " vs " + player2);
        
        board.reset();
        isGameActive = true;
        board.display();

        while (isGameActive) {
            playTurn();
            board.display();
            
            // Check for winner
            char winner = rules.checkWinner(board);
            if (winner != ' ') {
                announceWinner(winner);
                isGameActive = false;
            } else if (rules.isDraw(board)) {
                announceDraw();
                isGameActive = false;
            } else {
                switchPlayer();
            }
        }
    }

    /**
     * Executes a single turn for the current player
     */
    private void playTurn() {
        System.out.println(currentPlayer.getName() + "'s turn (" + currentPlayer.getSymbol() + ")");
        
        // Polymorphism in action - different behavior based on player type
        int[] move = currentPlayer.makeMove(board);
        board.makeMove(move[0], move[1], currentPlayer.getSymbol());
    }

    /**
     * Switches to the other player
     */
    private void switchPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    /**
     * Announces the winner of the game
     * @param winnerSymbol The winning player's symbol
     */
    private void announceWinner(char winnerSymbol) {
        Player winner = (player1.getSymbol() == winnerSymbol) ? player1 : player2;
        winner.incrementScore();
        
        System.out.println("\n========================================");
        System.out.println("🎉 GAME OVER! 🎉");
        System.out.println("========================================");
        System.out.println("Winner: " + winner.getName() + " (" + winner.getSymbol() + ")");
        System.out.println("========================================\n");
    }

    /**
     * Announces a draw
     */
    private void announceDraw() {
        System.out.println("\n========================================");
        System.out.println("🤝 GAME OVER! 🤝");
        System.out.println("========================================");
        System.out.println("It's a DRAW!");
        System.out.println("========================================\n");
    }

    /**
     * Displays the current scoreboard
     */
    private void displayScoreboard() {
        System.out.println("SCOREBOARD:");
        System.out.println(player1.getName() + ": " + player1.getScore() + " win(s)");
        System.out.println(player2.getName() + ": " + player2.getScore() + " win(s)");
        System.out.println();
    }

    /**
     * Asks if players want to play again
     * @return true if yes, false if no
     */
    private boolean askPlayAgain() {
        System.out.print("Play again? (yes/no): ");
        String response = scanner.nextLine().trim().toLowerCase();
        
        while (!response.equals("yes") && !response.equals("no") && 
               !response.equals("y") && !response.equals("n")) {
            System.out.print("Please enter 'yes' or 'no': ");
            response = scanner.nextLine().trim().toLowerCase();
        }
        
        return response.equals("yes") || response.equals("y");
    }

    /**
     * Displays final scores before exiting
     */
    private void displayFinalScores() {
        System.out.println("\nThanks for playing! Final Scores:");
        System.out.println(player1.getName() + ": " + player1.getScore() + " win(s)");
        System.out.println(player2.getName() + ": " + player2.getScore() + " win(s)");
        System.out.println("\nGoodbye! 👋");
    }
}