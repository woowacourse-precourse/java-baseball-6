package baseball.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.exception.guess_number.NotEqualsGameNumberDigitsException;
import baseball.exception.guess_number.NotMatchGameNumberRangeConditionException;
import baseball.exception.guess_number.NotUniqueNumberException;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayNameGeneration(ReplaceUnderscores.class)
@SuppressWarnings("NonAsciiCharacters")
class GuessNumberTest {

    @MethodSource("wrongGuessNumberProvider")
    @ParameterizedTest(name = "{0}")
    void 추측한_숫자가_숫자야구_게임_룰과_다를_경우_예외를_발생시킨다(String message, List<Integer> wrongGuessNumbers,
                                            Class<? extends Exception> expectedException) {
        // when & then
        assertThatThrownBy(() -> new GuessNumber(wrongGuessNumbers))
                .isInstanceOf(expectedException);
    }

    private static Stream<Arguments> wrongGuessNumberProvider() {
        return Stream.of(
                Arguments.of("자리수가 다른 경우", List.of(1, 5, 9, 3), NotEqualsGameNumberDigitsException.class),
                Arguments.of("중복된 값이 있는 경우", List.of(1, 1, 5), NotUniqueNumberException.class),
                Arguments.of("게임 숫자 범위를 벗어난 경우", List.of(1, 2, 0), NotMatchGameNumberRangeConditionException.class)
        );
    }
}
