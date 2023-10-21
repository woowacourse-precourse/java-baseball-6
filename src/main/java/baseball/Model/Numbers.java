package baseball.Model;

import java.util.List;

public class Numbers {

    private List<Integer> balls;

    public Numbers (List<Integer> numbers) {
        this.balls = numbers;
    }

    public int countSameNumber(Numbers computerNumbers) {
        int count = 0;
        List<Integer> computerBalls = computerNumbers.getBalls();
        for (int ball : balls) {
            if (computerBalls.contains(ball)) {
                count++;
            }
        }
        return count;
    }

    public int countSameIndexAndNumber(Numbers computerNumbers) {
        int count = 0;
        List<Integer> computerBalls = computerNumbers.getBalls();
        for (int index = 0; index <= 2; index++) {
            if (balls.get(index) == computerBalls.get(index)) {
                count++;
            }
        }
        return count;
    }

    public List<Integer> getBalls() {
        return balls;
    }
}
