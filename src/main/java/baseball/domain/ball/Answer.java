package baseball.domain.ball;

import baseball.domain.dto.GuessResult;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public final class Answer extends BallNumbers {

    private Answer(final List<Integer> numbers) {
        super(numbers);
    }

    public static Answer of(final Set<Integer> numbers) {
        return new Answer(new ArrayList<>(numbers));
    }

    public GuessResult guess(final Guess guess) {
        return new GuessResult(
                getBallCount(guess),
                getStrikeCount(guess)
        );
    }

    private int getStrikeCount(final Guess guess) {
        return (int) IntStream.range(0, BALL_COUNT)
                .filter(i -> equalsAt(i, guess))
                .count();
    }

    private int getBallCount(final Guess guess) {
        return (int) IntStream.range(0, BALL_COUNT)
                .filter(i -> containsAtDifferentIndex(i, guess))
                .count();
    }

    private boolean containsAtDifferentIndex(
            final int index,
            final Guess other
    ) {
        final BallNumber guessBallNumber = other.get(index);
        return notEqualsAt(index, other) && ballNumbers.contains(guessBallNumber);
    }

    private boolean equalsAt(
            final int index,
            final Guess other
    ) {
        final BallNumber answerBallNumber = ballNumbers.get(index);
        final BallNumber guessBallNumber = other.get(index);
        return answerBallNumber.equals(guessBallNumber);
    }

    private boolean notEqualsAt(
            final int index,
            final Guess other
    ) {
        return !equalsAt(index, other);
    }


}
