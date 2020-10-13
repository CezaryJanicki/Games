import java.util.HashMap;
import java.util.Map;

public class GameState {
    private final int noOfRounds;
    private int humanPoints = 0;
    private int computerPoints = 0;
    private int whichRound = 0;
    private static Map<Moves.ValidMoves, Moves.ValidMoves> winsWith = new HashMap<>();
        static {
            winsWith.put(Moves.ValidMoves.PAPER, Moves.ValidMoves.ROCK);
            winsWith.put(Moves.ValidMoves.SCISSORS, Moves.ValidMoves.PAPER);
            winsWith.put(Moves.ValidMoves.ROCK, Moves.ValidMoves.SCISSORS);
        }

    public GameState(int noOfRounds) {
        this.noOfRounds = noOfRounds;
    }

    public void addRound(Moves.ValidMoves computer, Moves.ValidMoves human) {

        if (winsWith.get(computer) == human) {
            computerPoints++;
        } else if (winsWith.get(human) == computer) {
            humanPoints++;
        }
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
        } else {
            return GameResult.NO_WINNER;
        }
    }
}
