package baseball.my_sol;

import baseball.my_func.NumConvertor;
import java.util.List;

public class Nums {
    private final List<Num> nums;

    public Nums(List<Integer> balls) {
        this.nums = NumConvertor.mapToBalls(balls);
    }

    public Score compareTo(Nums computerBalls) {
        Score playResult = new Score();
        nums.stream()
                .map(computerBalls::compareTo)
                .forEach(playResult::updateScore);
        return playResult;
    }

    private NumStatus compareTo(Num compareBall) {
        return nums.stream()
                .map(ball -> ball.compareTo(compareBall))
                .filter(NumStatus::isNotNothing)
                .findFirst()
                .orElse(NumStatus.NOTHING);
    }
}
