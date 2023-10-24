package domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GenerateRandomNumbers implements GenerateNumbersImple {
    private static final int RANDOM_MIN_VALUE = 1;
    private static final int RANDOM_MAX_VALUE = 9;
    private static final int RANDOM_NUMBERS_SIZE = 3;

    @Override
    public List<Integer> generate() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < RANDOM_NUMBERS_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(RANDOM_MIN_VALUE, RANDOM_MAX_VALUE);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}