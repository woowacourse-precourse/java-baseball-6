package baseball.domain;

import static baseball.domain.Score.NOTHING;

public class GameReferee {
    private final Ball answerBall;

    public GameReferee(Ball answerBall) {
        this.answerBall = answerBall;
    }

    public Score judge(Ball tryBall) {
        if (answerBall.hasNoRelationWith(tryBall)) {
            return NOTHING;
        }

        return answerBall.compareWith(tryBall);
    }
}
