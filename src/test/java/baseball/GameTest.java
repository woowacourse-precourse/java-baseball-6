package baseball;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GameTest {

  private Game game;

  @BeforeEach
  public void setUp() {
    game = new Game();
  }

  @Test
  void getStrikeCount_allStrikes() {
    String randomNumber = "123";
    String userNumber = "123";
    assertEquals(3, game.getStrikeCount(randomNumber, userNumber));
  }

  @Test
  void getStrikeCount_noStrikes() {
    String randomNumber = "123";
    String userNumber = "456";
    assertEquals(0, game.getStrikeCount(randomNumber, userNumber));
  }

  @Test
  void getNothing() {
    assertEquals("낫싱", game.publicCalculateResult("589", "601"));
  }

  @Test
  void getStrike() {
    assertEquals("2스트라이크", game.publicCalculateResult("605", "601"));
  }

  @Test
  void getBall() {
    assertEquals("3볼", game.publicCalculateResult("123", "231"));
  }

  @Test
  void returnstrikeandball() {
    assertEquals("2볼 1스트라이크", game.publicCalculateResult("123", "132"));
  }
}

