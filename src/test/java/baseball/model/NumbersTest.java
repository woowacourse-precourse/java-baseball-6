package baseball.model;

import static org.assertj.core.api.Assertions.assertThatCode;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class NumbersTest {

    @Test
    void validateScope_잘못된범위인_숫자가있다면_예외처리() {
        List<Integer> numbers = List.of(3, 10, 7);
        Assertions.assertThatThrownBy(() -> new Numbers(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자 범위에 포함되지 않는 숫자가 있습니다 [3, 10, 7]");

    }

    @Test
    void validateDistict_중복된숫자가있다면_예외처리() {
        List<Integer> numbers = List.of(3, 7, 7);
        Assertions.assertThatThrownBy(() -> new Numbers(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 정상생성() {
        List<Integer> numbers = List.of(3, 7, 5);
        assertThatCode(() -> new Numbers(numbers))
                .doesNotThrowAnyException();
    }
}