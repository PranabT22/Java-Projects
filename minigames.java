 import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    System.out.println("Welcome to the 4 in 1 game!");

    Scanner myObj = new Scanner(System.in);
    String player;

    // Enter player name to keep score
    System.out.println("Enter Playername:");
    player = myObj.nextLine();
    System.out.println("Welcome to the game: " + player);

    ticTacToe();
    numberGuesser();
    hangMan();

    myObj.close();
  }

  public static void ticTacToe() {
    System.out.println("Choose a square for the O or X to be entered in:");
    System.out.println(
        "      |---|---|---|\n" +
        "      | 1 | 2 | 3 |\n" +
        "      |-----------|\n" +
        "      | 4 | 5 | 6 |\n" +
        "      |-----------|\n" +
        "      | 7 | 8 | 9 |\n" +
        "      |---|---|---|"
    );
  }

  public static void numberGuesser() {
    int number = 1 + (int)(10 * Math.random());
    Scanner sc = new Scanner(System.in);
    int guess = 0;

    System.out.println("Guess the number between 1 and 10:");

    while (guess != number) {
      try {
        guess = Integer.parseInt(sc.nextLine());
        if (guess == number) {
          System.out.println("Correct! You guessed the number.");
        } else {
          System.out.println("Wrong guess. Try again:");
        }
      } catch (NumberFormatException e) {
        System.out.println("Please enter a valid number.");
      }
    }

    sc.close();
  }

public static void hangMan() {
	System.out.println("GAME OVER!");
	System.out.println("   ____________");
	System.out.println("   |          _|_");
	System.out.println("   |         /   \\");
	System.out.println("   |        |     |");
	System.out.println("   |         \\_ _/");
	System.out.println("   |          _|_");
	System.out.println("   |         / | \\");
	System.out.println("   |          / \\ ");
	System.out.println("___|___      /   \\");
	System.out.println("GAME OVER! The word was ");
}
}

