package baseball.domain.game;

import static baseball.domain.ball.BallNumbersTest.createTripleBallNumbers;
import static org.assertj.core.api.Assertions.assertThat;

import baseball.domain.TripleNumberPicker;
import baseball.domain.ball.AnswerCreator;
import baseball.domain.ball.BallNumber;
import baseball.domain.ball.Guess;
import collection.Triple;
import number.NumberPicker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

final class ComputerTest {

    @DisplayName("모든 숫자가 위치, 값이 모두 일치하는 경우 GuessResult의 strikeCount는 3이다.")
    @Test
    void strikeCountTest() {
        // given
        final NumberPicker numberPicker = new TripleNumberPicker(1, 2, 3);
        final AnswerCreator answerCreator = new AnswerCreator(numberPicker);
        final Computer computer = new Computer(answerCreator);
        computer.createAnswer();

        final Triple<BallNumber> guessBallNumbers =
                createTripleBallNumbers(1, 2, 3);

        // when
        final Guess guess = Guess.of(guessBallNumbers);
        final GameResult result = computer.check(guess);

        // then
        assertThat(result.hasThreeStrike()).isTrue();
        assertThat(result.strikeCount()).isEqualTo(3);
        assertThat(result.ballCount()).isEqualTo(0);
    }

    @DisplayName("모든 숫자가 위치는 다르지만 값은 존재하는 경우 ballCount는 3이다.")
    @Test
    void ballCountTest() {
        // given
        final NumberPicker numberPicker = new TripleNumberPicker(1, 2, 3);
        final AnswerCreator answerCreator = new AnswerCreator(numberPicker);
        final Computer computer = new Computer(answerCreator);
        final Triple<BallNumber> guessBallNumbers = createTripleBallNumbers(2, 3, 1);

        final Guess guess = Guess.of(guessBallNumbers);
        computer.createAnswer();

        // when
        final GameResult result = computer.check(guess);

        // then
        assertThat(result.hasThreeStrike()).isFalse();
        assertThat(result.strikeCount()).isEqualTo(0);
        assertThat(result.ballCount()).isEqualTo(3);
    }


    @DisplayName("모든 숫자가 일치하지 않는 경우 strikeCount, ballCount는 모두 0이다.")
    @Test
    void nothingTest() {
        // given
        final NumberPicker numberPicker = new TripleNumberPicker(1, 2, 3);
        final AnswerCreator answerCreator = new AnswerCreator(numberPicker);
        final Computer computer = new Computer(answerCreator);
        computer.createAnswer();
        final Triple<BallNumber> guessBallNumbers = createTripleBallNumbers(4, 5, 6);

        // when
        final Guess guess = Guess.of(guessBallNumbers);
        final GameResult result = computer.check(guess);

        // then
        assertThat(result.hasThreeStrike()).isFalse();
        assertThat(result.strikeCount()).isEqualTo(0);
        assertThat(result.ballCount()).isEqualTo(0);
    }


}