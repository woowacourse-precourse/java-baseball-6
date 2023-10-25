package baseball.service;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserValidationTest {
    private final UserValidation userValidation;


    UserValidationTest() {
        userValidation = new UserValidation();
    }

    @DisplayName("입력 길이 검증")
    @Test
    void checkInputLength() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> userValidation.validation("12345"));

        String expect = "100~999 사이 서로 다른 숫자를 입력해주세요.";
        String actual = exception.getMessage();

        Assertions.assertTrue(actual.contains(expect));
    }

    @DisplayName("중복 문자 검증")
    @Test
    void checkDuplicateCharacter() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> userValidation.validation("112"));

        String expect = "Fail : 중복된 숫자를 입력하셨습니다.";
        String actual = exception.getMessage();

        Assertions.assertTrue(actual.contains(expect));
    }

    @DisplayName("숫자가 아닌 값 입력했는지 검증")
    @Test
    void checkIsInteger() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> userValidation.validation("1ab"));

        String expect = "Fail : 1~9 사이 숫자를 입력해주세요.";
        String actual = exception.getMessage();

        Assertions.assertTrue(actual.contains(expect));
    }

    @DisplayName("100보다 낮은 숫자 검증")
    @Test
    void checkLowThan100() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> userValidation.validation("1"));

        String expect = "100~999 사이 서로 다른 숫자를 입력해주세요.";
        String actual = exception.getMessage();

        Assertions.assertTrue(actual.contains(expect));
    }

    @DisplayName("999보다 높은 숫자 검증")
    @Test
    void checkBiggerThan100() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> userValidation.validation("1000"));

        String expect = "100~999 사이 서로 다른 숫자를 입력해주세요.";
        String actual = exception.getMessage();

        Assertions.assertTrue(actual.contains(expect));
    }

    @DisplayName("restartOrExit : 숫자가 아닌 값 입력 검증")
    @Test
    void isNumber() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> userValidation.restartValid("a"));

        String expect = "Fail : '1' 또는 '2' 입력해주세요.";
        String actual = exception.getMessage();

        Assertions.assertTrue(actual.contains(expect));
    }

    @DisplayName("restartOrExit : 1 또는 2가 아닌 값 입력 검증")
    @Test
    void isOneOrTwo() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> userValidation.restartValid("3"));

        String expect = "Fail : '1' 또는 '2' 입력해주세요.";
        String actual = exception.getMessage();

        Assertions.assertTrue(actual.contains(expect));
    }
}