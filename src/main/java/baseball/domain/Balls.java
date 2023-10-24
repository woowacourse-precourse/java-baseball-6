package baseball.domain;

import java.util.Collections;
import java.util.List;

public class Balls {

    private final List<Integer> balls;

    public Balls(List<Integer> balls) {

        this.balls = balls;
    }

    public List<Integer> getBalls() {

        return Collections.unmodifiableList(balls);
    }

    public int calculateStrike(Balls answerBalls) {

        int strike = 0;

        for(int i = 0; i < balls.size(); i++) {
            if(balls.get(i) == answerBalls.getBalls().get(i)) {
                strike++;
            }
        }
        return strike;
    }

    public int calculateBall(Balls answerBalls) {

        int ball = 0;

        for(int i = 0; i < balls.size(); i++) {
            for(int j = 0; j < answerBalls.getBalls().size(); j++) {
                if(i == j) {
                    continue;
                }
                if(balls.get(i) == answerBalls.getBalls().get(j)) {
                    ball++;
                }
            }
        }
        return ball;
    }
}
