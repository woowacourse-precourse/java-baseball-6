package baseball.domain.ball;

import baseball.domain.result.Result;

import java.util.*;

public class Balls {
    private final List<Ball> values;

    public Balls(List<Ball> values, int rounds) {
        valid(values, rounds);
        this.values = new ArrayList<>(values);
    }

    private void valid(List<Ball> values, int rounds) {
        if (values.size() < rounds) {
            throw new IllegalArgumentException("입력된 숫자가" + rounds + "개 미만입니다.");
        } else if (values.size() > rounds) {
            throw new IllegalArgumentException("입력된 숫자가" + rounds + "개 초과입니다.");
        }
    }

    public Result compare(Balls computerBalls) {
        return computerBalls.compare(this.values);
    }

    private Result compare(List<Ball> userValues) {
        Result result = new Result();

        for (int i = 0; i < userValues.size(); i++) {
            Ball origin = values.get(i);
            Ball target = userValues.get(i);

            if (values.contains(target)) {
                checkPosition(result, origin, target);
            }
        }

        return result;
    }

    private void checkPosition(Result result, Ball origin, Ball target) {
        if (origin.equals(target)) {
            result.increaseStrike();
        } else {
            result.increaseBall();
        }
    }
}