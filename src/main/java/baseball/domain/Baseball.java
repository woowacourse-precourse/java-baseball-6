package baseball.domain;

import java.util.List;

public class Baseball {
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 9;
    private static final int TOTAL_SIZE = 3;

    private final List<Integer> balls;

    public Baseball(final List<Integer> balls) {
        this.balls = balls;
    }
}
