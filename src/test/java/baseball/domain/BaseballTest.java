package baseball.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Baseball 단위 테스트")
class BaseballTest {

    @DisplayName("정상 상황일 때 숫자 야구가 생성된다.")
    @Test
    void create_baseball() {
        List<Integer> numbers = List.of(1, 2, 3);
        Baseball baseball = new Baseball(numbers);
        Assertions.assertThat(baseball).isNotNull();
    }

    @DisplayName("길이가 3이상일 때 예외가 발생한다.")
    @Test
    void throw_exception_when_length_exceeds_than_expected() {
        List<Integer> numbers = List.of(1, 2, 3, 4);
        assertThatThrownBy(() ->
                new Baseball(numbers)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("길이가 3미만일 때 예외가 발생한다.")
    @Test
    void throw_exception_when_length_less_than_expected() {
        List<Integer> numbers = List.of(1, 2);
        assertThatThrownBy(() ->
                new Baseball(numbers)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("0이 포함된 경우 예외가 발생한다.")
    @Test
    void throw_exception_when_zero_contained() {
        List<Integer> numbers = List.of(0, 1, 2);
        assertThatThrownBy(() ->
                new Baseball(numbers)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("중복 숫자가 있을 경우 예외가 발생한다.")
    @Test
    void throw_exception_when_numbers_duplicated() {
        List<Integer> numbers = List.of(1, 2, 2);
        assertThatThrownBy(() ->
                new Baseball(numbers)).isInstanceOf(IllegalArgumentException.class);
    }
}
