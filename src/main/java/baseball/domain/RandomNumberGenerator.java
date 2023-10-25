package baseball.domain;

import baseball.util.ListUtility;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomNumberGenerator {
    public static final int START_INCLUSIVE = 1;
    public static final int END_INCLUSIVE = 9;

    public RandomNumberGenerator() {
    }

    public static int makeRandomNumberInRange() {
        return Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
    }

    public static List<Integer> makeRandomNumbers() {
        List<Integer> randNumbers = new ArrayList<>();
        do {
            int randNum = makeRandomNumberInRange();
            if (!randNumbers.contains(randNum)) {
                randNumbers.add(randNum);
            }
        } while (randNumbers.size() < BallNumber.LENGTH);
        return randNumbers;
    }

    public static int makeComputerNumber() {
        List<Integer> randNumbers = makeRandomNumbers();
        return ListUtility.parseRandomNumbersToInt(randNumbers);
    }
}
