package baseball.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Balls {
    private List<Ball> balls;

    public Balls(List<Integer> nums) {
        Set<Integer> set = new HashSet<>(nums);
        if (set.size() != 3) {
            throw new IllegalArgumentException("중복되지 않는 3자리 수를 입력해 주세요.");
        }

        this.balls = nums.stream()
                .map((num) -> new Ball(num))
                .toList();
    }

    public List<Ball> getBalls() {
        return balls;
    }
}
