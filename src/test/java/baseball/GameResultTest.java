package baseball;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
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
    game.setRestartOrQuitInput("1");
    assertTrue(game.inputArrList.contains(game.restartOrQuitInput));

  }

  @Test
  void isInputNumberNot1Nor2() {
    Assertions.assertThrows(IllegalArgumentException.class, () -> {
      game.setRestartOrQuitInput("3");
    });
  }


}
