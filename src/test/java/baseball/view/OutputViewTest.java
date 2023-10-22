package baseball.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OutputViewTest {

  private final ByteArrayOutputStream output = new ByteArrayOutputStream();
  private final OutputView outputView = new OutputView();

  @BeforeEach
  void setUpStreams() {
    System.setOut(new PrintStream(output));
  }

  @AfterEach
  void restoreStreams() {
    System.setOut(System.out);
  }

  @Test
  @DisplayName("게임 시작 메시지를 출력한다.")
  void 게임_시작_메시지를_출력한다() {
    // given
    final var expected = "숫자 야구 게임을 시작합니다.\n";

    // when
    outputView.printGameStartMessage();

    // then
    assertThat(output.toString()).isEqualTo(expected);
  }

  @Test
  @DisplayName("게임 결과 메시지를 출력한다.")
  void 게임_결과_메시지를_출력한다() {
    // given
    final var expected = "1볼 1스트라이크\n";

    // when
    outputView.printGameResultMessage("1볼 1스트라이크");

    // then
    assertThat(output.toString()).isEqualTo(expected);
  }

  @Test
  @DisplayName("게임 종료 메시지를 출력한다.")
  void 게임_종료_메시지를_출력한다() {
    // given
    final var expected = "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n";

    // when
    outputView.printGameEndMessage();

    // then
    assertThat(output.toString()).isEqualTo(expected);
  }
}
