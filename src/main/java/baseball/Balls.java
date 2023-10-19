package baseball;

import java.util.List;

public class Balls {

    private final List<Ball> balls;

    public Balls(List<Ball> ballList) {
        this.balls = ballList;
    }

    public void validateSize(List<Ball> ballList) {
        if (!hasThreeDigits(ballList)) {
            throw new IllegalArgumentException("3자리의 숫자를 입력해주세요.");
        }
    }

    public void valdateDuplicates(List<Ball> ballList) {
        if (hasDuplicatesInList(ballList)) {
            throw new IllegalArgumentException("중복되지 않는 3자리의 숫자를 입력해주세요.");
        }
    }

    private boolean hasThreeDigits(List<Ball> ballList) {
        return ballList.size() == 3;
    }

    private boolean hasDuplicatesInList(List<Ball> ballList) {
        int uniqueBallCount = (int) ballList.stream()
            .distinct()
            .count();

        return uniqueBallCount < 3;
    }
}
