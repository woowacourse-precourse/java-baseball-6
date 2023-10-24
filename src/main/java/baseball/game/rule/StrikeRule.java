package baseball.game.rule;

import baseball.game.BallAndStrike;
import baseball.game.BaseBallNumberGroup;
import java.util.concurrent.atomic.AtomicInteger;

public class StrikeRule implements BaseBallResultRule {
    public StrikeRule() {
        // Empty
    }

    @Override
    public BallAndStrike apply(final BaseBallNumberGroup answer, final BaseBallNumberGroup user) {
        final AtomicInteger answerIndex = new AtomicInteger(0);

        final int strike = (int) answer.stream().filter(answerNumber ->
            answerNumber == user.get(answerIndex.getAndIncrement())
        ).count();

        return new BallAndStrike(0, strike);
    }
}
