package baseball;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputValidationTest {
    @DisplayName("정상 게임 입력 데이터 검증")
    @Test
    void goodGameInput() {
        InputValidation inputValidation = new InputValidation();
        assertDoesNotThrow(() -> {
            inputValidation.validateGameInput("123");
        });
    }

    @DisplayName("4글자 게임 입력 데이터 예외발생 확인")
    @Test
    void length4GameInputThrowsError() {
        InputValidation inputValidation = new InputValidation();
        assertThrows(IllegalArgumentException.class, () -> {
            inputValidation.validateGameInput("1234");
        });
    }

    @DisplayName("게임 입력에 숫자 0포함 시 예외발생 확인")
    @Test
    void gameInputIncludeZeroThrowsError() {
        InputValidation inputValidation = new InputValidation();
        assertThrows(IllegalArgumentException.class, () -> {
            inputValidation.validateGameInput("012");
        });
    }

    @DisplayName("게임 입력에 중복숫자 포함시 예외발생 확인")
    @Test
    void duplicateNumberGameInputThrowsError() {
        InputValidation inputValidation = new InputValidation();
        assertThrows(IllegalArgumentException.class, () -> {
            inputValidation.validateGameInput("112");
        });
    }

    @DisplayName("정상적인 재시작 입력 테스트")
    @Test
    void goodRestartInput() {
        InputValidation inputValidation = new InputValidation();
        assertThrows(IllegalArgumentException.class, () -> {
            inputValidation.validateGameInput("1");
        });
    }

    @DisplayName("길이 1이 아닌 재시작 입력 예외발생 확인")
    @Test
    void restartInputLengthNot1ThrowsError() {
        InputValidation inputValidation = new InputValidation();
        assertThrows(IllegalArgumentException.class, () -> {
            inputValidation.validateGameInput("11");
        });
    }

    @DisplayName("1이나 2가 아닌 재시작 입력 예외발생 확인")
    @Test
    void restartInputNotEqualsOneOrTwoThrowsError() {
        InputValidation inputValidation = new InputValidation();
        assertThrows(IllegalArgumentException.class, () -> {
            inputValidation.validateGameInput("3");
        });
    }
}