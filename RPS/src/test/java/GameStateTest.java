import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameStateTest {
    @Test
    public void shouldScissorsWinWithPaper() {
        //Given
        GameState gameState = new GameState(1);
        //When
        gameState.addRound(Moves.ValidMove.SCISSORS, Moves.ValidMove.PAPER);
        //Then
        assertEquals(GameResult.COMPUTER_WINS, gameState.selectWinner());
    }

    @Test
    public void shouldRockWinWithScissors() {
        //Given
        GameState gameState = new GameState(1);
        //When
        gameState.addRound(Moves.ValidMove.ROCK, Moves.ValidMove.SCISSORS);
        //Then
        assertEquals(GameResult.COMPUTER_WINS, gameState.selectWinner());
    }

    @Test
    public void shouldPaperWinWithRock() {
        //Given
        GameState gameState = new GameState(1);
        //When
        gameState.addRound(Moves.ValidMove.PAPER, Moves.ValidMove.ROCK);
        //Then
        assertEquals(GameResult.COMPUTER_WINS, gameState.selectWinner());
    }

    @Test
    public void shouldScissorsWinWithPaperInSecondRound() {
        //Given
        GameState gameState = new GameState(2);
        //When
        gameState.addRound(Moves.ValidMove.SCISSORS, Moves.ValidMove.PAPER);
        //Then
        assertEquals(GameResult.NO_WINNER, gameState.selectWinner());
        //When
        gameState.addRound(Moves.ValidMove.SCISSORS, Moves.ValidMove.PAPER);
        //Then
        assertEquals(GameResult.COMPUTER_WINS, gameState.selectWinner());
    }

    @Test
    public void shouldThereBeDraw() {
        //Given
        GameState gameState = new GameState(2);
        //When
        gameState.addRound(Moves.ValidMove.PAPER, Moves.ValidMove.PAPER);
        gameState.addRound(Moves.ValidMove.SCISSORS, Moves.ValidMove.SCISSORS);
        //Then
        assertEquals(GameResult.DRAW, gameState.selectWinner());
    }

}