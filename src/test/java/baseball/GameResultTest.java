package baseball;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameResultTest {

  private Game game;

  @BeforeEach
  void createGame() {
    game = new Game();
  }

  @Test
  void isInputNumber1Or2() {
    assertDoesNotThrow(() -> game.setRestartOrQuitInput("1"));
    ;

  }

  @Test
  void isInputNumberNot1Nor2() {
    assertThrows(IllegalArgumentException.class, () -> game.setRestartOrQuitInput("3"));
  }

}
