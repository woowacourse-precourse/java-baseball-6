package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BallNumberGenerator {

    public static final int SIZE = 3;
    public static final int MIN_BALL_NUMBER = 1;
    public static final int MAX_BALL_NUMBER = 9;
    private static final List<Integer> generated = new ArrayList<>();

    public List<Integer> generateBallNumber() {
        while (generated.size() < SIZE) {
            generateNumber();
        }
        return generated;
    }

    private static void generateNumber() {
        int randomNumber = Randoms.pickNumberInRange(MIN_BALL_NUMBER, MAX_BALL_NUMBER);
        if (!generated.contains(randomNumber)) {
            generated.add(randomNumber);
        }
    }
}
