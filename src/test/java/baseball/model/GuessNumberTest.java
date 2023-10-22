package baseball.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.exception.guess_number.NotEqualsGameNumberDigitsException;
import baseball.exception.guess_number.NotMatchGameNumberRangeConditionException;
import baseball.exception.guess_number.NotUniqueNumberException;
import java.util.List;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(ReplaceUnderscores.class)
@SuppressWarnings("NonAsciiCharacters")
class GuessNumberTest {

    @Test
    void 추측한_숫자의_자리수가_숫자야구_게임_룰과_다를_경우_예외를_발생시킨다() {
        // given
        List<Integer> guessNumbers = List.of(1, 5, 9, 3);

        // when & then
        assertThatThrownBy(() -> new GuessNumber(guessNumbers))
                .isInstanceOf(NotEqualsGameNumberDigitsException.class);
    }

    @Test
    void 추측한_숫자중에_중복된_값이_존재하면_예외를_발생시킨다() {
        // given
        List<Integer> guessNumbers = List.of(1, 1, 5);

        // when & then
        assertThatThrownBy(() -> new GuessNumber(guessNumbers))
                .isInstanceOf(NotUniqueNumberException.class);
    }

    @Test
    void 추측한_숫자중에_숫자야구_게임_룰에_벗어나는_값이_존재하면_예외를_발생시킨다() {
        // given
        List<Integer> guessNumbers = List.of(1, 2, 0);

        // when & then
        assertThatThrownBy(() -> new GuessNumber(guessNumbers))
                .isInstanceOf(NotMatchGameNumberRangeConditionException.class);
    }
}
