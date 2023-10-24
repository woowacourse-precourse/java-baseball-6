package baseball.domain.ball;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Balls {

    public static final int CORRECT_SIZE = 3;
    public static final int START_INDEX = 0;
    public static final int END_INDEX = 3;
    List<Ball> balls;

    public Balls(List<Integer> values) {
        validate(values);
        this.balls = createBalls(values);
    }

    public int getStrikeCount(Balls otherBalls) {
        int result = 0;
        for (Ball ball : this.balls) {
            if(otherBalls.isStrike(ball)) {
                result++;
            }
        }
        return result;
    }
    private boolean isStrike(Ball otherBall) {
        for (Ball ball : this.balls) {
            if(ball.isMatch(otherBall)) {
                return true;
            }
        }
        return false;
    }

    public int getBallCount(Balls otherBalls) {
        int result = 0;
        for (Ball ball : this.balls) {
            if(otherBalls.isBall(ball)) {
                result++;
            }
        }
        return result;
    }
    private boolean isBall(Ball otherBall) {
        for (Ball ball : this.balls) {
            if(ball.isPartialMatch(otherBall)) {
                return true;
            }
        }
        return false;
    }

    private List<Ball> createBalls(List<Integer> values) {
        return IntStream.range(START_INDEX, END_INDEX)
                .mapToObj(index -> new Ball(new Number(values.get(index)), index))
                .collect(Collectors.toList());
    }
    private void validate(List<Integer> values) {
        validateDuplication(values);
        validateSize(values);
    }

    private void validateDuplication(List<Integer> values) {
        if(hasDuplicates(values)) {
            throw new IllegalArgumentException("서로 다른 수가 입력되어야합니다.");
        }
    }
    private boolean hasDuplicates(List<Integer> values) {
        return values.stream()
                .distinct() // 중복 제거
                .count() != values.size();
    }

    private void validateSize(List<Integer> values) {
        if(values.size() != CORRECT_SIZE) {
            throw new IllegalArgumentException("숫자의 길이는 3이어야합니다.");
        }
    }

    public List<Ball> getBalls() {
        return Collections.unmodifiableList(balls);
    }
}
