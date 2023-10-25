package baseball.domain;

import baseball.domain.hints.HintProvider;
import baseball.domain.hints.HintType;
import baseball.domain.numbers.AnswerNumber;
import baseball.domain.numbers.BaseBallNumber;
import baseball.domain.numbers.NumberGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

class HintProviderTest {
    private final AnswerNumber answerNumber = AnswerNumber.createAnswerNumbers(new TestGenerator());
    private final HintProvider hintProvider = new HintProvider(answerNumber);

    @Test
    @DisplayName("플레이어의 숫자가 1,2,3 일 때 STRIKE가 3개가 나오면 성공한다.")
    void STRIKE_3() {
        //given
        BaseBallNumber playerNumber = new BaseBallNumber(List.of(1, 2, 3));
        //when
        Map<HintType, Integer> hints = hintProvider.compareNumbers(playerNumber);
        //then
        Assertions.assertThat(hints.get(HintType.STRIKE)).isEqualTo(3);
    }

    @Test
    @DisplayName("플레이어의 숫자가 3,1,2 일 때 BALL이 3개가 나오면 성공한다.")
    void BALL_3() {
        //given
        BaseBallNumber playerNumber = new BaseBallNumber(List.of(3, 1, 2));
        //when
        Map<HintType, Integer> hints = hintProvider.compareNumbers(playerNumber);
        //then
        Assertions.assertThat(hints.get(HintType.BALL)).isEqualTo(3);
    }

    @Test
    @DisplayName("플레이어의 숫자가 3,2,1 일 때 2BALL, 1 STRIKE이면 성공한다.")
    void STRIKE_1_AND_BALL_2() {
        //given
        BaseBallNumber playerNumber = new BaseBallNumber(List.of(3, 2, 1));
        //when
        Map<HintType, Integer> hints = hintProvider.compareNumbers(playerNumber);
        //then
        Assertions.assertThat(hints.get(HintType.BALL)).isEqualTo(2);
        Assertions.assertThat(hints.get(HintType.STRIKE)).isEqualTo(1);
    }

    @Test
    @DisplayName("플레이어의 숫자가 4,5,6 일 때 1 NOTHING 이면 성공한다.")
    void ONLY_1_NOTHING() {
        //given
        BaseBallNumber playerNumber = new BaseBallNumber(List.of(4, 5, 6));
        //when
        Map<HintType, Integer> hints = hintProvider.compareNumbers(playerNumber);
        //then
        Assertions.assertThat(hints.get(HintType.NOTHING)).isEqualTo(1);
    }

    private static class TestGenerator implements NumberGenerator {
        @Override
        public List<Integer> generate(int numberSize) {
            return List.of(1, 2, 3);
        }
    }
}