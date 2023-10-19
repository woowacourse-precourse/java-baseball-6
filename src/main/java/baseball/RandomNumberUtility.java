package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.Collectors;

public class RandomNumberUtility {
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 9;
    private static final int NUMBER_LENGTH = 3;

    public List<Integer> generateRandomNumbers() {
        Set<Integer> randomNumbers = new LinkedHashSet<>();
        while(randomNumbers.size() != NUMBER_LENGTH) {
            randomNumbers.add(Randoms.pickNumberInRange(START_NUMBER, END_NUMBER));
        }
        return randomNumbers.stream().toList();
    }
}
