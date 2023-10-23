package baseball;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ValidatorTest {
    Validator validator = new Validator();

    /**
     *   - 아무 것도 입력하지 않는 경우 (null)
     *   - 입력의 길이가 3보다 크거나 작은 경우
     *   - 숫자가 아닌 값을 포함하는 경우
     *   - 같은 수를 여러개 포함하는 경우
     *   - 범위를 벗어난 수를 포함하는 경우 (숫자 중 0을 포함하는 경우)
     *   - 이 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션을 종료한다.
     */
    @Test
    void 사용자가_아무것도_입력하지_않으면_예외발생() {
        // given
        String userInput = null;

        // when, then
        assertValidation(userInput);
    }

    @Test
    void 사용자_입력의_길이가_3보다_큰_경우_예외발생() {
        // given
        String userInput = "1234";

        // when, then
        assertValidation(userInput);
    }

    @Test
    void 사용자_입력의_길이가_3보다_작은_경우_예외발생() {
        // given
        String userInput = "12";

        // when, then
        assertValidation(userInput);
    }

    @Test
    void 사용자_입력이_숫자가_아닌_값을_포함하면_예외발생() {
        // given
        String userInput = "12a";

        // when, then
        assertValidation(userInput);
    }

    @Test
    void 사용자_입력이_중복되는_수를_포함하면_예외발생() {
        // given
        String userInput = "112";

        // when, then
        assertValidation(userInput);
    }

    @Test
    void 사용자_입력이_범위를_벗어난_수를_포함하면_예외발생() {
        // given
        String userInput = "012";

        // when, then
        assertValidation(userInput);
    }

    private void assertValidation(String userInput) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            validator.validateUserInput(userInput);
        });
    }
}
