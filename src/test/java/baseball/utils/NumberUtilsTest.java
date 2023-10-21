package baseball.utils;

import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@Nested
@DisplayName("[Number Utils]")
class NumberUtilsTest {


    @ParameterizedTest
    @MethodSource("withInSuccessTest")
    @DisplayName("숫자가 범위 내에 있는지 확인 - 성공 시 true 리턴")
    public void checkTargetNumberWithInRange_Success(final Integer target,
                                                     final Integer start,
                                                     final Integer end
    ) {
        Assertions.assertTrue(NumberUtils.isWithInRange(target, start, end));
    }

    static Stream<Arguments> withInSuccessTest() {
        return Stream.of(
                arguments(1, 1, 5),
                arguments(4, 1, 5),
                arguments(4, 2, 5),
                arguments(9, 1, 9)
        );
    }


    @ParameterizedTest
    @MethodSource("withInFailureTest")
    @DisplayName("숫자가 범위 내에 있는지 확인 - 실패 시 false 리턴")
    public void checkTargetNumberWithInRange_Failure(final Integer target,
                                                     final Integer start,
                                                     final Integer end
    ) {
        Assertions.assertFalse(NumberUtils.isWithInRange(target, start, end));
    }

    static Stream<Arguments> withInFailureTest() {
        return Stream.of(
                arguments(1, 2, 5),
                arguments(0, 1, 5),
                arguments(10, 2, 5),
                arguments(0, 1, 9)
        );
    }

    @ParameterizedTest
    @MethodSource("withInExceptionTest")
    @DisplayName("숫자가 범위 내에 있는지 확인 - 입력값 오류")
    public void checkTargetNumberWithInRange_Exception(final Integer target,
                                                       final Integer start,
                                                       final Integer end
    ) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> NumberUtils.isWithInRange(target, start, end));

    }

    static Stream<Arguments> withInExceptionTest() {
        return Stream.of(
                arguments(1, 8, 5),
                arguments(0, 6, 5),
                arguments(10, 2, 0),
                arguments(0, 1, 0)
        );
    }
}