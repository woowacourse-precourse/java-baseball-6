package baseball.tdd;

import java.util.ArrayList;
import java.util.List;

public class Balls implements Playable {
    private final List<Ball> answers;

    public Balls(final List<Integer> answers) {
        this.answers = mapBall(answers);
    }

    private static List<Ball> mapBall(final List<Integer> answers) {
        List<Ball> balls = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            balls.add(new Ball(i + 1, answers.get(i)));
        }
        return balls;
    }

    public PlayResult play(List<Integer> balls) {
        Balls userBalls = new Balls(balls);
        PlayResult result = new PlayResult();
        for (Ball answers : answers) {
            BallStatus status = userBalls.play(answers);
            result.report(status);
        }
        return result;
    }

    public BallStatus play(final Ball userBall) {
        return answers.stream()
                .map(answer -> answer.play(userBall))
                .filter(BallStatus::isNotNothing)
                .findFirst()
                .orElse(BallStatus.NOTHING);
    }
}
