package baseball.utils;

import baseball.domain.Ball;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class BallGenerator {

    private static final int MINIMUM_DIGIT_VALUE = 1;
    private static final int MAXIMUM_DIGIT_VALUE = 9;
    private static final int MAX_LENGTH = 3;

    public List<Ball> generate() {
        List<Ball> computerNumber = new ArrayList<>();
        while (computerNumber.size() < MAX_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(MINIMUM_DIGIT_VALUE, MAXIMUM_DIGIT_VALUE);
            Ball newDigit = new Ball(randomNumber, MAX_LENGTH - computerNumber.size() - 1);
            if (!solutionContainsValue(computerNumber, newDigit)) {
                computerNumber.add(newDigit);
            }
        }
        return computerNumber;
    }

    private boolean solutionContainsValue(List<Ball> computerNumber, Ball digit) {
        return computerNumber.stream().anyMatch(d -> d.getValue() == digit.getValue());
    }
}
