package baseball.component;

import java.util.*;
public class Validator {

    private int strike, ball;
    private boolean noting;
    private List<Integer> target;
    private final int NUMBER_SIZE = 3;

    public Validator(List<Integer> target) {
        strike = 0;
        ball = 0;
        noting = false;
        this.target = target;
    }

    private void calculateStrike(List<Integer> numbers) {
        int strike = 0;
        for (int i = 0 ; i < NUMBER_SIZE ; i++) {
            if (numbers.get(i) == target.get(i)) {
                strike++;
            }
        }
        this.strike = strike;
    }
}
