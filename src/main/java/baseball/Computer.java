package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseball.Validator.isContainZero;
import static baseball.Validator.isDigitsUnique;

public class Computer {
    List<Integer> randomNumbers;

    public Computer() {
        this.randomNumbers = new ArrayList<>();
    }

    public List<Integer> getRandomNumbers() {
        return randomNumbers;
    }

    public void generateRandomNumber() {
        randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < 3) {
            int number = Randoms.pickNumberInRange(1, 9);
            if (!randomNumbers.contains(number)) {
                randomNumbers.add(number);
            }
        }
    }
}
