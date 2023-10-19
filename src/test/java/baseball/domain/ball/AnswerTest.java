package baseball.domain.ball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.domain.dto.GuessResult;
import baseball.util.NumberPicker;
import java.util.ArrayDeque;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public final class AnswerTest {

  @DisplayName("모든 숫자가 위치, 값이 모두 일치하는 경우 GuessResult의 strikeCount는 3이다.")
  @Test
  void strikeCountTest() {
    // given
    NumberPicker numberPicker = new FixedNumberPicker(new ArrayDeque<>(List.of(1, 2, 3)));
    final AnswerCreator answerCreator = new AnswerCreator(numberPicker);

    // when
    final Answer answer = answerCreator.create();
    final Guess guess = Guess.of(List.of(1, 2, 3));
    final GuessResult result = answer.guess(guess);

    // then
    assertThat(result.isThreeStrike()).isTrue();
    assertThat(result.strikeCount()).isEqualTo(3);
    assertThat(result.ballCount()).isEqualTo(0);
  }

  @DisplayName("모든 숫자가 위치는 다르지만 값은 존재하는 경우 ballCount는 3이다.")
  @Test
  void ballCountTest() {
    // given
    NumberPicker numberPicker = new FixedNumberPicker(new ArrayDeque<>(List.of(1, 2, 3)));
    final AnswerCreator answerCreator = new AnswerCreator(numberPicker);

    // when
    final Answer answer = answerCreator.create();
    final Guess guess = Guess.of(List.of(2, 3, 1));
    final GuessResult result = answer.guess(guess);

    // then
    assertThat(result.isThreeStrike()).isFalse();
    assertThat(result.strikeCount()).isEqualTo(0);
    assertThat(result.ballCount()).isEqualTo(3);
  }


  @DisplayName("모든 숫자가 일치하지 않는 경우 strikeCount, ballCount는 모두 0이다.")
  @Test
  void nothingTest() {
    // given
    NumberPicker numberPicker = new FixedNumberPicker(new ArrayDeque<>(List.of(1, 2, 3)));
    final AnswerCreator answerCreator = new AnswerCreator(numberPicker);

    // when
    final Answer answer = answerCreator.create();
    final Guess guess = Guess.of(List.of(4, 5, 6));
    final GuessResult result = answer.guess(guess);

    // then
    assertThat(result.isThreeStrike()).isFalse();
    assertThat(result.strikeCount()).isEqualTo(0);
    assertThat(result.ballCount()).isEqualTo(0);
  }

  @DisplayName("Guess 생성 시, 1~9 범위를 벗어나는 수가 들어가면 예외 발생")
  @Test
  void throwIfGuessHaveNumbersOutOfRange() {
    // given
    final List<Integer> numbers = List.of(10, 11, 12);
    final List<Integer> numbers2 = List.of(0, -1, -2);

    // when
    // then
    assertThatThrownBy(
        () -> Guess.of(numbers)
    )
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("BallNumbers는 1~9 사이의 3자리 수여야 합니다.");

    assertThatThrownBy(
        () -> Guess.of(numbers2)
    )
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("BallNumbers는 1~9 사이의 3자리 수여야 합니다.");
  }

  @DisplayName("Answer 생성 시, 1~9 범위를 벗어나는 수가 들어가면 예외 발생")
  @Test
  void throwIfAnswerHaveNumbersOutOfRange() {
    // given
    final List<Integer> numbers = List.of(10, 11, 12);
    final List<Integer> numbers2 = List.of(0, -1, -2);

    // when
    // then
    assertThatThrownBy(
        () -> Answer.of(numbers)
    )
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("BallNumbers는 1~9 사이의 3자리 수여야 합니다.");

    assertThatThrownBy(
        () -> Answer.of(numbers2)
    )
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("BallNumbers는 1~9 사이의 3자리 수여야 합니다.");
  }

  @DisplayName("Guess는 반드시 3자리 숫자를 가져야 하며, 아니면 예외 발생")
  @Test
  void guessMustHaveThreeNumbers() {
    // given
    final List<Integer> numbers = List.of(1, 2);
    final List<Integer> numbers2 = List.of(1, 2, 3, 4);

    // when
    // then
    assertThatThrownBy(
        () -> Guess.of(numbers)
    )
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("BallNumbers는 3자리로 이루어진 숫자여야 합니다.");

    assertThatThrownBy(
        () -> Guess.of(numbers2)
    )
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("BallNumbers는 3자리로 이루어진 숫자여야 합니다.");
  }

  @DisplayName("Answer는 반드시 3자리 숫자를 가져야 하며, 아니면 예외 발생")
  @Test
  void answerMustHaveThreeNumbers() {
    // given
    final List<Integer> numbers = List.of(1, 2);
    final List<Integer> numbers2 = List.of(1, 2, 3, 4);

    // when
    // then
    assertThatThrownBy(
        () -> Answer.of(numbers)
    )
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("BallNumbers는 3자리로 이루어진 숫자여야 합니다.");

    assertThatThrownBy(
        () -> Answer.of(numbers2)
    )
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("BallNumbers는 3자리로 이루어진 숫자여야 합니다.");
  }
}
