import java.sql.SQLOutput;
import java.util.Random;

public class Moves {

    enum ValidMoves {
        ROCK,
        PAPER,
        SCISSORS;
    }

    public static ValidMoves playerMove(UserChoice move) {
        System.out.println("Player has chosen " + move);
        if (move == UserChoice.ROCK) {
            return ValidMoves.ROCK;
        } else if (move == UserChoice.PAPER) {
            return ValidMoves.PAPER;
        } else return ValidMoves.SCISSORS;
    }

    public static ValidMoves computerMove() {
        Random randomMove = new Random();
        ValidMoves computerMove = ValidMoves.values()[randomMove.nextInt(ValidMoves.values().length)];
        System.out.println("Computer has chosen a move");
        System.out.println(computerMove);
        return computerMove;
    }

}
