package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import baseball.domain.number.Number;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NumberTest {

  @Test
  @DisplayName("값이 1에서 9사이가 아닌 경우 예외가 발생한다.")
  void 값이_1에서_9사이가_아닌_경우_예외가_발생한다() {
    // given
    final var value = 0;

    // when & then
    assertThrows(IllegalArgumentException.class, () -> new Number(value));
  }

  @Test
  @DisplayName("두 수가 같은 수이면 참을 반환한다.")
  void 두_수가_같은_수이면_참을_반환한다() {
    // given
    final var number = new Number(1);
    final var sameNumber = new Number(1);

    // when & then
    assertThat(number.equals(sameNumber)).isTrue();
  }

  @Test
  @DisplayName("두 수가 다른 수이면 거짓을 반환한다.")
  void 두_수가_다른_수이면_거짓을_반환한다() {
    // given
    final var number = new Number(1);
    final var differentNumber = new Number(2);

    // when & then
    assertThat(number.equals(differentNumber)).isFalse();
  }
}
