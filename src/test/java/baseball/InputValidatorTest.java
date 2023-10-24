package baseball;

import baseball.validator.GameRetryInputValidator;
import baseball.validator.UserAnswerInputValidator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class InputValidatorTest {
    GameRetryInputValidator gameRetryInputValidator = new GameRetryInputValidator();
    UserAnswerInputValidator userAnswerInputValidator = new UserAnswerInputValidator();

    @Test
    void 유저답안_입력_세자리_검증실패시_Exception_테스트() {
        String userInput = "1234";
        Assertions.assertThatThrownBy(() -> userAnswerInputValidator.keepLengthThree(userInput))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 유저답안_입력_숫자_검증실패시_Exception_테스트() {
        String userInput = "asd";
        Assertions.assertThatThrownBy(() -> userAnswerInputValidator.keepDigit(userInput))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 유저답안_입력_1to9_검증실패시_Exception_테스트() {
        String userInput = "109";
        Assertions.assertThatThrownBy(() -> userAnswerInputValidator.keepOneToNine(userInput))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 유저답안_입력_서로다른숫자_검증실패시_Exception_테스트() {
        String userInput = "112";
        Assertions.assertThatThrownBy(() -> userAnswerInputValidator.keepUnique(userInput))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 유저답안_입력_최종_검증성공_테스트() {
        String userInput = "123";
        Assertions.assertThatCode(() -> userAnswerInputValidator.validateInput(userInput)).doesNotThrowAnyException();
    }

    @Test
    void 게임재시작_입력_검증실패시_Exception_테스트() {
        String userInput = "3";
        Assertions.assertThatThrownBy(() -> gameRetryInputValidator.validateInput(userInput))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }
}