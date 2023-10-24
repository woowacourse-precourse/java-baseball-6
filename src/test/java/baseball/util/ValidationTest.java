package baseball.util;

import static baseball.util.Validation.MAX_INPUT_LENGTH;
import static baseball.util.Validation.containsLetter;
import static baseball.util.Validation.containsZero;
import static baseball.util.Validation.duplicateNumber;
import static baseball.util.Validation.isOneOrTwo;
import static baseball.util.Validation.validExitNumber;
import static baseball.util.Validation.validLength;
import static baseball.util.Validation.validNumber;
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

    @Test
    void 문자열_중복된_숫자_존재여부_테스트() {
        String[] testArr = {"111", "122", "144", "332", "311", "969"};

        for (String str : testArr) {
            assertThatThrownBy(() -> duplicateNumber(str)).isInstanceOf(
                    IllegalArgumentException.class);
        }
    }

    @Test
    void 문자열_1_또는_2_여부_테스트() {
        String[] testArr = {"0", "3", "4", "5", "6", "7", "8", "9"};

        for (String str : testArr) {
            assertThatThrownBy(() -> isOneOrTwo(str)).isInstanceOf(
                    IllegalArgumentException.class);
        }
    }

    @Test
    void 게임_미허용_입력값_테스트() {
        String[] testArr = {"1234", "112", "1a2", "2", "abc", "ㅁㅊㄷ"};

        for (String str : testArr) {
            assertThatThrownBy(() -> validNumber(str)).isInstanceOf(
                    IllegalArgumentException.class);
        }
    }

    @Test
    void 게임_종료여부_미허용_입력값_테스트() {
        String[] testArr = {"3", "1234", "1a2", "4", "a", "ㅁ"};

        for (String str : testArr) {
            assertThatThrownBy(() -> validExitNumber(str)).isInstanceOf(
                    IllegalArgumentException.class);
        }
    }
}