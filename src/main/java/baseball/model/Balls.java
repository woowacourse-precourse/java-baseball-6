package baseball.model;

import java.util.List;

import static baseball.util.InputUtils.inputToIntegerList;

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

    public Balls(Input input) {
        this(inputToIntegerList(input));
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
