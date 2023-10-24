package baseball.domain.ball;

import collection.Triple;
import java.util.stream.IntStream;

public final class Answer extends BallNumbers {

    private Answer(final Triple<BallNumber> numbers) {
        super(numbers);
    }

    public static Answer of(final Triple<BallNumber> numbers) {
        return new Answer(numbers);
    }

    public int getStrikeCount(final Guess guess) {
        return (int) IntStream.range(0, BALL_COUNT)
                .filter(i -> equalsAt(i, guess))
                .count();
    }

    public int getBallCount(final Guess guess) {
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
