package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    private static final int MAX_COMPUTER_NUMBERS_SIZE = 3;
    private static final int MIN_GENERATE_VALUE = 1;
    private static final int MAX_GENERATE_VALUE = 9;

    public static List<Integer> generateRandomNumber() {
        List<Integer> computerNumbers = new ArrayList<>();
        while (computerNumbers.size() < MAX_COMPUTER_NUMBERS_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(MIN_GENERATE_VALUE, MAX_GENERATE_VALUE);
            if (!computerNumbers.contains(randomNumber)) {
                computerNumbers.add(randomNumber);
            }
        }
        return computerNumbers;
    }
}