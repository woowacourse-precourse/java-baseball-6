package baseball.domain.ball;

import collection.Triple;

public final class Guess extends BallNumbers {

    private Guess(final Triple<BallNumber> ballNumbers) {
        super(ballNumbers);
    }

    public static Guess of(final Triple<BallNumber> ballNumbers) {
        return new Guess(ballNumbers);
    }

}
