public class GameState {
    private final int noOfRounds;
    private int humanPoints = 0;
    private int computerPoints = 0;
    private int whichRound = 0;


    public GameState(int noOfRounds) {
        this.noOfRounds = noOfRounds;
    }

    public void addRound(Moves.ValidMoves computer, Moves.ValidMoves human) {
        if (computer == Moves.ValidMoves.PAPER && human == Moves.ValidMoves.ROCK) { computerPoints++; }
        if (computer == Moves.ValidMoves.ROCK && human == Moves.ValidMoves.SCISSORS) { computerPoints++; }
        if (computer == Moves.ValidMoves.SCISSORS && human == Moves.ValidMoves.PAPER) { computerPoints++; }
        if (computer == Moves.ValidMoves.PAPER && human == Moves.ValidMoves.SCISSORS) { humanPoints++; }
        if (computer == Moves.ValidMoves.ROCK && human == Moves.ValidMoves.PAPER) { humanPoints++; }
        if (computer == Moves.ValidMoves.SCISSORS && human == Moves.ValidMoves.ROCK) { humanPoints++; }
        whichRound++;
    }

    public GameResult selectWinner() {
        if (whichRound < noOfRounds) {
            return GameResult.NO_WINNER;
        } else if (humanPoints > computerPoints) {
            return GameResult.PLAYER_WINS;
        } else if (humanPoints < computerPoints) {
            return GameResult.COMPUTER_WINS;
        } else if (humanPoints == computerPoints) {
            return GameResult.DRAW;
        } else
            return GameResult.NO_WINNER;
    }

    public void resetGame() {
        humanPoints = 0;
        computerPoints = 0;
        whichRound = 0;
    }
}
