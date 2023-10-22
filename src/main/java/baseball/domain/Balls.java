package baseball.domain;

import static baseball.util.Constants.BALL_AMOUNT;

import java.util.ArrayList;
import java.util.List;

public class Balls {
    private final List<Ball> answers;

    public Balls(List<Integer> answers) {
        this.answers = mapBall(answers);
    }

    private static List<Ball> mapBall(List<Integer> answers) {
        List<Ball> balls = new ArrayList<>();
        for (int i = 0; i < BALL_AMOUNT; i++) {
            balls.add(new Ball(i + 1, answers.get(i)));
        }
        return balls;
    }

    public boolean isRightSize() {
        return this.answers.size() == BALL_AMOUNT;
    }

    public BallStatus play(Ball userBall) {
        return answers.stream()
                .map(answers -> answers.play(userBall))
                .filter(BallStatus::isNotNothing)
                .findFirst()
                .orElse(BallStatus.NOTHING);
    }
}
