package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private static final int LENGTH_RANDOMNUMBERS = 3;
    private List<Integer> randomNumbers;

    public List<Integer> getRandomNumbers() {
        randomNumbers = new ArrayList<>();

        while (randomNumbers.size() < LENGTH_RANDOMNUMBERS) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);

            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }

        return randomNumbers;
    }



}
