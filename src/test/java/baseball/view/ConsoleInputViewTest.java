package baseball.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockedStatic;

class ConsoleInputViewTest {
    @ParameterizedTest
    @DisplayName("입력값 변환 테스트")
    @MethodSource("inputNumbersAndExpectList")
    void convertConsoleTextToIntegerList(String input, List<Integer> expectList) {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            when(readLine()).thenReturn(input);
            List<Integer> convertList = new ConsoleInputView().getPlayerNumbers();
            assertThat(convertList).isEqualTo(expectList);
        }
    }

    public static Stream<Arguments> inputNumbersAndExpectList() {
        return Stream.of(
                Arguments.of("123", List.of(1, 2, 3)),
                Arguments.of("456", List.of(4, 5, 6)),
                Arguments.of("789", List.of(7, 8, 9))
        );
    }

    @ParameterizedTest
    @DisplayName("게임 중지 반환 테스트")
    @MethodSource("inputNumberAndExpectBoolean")
    void convertConsoleTextToWantStopGameBoolean(String input, boolean expectBoolean) {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            when(readLine()).thenReturn(input);
            boolean wantStopGame = new ConsoleInputView().isWantStopGame();
            assertThat(expectBoolean).isEqualTo(wantStopGame);
        }
    }

    public static Stream<Arguments> inputNumberAndExpectBoolean() {
        return Stream.of(
                Arguments.of("1", false),
                Arguments.of("2", true)
        );
    }

    @ParameterizedTest
    @DisplayName("게임 중지 예외 테스트")
    @ValueSource(strings = {"3", "4", "-1", "TEST"})
    void convertConsoleTextToWantStopGameBooleanFailTest(String input) {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            when(readLine()).thenReturn(input);
            assertThrows(IllegalArgumentException.class, () -> new ConsoleInputView().isWantStopGame());
        }
    }
}