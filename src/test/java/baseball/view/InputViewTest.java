package baseball.view;

import baseball.util.Validation;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputViewTest {
    @ParameterizedTest
    @DisplayName("빈값 입력 예외 테스트")
    @ValueSource(strings = {"", " ", "  ", "   "})
    void invalidInputsTest1(String input) {
        Assertions.assertThatThrownBy(() -> Validation.isEmpty(input)).
                isInstanceOf(IllegalArgumentException.class)
                .hasMessage("값을 입력해 주세요.");
    }

    @ParameterizedTest
    @DisplayName("세 자리 숫자 입력 미준수 예외 테스트")
    @ValueSource(strings = {"", "1", "12", "1234", "abc99"})
    void invalidInputsTest2(String input) {
        Assertions.assertThatThrownBy(() -> Validation.isLengthThree(input)).
                isInstanceOf(IllegalArgumentException.class)
                .hasMessage("세 자리 숫자를 입력해 주세요.");
    }

    @ParameterizedTest
    @DisplayName("1부터 9까지 숫자외 입력 예외 테스트")
    @ValueSource(strings = {"-132", "000", "!@$", "pg9", "909", "007", "-23"})
    void invalidInputsTest3(String input) {
        Assertions.assertThatThrownBy(() -> Validation.isInRange(input)).
                isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1부터 9까지의 숫자만 입력 가능 합니다.");
    }

    @ParameterizedTest
    @DisplayName("중복된 숫자 입력 예외 테스트")
    @ValueSource(strings = {"113", "155", "383", "999", "464"})
    void invalidInputsTest4(String input) {
        Assertions.assertThatThrownBy(() -> Validation.isDuplicate(input)).
                isInstanceOf(IllegalArgumentException.class)
                .hasMessage("서로 다른 숫자를 입력해 주세요.");
    }

    @ParameterizedTest
    @DisplayName("모든 유효성 성공 테스트")
    @ValueSource(strings = {"123", "456", "789", "245", "386"})
    void validInputsTest(String input) {
        Assertions.assertThatCode(() -> Validation.isValidInput(input))
                .doesNotThrowAnyException();
    }
}