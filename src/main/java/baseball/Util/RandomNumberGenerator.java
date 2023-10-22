package baseball.Util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomNumberGenerator {
    public static final int MIN_NUMBER_RANGE = 1;
    public static final int MAX_NUMBER_RANGE = 9;
    public static final int THREE_DIGIT = 3;

    public static List<Integer> generateRandomThreeNumber() {
        List<Integer> threeNumbers = new ArrayList<Integer>();
        generateRandomThreeDigit(threeNumbers);
        return threeNumbers;
    }

    private static void generateRandomThreeDigit(List<Integer> computerNumbers) {
        while (computerNumbers.size() < THREE_DIGIT) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER_RANGE, MAX_NUMBER_RANGE);
            addUniqueNumber(computerNumbers, randomNumber);
        }
    }

    private static void addUniqueNumber(List<Integer> computerNumbers, int randomNumber) {
        if (!computerNumbers.contains(randomNumber)) {
            computerNumbers.add(randomNumber);
        }
    }
}
