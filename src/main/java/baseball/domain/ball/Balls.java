package baseball.domain.ball;

import baseball.domain.result.Result;
import baseball.exception.DuplicateException;
import baseball.exception.OutOfRangeException;

import java.util.*;
import java.util.stream.IntStream;

public class Balls {
    private static final int ROUNDS = 3;
    private static final String STRIKE = "strike";
    private static final String BALL = "ball";

    private final List<Ball> values;

    public Balls(List<Ball> values) {
        valid(values);
        this.values = new ArrayList<>(values);
    }

    private void valid(List<Ball> values) {
        validSize(values);
        validDuplicate(values);
    }

    private void validSize(List<Ball> values) {
        if (values.size() < ROUNDS) {
            throw new OutOfRangeException("입력된 숫자가" + ROUNDS + "개 미만입니다.");
        } else if (values.size() > ROUNDS) {
            throw new OutOfRangeException("입력된 숫자가" + ROUNDS + "개 초과입니다.");
        }
    }

    private void validDuplicate(List<Ball> values) {
        List<Ball> distinctList = values.stream().distinct().toList();

        if (values.size() != distinctList.size()) {
            throw new DuplicateException("중복된 숫자가 있습니다.");
        }
    }


    public Result compare(Balls computerBalls) {
        return computerBalls.compare(this.values);
    }

    private Result compare(List<Ball> userValues) {
        Map<String, Integer> map = new HashMap<>();
        map.put(STRIKE, 0);
        map.put(BALL, 0);

        IntStream.range(0, userValues.size())
                .filter(i -> values.contains(userValues.get(i)))
                .forEach(i -> checkPosition(values.get(i), userValues.get(i), map));

        return new Result(map.get(STRIKE), map.get(BALL));
    }

    private void checkPosition(Ball origin, Ball target, Map<String, Integer> map) {
        if (origin.equals(target)) {
            map.put(STRIKE, map.get(STRIKE) + 1);
        } else {
            map.put(BALL, map.get(BALL) + 1);
        }
    }
}