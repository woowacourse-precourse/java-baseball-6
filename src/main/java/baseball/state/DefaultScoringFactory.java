package baseball.state;

import baseball.util.RandomNumberCreator;

public class DefaultScoringFactory implements ScoringFactory {
    @Override
    public Scoring get() {
        return new Scoring(RandomNumberCreator.createByLength(3));
    }
}
