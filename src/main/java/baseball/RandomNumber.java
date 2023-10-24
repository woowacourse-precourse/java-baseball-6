package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomNumber {
    private static final int NUMBER_LENGTH = 3;
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 9;

    private final List<Integer> computerNumber = new ArrayList<>();

    public RandomNumber() {
        createNumber();
    }

    public int randomMake() {
        return Randoms.pickNumberInRange(START_NUMBER, END_NUMBER);
    }

    public void createNumber() {
        while (computerNumber.size() < NUMBER_LENGTH) {
            int randomNumber = randomMake();
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }
    }

    public List<Integer> getAllNumbers() {
        return new ArrayList<>(computerNumber);
    }
}
