package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import baseball.domain.number.InputNumbers;
import baseball.domain.number.Number;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputNumbersTest {

  @Test
  @DisplayName("입력값이 숫자가 아닌 경우 예외가 발생한다.")
  void 입력값이_숫자가_아닌_경우_예외가_발생한다() {
    // given
    final var input = "abc";

    // when & then
    assertThrows(IllegalArgumentException.class, () -> InputNumbers.of(input));
  }

  @Test
  @DisplayName("입력값이 3자리의 수가 아닌 경우 예외가 발생한다.")
  void 입력값이_3자리의_수가_아닌_경우_예외가_발생한다() {
    // given
    final var input = "1234";

    // when & then
    assertThrows(IllegalArgumentException.class, () -> InputNumbers.of(input));
  }

  @Test
  @DisplayName("입력값에 중복이 있는 경우 예외가 발생한다.")
  void 입력값에_중복이_있는_경우_예외가_발생한다() {
    // given
    final var input = "112";

    // when & then
    assertThrows(IllegalArgumentException.class, () -> InputNumbers.of(input));
  }

  @Test
  @DisplayName("정상적으로 컬렉션을 생성한다.")
  void 정상적으로_컬렉션을_생성한다() {
    // given
    final var input = "123";
    final var inputNumbers = InputNumbers.of(input);

    // when & then
    assertThat(inputNumbers).isNotNull();
  }

  @Test
  @DisplayName("컬렉션에서 인덱스에 해당하는 숫자를 가져온다.")
  void 컬렉션에서_인덱스에_해당하는_숫자를_가져온다() {
    // given
    final var input = "123";
    final var inputNumbers = InputNumbers.of(input);

    // when
    final var number = inputNumbers.get(0);

    // then
    assertThat(number).isEqualTo(new Number(1));
  }
}
