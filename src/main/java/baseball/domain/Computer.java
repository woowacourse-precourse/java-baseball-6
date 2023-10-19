package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private Baseball baseball;

    private Computer(final Baseball baseball) {
        this.baseball = baseball;
    }

    public static Computer init() {
        return new Computer(generateRandomBaseball());
    }

    public void reset() {
        this.baseball = generateRandomBaseball();
    }

    private static Baseball generateRandomBaseball() {
        final List<Integer> balls = new ArrayList<>();

        while (balls.size() < Baseball.TOTAL_COUNT) {
            final int randomNumber = Randoms.pickNumberInRange(Baseball.MIN_VALUE, Baseball.MAX_VALUE);
            if (!balls.contains(randomNumber)) {
                balls.add(randomNumber);
            }
        }

        return Baseball.of(balls);
    }

    public List<Integer> getBaseball() {
        return baseball.getBalls();
    }
}
