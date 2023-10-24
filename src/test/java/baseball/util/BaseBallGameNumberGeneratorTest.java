package baseball.util;

import static baseball.util.Constant.BASEBALL_GAME_NUMBER_DIGIT;
import static baseball.util.Constant.END_INCLUSIVE;
import static baseball.util.Constant.START_INCLUSIVE;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import java.util.List;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(ReplaceUnderscores.class)
@SuppressWarnings("NonAsciiCharacters")
class BaseBallGameNumberGeneratorTest {

    @Test
    void 숫자야구_게임의_규칙대로_숫자가_만들어지는지_검증한다() {
        // given
        BaseBallGameNumberGenerator baseBallGameNumberGenerator = new BaseBallGameNumberGenerator();

        // when
        final List<Integer> numbers = baseBallGameNumberGenerator.generateNumbers();

        // then
        assertSoftly(softly -> {
            softly.assertThat(numbers).hasSize(BASEBALL_GAME_NUMBER_DIGIT.getValue());
            softly.assertThat(numbers).allSatisfy(
                    number -> {
                        softly.assertThat(number).isBetween(START_INCLUSIVE.getValue(), END_INCLUSIVE.getValue());
                    }
            );
        });
    }
}
