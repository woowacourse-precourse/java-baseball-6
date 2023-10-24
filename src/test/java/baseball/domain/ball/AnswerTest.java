package baseball.domain.ball;

import static baseball.domain.ball.BallNumbersTest.createTripleBallNumbers;
import static org.assertj.core.api.Assertions.assertThat;

import baseball.domain.TripleNumberPicker;
import collection.Triple;
import number.NumberPicker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

final class AnswerTest {

    @DisplayName("Answer와 Guess의 index와 value가 모두 일치하는 경우 strikeCount는 3이다.")
    @Test
    void strikeCountTest() {
        // given
        final Triple<BallNumber> tripleBallNumbers =
                createTripleBallNumbers(1, 2, 3);

        final NumberPicker numberPicker =
                new TripleNumberPicker(1, 2, 3);

        final AnswerCreator answerCreator = new AnswerCreator(numberPicker);
        final Answer answer = answerCreator.create();
        final Guess guess = Guess.of(tripleBallNumbers);

        // when
        final int strikeCount = answer.getStrikeCount(guess);
        final int ballCount = answer.getBallCount(guess);

        // then
        assertThat(strikeCount).isEqualTo(3);
        assertThat(ballCount).isEqualTo(0);
    }

    @DisplayName("모든 숫자가 위치는 다르지만 값은 존재하는 경우 ballCount는 3이다.")
    @Test
    void ballCountTest() {
        // given
        final NumberPicker numberPicker =
                new TripleNumberPicker(1, 2, 3);

        final AnswerCreator answerCreator =
                new AnswerCreator(numberPicker);

        final Triple<BallNumber> guessBallNumbers =
                createTripleBallNumbers(2, 3, 1);

        final Guess guess = Guess.of(guessBallNumbers);
        final Answer answer = answerCreator.create();

        // when
        final int ballCount = answer.getBallCount(guess);
        final int strikeCount = answer.getStrikeCount(guess);

        // then
        assertThat(strikeCount).isEqualTo(0);
        assertThat(ballCount).isEqualTo(3);
    }


    @DisplayName("모든 숫자가 일치하지 않는 경우 strikeCount, ballCount는 모두 0이다.")
    @Test
    void nothingTest() {
        // given
        NumberPicker numberPicker = new TripleNumberPicker(1, 2, 3);
        final AnswerCreator answerCreator = new AnswerCreator(numberPicker);
        final Triple<BallNumber> guessBallNumbers =
                createTripleBallNumbers(4, 5, 6);

        final Answer answer = answerCreator.create();
        final Guess guess = Guess.of(guessBallNumbers);

        // when
        final int ballCount = answer.getBallCount(guess);
        final int strikeCount = answer.getStrikeCount(guess);

        // then
        assertThat(strikeCount).isEqualTo(0);
        assertThat(ballCount).isEqualTo(0);
    }

}
