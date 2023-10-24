package baseball.domain;

import baseball.util.Util;

import java.util.Collections;
import java.util.List;

public class Balls {

    private final List<Integer> balls;

    public Balls(String userInput) {

        Util.validateUserString(userInput);
        List<Integer> balls = Util.stringToIntegerList(userInput);
        this.balls = balls;
    }

    public List<Integer> getBalls() {
        return Collections.unmodifiableList(balls);
    }
}
