import java.util.Random;

public class Moves {

    enum ValidMove {
        ROCK,
        PAPER,
        SCISSORS;
    }

    public static ValidMove playerMove(UserChoice move) {
        System.out.println("Player has chosen " + move);
        if (move == UserChoice.ROCK) {
            return ValidMove.ROCK;
        } else if (move == UserChoice.PAPER) {
            return ValidMove.PAPER;
        } else return ValidMove.SCISSORS;
    }

    public static ValidMove computerMove() {
        Random randomMove = new Random();
        ValidMove computerMove = ValidMove.values()[randomMove.nextInt(ValidMove.values().length)];

        return computerMove;
    }

}
