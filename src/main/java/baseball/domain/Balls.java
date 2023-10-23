package baseball.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static baseball.domain.Ball.*;

public class Balls {
    private static final String ERROR_MESSAGE = "입력한 숫자는 1에서 9 사이의 중복되지 않는 3자리여야 합니다.";
    private final List<Ball> balls;

    public Balls(List<Ball> balls) {
        validate(balls);
        this.balls = List.copyOf(balls);
    }

    public Ball getBall(int index) {
        return balls.get(index);
    }

    public int countBalls(Balls otherBalls) {
        int ballCount = 0;
        for (int index = 0; index < BALL_SIZE; index++) {
            if (isBall(index, otherBalls)) {
                ballCount++;
            }
        }
        return ballCount;
    }

    private boolean isBall(int index, Balls playerBalls) {
        // index 위치의 컴퓨터 공과 플레이어 공의 번호를 비교하여 볼인지 확인
        boolean isNotStrike = !isStrike(index, playerBalls);
        boolean isContainsOtherBall = this.containsOtherBall(playerBalls.getBall(index));
        return isNotStrike && isContainsOtherBall;
    }

    public int countStrikes(Balls otherBalls) {
        int strikeCount = 0;
        for (int index = 0; index < BALL_SIZE; index++) {
            if (isStrike(index, otherBalls)) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    private boolean containsOtherBall(Ball otherBall) {
        for (Ball ball : balls) {
            if (ball.isSameNumber(otherBall)) {
                return true;
            }
        }
        return false;
    }

    private boolean isStrike(int index, Balls playerBalls) {
        // index 위치의 컴퓨터 공과 플레이어 공의 번호를 비교하여 스트라이크인지 확인
        Ball computerBall = this.getBall(index);
        Ball playerBall = playerBalls.getBall(index);
        return computerBall.number().equals(playerBall.number());
    }

    private void validate(List<Ball> balls) {
        validateNotNullAndNotEmpty(balls);
        validateNumeric(balls);
        validateNumberOfBalls(balls);
        validateDuplicates(balls);
    }

    private void validateNotNullAndNotEmpty(List<Ball> balls) {
        if (balls == null || balls.isEmpty()) {
            throwIllegalArgumentException();
        }
    }

    private void validateNumeric(List<Ball> balls) {
        for (Ball ball : balls) {
            if (ball.number() == null || ball.number() < MIN_BALL || ball.number() > MAX_BALL) {
                throwIllegalArgumentException();
            }
        }
    }

    private void validateNumberOfBalls(List<Ball> balls) {
        if (balls.size() != BALL_SIZE) {
            throwIllegalArgumentException();
        }
    }

    private void validateDuplicates(List<Ball> balls) {
        Set<Integer> set = new HashSet<>();
        for (Ball ball : balls) {
            if (!set.add(ball.number())) {
                throwIllegalArgumentException();
            }
        }
    }

    private void throwIllegalArgumentException() {
        throw new IllegalArgumentException(ERROR_MESSAGE);
    }
}