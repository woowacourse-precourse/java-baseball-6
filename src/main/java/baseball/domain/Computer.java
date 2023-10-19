package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private final Baseball baseball;

    private Computer(final Baseball baseball) {
        this.baseball = baseball;
    }

    public static Computer init() {
        final List<Integer> balls = new ArrayList<>();

        while (balls.size() < 3) {
            final int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!balls.contains(randomNumber)) {
                balls.add(randomNumber);
            }
        }

        return new Computer(Baseball.of(balls));
    }

    public List<Integer> getBaseball() {
        return baseball.getBalls();
    }
}
