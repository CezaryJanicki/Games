import java.util.Scanner;

public class Game {
    private final UserCommunication userCommunication;

    public Game(UserCommunication userCommunication) {
        this.userCommunication = userCommunication;
    }

    public void start() {

        GameSettings gameSettings = this.userCommunication.promptUserSettings(); //this out
        userCommunication.showLegend();

        GameResult winnerChosen = GameResult.NO_WINNER;
        GameState gameState = new GameState(gameSettings.getNoOfRounds());


        while (winnerChosen == GameResult.NO_WINNER) {
            //... case n/ case x;
            //continue - case n;
            // pakiet serCommunication ; pakiet - review;
            // testy game state; 3 metody
            // game mockito;
            gameState.addRound(Moves.computerMove(), Moves.playerMove(userCommunication.getUserChoice()));
            winnerChosen = gameState.selectWinner();
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
