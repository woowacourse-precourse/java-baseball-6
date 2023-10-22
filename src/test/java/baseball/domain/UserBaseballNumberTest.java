package baseball.domain;

import baseball.handler.ErrorHandler;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class UserBaseballNumberTest {

    private static Stream<Arguments> generateUserValues() {
        return Stream.of(
                Arguments.of(new UserBaseballNumber(List.of("1", "2", "3")), List.of(1, 2, 3)),
                Arguments.of(new UserBaseballNumber(List.of("3", "5", "9")), List.of(3, 5, 9))
        );
    }

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

    @DisplayName("1~9 사이의 범위가 아닌 경우 예외가 발생한다")
    @ParameterizedTest(name = "[{index}] Input : {0}")
    @ValueSource(strings = {"1,2,10", "0,2,3"})
    void createNumberWithInvalidRange(String inputString) {
        assertThatThrownBy(() -> new UserBaseballNumber(Arrays.asList(inputString.split(","))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorHandler.INVALID_RANGE.getException().getMessage());
    }

    @DisplayName("사용자의 입력값이 정상적으로 반환된다")
    @ParameterizedTest(name = "[{index}] Input : {0}")
    @MethodSource("generateUserValues")
    void createNumber(UserBaseballNumber userBaseballNumber, List<Integer> result) {
        assertThat(userBaseballNumber.getUserValues()).isEqualTo(result);
    }
}
