package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Computer {
    private Set<Ball> balls;
    private final static Integer MIN_VALUE = 1;
    private final static Integer MAX_VALUE = 9;

    public Computer() {
        this.balls = new LinkedHashSet<>();
        initComputerNumbers();
    }

    public void initComputerNumbers() {
        while (balls.size() < 3) {
            int randomNumber = pickNumberFromThreadLocalRandomForBalls(MIN_VALUE, MAX_VALUE);
            balls.add(new Ball(randomNumber));
        }
    }

    public Integer pickNumberFromThreadLocalRandomForBalls(int minValue, int maxValue) {
        return Randoms.pickNumberInRange(minValue, maxValue);
    }
}
