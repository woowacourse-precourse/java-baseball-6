package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    private List<Integer> randomNumber;

    public Computer() {
        randomNumber = new ArrayList<>();
    }

    public List<Integer> getRandomNumber() {
        return randomNumber;
    }

    public void generateRandomNumber() {
        initRandomNumber();
        while (randomNumber.size() < Number.NUMBER_SIZE) {
            int digit = Randoms.pickNumberInRange(1, 9);
            addUniqueNumber(digit);
        }
    }

    private void initRandomNumber() {
        randomNumber = new ArrayList<>();
    }

    private void addUniqueNumber(int digit) {
        if (!randomNumber.contains(digit)) {
            randomNumber.add(digit);
        }
    }
}
