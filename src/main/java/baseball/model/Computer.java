package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    private List<Integer> randomNumber;

    public Computer() {
        randomNumber = new ArrayList<>();
        generateRandomNumber();
    }

    public List<Integer> getRandomNumber() {
        return randomNumber;
    }

    private void generateRandomNumber() {
        while (randomNumber.size() < Number.NUMBER_SIZE) {
            int digit = Randoms.pickNumberInRange(1, 9);
            addUniqueNumber(digit);
        }
    }

    private void addUniqueNumber(int digit) {
        if (!randomNumber.contains(digit)) {
            randomNumber.add(digit);
        }
    }
}
