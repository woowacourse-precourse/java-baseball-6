package baseball.domain.ball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.util.NumberPicker;
import java.util.ArrayDeque;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public final class BallNumbersTest {

  @DisplayName("모든 숫자가 위치, 값이 모두 일치하는 경우 strikeCount는 3이다.")
  @Test
  void strikeCountTest() {
    // given
    NumberPicker numberPicker = new FixedNumberPicker(new ArrayDeque<>(List.of(1, 2, 3)));
    final AnswerCreator answerCreator = new AnswerCreator(numberPicker);

    // when
    final BallNumbers answer = answerCreator.create();
    final BallNumbers guess = BallNumbers.of(List.of(1, 2, 3));

    // then
    assertThat(answer.getBallCount(guess)).isEqualTo(0);
    assertThat(answer.getStrikeCount(guess)).isEqualTo(3);
  }

  @DisplayName("모든 숫자가 위치는 다르지만 값은 존재하는 경우 ballCount는 3이다.")
  @Test
  void ballCountTest() {
    // given
    NumberPicker numberPicker = new FixedNumberPicker(new ArrayDeque<>(List.of(1, 2, 3)));
    final AnswerCreator answerCreator = new AnswerCreator(numberPicker);

    // when
    final BallNumbers answer = answerCreator.create();
    final BallNumbers guess = BallNumbers.of(List.of(2, 3, 1));

    // then
    assertThat(answer.getBallCount(guess)).isEqualTo(3);
    assertThat(answer.getStrikeCount(guess)).isEqualTo(0);
  }


  @DisplayName("모든 숫자가 일치하지 않는 경우 strikeCount, ballCount는 모두 0이다.")
  @Test
  void nothingTest() {
    // given
    NumberPicker numberPicker = new FixedNumberPicker(new ArrayDeque<>(List.of(1, 2, 3)));
    final AnswerCreator answerCreator = new AnswerCreator(numberPicker);

    // when
    final BallNumbers answer = answerCreator.create();
    final BallNumbers guess = BallNumbers.of(List.of(4, 5, 6));

    // then
    assertThat(answer.getBallCount(guess)).isEqualTo(0);
    assertThat(answer.getStrikeCount(guess)).isEqualTo(0);
  }

  @DisplayName("BallNumbers에 1~9 범위를 벗어나는 수가 들어가면 예외 발생")
  @Test
  void throwIfBallNumbersHaveNumbersOutOfRange() {
    // given
    final List<Integer> numbers = List.of(10, 11, 12);
    final List<Integer> numbers2 = List.of(0, -1, -2);

    // when
    // then
    assertThatThrownBy(
        () -> BallNumbers.of(numbers)
    )
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("BallNumbers는 1~9 사이의 3자리 수여야 합니다.");

    assertThatThrownBy(
        () -> BallNumbers.of(numbers2)
    )
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("BallNumbers는 1~9 사이의 3자리 수여야 합니다.");
  }

  @DisplayName("BallNumbers는 반드시 3자리 숫자를 가져야 하며, 아니면 예외 발생")
  @Test
  void test() {
    // given
    final List<Integer> numbers = List.of(1, 2);
    final List<Integer> numbers2 = List.of(1, 2, 3, 4);

    // when
    // then
    assertThatThrownBy(
        () -> BallNumbers.of(numbers)
    )
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("BallNumbers는 3자리로 이루어진 숫자여야 합니다.");

    assertThatThrownBy(
        () -> BallNumbers.of(numbers2)
    )
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("BallNumbers는 3자리로 이루어진 숫자여야 합니다.");
  }
}
