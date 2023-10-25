package baseball;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UserInputValidatorTest {
    @Test
    void 정상_입력() {
        UserInputValidator userInputValidator = new UserInputValidator("123");
        assertDoesNotThrow(userInputValidator::checkValid);
    }

    @Test
    void 입력_길이_초과_오류() {
        UserInputValidator userInputValidator = new UserInputValidator("1234");
        assertThrows(IllegalArgumentException.class, userInputValidator::checkValid);
    }

    @Test
    void 입력_길이_미달_오류() {
        UserInputValidator userInputValidator = new UserInputValidator("12");
        assertThrows(IllegalArgumentException.class, userInputValidator::checkValid);
    }

    @Test
    void 입력_중복_오류() {
        UserInputValidator userInputValidator = new UserInputValidator("112");
        assertThrows(IllegalArgumentException.class, userInputValidator::checkValid);
    }

    @Test
    void 입력_숫자_아님_오류() {
        UserInputValidator userInputValidator = new UserInputValidator("1a2");
        assertThrows(IllegalArgumentException.class, userInputValidator::checkValid);
    }

    @Test
    void 입력_범위_초과_오류() {
        UserInputValidator userInputValidator = new UserInputValidator("012");
        assertThrows(IllegalArgumentException.class, userInputValidator::checkValid);
    }
}