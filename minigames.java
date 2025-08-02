import java.util.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome to the 4 in 1 game!");

        Scanner myObj = new Scanner(System.in);
        String player;

        // Enter player name to keep score
        System.out.println("Enter Playername:");
        player = myObj.nextLine();
        System.out.println("Welcome to the game: " + player);

        ticTacToe(myObj);
        numberGuesser(myObj);
        hangMan(myObj);

        myObj.close();
    }

    // Simple 2-player TicTacToe vs yourself
    public static void ticTacToe(Scanner sc) {
        char[] board = {'1','2','3','4','5','6','7','8','9'};
        char currentPlayer = 'X';
        int moves = 0;
        boolean gameEnded = false;

        System.out.println("\nLet's play Tic-Tac-Toe!");
        printBoard(board);

        while (!gameEnded) {
            System.out.println("Player " + currentPlayer + ", choose a square (1-9):");
            int pos;
            while (true) {
                String input = sc.nextLine();
                try {
                    pos = Integer.parseInt(input) - 1;
                    if (pos < 0 || pos > 8 || board[pos] == 'X' || board[pos] == 'O') {
                        System.out.println("Invalid move, try again:");
                    } else {
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a number between 1 and 9:");
                }
            }
            board[pos] = currentPlayer;
            moves++;
            printBoard(board);

            if (checkWin(board, currentPlayer)) {
                System.out.println("Player " + currentPlayer + " wins!");
                gameEnded = true;
            } else if (moves == 9) {
                System.out.println("It's a draw!");
                gameEnded = true;
            } else {
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            }
        }
    }

    public static void printBoard(char[] board) {
        System.out.println(
                "      |---|---|---|\n" +
                "      | " + board[0] + " | " + board[1] + " | " + board[2] + " |\n" +
                "      |-----------|\n" +
                "      | " + board[3] + " | " + board[4] + " | " + board[5] + " |\n" +
                "      |-----------|\n" +
                "      | " + board[6] + " | " + board[7] + " | " + board[8] + " |\n" +
                "      |---|---|---|"
        );
    }

    public static boolean checkWin(char[] b, char player) {
        // Rows, Columns, Diagonals
        int[][] lines = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
        for (int[] line : lines) {
            if (b[line[0]] == player && b[line[1]] == player && b[line[2]] == player)
                return true;
        }
        return false;
    }

    public static void numberGuesser(Scanner sc) {
        int number = 1 + (int)(10 * Math.random());
        int guess = 0;
        System.out.println("\nLet's play Number Guesser!");
        System.out.println("Guess the number between 1 and 10:");

        while (true) {
            try {
                guess = Integer.parseInt(sc.nextLine());
                if (guess == number) {
                    System.out.println("Correct! You guessed the number.");
                    break;
                } else if (guess < 1 || guess > 10) {
                    System.out.println("Number must be between 1 and 10. Try again:");
                } else {
                    System.out.println("Wrong guess. Try again:");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    public static void hangMan(Scanner sc) {
        String[] words = {"orange", "octopus", "game", "hangman", "platypus","minecraft"};
        String word = words[(int)(Math.random() * words.length)];
        Set<Character> guessed = new HashSet<>();
        int wrong = 0, maxWrong = 6;

        System.out.println("\nLet's play Hangman!");
        while (wrong < maxWrong) {
            boolean allGuessed = true;
            System.out.print("Word: ");
            for (char c : word.toCharArray()) {
                if (guessed.contains(c)) {
                    System.out.print(c + " ");
                } else {
                    System.out.print("_ ");
                    allGuessed = false;
                }
            }
            System.out.println();

            if (allGuessed) {
                System.out.println("Congratulations! You guessed the word: " + word);
                return;
            }

            System.out.print("Guess a letter: ");
            String input = sc.nextLine().toLowerCase();
            if (input.length() != 1 || !Character.isLetter(input.charAt(0))) {
                System.out.println("Enter a single letter.");
                continue;
            }
            char guess = input.charAt(0);
            if (guessed.contains(guess)) {
                System.out.println("Already guessed, try another letter.");
                continue;
            }
            guessed.add(guess);
            if (word.indexOf(guess) < 0) {
                wrong++;
                System.out.println("Wrong! Attempts left: " + (maxWrong - wrong));
                printHangman(wrong);
            }
        }
        System.out.println("GAME OVER! The word was " + word);
    }

    public static void printHangman(int wrong) {
        String[] stages = {
                "",
                "   |\n   |\n   |\n   |",
                "   ____________\n   |\n   |\n   |\n   |",
                "   ____________\n   |          _|_\n   |\n   |\n   |",
                "   ____________\n   |          _|_\n   |         /   \\\n   |        |     |\n   |         \\_ _/\n   |",
                "   ____________\n   |          _|_\n   |         /   \\\n   |        |     |\n   |         \\_ _/\n   |          _|_\n   |         / | \\",
                "   ____________\n   |          _|_\n   |         /   \\\n   |        |     |\n   |         \\_ _/\n   |          _|_\n   |         / | \\\n   |          / \\ \n___|___      /   \\"
        };
        System.out.println(stages[wrong]);
    }
}
