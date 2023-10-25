package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class ComNumberGenerator {
    private static final int START_RANGE = 1;
    private static final int END_RANGE = 9;
    private static final int BALL_COUNT = 3;
    private List<Integer> comNumbers;

    public List<Integer> generate() {
        resetComNumbers();

        while (isNotFull()) {
            updateComNumbers(getRandomNumber());
        }

        return comNumbers;
    }

    private void resetComNumbers() {
        comNumbers = new ArrayList<>();
    }

    private boolean isNotFull() {
        return comNumbers.size() < BALL_COUNT;
    }

    private void updateComNumbers(int randomNumber) {
        if (comNumbers.contains(randomNumber)) {
            return;
        }
        comNumbers.add(randomNumber);
    }

    protected int getRandomNumber() {
        return Randoms.pickNumberInRange(START_RANGE, END_RANGE);
    }
}
