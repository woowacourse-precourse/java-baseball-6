package baseball.domain;

import baseball.handler.ErrorHandler;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class GameChoiceTest {

    @DisplayName("1과 2가 아닌 숫자가 입력되면 예외가 발생한다")
    @ParameterizedTest(name = "[{index}] input {0} ")
    @ValueSource(ints = {0, 3, -1})
    void createNumberWithInvalidNumber(int inputNumber) {
        assertThatThrownBy(() -> new GameChoice(inputNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorHandler.INVALID_NUMBER.getException().getMessage());
    }
}
