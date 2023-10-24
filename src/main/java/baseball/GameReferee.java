package baseball;

import static baseball.Score.NOTHING;

public class GameReferee {
    private final Ball answerBall;

    public GameReferee(Ball answerBall) {
        this.answerBall = answerBall;
    }

    public Score judge(Ball tryBall) {

        boolean isNothing = true;
        for (Integer answerNumber : answerBall.getNumbers()) {
            if (tryBall.getNumbers().contains(answerNumber)) {
                isNothing = false;
                break;
            }
        }

        if (isNothing) {
            return NOTHING;
        }

        int ballCnt = 0;
        int strikeCnt = 0;

        for (int ballNumberPlace = 0; ballNumberPlace < 3; ballNumberPlace++) {
            if (isStrike(tryBall, ballNumberPlace)) {
                strikeCnt++;
                continue;
            }

            if (tryBallHasAnswerNumber(tryBall, answerBall.getNumbers().get(ballNumberPlace))) {
                ballCnt++;
            }
        }

        return Score.toScore(ballCnt, strikeCnt);
    }

    private boolean isStrike(Ball tryBall, int ballNumberPlace) {
        return answerBall.getNumbers().get(ballNumberPlace).equals(tryBall.getNumbers().get(ballNumberPlace));
    }

    private boolean tryBallHasAnswerNumber(Ball tryBall, Integer answerNumber) {
        return tryBall.getNumbers().contains(answerNumber);
    }
}
