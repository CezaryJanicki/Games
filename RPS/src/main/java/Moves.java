import java.util.Random;

public class Moves {

    enum ValidMoves {
        ROCK,
        PAPER,
        SCISSORS;
    }

    public static ValidMoves playerMove(int move) {
        if (move == 1) return ValidMoves.ROCK;
        if (move == 2) return ValidMoves.PAPER;
        if (move == 3) return ValidMoves.SCISSORS;
    }

    public static ValidMoves computerMove() {
        Random randomMove = new Random();
        return ValidMoves.values()[randomMove.nextInt(ValidMoves.values().length)];
    }

}
