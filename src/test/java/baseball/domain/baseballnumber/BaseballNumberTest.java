package baseball.domain.baseballnumber;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("[BaseballNumberTest]")
class BaseballNumberTest {

    private static final String ERROR_MESSAGE_INVALID_RANGE = "1에서 9 사이의 수만 입력할 수 있습니다.";

    @Test
    @DisplayName("정수로 생성 가능하다.")
    void construct() {
        // given
        int value = 3;

        // when
        BaseballNumber baseballNumber = new BaseballNumber(value);

        // then
        assertThat(baseballNumber.value()).isEqualTo(value);
    }

    @ParameterizedTest(name = "[{index}] : {0}")
    @ValueSource(ints = {-1, 0, 10})
    @DisplayName("1과 9 사이에 있지 않는 수를 입력하였을 때 IllegalArgumentException발생한다.")
    void throwIllegalArgumentExceptionWhenConstructedByInvalidInputs(final int input) {
        // when, then
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
            () -> new BaseballNumber(input));
        assertThat(e.getMessage()).isEqualTo(ERROR_MESSAGE_INVALID_RANGE);
    }

    @Test
    @DisplayName("값이 같은 경우 equals()가 true를 반한한다.")
    void equalsReturnTrueWhenHasSameValue() {
        // given
        int input = 3;
        BaseballNumber baseballNumber1 = new BaseballNumber(input);
        BaseballNumber baseballNumber2 = new BaseballNumber(input);

        // when
        boolean result = baseballNumber1.equals(baseballNumber2);

        // then
        assertThat(result).isEqualTo(true);
    }
}