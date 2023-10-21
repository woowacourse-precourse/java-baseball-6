package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private List<Integer> computerNumbers;

    public Computer() {
        setNumbers();
    }

    public List<Integer> getNumbers() {
        return computerNumbers;
    }

    public void setNumbers() {
        this.computerNumbers = generateRandomNumbers();
    }

    private List<Integer> generateRandomNumbers() {
        List<Integer> randomNumbers = new ArrayList<>();

        while (randomNumbers.size() < 3) {
            int number = Randoms.pickNumberInRange(1, 9);
            if (!randomNumbers.contains(number)) {
                randomNumbers.add(number);
            }
        }
        return randomNumbers;
    }
}
