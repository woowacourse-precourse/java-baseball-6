package baseball;

import java.util.List;

public class Ball {
    private final List<Integer> numbers;

    public Ball(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public boolean hasNoRelationWith(Ball tryBall) {
        return numbers.stream()
                .noneMatch(answerNumber -> tryBallHasAnswerNumber(tryBall, answerNumber));
    }

    public Score compareWith(Ball tryBall) {
        int strikeCnt = 0;
        int ballCnt = 0;

        for (int ballNumberPlace = 0; ballNumberPlace < 3; ballNumberPlace++) {
            if (isStrike(tryBall, ballNumberPlace)) {
                strikeCnt++;
                continue;
            }

            if (tryBallHasAnswerNumber(tryBall, this.numbers.get(ballNumberPlace))) {
                ballCnt++;
            }
        }
        return Score.toScore(ballCnt, strikeCnt);
    }

    private boolean isStrike(Ball tryBall, int ballNumberPlace) {
        return this.numbers.get(ballNumberPlace).equals(tryBall.numbers.get(ballNumberPlace));
    }

    private boolean tryBallHasAnswerNumber(Ball tryBall, Integer answerNumber) {
        return tryBall.numbers.contains(answerNumber);
    }
}
