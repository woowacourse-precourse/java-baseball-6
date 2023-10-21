package baseball.exception;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InputValidatorTest {

    @Test
    void 사용자_정답입력_검증_길이초과_예외() {
        InputValidator inputValidator = new InputValidator();
        String testSentence = "1234";

        InputException exception = Assertions.assertThrows(InputException.class, () -> {
            inputValidator.validateAnswer(testSentence);
        });

        String message = exception.getMessage();
        Assertions.assertEquals("입력값의 길이가 4이상입니다.", message);
    }

    @Test
    void 사용자_정답입력_검증_길이부족_예외() {
        InputValidator inputValidator = new InputValidator();
        String testSentence = "34";

        InputException exception = Assertions.assertThrows(InputException.class, () -> {
            inputValidator.validateAnswer(testSentence);
        });

        String message = exception.getMessage();
        Assertions.assertEquals("입력값의 길이가 2이하입니다.", message);
    }

    @Test
    void 사용자_정답입력_검증_문자_예외() {
        InputValidator inputValidator = new InputValidator();
        String testSentence = "테스트";

        InputException exception = Assertions.assertThrows(InputException.class, () -> {
            inputValidator.validateAnswer(testSentence);
        });

        String message = exception.getMessage();
        Assertions.assertEquals("입력값이 숫자가 아닙니다.", message);
    }

    @Test
    void 사용자_정답입력_검증_NULL_예외() {
        InputValidator inputValidator = new InputValidator();

        InputException exception = Assertions.assertThrows(InputException.class, () -> {
            inputValidator.validateAnswer(null);
        });

        String message = exception.getMessage();
        Assertions.assertEquals("입력값에 Null 값이 확인되었습니다.", message);
    }
}
