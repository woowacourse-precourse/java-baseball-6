package baseball.feature;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ConfirmTest {

    //일치 갯수 테스트
    @ParameterizedTest
    @MethodSource("provideTestCases")
    public void testAccordNumber(List<Integer> userNumbers, List<Integer> computerNumbers,
            int expected) {
        Confirm confirm = new Confirm(userNumbers, computerNumbers);
        int result = confirm.accordNumber();
        assertEquals(expected, result, expected + "개의 숫자가 일치해야 합니다.");
    }

    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of(List.of(1, 4, 7), List.of(1, 5, 6), 1),
                Arguments.of(List.of(1, 4, 7), List.of(1, 4, 6), 2),
                Arguments.of(List.of(1, 4, 7), List.of(1, 4, 7), 3),
                Arguments.of(List.of(1, 4, 7), List.of(4, 7, 1), 3),
                Arguments.of(List.of(1, 4, 7), List.of(4, 3, 1), 2),
                Arguments.of(List.of(1, 4, 7), List.of(9, 8, 6), 0)
        );
    }

    // 자리 일치 테스트
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
                Arguments.of(List.of(1, 2, 3), List.of(1, 2, 3), 3),
                Arguments.of(List.of(1, 2, 3), List.of(2, 1, 8), 0),
                Arguments.of(List.of(1, 2, 3), List.of(3, 2, 1), 1)
        );
    }

    // 자리일치, 갯수 일치에 맞게 알맞은 결과를 리턴하는지 테스트
    @ParameterizedTest
    @MethodSource("provideRefereeTestCases")
    public void testReferee(List<Integer> userNumbers, List<Integer> computerNumbers,
            String expected) {
        Confirm confirm = new Confirm(userNumbers, computerNumbers);
        String result = confirm.referee();
        assertEquals(expected, result);
    }

    private static Stream<Arguments> provideRefereeTestCases() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3), List.of(4, 5, 6), "낫싱"),
                Arguments.of(List.of(1, 2, 3), List.of(3, 1, 2), "3볼"),
                Arguments.of(List.of(1, 2, 3), List.of(1, 2, 3), "3스트라이크"),
                Arguments.of(List.of(1, 2, 3), List.of(1, 3, 2), "2볼 1스트라이크")
        );
    }

}
