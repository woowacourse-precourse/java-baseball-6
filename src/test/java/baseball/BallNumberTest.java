package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import util.validator.BallNumberValidator;

public class BallNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
    @DisplayName("1부터 9 옳은 값 검증")
    void validationRightValue(int number) {
        BallNumberValidator ballNumberValidator = BallNumberValidator.getInstance();
        Assertions.assertThat(ballNumberValidator.validate(number)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, 10, 11})
    @DisplayName("잘못된 입력 값 검증")
    void validationWrongValue(int number) {
        BallNumberValidator ballNumberValidator = BallNumberValidator.getInstance();
        Assertions.assertThatThrownBy(() -> ballNumberValidator.validate(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자 각각의 값은 1~9 이여야 합니다.");
    }
}
