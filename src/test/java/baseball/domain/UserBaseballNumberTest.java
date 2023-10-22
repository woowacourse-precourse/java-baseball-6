package baseball.domain;

import baseball.handler.ErrorHandler;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class UserBaseballNumberTest {

    @DisplayName("3자리의 숫자가 아닌 경우 예외가 발생한다")
    @ParameterizedTest(name = "[{index}] Input : {0}")
    @ValueSource(strings = {"1,2,3,4", "1,2"})
    void createNumberWithInvalidLength(String inputString) {
        assertThatThrownBy(() -> new UserBaseballNumber(Arrays.asList(inputString.split(","))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorHandler.INVALID_LENGTH.getException().getMessage());
    }

    @DisplayName("중복된 숫자가 있는 경우 예외가 발생한다")
    @ParameterizedTest(name = "[{index}] Input : {0}")
    @ValueSource(strings = {"1,2,2", "2,2,3"})
    void createNumberWithDuplicate(String inputString) {
        assertThatThrownBy(() -> new UserBaseballNumber(Arrays.asList(inputString.split(","))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorHandler.DUPLICATE_NUMBER.getException().getMessage());
    }
}
