package baseball.model;

import java.util.LinkedHashSet;
import java.util.Set;

public class Player {
    public Player() {

    }
    public boolean swingBat(Computer computer,String input) {
        Set<Ball> balls = new LinkedHashSet<>();
        for(String number : input.split("")) {
            int givensNumber = Integer.parseInt(number);
            balls.add(new Ball(givensNumber));
        }
        return computer.getHintByPlayer(balls);
    }
}
