package baseball.domain.ball;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.exception.DuplicateBallNumbersException;
import collection.Triple;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public final class BallNumbersTest {

    public static Triple<BallNumber> createTripleBallNumbers(
            final int first,
            final int second,
            final int third
    ) {
        return Triple.of(
                new BallNumber(first),
                new BallNumber(second),
                new BallNumber(third)
        );
    }

//    @DisplayName("Guess 생성 시, 1~9 범위를 벗어나는 수가 들어가면 예외 발생")
//    @Test
//    void throwIfGuessHaveNumbersOutOfRange() {
//        // given
//        final Triple<BallNumber> ballNumbers1 = createTripleBallNumbers(10, 11, 12);
//        final Triple<BallNumber> ballNumbers2 = createTripleBallNumbers(0, -1, -2);
//
//        // when
//        // then
//        assertThatThrownBy(
//                () -> Guess.of(ballNumbers1)
//        )
//                .isInstanceOf(IllegalArgumentException.class)
//                .hasMessage("BallNumbers는 1~9 사이의 3자리 수여야 합니다.");
//
//        assertThatThrownBy(
//                () -> Guess.of(ballNumbers2)
//        )
//                .isInstanceOf(IllegalArgumentException.class)
//                .hasMessage("BallNumbers는 1~9 사이의 3자리 수여야 합니다.");
//    }

//    @DisplayName("Answer 생성 시, 1~9 범위를 벗어나는 수가 들어가면 예외 발생")
//    @Test
//    void throwIfAnswerHaveNumbersOutOfRange() {
//        // given
//        final Triple<BallNumber> ballNumbers1 = createTripleBallNumbers(10, 11, 12);
//        final Triple<BallNumber> ballNumbers2 = createTripleBallNumbers(0, -1, -2);
//
//        // when
//        // then
//        assertThatThrownBy(
//                () -> Answer.of(ballNumbers1)
//        )
//                .isInstanceOf(IllegalArgumentException.class)
//                .hasMessage("BallNumbers는 1~9 사이의 3자리 수여야 합니다.");
//
//        assertThatThrownBy(
//                () -> Answer.of(ballNumbers2)
//        )
//                .isInstanceOf(IllegalArgumentException.class)
//                .hasMessage("BallNumbers는 1~9 사이의 3자리 수여야 합니다.");
//    }

//    @DisplayName("Guess는 반드시 3자리 숫자를 가져야 하며, 아니면 예외 발생")
//    @Test
//    void guessMustHaveThreeNumbers() {
//        // given
//        final List<Integer> numbers = List.of(1, 2);
//        final List<Integer> numbers2 = List.of(1, 2, 3, 4);
//        final Triple<BallNumber> ballNumbers1 = createTripleBallNumbers(10, 11, 12);
//        final Triple<BallNumber> ballNumbers2 = createTripleBallNumbers(0, -1, -2);
//
//        // when
//        // then
//        assertThatThrownBy(
//                () -> Guess.of(numbers)
//        )
//                .isInstanceOf(IllegalArgumentException.class)
//                .hasMessage("BallNumbers는 3자리로 이루어진 숫자여야 합니다.");
//
//        assertThatThrownBy(
//                () -> Guess.of(numbers2)
//        )
//                .isInstanceOf(IllegalArgumentException.class)
//                .hasMessage("BallNumbers는 3자리로 이루어진 숫자여야 합니다.");
//    }
//
//    @DisplayName("Answer는 반드시 3자리 숫자를 가져야 하며, 아니면 예외 발생")
//    @Test
//    void answerMustHaveThreeNumbers() {
//        // given
//        final Set<Integer> numbers = Set.of(1, 2);
//        final Set<Integer> numbers2 = Set.of(1, 2, 3, 4);
//
//        // when
//        // then
//        assertThatThrownBy(
//                () -> Answer.of(numbers)
//        )
//                .isInstanceOf(IllegalArgumentException.class)
//                .hasMessage("BallNumbers는 3자리로 이루어진 숫자여야 합니다.");
//
//        assertThatThrownBy(
//                () -> Answer.of(numbers2)
//        )
//                .isInstanceOf(IllegalArgumentException.class)
//                .hasMessage("BallNumbers는 3자리로 이루어진 숫자여야 합니다.");
//    }

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