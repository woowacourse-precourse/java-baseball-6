package baseball.util;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ValidatorTest {
    @ParameterizedTest
    @DisplayName("플레이어가 1 이상 9이하의 서로 다른 3자리 수를 입력하면 정상 작동한다.")
    @ValueSource(strings = {"123", "234", "345", "456", "789"})
    void validateInputNumbers_숫자_입력_정상작동_테스트(String numbers) {
        assertThatCode(() -> Validator.validateInputNumbers(numbers))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @DisplayName("플레이어가 1 이상 9이하의 서로 다른 3자리 수를 입력하지 않으면 예외가 발생한다.")
    @ValueSource(strings = {"", " ", "1", "12", "1234", "abc", "가나다", "1a2", "012", "-112", "001", "111", "222", "333"})
    void isValidNumbersLength_숫자_입력_예외처리_테스트(String numbers) {
        assertThatThrownBy(() -> Validator.validateInputNumbers(numbers))
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
    @DisplayName("1 또는 2가 아닌 종료 문자를 입력하면 예외가 발생한다.")
    @ValueSource(strings = {"a", "가", "b", "0", "3", "123"})
    void isValidRestartOrExitNumberType_재시작_또는_종료_숫자_예외처리_테스트(String numbers) {
        assertThatThrownBy(() -> Validator.validateRestartOrExitNumber(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }
}