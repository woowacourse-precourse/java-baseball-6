package baseball.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class NumberGenerator {

    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 9;
    private static final int DEFAULT_NUMBER_SIZE = 3;

    public static List<Integer> generateComputerNumber(int size) {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < size) {
            int randomNumber = generateRandomNumber();
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public static List<Integer> generateDefaultSizeComputerNumber() {
        return generateComputerNumber(DEFAULT_NUMBER_SIZE);
    }

    private static int generateRandomNumber() {
        return Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
    }
}
