package baseball;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class GameTest {

  @Test
  void returnStrike() {
    Game game = new Game();
    assertEquals("1볼 1스트라이크", game.publicCalculateResult("589", "597"));
  }
}

