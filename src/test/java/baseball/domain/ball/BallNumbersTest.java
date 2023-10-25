package baseball.domain.ball;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static testutils.TripleBallNumbersCreator.createTripleBallNumbers;

import baseball.exception.DuplicateBallNumbersException;
import collection.Triple;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public final class BallNumbersTest {

    @DisplayName("중복된 숫자로 Guess 생성 시 예외 발생")
    @Test
    void guessMustHaveUniqueNumbers() {
        // given
        final Triple<BallNumber> ballNumbers = createTripleBallNumbers(1, 2, 2);

        // when
        // then
        assertThatThrownBy(
                () -> Guess.of(ballNumbers)
        )
                .isInstanceOf(DuplicateBallNumbersException.class)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(DuplicateBallNumbersException.DUPLICATE_BALL_NUMBERS_EXCEPTION);

    }

    @DisplayName("중복된 숫자로 Answer 생성 시 예외 발생")
    @Test
    void answerMustHaveUniqueNumbers() {
        // given
        final Triple<BallNumber> ballNumbers = createTripleBallNumbers(1, 2, 2);

        // when
        // then
        assertThatThrownBy(
                () -> Answer.of(ballNumbers)
        )
                .isInstanceOf(DuplicateBallNumbersException.class)
                .hasMessage(DuplicateBallNumbersException.DUPLICATE_BALL_NUMBERS_EXCEPTION);
    }
}