package baseball.model;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Player {
    public Player() {

    }

    public Hint swingBat(Computer computer, List<Integer> playerNumbers) {
        Set<Ball> balls = new LinkedHashSet<>();
        for (Integer number : playerNumbers) {
            balls.add(new Ball(number));
        }
        return computer.getHintByPlayer(balls);
    }
}
