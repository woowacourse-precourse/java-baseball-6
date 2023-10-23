package baseball.validator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputValidatorTest {

    @Test
    @DisplayName("게임 재시작 여부 입력에서 유효하지 않은 값을 입력하는 경우")
    void validateCheckRestartGameInput() {
        String input = "0";

        IllegalArgumentException e = Assertions.assertThrows(IllegalArgumentException.class, () -> {
                InputValidator.validateCheckRestartGameInput(input);
        });

        Assertions.assertEquals(e.getMessage(), "잘못된 값을 입력했습니다.");
    }

    @Test
    @DisplayName("3자리가 아닌 숫자를 받는 경우")
    void validatePlayerInput_LengthError() {
        String input = "1234";

        IllegalArgumentException e = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.validatePlayerInput(input);
        });

        Assertions.assertEquals(e.getMessage(), "잘못된 길이의 문자열을 입력했습니다.");
    }

    @Test
    @DisplayName("유효하지 않은 문자를 받는 경우")
    void validatePlayerInput_NumberError() {
        String input = "102";

        IllegalArgumentException e = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.validatePlayerInput(input);
        });

        Assertions.assertEquals(e.getMessage(), "유효하지 않는 문자를 입력했습니다.");
    }

    @Test
    @DisplayName("중복된 숫자를 받는 경우")
    void validatePlayerInput_DuplicateError() {
        String input = "112";

        IllegalArgumentException e = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.validatePlayerInput(input);
        });

        Assertions.assertEquals(e.getMessage(), "중복된 숫자를 포함한 문자열을 입력했습니다.");
    }
}