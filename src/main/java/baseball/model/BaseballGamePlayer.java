package baseball.model;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class BaseballGamePlayer {
    public static GameResult swingBat(BaseballGameComputer computer, List<Integer> playerNumbers) {
        Set<Ball> balls = new LinkedHashSet<>();
        for (Integer number : playerNumbers) {
            balls.add(new Ball(number));
        }
        return new GameResult(computer.getHintByPlayerBalls(balls));
    }
}
