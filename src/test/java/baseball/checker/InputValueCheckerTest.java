package baseball.checker;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static baseball.checker.InputValueChecker.*;
import static org.assertj.core.api.Assertions.*;

@DisplayName("InputValueChecker 테스트")
public class InputValueCheckerTest {
    @Nested
    @DisplayName("사용자로부터 입력 받은 값의 유효성을 파악한다")
    public class checkNumberValidationTest {
        private final String errorLength = "1234";
        private final String errorDup = "111";
        private final String errorStart0 = "012";

        @Test
        @DisplayName("사용자가 입력한 값이 3자리 수가 아닌 경우, 오류를 반환한다")
        public void throwExceptionByValueLength() {
            // when - then
            assertThatThrownBy(() -> checkNumberValidation(errorLength))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("사용자가 중복되는 숫자를 입력하는 경우, 오류를 반환한다")
        public void throwExceptionByDuplicateNumber() {
            // when - then
            assertThatThrownBy(() -> checkNumberValidation(errorDup))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("사용자가 입력한 3자리의 수가 0으로 시작하는 경우, 오류를 반환한다")
        public void throwExceptionByStartWithZero() {
            // when - then
            assertThatThrownBy(() -> checkNumberValidation(errorStart0))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    @DisplayName("사용자로부터 입력 받은 신호의 유효성을 파악한다")
    public class checkSignalValidationTest {
        private final String errorSignal = "3";

        @Test
        @DisplayName("사용자가 입력한 값이 1 혹은 2가 아닌 경우, 오류를 반환한다")
        public void throwExceptionByInvalidValue() {
            // when - then
            assertThatThrownBy(() -> checkSignalValidation(errorSignal))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    @DisplayName("사용자로부터 입력 받은 값에 중복이 존재하는지 확인한다")
    public class checkDuplicationTest {
        private final String notDupValue = "123";
        private final String dupValue = "111";

        @Test
        @DisplayName("중복된 값이 존재하는 경우, false를 반환한다")
        public void returnFalseByDuplicateValue() {
            // when - then
            assertThat(checkDuplication(dupValue)).isFalse();
        }

        @Test
        @DisplayName("중복되는 값이 없는 경우, true를 반환한다")
        public void success() {
            // when - then
            assertThat(checkDuplication(notDupValue)).isTrue();
        }
    }
}