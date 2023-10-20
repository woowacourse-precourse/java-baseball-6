package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import util.validator.BallIndexValidator;


public class BallIndexTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("옳은 인덱스 값 검증")
    void validationRightValue(int number) {
        //given
        BallIndexValidator ballIndexValidator = BallIndexValidator.getInstance();
        //when
        boolean result = ballIndexValidator.validate(number);
        //then
        Assertions.assertThat(result).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, 4})
    @DisplayName("옳은 인덱스 값 검증")
    void validationWrongValue(int number) {
        //given
        BallIndexValidator ballIndexValidator = BallIndexValidator.getInstance();
        //then
        Assertions.assertThatThrownBy(() -> ballIndexValidator.validate(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("공의 인덱스는 1 - 3 이여야 합니다.");
    }

}
