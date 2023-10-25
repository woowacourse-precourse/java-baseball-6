package baseball.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import baseball.util.constants.ExceptionMessages;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("Numbers 클래스 테스트")
public class NumbersTest {
    static Stream<Arguments> invalidParametersForNumbersValidate() {
        return Stream.of(
                Arguments.of(new int[]{0, 2, 3}, ExceptionMessages.NUMBERS_OUT_OF_RANGE),
                Arguments.of(new int[]{1, 2}, ExceptionMessages.NUMBERS_WRONG_LENGTH),
                Arguments.of(new int[]{1, 2, 3, 4}, ExceptionMessages.NUMBERS_WRONG_LENGTH),
                Arguments.of(new int[]{1, 1, 2}, ExceptionMessages.NUMBERS_DUPLICATED_MESSAGE)
        );
    }

    static Stream<Arguments> parametersForCompare() {
        return Stream.of(
                Arguments.of(getNumbers(1, 2, 3), getNumbers(2, 3, 1), new BallCount(0, 3)),
                Arguments.of(getNumbers(1, 2, 3), getNumbers(1, 2, 3), new BallCount(3, 0)),
                Arguments.of(getNumbers(1, 2, 3), getNumbers(1, 3, 4), new BallCount(1, 1))
        );
    }

    static Numbers getNumbers(int... args) {
        return Numbers.create(args);
    }

    @ParameterizedTest(name = "유효하지 않은 값: {0} -> {1}")
    @MethodSource("invalidParametersForNumbersValidate")
    @DisplayName("유효성 검사 - 유효하지 않은 입력")
    void testValidate(int[] invalidInput, String expectedMessage) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> Numbers.create(invalidInput));
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    @DisplayName("equals() 테스트 - 일치")
    void testEquals() {
        Numbers numbers1 = getNumbers(1, 2, 3);
        Numbers numbers2 = getNumbers(1, 2, 3);
        assertEquals(numbers1, numbers2);
    }

    @Test
    @DisplayName("equals() 테스트 - 불일치")
    void testNotEquals() {
        Numbers numbers1 = getNumbers(1, 2, 3);
        Numbers numbers2 = getNumbers(2, 3, 1);

        assertNotEquals(numbers1, numbers2);
    }

    @ParameterizedTest(name = "{0} {1} {2}")
    @MethodSource("parametersForCompare")
    @DisplayName("compare() 테스트")
    void testCompare(Numbers numbers1, Numbers numbers2, BallCount expected) {
        BallCount result = numbers1.compare(numbers2);
        assertEquals(expected, result);
    }
}
