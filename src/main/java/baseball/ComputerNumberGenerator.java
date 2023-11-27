package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class ComputerNumberGenerator {

    private static final int BALL_SIZE = 3;
    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 9;

    public static List<Integer> generate() {
        List<Integer> computerNumbers = new ArrayList<>();
        while (computerNumbers.size() < BALL_SIZE) {
            int randomNumber = getRandomNumber();
            if (isUniqueNumber(computerNumbers, randomNumber)) {
                computerNumbers.add(randomNumber);
            }
        }
        return computerNumbers;
    }

    private static int getRandomNumber() {
        return Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
    }

    private static boolean isUniqueNumber(List<Integer> randomNumbers, int randomNumber) {
        return !randomNumbers.contains(randomNumber);
    }
}