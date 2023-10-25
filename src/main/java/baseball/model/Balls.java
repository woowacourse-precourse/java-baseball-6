package baseball.model;

import java.util.ArrayList;
import java.util.List;

import static baseball.util.InputUtils.inputNumbersToIntegerList;

public class Balls {
    private List<Ball> balls;

    public Balls(List<Integer> nums) {
        if (nums.size() != 3) {
            throw new IllegalArgumentException("3자리 숫자를 입력해주세요.");
        }

        this.balls = nums.stream()
                .map((num) -> new Ball(num))
                .toList();
    }

    public Balls(InputNumbers inputNumbers) {
        this(inputNumbersToIntegerList(inputNumbers));
    }

    public PlayResult checkBalls(Balls targetBalls) {
        List<BallStatus> results = new ArrayList<>();

        for (int i = 0; i < balls.size(); i++) {
            List<BallStatus> result = balls.get(i).checkBalls(i, targetBalls);
            results.addAll(result);
        }

        return new PlayResult(results);
    }

    public List<Ball> getBalls() {
        return balls;
    }

    public int size() {
        return balls.size();
    }

    public Ball getBall(int i) {
        return balls.get(i);
    }
}
