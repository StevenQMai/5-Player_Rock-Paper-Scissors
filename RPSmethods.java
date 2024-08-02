package Games.RPS;

import java.util.*;

/**
 * Rock-Paper-Scissors Game
 * Handles single-player, two-player, three-player, four-player, and five-player game modes with CPU participation.
 */
public class RPSmethods {
    static Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to the Rock-Paper-Scissors Game!");
        System.out.println("Press 'Q' at any time to quit.\n");

        // Get number of players
        int players = getInt("How many players will be playing (2-5)?\n# of Players: ");
        System.out.println("\nYou entered: " + players);
        
        switch (players) {
            case 2:
                twoPlayers();
                break;
            case 3:
                threePlayers();
                break;
            case 4:
                fourPlayers();
                break;
            case 5:
                fivePlayers();
                break;
            default:
                System.out.println("Invalid number of players.");
                break;
        }
    }

    /**
     * Prompt and get a positive integer from the user.
     *
     * @param prompt a string to prompt the user
     * @return a positive integer input by the user
     */
    private static int getInt(String prompt) {
        System.out.print(prompt);
        while (!keyboard.hasNextInt()) {
            keyboard.next(); // Clear invalid input
            System.out.print("Invalid input. " + prompt);
        }
        int input = keyboard.nextInt();
        keyboard.nextLine(); // Clear input buffer
        return input;
    }

    /**
     * Prompt and get a valid symbol from the user.
     * 
     * @return a valid symbol (R, P, S, or Q) input by the user
     */
    private static char chooseSymbol() {
        char input;
        while (true) {
            System.out.print("Choose a symbol [R, P, S] or (Q to quit): ");
            input = keyboard.nextLine().trim().toUpperCase().charAt(0);
            if (input == 'R' || input == 'P' || input == 'S' || input == 'Q') {
                break; // Got a valid character, break the loop
            }
            System.out.println("Invalid input, try again!");
        }
        return input;
    }

    /**
     * Generate a random choice for the CPU.
     * 
     * @return a random symbol (R, P, S)
     */
    private static char cpuChoice() {
        Random rand = new Random();
        int choice = rand.nextInt(3);
        return switch (choice) {
            case 0 -> 'R';
            case 1 -> 'P';
            case 2 -> 'S';
            default -> 'R'; // Default case
        };
    }

    /**
     * Determine the winner between two players.
     *
     * @param c symbol of the first player
     * @param x symbol of the second player
     * @return 0 if tie, 1 if the first player wins, 2 if the second player wins
     */
    private static int check(char c, char x) {
        if ((c == 'R' && x == 'S') || (c == 'P' && x == 'R') || (c == 'S' && x == 'P')) {
            return 1; // First player wins
        } else if ((x == 'R' && c == 'S') || (x == 'P' && c == 'R') || (x == 'S' && c == 'P')) {
            return 2; // Second player wins
        }
        return 0; // Tie
    }

    /**
     * Determine the winner among three players.
     *
     * @param x symbol of the first player
     * @param y symbol of the second player
     * @param z symbol of the third player (CPU)
     * @return 0 if tie, 1 if the first player wins, 2 if the second player wins,
     *         3 if the third player (CPU) wins, or other codes for combined winners
     */
    private static int check(char x, char y, char z) {
        if ((x == 'R' && y == 'S' && z == 'S') ||
            (x == 'P' && y == 'R' && z == 'R') ||
            (x == 'S' && y == 'P' && z == 'P')) {
            return 1; // First player wins
        } else if ((y == 'R' && x == 'S' && z == 'S') ||
                   (y == 'P' && x == 'R' && z == 'R') ||
                   (y == 'S' && x == 'P' && z == 'P')) {
            return 2; // Second player wins
        } else if ((z == 'R' && x == 'S' && y == 'S') ||
                   (z == 'P' && x == 'R' && y == 'R') ||
                   (z == 'S' && x == 'P' && y == 'P')) {
            return 3; // Third player (CPU) wins
        } else if ((x == 'R' && y == 'R' && z == 'S') ||
                   (x == 'S' && y == 'S' && z == 'P') ||
                   (x == 'P' && y == 'P' && z == 'R')) {
            return 4; // Players 1 and 2 win
        } else if ((x == 'R' && y == 'S' && z == 'R') ||
                   (x == 'S' && y == 'P' && z == 'S') ||
                   (x == 'P' && y == 'R' && z == 'P')) {
            return 5; // Players 1 and 3 win
        } else if ((x == 'S' && y == 'R' && z == 'R') ||
                   (x == 'P' && y == 'S' && z == 'S') ||
                   (x == 'R' && y == 'P' && z == 'P')) {
            return 6; // Players 2 and 3 win
        }
        return 0; // Tie
    }

    /**
     * Determine the winner among four players.
     *
     * @param w symbol of the first player
     * @param x symbol of the second player
     * @param y symbol of the third player
     * @param z symbol of the fourth player
     * @return 0 if tie, 1 if the first player wins, 2 if the second player wins,
     *         3 if the third player wins, 4 if the fourth player wins, or other codes for combined winners
     */
    private static int check(char w, char x, char y, char z) {
        if ((w == 'R' && x == 'S' && y == 'S' && z == 'S') ||
            (w == 'P' && x == 'R' && y == 'R' && z == 'R') ||
            (w == 'S' && x == 'P' && y == 'P' && z == 'P')) {
            return 1; // First player wins
        } else if ((x == 'R' && y == 'S' && z == 'S' && w == 'S') ||
                   (x == 'P' && y == 'R' && z == 'R' && w == 'R') ||
                   (x == 'S' && y == 'P' && z == 'P' && w == 'P')) {
            return 2; // Second player wins
        } else if ((y == 'R' && z == 'S' && w == 'S' && x == 'S') ||
                   (y == 'P' && z == 'R' && w == 'R' && x == 'R') ||
                   (y == 'S' && z == 'P' && w == 'P' && x == 'P')) {
            return 3; // Third player wins
        } else if ((z == 'R' && w == 'S' && x == 'S' && y == 'S') ||
                   (z == 'P' && w == 'R' && x == 'R' && y == 'R') ||
                   (z == 'S' && w == 'P' && x == 'P' && y == 'P')) {
            return 4; // Fourth player wins
        } else if ((w == 'R' && x == 'R' && y == 'S' && z == 'S') ||
                   (w == 'S' && x == 'S' && y == 'R' && z == 'R') ||
                   (w == 'P' && x == 'P' && y == 'S' && z == 'S')) {
            return 5; // Players 1 and 2 win
        } else if ((w == 'R' && x == 'S' && y == 'R' && z == 'S') ||
                   (w == 'S' && x == 'P' && y == 'S' && z == 'R') ||
                   (w == 'P' && x == 'R' && y == 'P' && z == 'P')) {
            return 6; // Players 1 and 3 win
        } else if ((w == 'S' && x == 'R' && y == 'P' && z == 'P') ||
                   (w == 'R' && x == 'P' && y == 'S' && z == 'S') ||
                   (w == 'P' && x == 'S' && y == 'R' && z == 'R')) {
            return 7; // Players 1 and 4 win
        } else if ((x == 'R' && y == 'S' && z == 'R' && w == 'S') ||
                   (x == 'S' && y == 'P' && z == 'S' && w == 'R') ||
                   (x == 'P' && y == 'R' && z == 'P' && w == 'P')) {
            return 8; // Players 2 and 3 win
        } else if ((x == 'S' && y == 'R' && z == 'P' && w == 'R') ||
                   (x == 'R' && y == 'P' && z == 'S' && w == 'S') ||
                   (x == 'P' && y == 'S' && z == 'R' && w == 'P')) {
            return 9; // Players 2 and 4 win
        } else if ((y == 'R' && z == 'S' && w == 'S' && x == 'S') ||
                   (y == 'S' && z == 'R' && w == 'R' && x == 'R') ||
                   (y == 'P' && z == 'P' && w == 'S' && x == 'S')) {
            return 10; // Players 3 and 4 win
        }
        return 0; // Tie
    }

    /**
     * Handle a two-player game.
     */
    private static void twoPlayers() {
        System.out.println("----- Two-Player Mode -----");
        char player1 = chooseSymbol();
        if (player1 == 'Q') {
            System.out.println("Game terminated.");
            return;
        }
        char player2 = cpuChoice();
        System.out.println("Player 1: " + player1 + " vs CPU: " + player2);
        int result = check(player1, player2);
        displayResult(result, "Player 1", "CPU");
    }

    /**
     * Handle a three-player game.
     */
    private static int threePlayers() {
        System.out.println("----- Three-Player Mode -----");
        char player1 = chooseSymbol();
        if (player1 == 'Q') {
            System.out.println("Game terminated.");
            return 0;
        }
        char player2 = chooseSymbol();
        if (player2 == 'Q') {
            System.out.println("Game terminated.");
            return 0;
        }
        char player3 = cpuChoice();
        System.out.println("Player 1: " + player1 + " vs Player 2: " + player2 + " vs CPU: " + player3);
        int result = check(player1, player2, player3);
        displayResult(result, "Player 1", "Player 2", "CPU");
        return result;
    }

    /**
     * Handle a four-player game.
     */
    private static int fourPlayers() {
        System.out.println("----- Four-Player Mode -----");
        char player1 = chooseSymbol();
        if (player1 == 'Q') {
            System.out.println("Game terminated.");
            return 0;
        }
        char player2 = chooseSymbol();
        if (player2 == 'Q') {
            System.out.println("Game terminated.");
            return 0;
        }
        char player3 = chooseSymbol();
        if (player3 == 'Q') {
            System.out.println("Game terminated.");
            return 0;
        }
        char player4 = cpuChoice();
        System.out.println("Player 1: " + player1 + " vs Player 2: " + player2 + " vs Player 3: " + player3 + " vs CPU: " + player4);
        int result = check(player1, player2, player3, player4);
        displayResult(result, "Player 1", "Player 2", "Player 3", "CPU");
        return result;
    }

    /**
     * Handle a five-player game.
     */
    private static int fivePlayers() {
        System.out.println("----- Five-Player Mode -----");
        int winnerR1;
        int winnerR2;
        System.out.println("Elimination Round 1: 1 vs 1 vs 1");
        do {
            winnerR1 = threePlayers(); // Three players
        } while (winnerR1 == 0);

        System.out.println("\nFinal Round: 1 vs 1 vs 1");
        do {
            winnerR2 = fivePlayers1v1v1(); // Final one-on-one vs one situation
        } while (winnerR1 == 1 || winnerR2 == 0);
        return winnerR2;
    }

    /**
     * Handle a final one-on-one vs one situation among three players.
     */
    private static int fivePlayers1v1v1() {
        char player1 = chooseSymbol();
        if (player1 == 'Q') {
            System.out.println("Game terminated.");
            return 0;
        }
        char player2 = chooseSymbol();
        if (player2 == 'Q') {
            System.out.println("Game terminated.");
            return 0;
        }
        char player3 = cpuChoice();
        System.out.println("Finalist 1: " + player1 + " vs Finalist 2: " + player2 + " vs CPU: " + player3);
        int result = check(player1, player2, player3);
        displayResult(result, "Finalist 1", "Finalist 2", "CPU");
        return result;
    }

    /**
     * Handle a final one-on-one situation.
     */
    private static void oneVsOne() {
        char player1 = chooseSymbol();
        if (player1 == 'Q') {
            System.out.println("Game terminated.");
            return;
        }
        char player2 = cpuChoice();
        System.out.println("Finalist 1: " + player1 + " vs CPU: " + player2);
        int result = check(player1, player2);
        displayResult(result, "Finalist 1", "CPU");
    }

    /**
     * Display the result of the game.
     * 
     * @param result the result code from the check method
     * @param playerNames the names of the players
     */
    private static void displayResult(int result, String... playerNames) {
        switch (result) {
            case 0:
                System.out.println("It's a Tie!");
                break;
            case 1:
                System.out.println(playerNames[0] + " wins!");
                break;
            case 2:
                System.out.println(playerNames[1] + " wins!");
                break;
            case 3:
                System.out.println(playerNames[2] + " wins!");
                break;
            case 4:
                System.out.println(playerNames[0] + " and " + playerNames[1] + " win!");
                System.out.println("Final Round");
                oneVsOne();
                break;
            case 5:
                System.out.println(playerNames[0] + " and " + playerNames[2] + " win!");
                System.out.println("Final Round");
                oneVsOne();
                break;
            case 6:
                System.out.println(playerNames[1] + " and " + playerNames[2] + " win!");
                System.out.println("Final Round");
                oneVsOne();
                break;
            case 7:
                System.out.println(playerNames[0] + " and " + playerNames[3] + " win!");
                System.out.println("Final Round");
                oneVsOne();
                break;
            case 8:
                System.out.println(playerNames[1] + " and " + playerNames[2] + " win!");
                System.out.println("Final Round");
                oneVsOne();
                break;
            case 9:
                System.out.println(playerNames[1] + " and " + playerNames[3] + " win!");
                System.out.println("Final Round");
                oneVsOne();
                break;
            case 10:
                System.out.println(playerNames[2] + " and " + playerNames[3] + " win!");
                System.out.println("Final Round");
                oneVsOne();
                break;
        }
    }
}
