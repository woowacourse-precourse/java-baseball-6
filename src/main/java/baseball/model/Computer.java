package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Computer {
    private static final int MAX_SIZE = 3;
    private static final int LOWER_INCLUSIVE = 1;
    private static final int UPPER_INCLUSIVE = 9;
    private List<Integer> numbers;

    public void generateRandomNumbers() {
        Set<Integer> randomNumbers = new HashSet<>();

        while (randomNumbers.size() < MAX_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(LOWER_INCLUSIVE, UPPER_INCLUSIVE);
            randomNumbers.add(randomNumber);
        }
        numbers = new ArrayList<>(randomNumbers);
    }
}
