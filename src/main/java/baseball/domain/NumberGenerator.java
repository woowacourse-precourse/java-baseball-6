package baseball.domain;


import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class NumberGenerator {

    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 9;
    private static final int NUMBER = 3;

    public Balls generate() {

        List<Ball> balls = new ArrayList<>();
        for (int position = 0; position < NUMBER; position++) {
            int number = pickNumberInRange(MIN_RANGE, MAX_RANGE);
            balls.add(new Ball(number, position));
        }
        return new Balls(balls);
    }


}
