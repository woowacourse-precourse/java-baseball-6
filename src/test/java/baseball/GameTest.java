package baseball;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class GameTest {

  @Test
  void returnStrike() {
    Game game = new Game();
    assertEquals(1, game.publicCalculateResult("135", "123"));
  }
}

