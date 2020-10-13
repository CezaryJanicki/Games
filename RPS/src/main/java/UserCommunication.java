import java.util.Scanner;

public class UserCommunication {

    private final Scanner scan = new Scanner(System.in);

    public GameSettings promptUserSettings() {
        System.out.println("Please tell me your name: ");
        String firstName = scan.next();
        System.out.println("Welcome " + firstName);
        System.out.println("Please specify no of rounds for the game: ");
        int noOfRounds = scan.nextInt();

        return new GameSettings(firstName, noOfRounds);
    }

    public void showLegend() {
        System.out.println("How to play the game:");
        System.out.println(" 1 - Rock");
        System.out.println(" 2 - Paper");
        System.out.println(" 3 - Scissors");
        System.out.println(" x - End the game");
        System.out.println(" n - Start new game");
        System.out.println("Let's play the game.");
        System.out.println("Please provide your move:");
        System.out.println("1 for Rock, 2 for Paper, 3 for Scissors.");
    }

    public UserChoice getUserChoice() {
        switch (scan.next()) {
            case "1":
                return UserChoice.ROCK;
            case "2":
                return UserChoice.PAPER;
            case "3":
               return UserChoice.SCISSORS;
            case "x":
                return UserChoice.EXIT_GAME;
            case "n":
                return UserChoice.NEW_GAME;
            default:
                throw new IllegalArgumentException("Illegal Choice.");
        }
    }

    public void showGameResult(GameResult gameResult) {
        switch (gameResult) {
            case PLAYER_WINS:
                System.out.println("You have won the game, congratulations!");
            case COMPUTER_WINS:
                System.out.println("Computer has won the game, sorry.");
            case DRAW:
                System.out.println("It's a draw. Try again.");
            case NO_WINNER:
                System.out.println("No one won.");
            default:
                System.out.println("Wrong choice.");
        }
    }


    public boolean acknowledgeEnd() {
        System.out.println("Do you really want to end the game?");
        System.out.println("Press y for yes, n for no.");
        while (true) {
            switch (scan.next()) {
                case "y":
                    return true;
                case "n":
                    return false;
                default:
                    System.out.println("Please choose an option");
            }
        }
    }

    public void showComputerMove(Moves.ValidMove computerMove) {
        System.out.println("Computer has chosen a move");
        System.out.println(computerMove);
    }

    public void endWinnerNotify(GameResult winnerChosen) {
        System.out.println("Winner of the whole game is " + winnerChosen);
    }
}
