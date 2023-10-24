package baseball.domain;

import java.util.List;

import static baseball.validator.BaseballsValidator.validate;


public class Baseballs {

    public static final int MIN_BALL = 1;
    public static final int MAX_BALL = 9;
    public static final int BALL_SIZE = 3;

    private final List<Integer> baseballs;

    public Baseballs(List<Integer> baseballs) {
        validate(baseballs);
        this.baseballs = List.copyOf(baseballs);
    }

    public boolean contains(Integer baseball) {
        return this.baseballs.contains(baseball);
    }

    public Integer getBall(int index) {
        return baseballs.get(index);
    }
}