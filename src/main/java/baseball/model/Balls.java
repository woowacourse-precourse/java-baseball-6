package baseball.model;

import java.util.List;
import java.util.stream.Collectors;

public class Balls {

    private static final String WRONG_BALLS_NO = "[ERROR] 야구공은 서로 다른 3자리의 수입니다.";
    private static final int BALL_COUNT = 3;
    private final List<Ball> answer;

    public Balls(List<Integer> answer) {
        validate(answer);

        this.answer = answer.stream()
                .map(number -> new Ball(answer.indexOf(number), number))
                .collect(Collectors.toList());
    }

    private void validate(List<Integer> answer) {
        if ((int) answer.stream().distinct().count() != BALL_COUNT) {
            throw new IllegalArgumentException(WRONG_BALLS_NO);
        }
    }
}
