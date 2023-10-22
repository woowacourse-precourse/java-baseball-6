package baseball;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameTest {

  @Test
  @DisplayName("3스트라이크 테스트")
  void 스트라이크_테스트() {
    String answer = "123";
    String input = "123";
    Assertions.assertEquals(NumberBaseball.baseballGame(input, answer), "3스트라이크");
  }

  @Test
  @DisplayName("볼 스트라이크 출력 테스트")
  void 볼_스트라이크_테스트() {
    String answer = "123";
    String input = "413";
    Assertions.assertEquals(NumberBaseball.baseballGame(input, answer), "1볼 1스트라이크");
  }

  @Test
  @DisplayName("볼 테스트")
  void 볼_테스트() {
    String answer = "123";
    String input = "279";
    Assertions.assertEquals(NumberBaseball.baseballGame(input, answer), "1볼");

  }

}
