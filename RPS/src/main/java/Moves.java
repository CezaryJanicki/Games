import java.util.Random;

public class Moves {

    enum ValidMoves {
        ROCK,
        PAPER,
        SCISSORS;
    }

    public static ValidMoves playerMove(UserChoice move) {
        if (move == UserChoice.ROCK) return ValidMoves.ROCK;
        if (move == UserChoice.PAPER) return ValidMoves.PAPER;
        if (move == UserChoice.SCISSORS) return ValidMoves.SCISSORS;
    }

    public static ValidMoves computerMove() {
        Random randomMove = new Random();
        return ValidMoves.values()[randomMove.nextInt(ValidMoves.values().length)];
    }

}
