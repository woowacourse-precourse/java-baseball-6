package baseball.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;

public class RandomNumbersGenerator {

    private static final int COMPUTERNUMBERS_LENGTH = 3;
    private static final int NUMBER_RANGE_START = 1;
    private static final int NUMBER_RANGE_END = 9;

    public ArrayList<Integer> generateNumbers() {
        HashSet<Integer> setComputerNumbers = new HashSet<>();
        while (setComputerNumbers.size() < COMPUTERNUMBERS_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(NUMBER_RANGE_START, NUMBER_RANGE_END);
            setComputerNumbers.add(randomNumber);
        }
        return new ArrayList<>(setComputerNumbers);
    }

}
