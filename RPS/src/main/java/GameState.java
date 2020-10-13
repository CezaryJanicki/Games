import java.util.HashMap;
import java.util.Map;

public class GameState {
    private final int noOfRounds;
    private int humanPoints = 0;
    private int computerPoints = 0;
    private int whichRound = 0;
    private static Map<Moves.ValidMove, Moves.ValidMove> winsWith = new HashMap<>();
        static {
            winsWith.put(Moves.ValidMove.PAPER, Moves.ValidMove.ROCK);
            winsWith.put(Moves.ValidMove.SCISSORS, Moves.ValidMove.PAPER);
            winsWith.put(Moves.ValidMove.ROCK, Moves.ValidMove.SCISSORS);
        }

    public GameState(int noOfRounds) {
        this.noOfRounds = noOfRounds;
    }

    public void addRound(Moves.ValidMove computer, Moves.ValidMove human) {

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
