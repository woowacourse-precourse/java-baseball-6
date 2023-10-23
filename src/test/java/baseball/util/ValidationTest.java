package baseball.util;

import static baseball.util.Validation.MAX_INPUT_LENGTH;
import static baseball.util.Validation.containsLetter;
import static baseball.util.Validation.containsZero;
import static baseball.util.Validation.validLength;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class ValidationTest {

    @Test
    void 문자열_0_포함_테스트() {
        String[] testArr = {"102", "012", "120"};

        for (String str : testArr) {
            assertThatThrownBy(() -> containsZero(str)).isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Test
    void 문자열_숫자여부_테스트() {
        String[] testArr = {"ㅁㅈa", "a32", "abc", "a2c"};

        for (String str : testArr) {
            assertThatThrownBy(() -> containsLetter(str, MAX_INPUT_LENGTH)).isInstanceOf(
                    IllegalArgumentException.class);
        }
    }

    @Test
    void 문자열_유효길이_테스트() {
        String[] testArr = {"1234", "12345", "123456", "1234567", "12345678", "123456789"};

        for (String str : testArr) {
            assertThatThrownBy(() -> validLength(str, MAX_INPUT_LENGTH)).isInstanceOf(
                    IllegalArgumentException.class);
        }
    }
}