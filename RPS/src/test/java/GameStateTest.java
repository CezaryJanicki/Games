
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class GameStateTest {
    @Test
    public void shouldScissorsWinWithPaper() {
        //Given
        GameState gameState = new GameState(1);
        //When
        gameState.addRound(Moves.ValidMoves.SCISSORS, Moves.ValidMoves.PAPER);
        //Then
        assertEquals(GameResult.COMPUTER_WINS, gameState.selectWinner());
    }

    @Test
    public void shouldRockWinWithScissors() {
        //Given
        GameState gameState = new GameState(1);
        //When
        gameState.addRound(Moves.ValidMoves.ROCK, Moves.ValidMoves.SCISSORS);
        //Then
        assertEquals(GameResult.COMPUTER_WINS, gameState.selectWinner());
    }

    @Test
    public void shouldPaperWinWithRock() {
        //Given
        GameState gameState = new GameState(1);
        //When
        gameState.addRound(Moves.ValidMoves.PAPER, Moves.ValidMoves.ROCK);
        //Then
        assertEquals(GameResult.COMPUTER_WINS, gameState.selectWinner());
    }

    @Test
    public void shouldScissorsWinWithPaperInSecondRound() {
        //Given
        GameState gameState = new GameState(2);
        //When
        gameState.addRound(Moves.ValidMoves.SCISSORS, Moves.ValidMoves.PAPER);
        //Then
        assertEquals(GameResult.NO_WINNER, gameState.selectWinner());
        //When
        gameState.addRound(Moves.ValidMoves.SCISSORS, Moves.ValidMoves.PAPER);
        //Then
        assertEquals(GameResult.COMPUTER_WINS, gameState.selectWinner());
    }

//3pary
}