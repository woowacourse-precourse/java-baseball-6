package baseball.utils;

import baseball.utils.Validator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ValidatorTest {
    Validator validator = new Validator();

    /**
     * guess()시 사용자의 입력값 검증
     */
    @Test
    void 입력값이_null이면_예외발생() {
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

    /**
     * restart()시 사용자의 입력 검증
     */
    @Test
    void restart시_입력값이_null이면_예외발생() {
        // given
        String userInput = null;

        // when, then
        assertRestartValidation(userInput);
    }

    @Test
    void restart시_사용자_입력의_길이가_1보다_크면_예외발생() {
        // given
        String userInput = "123";

        // when, then
        assertRestartValidation(userInput);
    }

    @Test
    void restart시_사용자_입력의_길이가_1보다_작으면_예외발생() {
        // given
        String userInput = "";

        // when, then
        assertRestartValidation(userInput);
    }

    @Test
    void restart시_사용자_입력이_숫자가_아닌_값을_포함하면_예외발생() {
        // given
        String userInput = "a";

        // when, then
        assertRestartValidation(userInput);
    }

    private void assertRestartValidation(String userInput) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            validator.validateRestartInput(userInput);
        });
    }
}
