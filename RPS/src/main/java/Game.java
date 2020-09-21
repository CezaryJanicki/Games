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
            gameState.addRound(Moves.computerMove(), Moves.playerMove(userChoice));
            winnerChosen = gameState.selectWinner();

        }
        System.out.println("Winner of the whole game is " + winnerChosen);

    }

    private void initialize() {
        gameSettings = userCommunication.promptUserSettings();
        userCommunication.showLegend();

        winnerChosen = GameResult.NO_WINNER;
        gameState = new GameState(gameSettings.getNoOfRounds());
    }

    public void startNewGame() {
        System.out.println("Starting new game.");
        //this.start();
    }

    public void endGame() {
        if (userCommunication.acknowledgeEnd()) {
            System.exit(0);
        }
    }
}
