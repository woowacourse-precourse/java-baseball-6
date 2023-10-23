package baseball.model;

import java.util.List;
import java.util.stream.Collectors;

public class Balls {

    private static final String WRONG_BALLS_NO = "[ERROR] 야구공은 서로 다른 3자리의 수입니다.";
    private static final int BALL_COUNT = 3;
    private final List<Ball> answers;

    public Balls(List<Integer> answers) {
        validate(answers);

        this.answers = answers.stream()
                .map(number -> new Ball(answers.indexOf(number), number))
                .collect(Collectors.toList());
    }

    private void validate(List<Integer> answers) {
        if (answers.stream().distinct().count() != BALL_COUNT) {
            throw new IllegalArgumentException(WRONG_BALLS_NO);
        }
    }

    public BallStatus play(Ball userBall) {
        return answers.stream()
                .map(answer -> answer.play(userBall))
                .filter(BallStatus::isNotNothing)
                .findFirst()
                .orElse(BallStatus.NOTHING);
    }

    public PlayResult play(Balls userBalls) {
        return null;
    }
}
