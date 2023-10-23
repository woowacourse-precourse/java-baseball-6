package baseball.util;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ValidatorTest {
    @ParameterizedTest
    @DisplayName("플레이어가 서로 다른 3자리 수를 입력하면 정상 작동한다.")
    @ValueSource(strings = {"123", "234", "345", "456", "789"})
    void validateInputNumbers_숫자_입력_정상작동_테스트(String numbers) {
        assertThatCode(() -> Validator.validateInputNumbers(numbers))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @DisplayName("정확히 3개의 숫자를 입력하지 않으면 예외가 발생한다.")
    @ValueSource(strings = {"", " ", "1", "12", "1234"})
    void isValidNumbersLength_숫자_개수_예외처리_테스트(String numbers) {
        assertThatThrownBy(() -> Validator.validateNumbersLength(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("숫자가 아닌 값을 입력하면 예외가 발생한다.")
    @ValueSource(strings = {"abc", "가나다", "1a2"})
    void isValidNumbersType_숫자_자료형_예외처리_테스트(String numbers) {
        assertThatThrownBy(() -> Validator.validateNumbersType(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("1보다 작은 값이 포함되었다면 예외가 발생한다.")
    @ValueSource(strings = {"012", "-112", "001"})
    void isValidNumbersRange_숫자_범위_예외처리_테스트(String numbers) {
        assertThatThrownBy(() -> Validator.validateNumbersRange(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("중복된 숫자를 입력하면 예외가 발생한다.")
    @ValueSource(strings = {"333", "222", "111"})
    void isDuplicate_숫자_중복_예외처리_테스트(String numbers) {
        assertThatThrownBy(() -> Validator.validateNoDuplicate(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("1 또는 2를 입력하면 정상 작동한다.")
    @ValueSource(strings = {"1", "2", "2", "1"})
    void validateRestartOrExitNumber_재시작_또는_종료_정상작동_테스트(String numbers) {
        assertThatCode(() -> Validator.validateRestartOrExitNumber(numbers))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @DisplayName("숫자가 아닌 종료 문자를 입력하면 예외가 발생한다.")
    @ValueSource(strings = {"a", "가", "b"})
    void isValidRestartOrExitNumberType_재시작_또는_종료_숫자_자료형_예외처리_테스트(String numbers) {
        assertThatThrownBy(() -> Validator.validateRestartOrExitNumberType(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("1 또는 2가 아닌 숫자를 입력하면 예외가 발생한다.")
    @ValueSource(strings = {"0", "3", "123"})
    void isValidRestartOrExitNumber_재시작_또는_종료_숫자_일치_여부_예외처리_테스트(String numbers) {
        assertThatThrownBy(() -> Validator.validateRestartOrExitNumberValue(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }
}