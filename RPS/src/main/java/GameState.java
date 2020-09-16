public class GameState {
    private final int noOfRounds;
    private int humanPoints;
    private int computerPoints;
    private int whichRound;


    public GameState(int noOfRounds) {
        this.noOfRounds = noOfRounds;
    }

    public void addRound(Moves.ValidMoves computer, Moves.ValidMoves human) {
        whichRound++;

    }

    public GameResult selectWinner() {
        if (whichRound < noOfRounds) {
            return GameResult.NO_WINNER;
        }
        if (humanPoints > computerPoints) return { GameResult.PLAYER_WINS }
            else if (humanPoints < ...)
    }

    public resetGame() {
        humanPoints = 0;
        computerPoints = 0;
        whichRound = 0;
    }
}
