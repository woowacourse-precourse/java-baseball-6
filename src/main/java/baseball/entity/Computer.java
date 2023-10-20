package baseball.entity;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    private static final int MAX_SIZE = 3;
    private static final int NUMBER_SIZE = 10;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    private static final Computer instance = new Computer();
    private final List<Integer> balls = new ArrayList<>();
    private boolean[] numberList;

    private Computer() {
    }

    public static Computer getInstance() {
        return instance;
    }

    public void init() {
        balls.clear();
        numberList = new boolean[NUMBER_SIZE];
        while (balls.size() != MAX_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            if (existNumber(randomNumber)) {
                continue;
            }
            numberList[randomNumber] = true;
            balls.add(randomNumber);
        }
    }

    private boolean existNumber(int randomNumber) {
        return numberList[randomNumber];
    }
}
