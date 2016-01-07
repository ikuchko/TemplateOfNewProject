import org.junit.*;
import static org.junit.Assert.*;

public class RPSGameTest {

  @Test
  public void checkWinner_rockBeatsScissors_true() {
    RPSGame rpsGame = new RPSGame();
    assertEquals(true, rpsGame.checkWinner("Rock", "Scissors"));
  }

  @Test
  public void checkWinner_ScissorsBeatsRocks_false() {
    RPSGame rpsGame = new RPSGame();
    assertEquals(false, rpsGame.checkWinner("Scissors", "Rock"));
  }

  @Test
  public void checkWinner_rockBeatsPaper_false() {
    RPSGame rpsGame = new RPSGame();
    assertEquals(false, rpsGame.checkWinner("Rock", "Paper"));
  }

  @Test
  public void checkWinner_PaperBeatsRock_true() {
    RPSGame rpsGame = new RPSGame();
    assertEquals(true, rpsGame.checkWinner("Paper", "Rock"));
  }

  @Test
  public void checkWinner_ScissorsBeatsPaper_true() {
    RPSGame rpsGame = new RPSGame();
    assertEquals(true, rpsGame.checkWinner("Scissors", "Paper"));
  }

  @Test
  public void checkWinner_PaperBeatsScissors_false() {
    RPSGame rpsGame = new RPSGame();
    assertEquals(false, rpsGame.checkWinner("Paper", "Scissors"));
  }
}

 /*rock Scissors true
Scissors Rock  false
rock paper false
Paper Rock true
scissors paper true
paper scissors false
*/
