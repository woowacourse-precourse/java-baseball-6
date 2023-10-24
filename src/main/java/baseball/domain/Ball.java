package baseball.domain;

import java.util.List;

public class Ball {

    private final int ball;

    public Ball(int ball) {

        this.ball = ball;
    }

    public static int calculateBallCnt(List<Integer> answerNumbers, Balls balls) {

        int ball = 0;

        for(int i = 0; i < answerNumbers.size(); i++) {
            for(int j = 0; j < balls.getBalls().size(); j++) {
                if((i != j) && (answerNumbers.get(i) == balls.getBalls().get(j))) {
                    ball++;
                }
            }
        }

        return ball;
    }

    public int getBall() {

        return ball;
    }
}
