import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Main class that serves as the entry point for the Tic-Tac-Toe game.
 * Handles user interface and game initialization.
 * Demonstrates exception handling and user interaction.
 */
public class TicTacToeGame {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        displayWelcome();
        
        boolean exitProgram = false;
        
        while (!exitProgram) {
            try {
                int choice = displayMenu();
                
                switch (choice) {
                    case 1:
                        startHumanVsHuman();
                        break;
                    case 2:
                        startHumanVsComputer();
                        break;
                    case 3:
                        startHumanVsSmartComputer();
                        break;
                    case 4:
                        System.out.println("\nThank you for playing! Goodbye! 👋");
                        exitProgram = true;
                        break;
                    default:
                        System.out.println("❌ Invalid choice! Please enter 1-4.");
                }
            } catch (InputMismatchException e) {
                System.out.println("❌ Invalid input! Please enter a number.");
                scanner.nextLine(); // Clear invalid input
            } catch (Exception e) {
                System.out.println("❌ An error occurred: " + e.getMessage());
                scanner.nextLine();
            }
        }
        
        scanner.close();
    }

    /**
     * Displays welcome message
     */
    private static void displayWelcome() {
        System.out.println("========================================");
        System.out.println("     TIC-TAC-TOE GAME");
        System.out.println("========================================");
        System.out.println("Welcome! Let's play Tic-Tac-Toe!\n");
    }

    /**
     * Displays main menu and gets user choice
     * @return The user's menu choice
     */
    private static int displayMenu() {
        System.out.println("Select Game Mode:");
        System.out.println("1. Human vs Human");
        System.out.println("2. Human vs Computer (Easy)");
        System.out.println("3. Human vs Smart Computer");
        System.out.println("4. Exit");
        System.out.print("\nEnter your choice: ");
        
        return scanner.nextInt();
    }

    /**
     * Starts a Human vs Human game
     */
    private static void startHumanVsHuman() {
        scanner.nextLine(); // Consume newline
        
        System.out.println("\n--- Human vs Human Mode ---");
        System.out.print("Enter Player 1 name: ");
        String player1Name = scanner.nextLine();
        
        System.out.print("Enter Player 2 name: ");
        String player2Name = scanner.nextLine();
        
        // Create two human players - demonstrates polymorphism
        Player player1 = new HumanPlayer(player1Name, 'X');
        Player player2 = new HumanPlayer(player2Name, 'O');
        
        // Start the game
        Game game = new Game(player1, player2);
        game.start();
    }

    /**
     * Starts a Human vs Computer game
     */
    private static void startHumanVsComputer() {
        scanner.nextLine(); // Consume newline
        
        System.out.println("\n--- Human vs Computer Mode ---");
        System.out.print("Enter your name: ");
        String playerName = scanner.nextLine();
        
        // Create human and computer players - demonstrates polymorphism
        Player player1 = new HumanPlayer(playerName, 'X');
        Player player2 = new ComputerPlayer("Computer", 'O');
        
        // Start the game
        Game game = new Game(player1, player2);
        game.start();
    }

    /**
     * Starts a Human vs Smart Computer game
     */
    private static void startHumanVsSmartComputer() {
        scanner.nextLine(); // Consume newline
        
        System.out.println("\n--- Human vs Smart Computer Mode ---");
        System.out.print("Enter your name: ");
        String playerName = scanner.nextLine();
        
        // Create human and smart computer players - demonstrates polymorphism
        Player player1 = new HumanPlayer(playerName, 'X');
        Player player2 = new SmartComputerPlayer("Smart Bot", 'O');
        
        System.out.println("\n⚠️  Warning: The Smart Bot is unbeatable! Good luck! 🤖");
        
        // Start the game
        Game game = new Game(player1, player2);
        game.start();
    }
}