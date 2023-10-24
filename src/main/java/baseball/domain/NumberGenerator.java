package baseball.domain;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.ArrayList;
import java.util.List;

public class NumberGenerator {

    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 9;
    private static final int MIN_POSITION = 0;
    private static final int NUMBER = 3;

    public Balls generate() {

        List<Ball> balls = new ArrayList<>();
        for (int position = MIN_POSITION; position < NUMBER; position++) {
            int number = pickNumberInRange(MIN_RANGE, MAX_RANGE);
            validateRange(number);
            balls.add(new Ball(number, position));
        }
        return new Balls(balls);
    }

    private void validateRange(int number) {
        if (number < MIN_RANGE || MAX_RANGE < number) {
            throw new IllegalArgumentException("생성된 랜덤 숫자는 1~9 범위여야 합니다.");
        }
    }

}
