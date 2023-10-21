package baseball;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserInputTest {

    @Test
    void 유효하지_않은_입력에_대해_예외_발생() {
        // given
        GameRule rule = new GameRule(3, 1, 9);
        UserInputHandler iHandler = new UserInputHandler(rule);
        // when
        String[] inputs = {"1234", "012", "12", "117", "abc", "445"};
        // then
        for (int i = 0; i < inputs.length; i++) {
            String input = inputs[i];
            Assertions.assertThrowsExactly(IllegalArgumentException.class,
                    () -> iHandler.createUserGuess(input));
        }
    }
}
