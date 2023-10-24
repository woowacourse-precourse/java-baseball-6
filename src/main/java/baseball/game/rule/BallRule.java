package baseball.game.rule;

import baseball.game.BallAndStrike;
import baseball.game.BaseBallNumberGroup;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

public class BallRule implements BaseBallResultRule {
    public BallRule() {
        // Empty
    }

    @Override
    public BallAndStrike apply(final BaseBallNumberGroup answer, final BaseBallNumberGroup user) {
        final AtomicInteger answerIndex = new AtomicInteger(0);

        final int ball = (int) answer.stream().filter(answerNumber -> {
            final int userNumberAtSameIndex = user.get(answerIndex.getAndIncrement());

            final Optional<Integer> userNumberEqualAnswerNumber = user.stream()
                    .filter(userNumber -> userNumber == answerNumber)
                    .findFirst();

            if (userNumberEqualAnswerNumber.isEmpty()) {
                return false;
            }

            return userNumberAtSameIndex != userNumberEqualAnswerNumber.get();
        }).count();

        return new BallAndStrike(ball, 0);
    }
}
