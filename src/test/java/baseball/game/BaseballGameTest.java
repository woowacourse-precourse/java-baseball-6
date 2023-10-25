package baseball.game;

import baseball.error.ErrorCode;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BaseballGameTest {

    @MethodSource("provideNumbers")
    @ParameterizedTest
    void 숫자_체크(List<Integer> computerNumbers, String userNumbers, int strikeAnswer, int ballAnswer) {
        //given
        BaseballGame game = new BaseballGame(computerNumbers);

        //when
        game.tryUserInput(userNumbers);

        //then
        assertThat(game.getStrike()).isEqualTo(strikeAnswer);
        assertThat(game.getBall()).isEqualTo(ballAnswer);
    }

    private static Stream<Arguments> provideNumbers() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3), "456", 0, 0),
                Arguments.of(List.of(1, 2, 3), "789", 0, 0),
                Arguments.of(List.of(1, 5, 9), "268", 0, 0),
                Arguments.of(List.of(1, 5, 9), "261", 0, 1),
                Arguments.of(List.of(5, 9, 1), "259", 0, 2),
                Arguments.of(List.of(5, 9, 1), "159", 0, 3),
                Arguments.of(List.of(5, 9, 1), "539", 1, 1),
                Arguments.of(List.of(5, 9, 1), "593", 2, 0),
                Arguments.of(List.of(5, 7, 9), "579", 3, 0),
                Arguments.of(List.of(1, 3, 5), "135", 3, 0)
        );
    }

    @ValueSource(strings = {"a12", "1b2", "56c", "qw1", "q2소", "9cz", "zxc"})
    @ParameterizedTest
    void 숫자_외에_다른_것_입력(String input) {
        //given, when
        BaseballGame game = new BaseballGame(List.of(1, 2, 3));

        //then
        assertThatThrownBy(() -> game.tryUserInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.DIGIT_ERROR.message);
    }

    @ValueSource(strings = {"1", "12", "1234", "12345", "123456"})
    @ParameterizedTest
    void 숫자_개수가_다를_때(String input) {
        //given, when
        BaseballGame game = new BaseballGame(List.of(1, 2, 3));

        //then
        assertThatThrownBy(() -> game.tryUserInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.SIZE_ERROR.message);
    }

    @ValueSource(strings = {"112", "151", "122", "333"})
    @ParameterizedTest
    void 중복된_숫자가_포함될_때(String input) {
        //given, when
        BaseballGame game = new BaseballGame(List.of(1, 2, 3));

        //then
        assertThatThrownBy(() -> game.tryUserInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.DUPLICATION_ERROR.message);
    }
}