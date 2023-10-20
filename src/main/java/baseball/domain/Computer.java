package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private List<Integer> randomNumbers = new ArrayList<>();

    private static final int THREE_NUMBER = 3;

    private static final int MINIMUM_NUMBER = 1;

    private static final int MAXIMUM_NUMBER = 9;

    public List<Integer> getRandomNumbers() {
        return randomNumbers;
    }

    public Computer() {
        while (randomNumbers.size() < THREE_NUMBER) {
            int randomNumber = Randoms.pickNumberInRange(MINIMUM_NUMBER, MAXIMUM_NUMBER);
            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }
        System.out.println(randomNumbers);
    }
}
