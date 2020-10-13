public class Game {
    private final UserCommunication userCommunication;
    private GameSettings gameSettings;
    private GameResult winnerChosen;
    private GameState gameState;

    public Game(UserCommunication userCommunication) {
        this.userCommunication = userCommunication;
    }

    public void start() {

        initialize();

        while (winnerChosen == GameResult.NO_WINNER) {
            // testy game state; 3 metody
            // game mockito;

            UserChoice userChoice = userCommunication.getUserChoice();
            if (userChoice == UserChoice.NEW_GAME) {
                initialize();
                continue;
            }
            if (userChoice == UserChoice.EXIT_GAME) {
                endGame();
                userCommunication.showLegend();
                continue;
            }
            Moves.ValidMove computerMove = Moves.computerMove();
            Moves.ValidMove playerMove = Moves.playerMove(userChoice);
            userCommunication.showComputerMove(computerMove);

            gameState.addRound(computerMove, playerMove);
            winnerChosen = gameState.selectWinner();

        }
        userCommunication.endWinnerNotify(winnerChosen);

    }



    private void initialize() {
        gameSettings = userCommunication.promptUserSettings();
        userCommunication.showLegend();

        winnerChosen = GameResult.NO_WINNER;
        gameState = new GameState(gameSettings.getNoOfRounds());
    }

    public void endGame() {
        if (userCommunication.acknowledgeEnd()) {
            System.exit(0);
        }
    }
}
