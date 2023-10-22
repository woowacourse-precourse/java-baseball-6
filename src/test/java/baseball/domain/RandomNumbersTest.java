package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.domain.number.RandomNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandomNumbersTest {

  @Test
  @DisplayName("정상적으로 컬렉션을 생성한다.")
  void 정상적으로_컬렉션을_생성한다() {
    // given
    final var randomNumbers = RandomNumbers.create();

    // when & then
    assertThat(randomNumbers).isNotNull();
  }

  @Test
  @DisplayName("주어진 숫자가 컬렉션에 포함되어 있을 때 참을 반환한다.")
  void 주어진_숫자가_컬렉션에_포함되어_있을_때_참을_반환한다() {
    // given
    final var randomNumbers = RandomNumbers.create();
    final var number = randomNumbers.get(0);

    // when
    final var contains = randomNumbers.contains(number);

    // then
    assertThat(contains).isTrue();
  }

  @Test
  @DisplayName("컬렉션에서 인덱스에 해당하는 숫자를 가져온다.")
  void 컬렉션에서_인덱스에_해당하는_숫자를_가져온다() {
    // given
    final var randomNumbers = RandomNumbers.create();

    // when
    final var number = randomNumbers.get(0);

    // then
    assertThat(number).isNotNull();
  }
}
