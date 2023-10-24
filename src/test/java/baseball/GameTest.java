package baseball;

import static baseball.NumberBaseballGame.computeResultMessage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameTest {

  @Test
  @DisplayName("3스트라이크 테스트")
  void 스트라이크_테스트() {
    String userInput = "123";
    String computerBalls = "123";

    Assertions.assertEquals(computeResultMessage(userInput, computerBalls), "3스트라이크");
  }

  @Test
  @DisplayName("볼 스트라이크 출력 테스트")
  void 볼_스트라이크_테스트() {
    String userInput = "123";
    String computerBalls = "134";
    Assertions.assertEquals(computeResultMessage(userInput, computerBalls), "1볼 1스트라이크");
  }

  @Test
  @DisplayName("볼 테스트")
  void 볼_테스트() {
    String userInput = "123";
    String computerBalls = "415";
    Assertions.assertEquals(computeResultMessage(userInput, computerBalls), "1볼");

  }

}
