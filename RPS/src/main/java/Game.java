
import java.util.Scanner;

public class Game {
    public void start() {
        System.out.println("Please tell me your name: ");
        Scanner scan = new Scanner(System.in);
        //String firstName = scan.nextLine();
        //System.out.println("Welcome " + firstName);
        System.out.println("Please specify no of rounds for the game: ");
       // int noOfRounds = scan.nextInt();
        System.out.println("How to play the game:");
        System.out.println(" 1 - Rock");
        System.out.println(" 2 - Paper");
        System.out.println(" 3 - Scissors");
        System.out.println(" x - End the game");
        System.out.println(" n - Start new game");

        //String choice = scan.next();

        System.out.println("Let's play the game.");
        System.out.println("Please provide your move:");
        System.out.println("1 for Rock, 2 for Paper, 3 for Scissors.");
        int choice = scan.nextInt();

        Moves.playerMove(choice);
        Moves.computerMove();

        switch (scan.next()) {
            case "1":
                System.out.println("Pressing 1 gives Rock.");
                break;
            case "2":
                System.out.println("Pressing 2 gives Paper.");
                break;
            case "3":
                System.out.println("Pressing 3 gives Scissors.");
                break;
            case "x":
                System.out.println("Pressing x - ends the game.");
                break;
            case "n":
                System.out.println("Pressing n - starts new game");
                break;
            default:
                System.out.println("Default");
        }
    }

    public void startNewGame() {
        System.out.println("Do you really want to end the actual game?");
        this.start();
    }

    public void endGame() {
        System.out.println("Do you really want to end the game?");
        System.out.println("Press y for yes, n for no.");
        Scanner scan = new Scanner(System.in);
        switch (scan.next()) {
            case "y":
                System.out.println("The game has ended.");
            case "n":
                System.out.println("The game continues.");
                this.start();
            default:
                System.out.println("Please choose an option");
                this.endGame();
        }
    }
}
      //  klawisz x - zakończenie gry, poprzedzone pytaniem "Czy na pewno zakończyć grę?",
      //  klawisz n - uruchomienie gry od nowa, poprzedzone pytaniem "Czy na pewno zakończyć aktualną grę?",
