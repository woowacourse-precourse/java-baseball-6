package baseball.feature;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import baseball.feature.Confirm;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ConfirmTest {

    // 일치 갯수를 잘 표현 하는지 확인
    @ParameterizedTest
    @MethodSource("provideTestCases")
    public void testAccordNumber(List<Integer> userNumbers, List<Integer> computerNumbers,
            int expected) {
        Confirm confirm = new Confirm(userNumbers, computerNumbers);
        int result = confirm.accordNumber();
        assertEquals(expected, result, expected + "개의 숫자가 일치해야 합니다.");
    }

    // 일치 갯수를 잘 표현 하는지 확인
    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of(List.of(1, 4, 7), List.of(1, 5, 6), 1),
                Arguments.of(List.of(1, 4, 7), List.of(1, 4, 6), 2),
                Arguments.of(List.of(1, 4, 7), List.of(1, 4, 7), 3)
        );
    }

    @ParameterizedTest
    @MethodSource("providePositionMatchTestCases")
    public void testCheckPositionMatch(List<Integer> userNumbers, List<Integer> computerNumbers,
            int expected) {
        Confirm confirm = new Confirm(userNumbers, computerNumbers);
        int result = confirm.checkPositionMatch();
        assertEquals(expected, result, expected + "개의 숫자와 위치가 일치해야 합니다.");
    }

    private static Stream<Arguments> providePositionMatchTestCases() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3), List.of(1, 5, 6), 1),
                Arguments.of(List.of(1, 2, 3), List.of(1, 2, 6), 2),
                Arguments.of(List.of(1, 2, 3), List.of(1, 2, 3), 3)
        );
    }

}
